package com.ssafy.traveen;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(properties = { "spring.config.location=classpath:application.properties" })
@Slf4j
class TraveenBackendApplicationTests {
	@Value("${userId}")
	private String userId;

	@Value("${userPwd}")
	private String userPwd;

	@Test
	@DisplayName("#### 프로퍼티 읽기 테스트 ####")
	void contextLoads() {
		log.debug("userId, userPwd : {}, {}", userId, userPwd);
	}

}
