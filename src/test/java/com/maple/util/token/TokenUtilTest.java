package com.maple.util.token;

import com.auth0.jwt.interfaces.Claim;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class TokenUtilTest {

    @Test
    public void test() {
        String token = TokenUtil.createToken(2);
        System.out.println(token);
        System.out.println("===========");
        Map<String,Claim> claims = TokenUtil.verifyToken(token);
        int id = claims.get("uid").asInt();
        System.out.println(id);
    }
}