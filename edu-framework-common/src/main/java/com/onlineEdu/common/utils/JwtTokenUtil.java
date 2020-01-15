package com.onlineEdu.common.utils;

import com.onlineEdu.common.constants.UserStatusEnum;
import com.onlineEdu.common.exception.LoginException;
import io.jsonwebtoken.*;

import java.util.Date;

/**
 * 生成token的工具类
 */
public class JwtTokenUtil {
    public static final String TOKEN_HEADER = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    private static final String SECRET = "jwtsecretdemo";
    private static final String ISS = "leopard";

    // 过期时间是7天
    private static final long EXPIRATION = 604800L;

    /**
     * 创建token
     * @param id
     * @param username
     * @return
     */
    public static String createToken(String id,String username){
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        JwtBuilder builder = Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .setHeaderParam("typ", "JWT") // 设置header
                .setHeaderParam("alg", "HS256")
                .setIssuedAt(new Date()) // 设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION * 1000))
//                .claim("userId",String.valueOf(id) ) // 设置内容
                .setId(id)
                .setSubject(username)
                .setIssuer(ISS);// 设置签发人
        return builder.compact();
    }

    public static Claims getTokenBody(String token){
        try{
            return Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token)
                    .getBody();
        }catch(ExpiredJwtException expired){
            //过期
            throw new LoginException(UserStatusEnum.TOKEN_EXPIRED);
        }catch (SignatureException e){
            //无效
            throw new LoginException(UserStatusEnum.INVALID_REQUEST);
        }catch(MalformedJwtException malformedJwt){
            //无效
            throw new LoginException(UserStatusEnum.INVALID_REQUEST);
        }
    }

    public static String getId(String token){
        return getTokenBody(token).getId();
    }

    public static String getUsername(String token){
        return getTokenBody(token).getSubject();
    }

    public static boolean isExpiration(String token){
        return getTokenBody(token).getExpiration().before(new Date());
    }
}
