package com.cognizant.auditauthentication.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserModelTest {

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void testPensionerBean() {
		final BeanTester beanTester = new BeanTester();
		beanTester.getFactoryCollection();
		beanTester.testBean(User.class);
	}
}
