package cl.triskeledu.reportes.service.impl;

import cl.triskeledu.reportes.client.AuthFeignClient;
import cl.triskeledu.reportes.client.PagoClient;
import cl.triskeledu.reportes.client.PedidoClient;
import cl.triskeledu.reportes.dto.request.FiltroReporteDTO;
import cl.triskeledu.reportes.dto.response.ReporteSnapshotResponseDTO;
import cl.triskeledu.reportes.entity.ReporteSnapshot;
import cl.triskeledu.reportes.entity.enums.TipoReporte;
import cl.triskeledu.reportes.mapper.ReporteMapper;
import cl.triskeledu.reportes.repository.ReporteSnapshotRepository;
import cl.triskeledu.reportes.service.ReporteService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <h1>Servicio de generación de reportes</h1>
 * <p>
 * Implementa {@link ReporteService} y constituye el núcleo de ms-reportes.
 * </p>
 *
 * <h2>Integraciones síncronas vía Feign</h2>
 * <ul>
 *   <li><b>ms-pedidos</b> → {@link PedidoClient}: obtiene listados de pedidos
 *       para los reportes {@code TOP_PLATOS}, {@code KARDEX_MENSUAL} y
 *       {@code RENDIMIENTO_REPARTIDORES}.</li>
 *   <li><b>ms-pagos</b> → {@link PagoClient}: obtiene el historial de pagos
 *       para el reporte {@code VENTAS_DIARIAS}.</li>
 *   <li><b>ms-auth</b> → {@link AuthFeignClient}: autenticación que respalda
 *       el {@code credencialId} enviado en cada petición Feign.</li>
 * </ul>
 *
 * <h2>Integraciones asíncronas vía Kafka</h2>
 * <p>
 * Un listener externo (no en este archivo) consume los tópicos
 * {@code pedido-events} y {@code pago-events}, y persiste snapshots
 * proactivos en {@link ReporteSnapshotRepository} para que los reportes
 * históricos puedan servirse sin consultar los microservicios remotos.
 * </p>
 *
 * <h2>Lógica de despacho por tipo de reporte</h2>
 * <p>
 * El método privado {@link #fetchReportData(FiltroReporteDTO)} utiliza una
 * expresión {@code switch} sobre el {@link TipoReporte} para decidir qué
 * cliente Feign invocar y cómo estructurar el JSON resultante.
 * </p>
 *
 * @see ReporteService
 * @see PedidoClient
 * @see PagoClient
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class ReporteServiceImpl implements ReporteService {

    private final ReporteSnapshotRepository reporteSnapshotRepository;
    private final ReporteMapper reporteMapper;
    private final AuthFeignClient authFeignClient;
    private final PedidoClient pedidoClient;
    private final PagoClient pagoClient;
    private final ObjectMapper objectMapper;

    /**
     * Genera un reporte dinámico consultando los microservicios correspondientes
     * según el tipo de reporte solicitado.
     * <p>
     * Delega en {@link #fetchReportData(FiltroReporteDTO)} para obtener el JSON
     * con los datos crudos, los persiste como {@link ReporteSnapshot} y retorna
     * el DTO de respuesta.
     * </p>
     *
     * @param filtro criterios del reporte: tipo, sucursalId y credencialId
     * @return DTO con el snapshot creado (id, tipo, sucursal, dataJson)
     */
    @Override
    public ReporteSnapshotResponseDTO generarReporteDinamico(FiltroReporteDTO filtro) {
        log.info("Generando reporte dinámico tipo={} sucursalId={}", filtro.getTipo(), filtro.getSucursalId());

        String dataJson = fetchReportData(filtro);

        ReporteSnapshot snapshot = ReporteSnapshot.builder()
                .tipo(filtro.getTipo())
                .sucursalId(filtro.getSucursalId())
                .dataJson(dataJson)
                .build();

        snapshot = reporteSnapshotRepository.save(snapshot);
        log.info("ReporteSnapshot creado con id={}, tipo={}", snapshot.getId(), snapshot.getTipo());
        return reporteMapper.toResponseDTO(snapshot);
    }

    /**
     * Despacha la consulta al microservicio adecuado según el {@link TipoReporte}
     * mediante una expresión {@code switch}.
     *
     * <h3>Ramificaciones del switch</h3>
     * <ul>
     *   <li>{@code VENTAS_DIARIAS} → consulta a ms-pagos vía {@link PagoClient}</li>
     *   <li>{@code TOP_PLATOS} y {@code KARDEX_MENSUAL} → consulta a ms-pedidos vía {@link PedidoClient}</li>
     *   <li>{@code RENDIMIENTO_REPARTIDORES} → consulta a ms-pedidos, opcionalmente filtrado por sucursalId</li>
     * </ul>
     *
     * @param filtro contiene el tipo de reporte, sucursalId y credencialId
     * @return JSON serializado con los datos del reporte, o {@code "{}"} en caso de error
     */
    private String fetchReportData(FiltroReporteDTO filtro) {
        Long credencialId = filtro.getCredencialId();
        Long sucursalId = filtro.getSucursalId();

        try {
            return switch (filtro.getTipo()) {
                case VENTAS_DIARIAS -> {
                    List<Map<String, Object>> pagos = pagoClient.listarPagos(credencialId);
                    yield objectMapper.writeValueAsString(Map.of(
                            "tipo", "VENTAS_DIARIAS",
                            "totalRegistros", pagos.size(),
                            "pagos", pagos
                    ));
                }
                case TOP_PLATOS, KARDEX_MENSUAL -> {
                    List<Map<String, Object>> pedidos = pedidoClient.listarPedidos(credencialId);
                    yield objectMapper.writeValueAsString(Map.of(
                            "tipo", filtro.getTipo().name(),
                            "totalRegistros", pedidos.size(),
                            "pedidos", pedidos
                    ));
                }
                case RENDIMIENTO_REPARTIDORES -> {
                    List<Map<String, Object>> pedidos = sucursalId != null
                            ? pedidoClient.listarPedidosActivos(sucursalId, credencialId)
                            : pedidoClient.listarPedidos(credencialId);
                    yield objectMapper.writeValueAsString(Map.of(
                            "tipo", "RENDIMIENTO_REPARTIDORES",
                            "totalRegistros", pedidos.size(),
                            "pedidos", pedidos
                    ));
                }
            };
        } catch (JsonProcessingException e) {
            log.error("Error serializando datos del reporte: {}", e.getMessage(), e);
            return "{}";
        } catch (Exception e) {
            log.error("Error obteniendo datos de microservicio para reporte tipo={}: {}", filtro.getTipo(), e.getMessage(), e);
            return "{}";
        }
    }

    /**
     * Recupera el historial de snapshots generados para un tipo de reporte específico,
     * ordenados del más reciente al más antiguo.
     * <p>
     * Los snapshots son almacenados por el listener de Kafka que consume
     * {@code pedido-events} y {@code pago-events}, permitiendo servir el
     * historial sin depender de llamadas síncronas a otros microservicios.
     * </p>
     *
     * @param tipo tipo de reporte a consultar
     * @return lista de DTOs con los snapshots históricos
     */
    @Override
    public List<ReporteSnapshotResponseDTO> obtenerHistorial(TipoReporte tipo) {
        return reporteSnapshotRepository.findByTipoOrderByCreadoEnDesc(tipo).stream()
                .map(reporteMapper::toResponseDTO)
                .toList();
    }
}
