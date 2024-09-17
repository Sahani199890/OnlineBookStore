package com.onlinebookstore.user.helper;

import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;

@Service
public class JWTService {
	private String secretKey = "iamadeveloperworkingonmicroservices";
	private String developer = "Abhishek Sahani";

	public String generateToken(String name, String email) {
		Algorithm algorithm = Algorithm.HMAC512(secretKey);
		return JWT.create().withSubject(name + ":" + email).withIssuer(developer).withIssuedAt(new Date())
				.withExpiresAt(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiration
				.sign(algorithm);
	}

	public boolean validateToken(String token, String username) {
		String tokenUsername = extractUsername(token);
		return (username.equals(tokenUsername) && !isTokenExpired(token));
	}

	private String extractUsername(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secretKey);
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT decodedJWT = verifier.verify(token);
			return decodedJWT.getSubject();
		} catch (JWTVerificationException exception) {
			throw new RuntimeException("Invalid token");
		}
	}

	private boolean isTokenExpired(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secretKey);
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT decodedJWT = verifier.verify(token);
			Date expirationDate = decodedJWT.getExpiresAt();
			return expirationDate.before(new Date());
		} catch (JWTVerificationException exception) {
			throw new RuntimeException("Invalid token");
		}
	}
}
