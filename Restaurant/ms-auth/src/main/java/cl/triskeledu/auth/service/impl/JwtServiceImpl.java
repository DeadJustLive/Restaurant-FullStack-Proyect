package cl.triskeledu.auth.service.impl;

import cl.triskeledu.auth.entity.UserCredential;
import cl.triskeledu.auth.service.JwtService;
import org.springframework.stereotype.Service;

@Service
public class JwtServiceImpl implements JwtService {

    @Override
    public String generarToken(UserCredential credential) {
        return "mock-jwt-token";
    }

    @Override
    public String generarRefreshToken(Long userId) {
        return "mock-refresh-token";
    }

    @Override
    public Long extraerUserId(String token) {
        return 1L;
    }

    @Override
    public String extraerUsername(String token) {
        return "mockuser";
    }

    @Override
    public String extraerRol(String token) {
        return "ROLE_CL";
    }

    @Override
    public boolean esValido(String token) {
        return true;
    }
}
