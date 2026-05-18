package cl.triskeledu.reportes.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;
import java.util.Map;

/**
 * @use(reportes)
 * @kind(client)
 * @contract(in: Long credencialId -> out: List<Map<String, Object>>)
 * @limit(lines: 40)
 */
@FeignClient(name = "ms-pagos", url = "${feign.pagos.url:http://localhost:9008}")
public interface PagoClient {

    @GetMapping("/api/v1/pagos")
    List<Map<String, Object>> listarPagos(@RequestHeader("X-Credencial-Id") Long credencialId);
}