package cl.triskeledu.auth.service.impl;

import cl.triskeledu.auth.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @use(auth)
 * @kind(service)
 * @contract(in: Long userId, String refreshToken -> out: void @error: TokenInvalidoException)
 * @limit(lines: 150)
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final ConcurrentHashMap<Long, Set<String>> tokenStore = new ConcurrentHashMap<>();

    @Override
    public void storeRefreshToken(Long userId, String refreshToken) {
        tokenStore.computeIfAbsent(userId, k -> Collections.newSetFromMap(new ConcurrentHashMap<>()))
                .add(refreshToken);
        log.debug("Refresh token almacenado para userId={}", userId);
    }

    @Override
    public boolean validateRefreshToken(Long userId, String refreshToken) {
        Set<String> tokens = tokenStore.get(userId);
        return tokens != null && tokens.contains(refreshToken);
    }

    @Override
    public void revokeRefreshToken(Long userId, String refreshToken) {
        Set<String> tokens = tokenStore.get(userId);
        if (tokens != null) {
            tokens.remove(refreshToken);
            log.info("Refresh token revocado para userId={}", userId);
        }
    }

    @Override
    public void revokeAllRefreshTokens(Long userId) {
        Set<String> removed = tokenStore.remove(userId);
        if (removed != null) {
            log.info("Todos los refresh tokens revocados para userId={} ({} tokens)", userId, removed.size());
        }
    }

    @Scheduled(fixedRate = 600000)
    public void cleanupExpiredTokens() {
        log.debug("Ejecutando limpieza de tokens expirados (in-memory: sin expiración trackeable por ahora)");
    }
}