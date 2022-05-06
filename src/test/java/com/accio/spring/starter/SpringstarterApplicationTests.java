package com.accio.spring.starter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
//@Testcontainers
@ActiveProfiles("test-containers")
class SpringstarterApplicationTests {

	@Test
	void contextLoads() {
	}

}
