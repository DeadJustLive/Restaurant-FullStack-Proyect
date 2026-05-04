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

@Service
public class JwtServiceImpl implements JwtService {

    // Using a hardcoded secret for demo/dev purposes, but normally from application.yml
    @Value("${application.security.jwt.secret-key:404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970}")
    private String secretKey;

    @Value("${application.security.jwt.expiration:86400000}")
    private long jwtExpiration;

    @Value("${application.security.jwt.refresh-token.expiration:604800000}")
    private long refreshExpiration;

    @Override
    public String generarToken(UserCredential credential) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("userId", credential.getId());
        extraClaims.put("rol", credential.getRol().name());
        return buildToken(extraClaims, credential.getUsername(), jwtExpiration);
    }

    @Override
    public String generarRefreshToken(Long userId) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("userId", userId);
        extraClaims.put("isRefresh", true);
        return buildToken(extraClaims, "refresh-user-" + userId, refreshExpiration);
    }

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

    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
