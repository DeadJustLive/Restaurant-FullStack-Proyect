package cl.triskeledu.auth.config;

import cl.triskeledu.auth.entity.UserCredential;
import cl.triskeledu.auth.repository.UserCredentialRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Componente que al arrancar ms-auth verifica y corrige los passwords seed.
 *
 * El hash original en init-db/01-auth.sql era INCORRECTO (no codifica "123456").
 * Este runner recalcula el hash BCrypt correcto para todos los usuarios
 * que usan la password seed por defecto.
 *
 * SEED_PASSWORD = "123456" — la password documentada en AGENTS.md y Guion.
 *
 * Este componente es IDEMPOTENTE: si el hash ya es correcto, no modifica nada.
 * Solo actúa si detecta que el hash actual NO coincide con "123456".
 *
 * @kind(infrastructure)
 * @use(zero-trust-jwt)
 */
@Component
@RequiredArgsConstructor
@Slf4j
@Order(1)
public class SeedPasswordFixer implements CommandLineRunner {

    private static final String SEED_PASSWORD = "123456";

    private final UserCredentialRepository userCredentialRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void run(String... args) {
        log.info("[SeedPasswordFixer] Verificando passwords de usuarios seed...");

        List<UserCredential> allCredentials = userCredentialRepository.findAll();

        int fixed = 0;
        int skipped = 0;

        for (UserCredential cred : allCredentials) {
            boolean matches = passwordEncoder.matches(SEED_PASSWORD, cred.getPassword());

            if (matches) {
                skipped++;
            } else {
                String newHash = passwordEncoder.encode(SEED_PASSWORD);
                cred.setPassword(newHash);
                userCredentialRepository.save(cred);
                fixed++;
            }
        }

        if (fixed > 0) {
            log.warn("[SeedPasswordFixer] Corregidos {} passwords que no coincidian con '{}'.", fixed, SEED_PASSWORD);
        }
        if (skipped > 0) {
            log.info("[SeedPasswordFixer] {} usuarios ya tenian password correcto — sin cambios.", skipped);
        }
        log.info("[SeedPasswordFixer] Verificacion completada: {} usuarios total.", allCredentials.size());
    }
}
