package com.ssafy.user.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.user.model.User;
import com.ssafy.user.model.service.UserService;
import com.ssafy.util.JWTUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
@Api(tags = "회원 API", value = "Traveen")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserService userService;
	private JWTUtil jwtUtil;

	public UserController(UserService userService, JWTUtil jwtUtil) {
		super();
		this.userService = userService;
		this.jwtUtil = jwtUtil;
	}

	@GetMapping("/idCheck/{userId}")
	@ApiOperation(value = "아이디 체크 API", notes = "userId를 PathVariable로 받아 존재하는 아이디인지 체크하는 역할을 합니다. /user/idCheck/{userId}")
	public ResponseEntity<String> idCheck(@PathVariable("userId") String userId) throws Exception {
		logger.debug("idCheck userid : {}", userId);
		int cnt = userService.idCheck(userId);
		if (cnt != 0) { // 중복
			return new ResponseEntity<String>("중복됨", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("사용가능", HttpStatus.OK);
		}
	}

	@PostMapping("/login")
	@ApiOperation(value = "로그인 API", notes = "userId와 userPwd를 받아 아이디와 비밀번호가 일치하면 로그인해주는 역할을 합니다. /user/login", response = Map.class)
	public ResponseEntity<Map<String, Object>> login(@RequestBody User user,
			@RequestParam(name = "idSave", required = false) String idSave) {
		logger.debug("login user : {}", user);
		Map<String, Object> resultMap = new HashMap<String, Object>();
		HttpStatus status = HttpStatus.ACCEPTED;
		
		String userPwd = user.getUserPwd();
		System.out.println(user.getUserPwd());
		
		try {
			User loginUser = userService.login(user);
			if (loginUser != null) {
				System.out.println("null 아니지?");
				String accessToken = jwtUtil.createAccessToken(loginUser.getUserId());
				String refreshToken = jwtUtil.createRefreshToken(loginUser.getUserId());
				logger.debug("access token : {}", accessToken);
				logger.debug("refresh token : {}", refreshToken);

				// 발급받은 refresh token을 DB에 저장.
				userService.saveRefreshToken(loginUser.getUserId(), refreshToken);

				// JSON으로 token 전달.
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);

				status = HttpStatus.CREATED;

			} else {System.out.println("null..?");
				resultMap.put("message", "아이디 또는 패스워드를 확인해주세요.");
				status = HttpStatus.UNAUTHORIZED;
			}

		} catch (Exception e) {
			logger.debug("로그인 에러 발생 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "로그아웃 API", notes = "회원 정보를 담은 Token을 제거하는 역할을 합니다.", response = Map.class)
	@GetMapping("/logout/{userId}")
	public ResponseEntity<?> removeToken(@PathVariable ("userId") @ApiParam(value = "로그아웃할 회원의 아이디.", required = true) String userId) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			userService.deleRefreshToken(userId);
			status = HttpStatus.OK;
		} catch (Exception e) {
			logger.error("로그아웃 실패 : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "Access Token 재발급 API", notes = "만료된 access token을 재발급 받는 역할을 합니다.", response = Map.class)
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody User user, HttpServletRequest request)
			throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refreshToken");
		logger.debug("token : {}, user : {}", token, user);
		if (jwtUtil.checkToken(token)) {
			if (token.equals(userService.getRefreshToken(user.getUserId()))) {
				String accessToken = jwtUtil.createAccessToken(user.getUserId());
				logger.debug("token : {}", accessToken);
				logger.debug("정상적으로 액세스토큰 재발급!!!");
				resultMap.put("access-token", accessToken);
				status = HttpStatus.CREATED;
			}
		} else {
			logger.debug("리프레쉬토큰도 사용불가!!!!!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@PostMapping("/join")
	@ApiOperation(value = "회원가입 API", notes = "가입할 회원 정보를 입력 받아 회원가입하는 역할을 합니다. /user/join")
	public ResponseEntity<?> join(@RequestBody User user) throws Exception {
		logger.debug("join user : {}", user);
		userService.join(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{userId}")
	@ApiOperation(value = "회원 탈퇴 API", notes = "userId를 PathVariable으로 받아 회원 탈퇴를 하는 역할을 합니다. /user/delete")
	public String delete(@PathVariable("userId") String userId, HttpSession session, HttpServletRequest request,
			HttpServletResponse response, RedirectAttributes rttr) throws Exception {
		logger.debug("delete user userId : {}", userId);
		userService.deleteUser(userId);
		session.invalidate();

		Cookie cookies[] = request.getCookies();
		if (cookies != null && cookies.length != 0) {
			for (Cookie cookie : cookies) {
				String name = cookie.getName(); // '쿠키변수'값 구하기
				if ("login_id".equals(name)) {// 삭제할 쿠키 찾기
					cookie.setMaxAge(0);
					response.addCookie(cookie);// 변경된 쿠키를 저장한다.
				}
			}
		}

		rttr.addFlashAttribute("msg", "회원 탈퇴가 완료 되었습니다.");
		return "redirect:/";
	}
	
	@ApiOperation(value = "회원 정보 조회 API", notes = "userId를 PathVariable으로 받아 회원 정보를 담은 Token을 반환하는 역할을 합니다. /user/myinfo")
	@GetMapping("/myinfo/{userId}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userId") @ApiParam(value = "인증할 User의 아이디.", required = true) String userId,
			HttpServletRequest request) {
		logger.debug("userId : {} ", userId);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtUtil.checkToken(request.getHeader("Authorization"))) {
			logger.info("사용 가능한 토큰!!!");
			try {
//				로그인 사용자 정보.
				User user = userService.getUser(userId);
				resultMap.put("userInfo", user);
				status = HttpStatus.OK;
			} catch (Exception e) {
				logger.error("정보 조회 실패 : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("사용 불가능 토큰!!!");
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

//	@GetMapping("/myinfo/{userId}")
//	@ApiOperation(value = "회원 정보 조회 API", notes = "User의 userId를 PathVariable으로 받아 해당 회원을 상세 조회하는 역할을 합니다. /user/myinfo")
//	public ResponseEntity<?> myinfo(@PathVariable(value = "userId") String userId) throws Exception {
//		User user = userService.getUser(userId);
//		return ResponseEntity.ok(user);
//	}

	@PutMapping("/myinfo/modify")
	@ApiOperation(value = "회원 정보 수정 API", notes = "User를 받아 회원정보를 업데이트 해주는 역할을 합니다. /user/myinfo/modify")
	public ResponseEntity<?> myinfo(@RequestBody User user, RedirectAttributes rttr) throws Exception {
		logger.debug("myinfo user : {}", user);
		userService.updateUser(user);
		System.out.println(user);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/myinfo/modifypwd")
	@ApiOperation(value = "비밀번호 변경 API", notes = "회원의 userPwd와 변경할 비밀번호를 받아 userPwd가 같다면 비밀번호를 변경하는 역할을 합니다. /user/myinfo/modifypwd")
	public String mypwd(@RequestParam User user, @RequestParam String newPwd, HttpSession session,
			RedirectAttributes rttr) throws Exception {
		int cnt = userService.pwdCheck(user.getUserId(), user.getUserPwd());
		if (cnt == 1) { // 비밀번호가 일치할 때
			userService.updatePwd(user, newPwd);
			rttr.addFlashAttribute("msg", "비밀번호가 변경되었습니다.");
		} else { // 비밀번호가 일치하지 않을때
			rttr.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
		}
		return "redirect:/user/myinfo";
	}
}
