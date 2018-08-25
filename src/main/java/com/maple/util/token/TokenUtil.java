package com.maple.util.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenUtil {
    private TokenUtil() {
    }

    // 密钥
    private static final String SECRET = "maple-mall-server-by-gorilla-nmslwsndhjyzyrwcsltzwlsc";

    /**
     * 创建token
     *
     * @param uid
     * @return
     */
    public static String createToken(int uid) {
        String token = null;

        // 定义签发时间和过期时间
        Date iatDate = new Date();
        Calendar now = Calendar.getInstance();
        now.add(Calendar.HOUR,1);
        Date expireDate = now.getTime();

        // 定义jwt头部信息
        Map<String, Object> header = new HashMap<String, Object>();
        header.put("alg","HS256");
        header.put("typ", "JWT");

        // 生成token
        try {
            return JWT.create()
                    .withHeader(header)
                    .withClaim("uid",uid)
                    .withIssuedAt(iatDate)
                    .withExpiresAt(expireDate)
                    .sign(Algorithm.HMAC256(SECRET));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String,Claim> verifyToken(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            return verifier.verify(token).getClaims();
        } catch (UnsupportedEncodingException e) {
            return null;
        }
    }
}
