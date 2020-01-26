package com.inquisitive.gateway.model;

import org.springframework.beans.factory.annotation.Value;

/**
 * Created by ankitmishra on 26/01/20.
 */
public class JwtConfig {
    @Value("${security.jwt.uri:/auth/**}")
    private String Uri;

    @Value("${security.jwt.header:Authorization}")
    private String header;

    @Value("${security.jwt.prefix:Bearer }")
    private String prefix;

    @Value("${security.jwt.expiration:#{24*60*60}}")
    private int expiration;

    @Value("${security.jwt.secret:JwtSecretKey}")
    private String secret;

   //Temporary URI to whitelist User Service. Should be removed once Authentication is implemented
    @Value("${security.jwt.uri:/user/**}")
    private String UserServiceUri;

    public String getUri() {
        return Uri;
    }

    public String getHeader() {
        return header;
    }

    public String getPrefix() {
        return prefix;
    }

    public int getExpiration() {
        return expiration;
    }

    public String getSecret() {
        return secret;
    }

    public String getUserServiceUri() {
        return UserServiceUri;
    }
}
