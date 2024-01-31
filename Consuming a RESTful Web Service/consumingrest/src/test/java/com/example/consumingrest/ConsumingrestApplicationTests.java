package com.example.consumingrest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class ConsumingrestApplicationTests {

	@Autowired
	private RestTemplate restTemplate;

	@Test
	void contextLoads() {
		assertThat(restTemplate).isNotNull();
	}

}
