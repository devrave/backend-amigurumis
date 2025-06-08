package com.amigurumis_atelier.backend.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Claims;
import java.util.Date;

public class JwtUtil {
    private static final String SECRET_KEY = "mi_clave_secreta_super_segura";
    private static final long EXPIRATION_TIME = 86400000; // 1 día en ms

    public static String generateToken(String subject, Long userId, String rol) {
        return Jwts.builder()
                .setSubject(subject)
                .claim("id", userId)
                .claim("rol", rol)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    public static Claims validateToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
