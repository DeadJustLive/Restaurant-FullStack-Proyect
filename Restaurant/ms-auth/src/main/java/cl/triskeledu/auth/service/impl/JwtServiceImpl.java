package cl.triskeledu.auth.service.impl;

import cl.triskeledu.auth.entity.UserCredential;
import cl.triskeledu.auth.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Implementación del servicio JWT utilizando el algoritmo HS256 (HMAC-SHA256).
 * <p>
 * HS256 es un algoritmo de firma simétrica: se utiliza la misma clave secreta
 * ({@code secretKey}) tanto para firmar como para verificar los tokens.
 * La clave de firma se deriva decodificando el secret en Base64 y generando
 * una clave HMAC-SHA a partir de los bytes resultantes (ver {@link #getSignInKey()}).
 * </p>
 */
@Service
public class JwtServiceImpl implements JwtService {

    // Using a hardcoded secret for demo/dev purposes, but normally from application.yml
    @Value("${application.security.jwt.secret-key:404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970}")
    private String secretKey;

    /** Duración del access token: 24 horas (86400000 ms). */
    @Value("${application.security.jwt.expiration:86400000}")
    private long jwtExpiration;

    /** Duración del refresh token: 7 días (604800000 ms). */
    @Value("${application.security.jwt.refresh-token.expiration:604800000}")
    private long refreshExpiration;

    /**
     * Genera un access token (24h) con los claims:
     * sub (username), userId, rol, iat, exp.
     */
    @Override
    public String generarToken(UserCredential credential) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("userId", credential.getId());
        extraClaims.put("rol", credential.getRol().name());
        return buildToken(extraClaims, credential.getUsername(), jwtExpiration);
    }

    /**
     * Genera un refresh token (7 días) con los claims:
     * userId, isRefresh=true (para diferenciarlo del access token).
     */
    @Override
    public String generarRefreshToken(Long userId) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("userId", userId);
        extraClaims.put("isRefresh", true);
        return buildToken(extraClaims, "refresh-user-" + userId, refreshExpiration);
    }

    /**
     * Construye y firma el token JWT con HS256. Establece los claims
     * personalizados, el subject, la fecha de emisión (iat) y la expiración (exp).
     */
    private String buildToken(Map<String, Object> extraClaims, String subject, long expiration) {
        return Jwts
                .builder()
                .setClaims(extraClaims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    @Override
    public Long extraerUserId(String token) {
        return extractClaim(token, claims -> claims.get("userId", Long.class));
    }

    @Override
    public String extraerUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    @Override
    public String extraerRol(String token) {
        return extractClaim(token, claims -> claims.get("rol", String.class));
    }

    /**
     * Valida un token verificando que no haya expirado y que su firma sea correcta
     * (la verificación de firma ocurre implícitamente al parsear el token).
     */
    @Override
    public boolean esValido(String token) {
        try {
            return !isTokenExpired(token);
        } catch (Exception e) {
            return false;
        }
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extrae un claim específico del token parseando primero todos los claims
     * y aplicando la función de resolución {@code claimsResolver}.
     */
    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * Deriva la clave de firma simétrica HS256 a partir del secret.
     * El secret (String) se decodifica de Base64 a bytes y se usa para
     * construir una clave {@link io.jsonwebtoken.security.Keys#hmacShaKeyFor}.
     */
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
