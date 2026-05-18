-- fix-passwords.sql
-- Ejecutar con: docker exec -i restaurant-postgres psql -U postgres -d auth < fix-passwords.sql
-- O copiar al contenedor y ejecutar: docker cp fix-passwords.sql restaurant-postgres:/tmp/ && docker exec restaurant-postgres psql -U postgres -d auth -f /tmp/fix-passwords.sql

UPDATE user_credentials SET password = '$2a$10$1sPnz9oX7wNmCKXNJChky.SA6Z9sU0h8gYH17DZdaxr5PN1fqFcSe';
