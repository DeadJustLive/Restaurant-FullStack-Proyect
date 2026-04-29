package cl.triskeledu.menu.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * =============================================================================
 * EXCEPTION: ItemDuplicadoException
 * =============================================================================
 * Lanzada cuando se intenta crear un MenuItem con un nombre que ya existe
 * en la misma categoría.
 * HTTP 409 Conflict.
 *
 * CUÁNDO LANZARLA:
 *   - MenuItemServiceImpl.crear() → existsByNombreIgnoreCaseAndCategoriaId() retorna true.
 *
 * MENSAJE RECOMENDADO:
 *   "Ya existe un ítem con el nombre '{nombre}' en la categoría ID: {categoriaId}"
 *
 * TODO: Evaluar si la unicidad debe ser (nombre, categoriaId, sucursalId).
 *       Si la misma sucursal puede tener su propia versión de "Hamburguesa Clásica"
 *       con precio distinto, la restricción de unicidad actual es demasiado estricta.
 * =============================================================================
 */
@ResponseStatus(HttpStatus.CONFLICT)
public class ItemDuplicadoException extends RuntimeException {
    public ItemDuplicadoException(String mensaje) {
        super(mensaje);
    }
}
