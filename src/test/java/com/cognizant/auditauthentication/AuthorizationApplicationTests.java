package com.cognizant.auditauthentication;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class AuthorizationApplicationTests {

	@Test
	void contextLoads() {
		log.info("Inside contextLoads()");
		AuditManagementAuthorizationApplication.main(new String[] {});
		assertTrue(true);
		log.info("End contextLoads()");
	}

}
