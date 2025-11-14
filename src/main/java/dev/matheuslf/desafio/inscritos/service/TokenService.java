package dev.matheuslf.desafio.inscritos.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import dev.matheuslf.desafio.inscritos.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

  @Value("${spring.api.security.secretKey}")
  private String secret;

  public String generate(User user) {
    Algorithm algorithm = Algorithm.HMAC256(secret);
    return JWT.create()
        .withIssuer("inscritos")
        .withSubject(user.getLogin())
        .withExpiresAt(getExpirationDate())
        .sign(algorithm);
  }

  public String validateToken(String token) {
      Algorithm algorithm = Algorithm.HMAC256(secret);
      return JWT.require(algorithm)
              .withIssuer("inscritos")
              .build()
              .verify(token)
              .getSubject();
  }

  private Instant getExpirationDate() {
    return LocalDateTime.now().plusHours(2).atOffset(ZoneOffset.of("-03:00")).toInstant();
  }
}
