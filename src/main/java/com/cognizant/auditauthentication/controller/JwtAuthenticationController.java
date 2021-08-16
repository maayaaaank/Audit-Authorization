package com.cognizant.auditauthentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.auditauthentication.config.JwtTokenUtil;
import com.cognizant.auditauthentication.exception.AuthorizationException;
import com.cognizant.auditauthentication.model.JwtRequest;
import com.cognizant.auditauthentication.model.JwtResponse;
import com.cognizant.auditauthentication.service.JwtUserDetailsService;

import io.jsonwebtoken.ExpiredJwtException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin
@Slf4j
@Api(value = "JwtAuthenticationController")
public class JwtAuthenticationController {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	/**
	 * @param authenticationRequest
	 * @return
	 * @throws AuthorizationException
	 * @throws Exception
	 */
	@ApiOperation(value = "Authenticate a user and create Authentication token", response = ResponseEntity.class, tags = "createAuthenticationToken")
	@PostMapping(value = "/authenticate")
	public ResponseEntity<Object> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest)
			throws AuthorizationException {
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
		log.debug("User Details :{}", userDetails);
		if (passwordEncoder.matches(authenticationRequest.getPassword(), userDetails.getPassword())) {

			final String token = jwtTokenUtil.generateToken(userDetails);
			return ResponseEntity.ok(new JwtResponse(token));
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}

	}

	@ApiOperation(value = "Authorize a user ", tags = "authorizeTheRequest")
	@PostMapping(value = "/authorize")
	public boolean authorizeTheRequest(
			@RequestHeader(value = "Authorization", required = true) String requestTokenHeader) {
		log.debug("Inside authorize ============== {}", requestTokenHeader);
		String jwtToken = null;
		String userName = null;
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			jwtToken = requestTokenHeader.substring(7);
			log.debug("JWT Token ======================= {}", jwtToken);
			try {
				userName = jwtTokenUtil.getUsernameFromToken(jwtToken);
			} catch (IllegalArgumentException | ExpiredJwtException e) {
				return false;
			}
		}
		return userName != null;

	}

}