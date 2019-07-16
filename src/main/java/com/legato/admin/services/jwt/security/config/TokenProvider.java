package com.legato.admin.services.jwt.security.config;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.legato.admin.services.jwt.security.dto.AppUser;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Clock;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.impl.DefaultClock;

@Component
public class TokenProvider {
	private static final Logger logger = LoggerFactory.getLogger(TokenProvider.class);
	@Value("${app.secret}")
	private String secret;
	@Value("${app.expiration}")
	private int expiration;
	private Clock clock = DefaultClock.INSTANCE;

	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token, Claims::getSubject);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		AppUser user = (AppUser) userDetails;
		claims.put("id", user.getId());
		claims.put("firstName", user.getFirstName());
		claims.put("lastName", user.getLastName());
		claims.put("email", user.getEmail());
		claims.put("mobile", user.getMobile());
		claims.put("gender", user.getGender());
		claims.put("authorities", user.getAuthorities().stream().map(Object::toString).collect(Collectors.toList()));
		return doGenerateToken(claims, user.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		final Date createdDate = clock.now();
		final Date expirationDate = calculateExpirationDate(createdDate);
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(createdDate)
				.setExpiration(expirationDate).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	private Date calculateExpirationDate(Date createdDate) {
		return new Date(createdDate.getTime() + expiration * 1000);
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		try {
			final String username = getUsernameFromToken(token);
			if (username != null)
				return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
			return false;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature -> Message: {} ", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token -> Message: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("Expired JWT token -> Message: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("Unsupported JWT token -> Message: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty -> Message: {}", e.getMessage());
		}
		return false;
	}

	private Boolean isTokenExpired(String token) {
		final Date expirationDate = getExpirationDateFromToken(token);
		return expirationDate.before(clock.now());
	}

	public Date getExpirationDateFromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public String getUserNameFromJwtToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	public UserDetails getUserDetailsFromToken(String token) {
		final Claims claims = getAllClaimsFromToken(token);
		AppUser user = new AppUser();
		user.setId(Long.parseLong(claims.get("id").toString()));
		user.setUsername(claims.getSubject());
		user.setFirstName(claims.get("firstName").toString());
		user.setLastName(claims.get("lastName").toString());
		user.setEmail(claims.get("email").toString());
		user.setMobile(claims.get("mobile").toString());
		user.setGender((Integer)(claims.get("gender")));
		@SuppressWarnings("unchecked")
		List<String> stringAuthorities = (List<String>) claims.get("authorities");
		Collection<GrantedAuthority> authorities = new HashSet<>();
		for (String priv : stringAuthorities) {
			authorities.add(new SimpleGrantedAuthority(priv));
		}
		user.setAuthorities(authorities);
		return user;
	}
}