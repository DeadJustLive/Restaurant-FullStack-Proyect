import os

IGNORED_DIRS = {'.git', 'node_modules', 'dist', '.gemini', 'public'}
IGNORED_FILES = {'ExtractorInformacion.py', 'package-lock.json','.env.local','.env'}
IGNORED_EXTENSIONS = {'.png', '.jpg', '.jpeg', '.gif', '.ico', '.svg', '.webp', '.pdf', '.woff', '.woff2', '.ttf','.env'}

def generate_tree(dir_path, prefix=""):
    tree_str = ""
    try:
        entries = sorted(os.listdir(dir_path))
    except PermissionError:
        return ""
    
    entries = [e for e in entries if e not in IGNORED_DIRS and e not in IGNORED_FILES]
    for i, entry in enumerate(entries):
        path = os.path.join(dir_path, entry)
        is_last = (i == len(entries) - 1)
        
        connector = "└── " if is_last else "├── "
        tree_str += f"{prefix}{connector}{entry}\n"
        
        if os.path.isdir(path):
            extension = "    " if is_last else "│   "
            tree_str += generate_tree(path, prefix + extension)
            
    return tree_str

def main():
    base_dir = os.path.abspath(os.path.dirname(__file__))
    project_name = os.path.basename(base_dir)+"_Proyecto_Completo"
    output_filename = f"{project_name}.md"
    output_file = os.path.join(base_dir, output_filename)
    
    with open(output_file, 'w', encoding='utf-8') as out:
        out.write("# Contenido del Proyecto\n\n")
        
        for root, dirs, files in os.walk(base_dir):
            dirs[:] = [d for d in dirs if d not in IGNORED_DIRS]
            
            for file in sorted(files):
                if file in IGNORED_FILES or file == output_filename:
                    continue
                    
                _, ext = os.path.splitext(file)
                if ext.lower() in IGNORED_EXTENSIONS:
                    continue
                
                file_path = os.path.join(root, file)
                rel_path = os.path.relpath(file_path, base_dir)
                
                try:
                    with open(file_path, 'r', encoding='utf-8') as f:
                        content = f.read()
                except UnicodeDecodeError:
                    continue # Sirve para evadir binarios que por casualidad no estaban en excluidos
                
                language = ext.replace('.', '')
                if language not in ['ts', 'tsx', 'js', 'jsx', 'json', 'css', 'html', 'md', 'mdx']:
                    language = ''
                
                if language == 'md' and file_path == output_file:
                    continue # Evitar redundancia si el archivo se llama distinto de imprevisto

                out.write(f"### Archivo: {rel_path}\n")
                out.write(f"```{language}\n")
                out.write(content)
                if not content.endswith('\n'):
                    out.write('\n')
                out.write("```\n\n")

        out.write("# Estructura de Carpetas\n")
        out.write("```text\n")
        out.write(os.path.basename(base_dir) + "/\n")
        out.write(generate_tree(base_dir))
        out.write("```\n")
        
    print(f"✅ Extracción completada. El archivo '{output_file}' ha sido generado.")

if __name__ == '__main__':
    main()
