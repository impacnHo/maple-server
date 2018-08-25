package com.maple.util.token;

import org.junit.Test;

import static org.junit.Assert.*;

public class TokenUtilTest {

    @Test
    public void test() {
        String token = TokenUtil.createToken(2);
        System.out.println(token);
        System.out.println("===========");
        System.out.println(TokenUtil.verifyToken(token));
        System.out.println("===========");
        System.out.println(TokenUtil.verifyToken("nmslwsndhjyz"));
    }
}