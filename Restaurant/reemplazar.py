import os
import shutil

def reemplazar_configs_con_apellido():
    # Directorio base donde están las carpetas ms-*
    base_path = os.getcwd()
    
    # Mapeo de carpeta -> apellido del archivo yml
    # Basado en tu estructura de microservicios
    microservicios = {
        'ms-auth': 'auth',
        'ms-usuarios': 'usuarios',
        'ms-sucursales': 'sucursales',
        'ms-menu': 'menu',
        'ms-categorias': 'categorias',
        'ms-carrito': 'carrito',
        'ms-pedidos': 'pedidos',
        'ms-pagos': 'pagos',
        'ms-delivery': 'delivery',
        'ms-inventario': 'inventario',
        'ms-notificaciones': 'notificaciones',
        'ms-reportes': 'reportes'
    }

    for folder, apellido in microservicios.items():
        ms_folder_path = os.path.join(base_path, folder)
        
        if os.path.isdir(ms_folder_path):
            # 1. Definir rutas
            # Archivo nuevo: ms-sucursales/application-sucursales.yml
            archivo_nuevo = os.path.join(ms_folder_path, f"application-{apellido}.yml")
            
            # Destino: ms-sucursales/src/main/resources/application.yml
            resources_dir = os.path.join(ms_folder_path, 'src', 'main', 'resources')
            destino_final = os.path.join(resources_dir, "application.yml")

            # 2. Asegurar que existe la carpeta resources
            if not os.path.exists(resources_dir):
                os.makedirs(resources_dir)

            # 3. Eliminar el application.yml viejo si existe
            if os.path.exists(destino_final):
                os.remove(destino_final)
                print(f"[{folder}] Borrado application.yml antiguo.")

            # 4. Mover y renombrar el archivo con apellido
            if os.path.exists(archivo_nuevo):
                shutil.move(archivo_nuevo, destino_final)
                print(f"[{folder}] EXITO: application-{apellido}.yml movido a resources/application.yml")
            else:
                print(f"[{folder}] Error: No se encontró el archivo '{os.path.basename(archivo_nuevo)}' en la raíz.")
        else:
            print(f"Saltando: La carpeta {folder} no existe.")

if __name__ == "__main__":
    reemplazar_configs_con_apellido()