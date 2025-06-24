package com.ShambaSmart.gateway;

import com.ShambaSmart.gateway.security.TestSecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {ApiGatewayApplication.class, TestSecurityConfig.class})
class GatewayTests {

	@Test
	void contextLoads() {
	}

}
