package cl.triskeledu.menu.mapper;

import cl.triskeledu.menu.dto.request.MenuItemRequestDTO;
import cl.triskeledu.menu.dto.response.MenuItemResponseDTO;
import cl.triskeledu.menu.entity.MenuItem;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-05-17T20:45:42-0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 25.0.2 (Red Hat, Inc.)"
)
@Component
public class MenuItemMapperImpl implements MenuItemMapper {

    @Override
    public MenuItemResponseDTO toResponseDTO(MenuItem menuItem) {
        if ( menuItem == null ) {
            return null;
        }

        MenuItemResponseDTO.MenuItemResponseDTOBuilder menuItemResponseDTO = MenuItemResponseDTO.builder();

        menuItemResponseDTO.id( menuItem.getId() );
        menuItemResponseDTO.nombre( menuItem.getNombre() );
        menuItemResponseDTO.descripcion( menuItem.getDescripcion() );
        menuItemResponseDTO.precio( menuItem.getPrecio() );
        menuItemResponseDTO.imagenUrl( menuItem.getImagenUrl() );
        menuItemResponseDTO.disponible( menuItem.getDisponible() );
        menuItemResponseDTO.sucursalId( menuItem.getSucursalId() );
        menuItemResponseDTO.creadoEn( menuItem.getCreadoEn() );
        menuItemResponseDTO.actualizadoEn( menuItem.getActualizadoEn() );

        return menuItemResponseDTO.build();
    }

    @Override
    public MenuItem toEntity(MenuItemRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MenuItem.MenuItemBuilder menuItem = MenuItem.builder();

        menuItem.nombre( dto.getNombre() );
        menuItem.descripcion( dto.getDescripcion() );
        menuItem.precio( dto.getPrecio() );
        menuItem.imagenUrl( dto.getImagenUrl() );
        menuItem.disponible( dto.getDisponible() );
        menuItem.sucursalId( dto.getSucursalId() );

        return menuItem.build();
    }

    @Override
    public void updateEntityFromDto(MenuItemRequestDTO dto, MenuItem target) {
        if ( dto == null ) {
            return;
        }

        target.setNombre( dto.getNombre() );
        target.setDescripcion( dto.getDescripcion() );
        target.setPrecio( dto.getPrecio() );
        target.setImagenUrl( dto.getImagenUrl() );
        target.setDisponible( dto.getDisponible() );
        target.setSucursalId( dto.getSucursalId() );
    }
}
