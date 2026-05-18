package cl.triskeledu.menu.mapper;

import cl.triskeledu.menu.dto.request.CategoriaRequestDTO;
import cl.triskeledu.menu.dto.response.CategoriaResponseDTO;
import cl.triskeledu.menu.entity.Categoria;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-17T20:45:42-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Red Hat, Inc.)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaResponseDTO toResponseDTO(Categoria categoria) {
        if ( categoria == null ) {
            return null;
        }

        CategoriaResponseDTO.CategoriaResponseDTOBuilder categoriaResponseDTO = CategoriaResponseDTO.builder();

        categoriaResponseDTO.id( categoria.getId() );
        categoriaResponseDTO.nombre( categoria.getNombre() );
        categoriaResponseDTO.descripcion( categoria.getDescripcion() );
        categoriaResponseDTO.activa( categoria.getActiva() );
        categoriaResponseDTO.creadoEn( categoria.getCreadoEn() );
        categoriaResponseDTO.actualizadoEn( categoria.getActualizadoEn() );

        return categoriaResponseDTO.build();
    }

    @Override
    public Categoria toEntity(CategoriaRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Categoria.CategoriaBuilder categoria = Categoria.builder();

        categoria.nombre( dto.getNombre() );
        categoria.descripcion( dto.getDescripcion() );

        return categoria.build();
    }

    @Override
    public void updateEntityFromDto(CategoriaRequestDTO dto, Categoria target) {
        if ( dto == null ) {
            return;
        }

        target.setNombre( dto.getNombre() );
        target.setDescripcion( dto.getDescripcion() );
    }
}
