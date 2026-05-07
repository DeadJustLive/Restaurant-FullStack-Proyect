package cl.triskeledu.pedidos.client;

import cl.triskeledu.pedidos.dto.response.PermisoResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-auth", path = "/api/v1/auth")
public interface AuthFeignClient {
    
    @GetMapping("/validar-acceso")
    ResponseEntity<PermisoResponseDTO> validarAcceso(
        @RequestParam("credencialId") Long credencialId, 
        @RequestParam("modulo") String modulo, 
        @RequestParam("accion") String accion
    );
}
