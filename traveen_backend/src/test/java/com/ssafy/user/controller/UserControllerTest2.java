package com.ssafy.user.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.ssafy.user.model.service.UserService;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(properties = { "spring.config.location=classpath:application.properties" })
@Slf4j
@ComponentScan(basePackages = {"com.ssafy"})
@ContextConfiguration(classes = UserController.class)
class UserControllerTest2 {
	@Value("${userId}")
	private String userId;

	@Value("${userPwd}")
	private String userPwd;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private UserService userService;

	@Test
	@Disabled
	void testUserController() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testIdCheck() {
		fail("Not yet implemented");
	}

	@Test
	@DisplayName("### 로그인 테스트 ####")
	void testLogin() throws Exception {
		log.debug("#### 로그인 테스트 시작 ####");
		mockMvc.perform(get("/user"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andDo(print());
		log.debug("#### 로그인 테스트 종료 ####");
	}

	@Test
	@Disabled
	void testLoginMapOfStringStringStringModelHttpSessionHttpServletResponseHttpServletRequest() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testLogout() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testJoin() {
		fail("Not yet implemented");
	}

	@Test
	@Disabled
	void testJoinMapOfStringStringModel() {
		fail("Not yet implemented");
	}

}
