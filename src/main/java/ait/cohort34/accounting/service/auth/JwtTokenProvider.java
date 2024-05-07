package ait.cohort34.accounting.service.auth;


import io.jsonwebtoken.*;
import ait.cohort34.accounting.dto.exceptions.InvalidJwtException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtTokenProvider {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.lifetime}")
    private long jwtLifetime;

    public String createToken(UserDetails userDetails) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtLifetime);

        return Jwts.builder()
                //.setSubject()
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .compact();
    }

    public String getManagerNameFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            // Invalid JWT signature
            throw new InvalidJwtException("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            // Invalid JWT token
            throw new InvalidJwtException("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            // Expired JWT token
            throw new InvalidJwtException("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            // Unsupported JWT token
            throw new InvalidJwtException("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            // JWT claims string is empty
            throw new InvalidJwtException("JWT claims string is empty");
        }
    }
}
