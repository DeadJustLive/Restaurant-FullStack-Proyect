package cl.triskeledu.auth.service;

/**
 * @use(auth)
 * @kind(service)
 * @contract(in: Long userId, String refreshToken -> out: void @error: TokenInvalidoException)
 * @limit(lines: 150)
 */
public interface RefreshTokenService {
    void storeRefreshToken(Long userId, String refreshToken);
    boolean validateRefreshToken(Long userId, String refreshToken);
    void revokeRefreshToken(Long userId, String refreshToken);
    void revokeAllRefreshTokens(Long userId);
}