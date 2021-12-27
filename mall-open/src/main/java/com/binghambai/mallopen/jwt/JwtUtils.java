package com.binghambai.mallopen.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.binghambai.mallopen.response.LoginResponse;
import com.mall.common.provider.Exception.SbcException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    //设置过期时间
    private static final long EXPIRE_DATE=3*24*60*60*1000;
    //token秘钥
    private static final String TOKEN_SECRET = "ZCfasfhuaUUHufguGuwu2020BQWE";

    public static String createToken (String username,String phone){

        String token = "";
        try {
            //过期时间
            Date date = new Date(System.currentTimeMillis()+EXPIRE_DATE);
            //秘钥及加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            //设置头部信息
            Map<String,Object> header = new HashMap<>();
            header.put("typ","JWT");
            header.put("alg","HS256");
            //携带username，password信息，生成签名
            token = JWT.create()
                    .withHeader(header)
                    .withClaim("username",username)
                    .withClaim("phone", phone).withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
        return token;
    }

    public static boolean verify(String token){
        /**
         * @desc   验证token，通过返回true
         * @params [token]需要校验的串
         **/
        try {
            Map<String, Claim> claims = getClaim(token);
            Date date = new Date(System.currentTimeMillis());
            return claims.get("exp").toString().compareTo(date.toString()) < 0;
        }catch (Exception e){
            e.printStackTrace();
            return  false;
        }
    }

    public static LoginResponse getUser(String token) {
        try {
            Map<String, Claim> claims = getClaim(token);
            Date date = new Date(System.currentTimeMillis());
            if (claims.get("exp").toString().compareTo(date.toString()) >= 0) {
                return null;
            }
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setUserName(claims.get("username").toString());
            loginResponse.setUserPhone(claims.get("phone").toString());
            return loginResponse;
        }catch (Exception e){
            return  null;
        }
    }

    public static Map<String, Claim> getClaim(String token) {
        Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
        JWTVerifier verifier = JWT.require(algorithm).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaims();
    }
}