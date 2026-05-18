package cl.triskeledu.reportes.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Map;

/**
 * @use(reportes)
 * @kind(client)
 * @contract(in: Long credencialId, Long sucursalId -> out: List<Map<String, Object>>)
 * @limit(lines: 40)
 */
@FeignClient(name = "ms-pedidos", url = "${feign.pedidos.url:http://localhost:9007}")
public interface PedidoClient {

    @GetMapping("/api/v1/pedidos")
    List<Map<String, Object>> listarPedidos(@RequestHeader("X-Credencial-Id") Long credencialId);

    @GetMapping("/api/v1/pedidos/sucursal/{sucursalId}/activos")
    List<Map<String, Object>> listarPedidosActivos(@PathVariable("sucursalId") Long sucursalId,
                                                    @RequestHeader("X-Credencial-Id") Long credencialId);
}