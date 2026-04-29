import os
import shutil

def limpiar_y_reemplazar_configs():
    # Directorio base del proyecto
    base_path = os.getcwd()
    
    # Lista de microservicios basada en tu estructura de archivos
    microservicios = [
        'ms-auth', 'ms-usuarios', 'ms-sucursales', 'ms-menu', 
        'ms-categorias', 'ms-carrito', 'ms-pedidos', 'ms-pagos', 
        'ms-delivery', 'ms-inventario', 'ms-notificaciones', 'ms-reportes'
    ]

    for ms in microservicios:
        ms_path = os.path.join(base_path, ms)
        
        if os.path.isdir(ms_path):
            # Ruta estándar de Spring Boot
            resources_dir = os.path.join(ms_path, 'src', 'main', 'resources')
            
            # Archivo nuevo (con apellido) y destino (genérico)
            archivo_nuevo_con_apellido = os.path.join(ms_path, f"application-{ms}.yml")
            archivo_destino_final = os.path.join(resources_dir, "application.yml")

            # 1. Crear carpeta resources si no existe
            if not os.path.exists(resources_dir):
                os.makedirs(resources_dir)

            # 2. ELIMINAR el application.yml viejo si existe en resources
            if os.path.exists(archivo_destino_final):
                try:
                    os.remove(archivo_destino_final)
                    print(f"[{ms}] Eliminado application.yml antiguo.")
                except Exception as e:
                    print(f"[{ms}] Error al eliminar el archivo antiguo: {e}")

            # 3. MOVER y RENOMBRAR el nuevo archivo con apellido
            if os.path.exists(archivo_nuevo_con_apellido):
                try:
                    shutil.move(archivo_nuevo_con_apellido, archivo_destino_final)
                    print(f"[{ms}] REEMPLAZO EXITOSO: application-{ms}.yml -> resources/application.yml")
                except Exception as e:
                    print(f"[{ms}] Error al mover el archivo nuevo: {e}")
            else:
                print(f"[{ms}] Advertencia: No se encontró el archivo 'application-{ms}.yml' en la raíz.")
        else:
            print(f"Omitiendo: La carpeta {ms} no existe en este directorio.")

if __name__ == "__main__":
    limpiar_y_reemplazar_configs()