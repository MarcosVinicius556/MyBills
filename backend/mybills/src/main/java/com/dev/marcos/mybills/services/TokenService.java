package com.dev.marcos.mybills.services;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dev.marcos.mybills.entities.User;

@Service
public class TokenService {

    private static final String ISSUER = "User";
    private static final String SECRET = "s3cret";

    /**
     * @apiNote this generates a token for users
     * @param user
     * @return String userToken
     */
    public String generateToken(User user){
        return JWT.create()
                  .withIssuer(ISSUER)
                  .withSubject(user.getUsername())
                  .withClaim("id", user.getId())
                  .withExpiresAt(LocalDateTime.now().plusMinutes(40).toInstant(ZoneOffset.of("-03:00")))
                  .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * @apiNote this method verify an user token and provides the subject
     * @param token
     * @return String subject
     */
    public String getSubject(String token) {
        return JWT.require(Algorithm.HMAC256(SECRET))
                  .withIssuer(ISSUER)
                  .build()
                  .verify(token)
                  .getSubject();
    }

}
