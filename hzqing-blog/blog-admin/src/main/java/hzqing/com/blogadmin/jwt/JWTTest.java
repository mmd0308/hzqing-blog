package hzqing.com.blogadmin.jwt;

import hzqing.com.hzqingcommon.jwt.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JWTTest {
    public static void main(String[] args) throws InterruptedException {
        String jwt = getJwt();
        System.out.println(jwt);
        parseJWT(jwt);
        System.out.println(getJwt());
    }
    /**
     * 生成JWT
     * @return
     */
    public static String getJwt(){
        // 定义签名的加密算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        Map<String, Object> claims = new HashMap<String, Object>();  // Claims包含您想要签署的任何信息
        //Map claims = new HashMap();
        claims.put("userId","adminuserID");
        JwtBuilder builder = Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis())) //JWT的签发时间  timestamp
                .setExpiration(new Date(System.currentTimeMillis() + 10000)) //JWT的过期时间，这个过期时间必须大于签发时间 一个小时以后过期
                .setSubject("admin") //sub： JWT所面向的用户
                .setIssuer("hzqing.com")  //iss： JWT签发者
                .setAudience("admin") //aud： 接受JWT的一方
                .setNotBefore(new Date(System.currentTimeMillis())) //nbf： 定义在什么时间之前，该JWT都是不可用的
                .setId(UUID.randomUUID().toString()) //jti： JWT的唯一身份标识，主要用作为一次性token，从而回避重放攻击。
                .signWith(signatureAlgorithm,"hzqing.com"); // jwt 签名
        String jwt = builder.compact();
        return jwt;
    }
    /**
     * 解析JWT
     * @param jwt
     */
    public static void parseJWT(String jwt){
        Claims body = Jwts.parser().setSigningKey("hzqing.com").parseClaimsJws(jwt).getBody();
        System.out.println("JWT的唯一标识: " +body.getId());
        System.out.println("JWT所面向的用户: "+body.getSubject());
        System.out.println("JWT 的签发时间: " + body.getIssuedAt());
        System.out.println("JWT 在此刻之前不可以使用: " + body.getNotBefore());
        System.out.println("JWT过期时间: " +body.getExpiration());
        System.out.println(body.get("userId"));
        System.out.println(body.getIssuedAt().getTime());
        System.out.println(body.getExpiration().getTime());
        System.out.println(new Date().getTime());
    }
}
