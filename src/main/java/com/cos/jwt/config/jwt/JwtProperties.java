package com.cos.jwt.config.jwt;

public class JwtProperties {

    public static final String SECRET = "cos";
    public static final int EXPIRATION_TIME = 60000 * 10; //10분
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";

}
