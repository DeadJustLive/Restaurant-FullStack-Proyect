package cl.triskeledu.pagos.mapper;

import cl.triskeledu.pagos.dto.request.PagoRequestDTO;
import cl.triskeledu.pagos.dto.response.PagoResponseDTO;
import cl.triskeledu.pagos.entity.Pago;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-17T21:34:26-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Red Hat, Inc.)"
)
@Component
public class PagoMapperImpl implements PagoMapper {

    @Override
    public PagoResponseDTO toResponseDTO(Pago pago) {
        if ( pago == null ) {
            return null;
        }

        PagoResponseDTO.PagoResponseDTOBuilder pagoResponseDTO = PagoResponseDTO.builder();

        pagoResponseDTO.id( pago.getId() );
        pagoResponseDTO.pedidoId( pago.getPedidoId() );
        pagoResponseDTO.monto( pago.getMonto() );
        pagoResponseDTO.metodo( pago.getMetodo() );
        pagoResponseDTO.estado( pago.getEstado() );
        pagoResponseDTO.transaccionId( pago.getTransaccionId() );
        pagoResponseDTO.creadoEn( pago.getCreadoEn() );
        pagoResponseDTO.actualizadoEn( pago.getActualizadoEn() );

        return pagoResponseDTO.build();
    }

    @Override
    public Pago toEntity(PagoRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Pago.PagoBuilder pago = Pago.builder();

        pago.pedidoId( dto.getPedidoId() );
        pago.monto( dto.getMonto() );
        pago.metodo( dto.getMetodo() );

        return pago.build();
    }
}
