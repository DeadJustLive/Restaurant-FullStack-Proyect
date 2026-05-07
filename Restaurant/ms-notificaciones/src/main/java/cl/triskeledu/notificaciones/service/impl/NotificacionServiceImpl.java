package cl.triskeledu.notificaciones.service.impl;

import cl.triskeledu.notificaciones.dto.request.NotificacionRequestDTO;
import cl.triskeledu.notificaciones.dto.response.NotificacionResponseDTO;
import cl.triskeledu.notificaciones.entity.enums.EstadoNotificacion;
import cl.triskeledu.notificaciones.service.NotificacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import cl.triskeledu.notificaciones.client.AuthFeignClient;
import cl.triskeledu.notificaciones.dto.response.PermisoResponseDTO;
import cl.triskeledu.notificaciones.exception.AccesoDenegadoException;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * =============================================================================
 * SERVICE IMPL: NotificacionServiceImpl
 * =============================================================================
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class NotificacionServiceImpl implements NotificacionService {

    private final AuthFeignClient authFeignClient;


    @Override
    public NotificacionResponseDTO enviarNotificacion(NotificacionRequestDTO dto) {
        /*
         * INTENCIÓN: Registrar y procesar el envío de una alerta.
         *
         * FLUJO ESPERADO:
         *   1. Crear entidad en estado PENDIENTE.
         *   2. Guardar en BD.
         *   3. Simular integración con AWS SES, Twilio, Firebase, etc.
         *   4. Si exitoso -> Actualizar a ENVIADO. Si falla -> FALLIDO.
         *   5. Guardar actualización en BD.
         *   Output: NotificacionResponseDTO con estado final.
         */
        return null; // TODO: Tu compañero debe implementar la lógica de negocio perfecta según el flujo esperado.
    }

    @Override
    public NotificacionResponseDTO getById(Long id) {
        /*
         * INTENCIÓN: Consultar si un mensaje específico se envió.
         */
        return null; // TODO: Tu compañero debe implementar la lógica de negocio perfecta según el flujo esperado.
    }

    @Override
    public List<NotificacionResponseDTO> listarPorEstado(EstadoNotificacion estado) {
        /*
         * INTENCIÓN: Listar para posible reintento (ej. buscar todas las FALLIDAS).
         */
        return null; // TODO: Tu compañero debe implementar la lógica de negocio perfecta según el flujo esperado.
    }
}
