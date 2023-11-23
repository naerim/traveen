package com.ssafy.interceptor;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ssafy.exception.UnAuthorizedException;
import com.ssafy.util.JWTUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JWTInterceptor implements HandlerInterceptor {

	private final String HEADER_AUTH = "Authorization";
	
	private JWTUtil jwtUtil;

//	public JWTInterceptor(JWTUtil jwtUtil) {
//		super();
//		this.jwtUtil = jwtUtil;
//	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		final String token = request.getHeader(HEADER_AUTH);

		if (token != null && jwtUtil.checkToken(token)) {
//			log.info("토큰 사용 가능 : {}", token);
			return true;
		} else {
//			log.info("토큰 사용 불가능 : {}", token);
			//throw new UnAuthorizedException();
			return false;
		}

	}
}
