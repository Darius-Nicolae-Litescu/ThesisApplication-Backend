package darius.licenta.backend.configuration.security;

import darius.licenta.backend.domain.sql.UserRole;
import darius.licenta.backend.exception.InvalidJwtException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class JwtTokenProvider {


    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    @Value("${security.jwt.token.expire-length:3600000}")
    private long validityInMilliseconds = 3600000; // 1h

    @Autowired
    private UserJwtDetailsService userJwtDetailsService;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String username, List<UserRole> userRoles) {

        Claims claims = Jwts.claims().setSubject(username);
        claims.put("auth", userRoles.stream().map(Enum::toString).collect(Collectors.toList()));

        Date now = new Date();
        Date validity = new Date(now.getTime() + validityInMilliseconds);


        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(validity)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userJwtDetailsService.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    public String getUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            throw new InvalidJwtException("Expired or invalid JWT token");
        }
    }

}