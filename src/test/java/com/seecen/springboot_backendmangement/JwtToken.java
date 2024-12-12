package com.seecen.springboot_backendmangement;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName JwtToken
 * @Description TODO
 * @Author aql
 * @Date 2024/12/9 下午2:44
 * @Version 1.0
 **/
public class JwtToken {

    @Test
    public void test() {
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("username", "admin");

        //生成jwt代码
      String jwtToken =   JWT.create()
                //添加载荷
                .withClaim("username", claims)
                //添加过期时间
                .withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24))
                //设置签名算法和密钥
                .sign(Algorithm.HMAC256("secret"));

        System.out.println(jwtToken);
    }

    @Test
    public void testParse(){
        //定义字符串，模拟用户传递过来的token
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MzM5NzAzNTEsInVzZXJuYW1lIjp7ImlkIjoxLCJ1c2VybmFtZSI6ImFkbWluIn19.nwHfP2tcEWUamtrxHkNOFOFkOccGZM8qaVr7Ba6ttKY";


        JWTVerifier secret = JWT.require(Algorithm.HMAC256("secret")).build();

        //验证token,生成一个解析后的JWT对象
        DecodedJWT jwt = secret.verify(token);

        Map<String, Claim> claims = jwt.getClaims();
        System.out.println(claims.get("username"));

    }
}
