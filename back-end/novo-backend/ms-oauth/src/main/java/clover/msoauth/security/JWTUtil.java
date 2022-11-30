package clover.msoauth.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JWTUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    // chamar , dentro desse método, um método da biblioteca jsonwebtoken
    public String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS512, secret.getBytes()) // qual o algoritmo de assinatura a se utilizar e qual o segredo, num array de bytes
                .compact();
    }

    public boolean tokenValido(String token){
        // Claims -> Armazena as reivindicações do token. No nosso caso é o usuário e o tempo de expiração. Ela está alegando que ela é usuario x e seu tempo
        // para expiração é y.
        Claims claims = getClaims(token);
        if(claims != null){
            String username = claims.getSubject();
            Date expirationDate = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());
            if(username != null && expirationDate != null && now.before(expirationDate)){
                return true;
            }
        }
        return false;
    }

    public String getUsername(String token) {
        Claims claims = getClaims(token);
        if (claims != null) {
            return claims.getSubject();
        }
        return null;
    }

    private Claims getClaims(String token) {
        // recupera um claims a partir de um token, caso esse token seja válido
        try{
            return Jwts.parser().setSigningKey(secret.getBytes()).parseClaimsJws(token).getBody();
        }
        catch (Exception e){
            return null;
        }
    }

}
