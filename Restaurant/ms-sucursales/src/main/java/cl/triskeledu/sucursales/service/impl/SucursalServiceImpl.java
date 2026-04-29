package cl.triskeledu.sucursales.service.impl;

import cl.triskeledu.sucursales.dto.request.SucursalRequestDTO;
import cl.triskeledu.sucursales.dto.response.SucursalResponseDTO;
import cl.triskeledu.sucursales.mapper.SucursalMapper;
import cl.triskeledu.sucursales.repository.SucursalRepository;
import cl.triskeledu.sucursales.service.SucursalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * =============================================================================
 * SERVICE IMPL: SucursalServiceImpl
 * =============================================================================
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class SucursalServiceImpl implements SucursalService {

    private final SucursalRepository sucursalRepository;
    private final SucursalMapper sucursalMapper;

    @Override
    public SucursalResponseDTO crear(SucursalRequestDTO dto) {
        /*
         * INTENCIÓN:
         *   Dar de alta una nueva sucursal física en el sistema.
         *
         * FLUJO ESPERADO:
         *   Input: SucursalRequestDTO (nombre, direccion, telefono)
         *   Process:
         *     1. Mapear DTO a Entidad.
         *     2. Forzar estado activa = true al crear.
         *     3. Guardar en BD.
         *   Output: SucursalResponseDTO con el ID asignado.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public SucursalResponseDTO getById(Long id) {
        /*
         * INTENCIÓN:
         *   Recuperar los datos de una sucursal específica.
         *
         * FLUJO ESPERADO:
         *   Input: ID de la sucursal (Long)
         *   Process:
         *     1. Buscar en BD por ID.
         *     2. Si no existe -> SucursalNotFoundException.
         *   Output: SucursalResponseDTO
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public List<SucursalResponseDTO> listarActivas() {
        /*
         * INTENCIÓN:
         *   Listar sucursales disponibles para clientes y asignaciones.
         *
         * FLUJO ESPERADO:
         *   Input: N/A
         *   Process: Consultar repository por activa=true.
         *   Output: Lista de SucursalResponseDTO.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public List<SucursalResponseDTO> listarTodas() {
        /*
         * INTENCIÓN:
         *   Listado administrativo que incluye sucursales cerradas.
         *
         * FLUJO ESPERADO:
         *   Input: N/A
         *   Process: Consultar findAll().
         *   Output: Lista de SucursalResponseDTO.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public SucursalResponseDTO actualizar(Long id, SucursalRequestDTO dto) {
        /*
         * INTENCIÓN:
         *   Modificar nombre, dirección o teléfono de una sucursal.
         *
         * FLUJO ESPERADO:
         *   Input: ID y DTO con nuevos datos.
         *   Process:
         *     1. Buscar sucursal por ID (lanzar NotFound si no).
         *     2. Actualizar entidad in-place.
         *     3. Guardar en BD.
         *   Output: SucursalResponseDTO.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }

    @Override
    public SucursalResponseDTO cambiarEstado(Long id, Boolean activa) {
        /*
         * INTENCIÓN:
         *   Abrir o cerrar (soft delete) una sucursal.
         *
         * FLUJO ESPERADO:
         *   Input: ID y nuevo estado (boolean)
         *   Process:
         *     1. Verificar existencia.
         *     2. Actualizar estado (query @Modifying).
         *     3. Recargar y devolver.
         *   Output: SucursalResponseDTO.
         *
         * DEPENDENCIAS:
         *   - Debería notificar (vía Kafka/RabbitMQ) a ms-pedidos y ms-menu 
         *     para pausar ventas si activa = false.
         */
        throw new UnsupportedOperationException("Scaffolding: Lógica de negocio pendiente de implementación.");
    }
}
