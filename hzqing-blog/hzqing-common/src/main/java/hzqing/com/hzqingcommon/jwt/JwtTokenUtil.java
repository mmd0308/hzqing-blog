package hzqing.com.hzqingcommon.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class JwtTokenUtil {


    public static String generateToken(Map<String, Object> claims,String secret,Integer expiration) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate(expiration))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    private static Date generateExpirationDate(Integer expiration) {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    public static String getUsernameFromToken(String token, String secret) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token,secret);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
    private static Claims getClaimsFromToken(String token,String secret) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }
}
