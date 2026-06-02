package com.globalsolution.java.celticstech.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.globalsolution.java.celticstech.models.AssociacaoModels;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    private String secret = "celticstech-secret";

    public String gerarToken(AssociacaoModels associacao) {
        Algorithm algorithm = Algorithm.HMAC256(secret);

        return JWT.create()
                .withIssuer("celticstech-api")
                .withSubject(associacao.getLogin())
                .withExpiresAt(gerarExpiracao())
                .sign(algorithm);
    }

    private Instant gerarExpiracao() {
        return LocalDateTime.now()
                .plusHours(2)
                .toInstant(ZoneOffset.of("-03:00"));
    }
}