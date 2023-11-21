package com.ssafy.user.controller;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
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
	@Autowired
	private JavaMailSender mailSender;

	

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
		
		
		try {
			User loginUser = userService.login(user);
			if (loginUser != null) {
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

			} else {
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
				User user = userService.getUserById(userId);
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

	@PutMapping("/myinfo/modify")
	@ApiOperation(value = "회원 정보 수정 API", notes = "User를 받아 회원정보를 업데이트 해주는 역할을 합니다. /user/myinfo/modify")
	public ResponseEntity<?> myinfo(@RequestBody User user) throws Exception {
		logger.debug("myinfo user : {}", user);
		userService.updateUser(user);
		System.out.println(user);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/myinfo/modifypwd")
	@ApiOperation(value = "비밀번호 변경 API", notes = "회원의 userPwd와 변경할 비밀번호를 받아 userPwd가 같다면 비밀번호를 변경하는 역할을 합니다. /user/myinfo/modifypwd")
	public ResponseEntity<?> mypwd(@RequestBody @ApiParam(value = "비밀번호 변경을 위한 정보.", required = true) Map<String, String> param) throws Exception {
		logger.debug("myinfoPwd map : {}", param);
		Map<String, String> result = new HashMap<>();
		String userId = param.get("userId");
		String userPwd = param.get("userPwd");
		String newPwd = param.get("newPwd");
		
		int cnt = userService.pwdCheck(userId, userPwd);
		if (cnt == 1) { // 비밀번호가 일치할 때
			result.put("userId", userId);
			result.put("newPwd", newPwd);
			userService.updatePwd(result);
		}
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/email")
	public Map<String, Object> email(@RequestBody String email) throws Exception {
		logger.debug("send email : {}", email);
		Map<String, Object> map = new HashMap<>();
		int idx = email.indexOf("@");
		String emailId = email.substring(0, idx);
		String emailDomain = email.substring(idx + 1);
		User user = userService.getUserByEmail(emailId, emailDomain);
        
		JavaMailSenderImpl mailSenderImpl = new JavaMailSenderImpl();
		Properties prop = new Properties();
		mailSenderImpl.setHost("smtp.gmail.com");
		mailSenderImpl.setPort(587);
		mailSenderImpl.setUsername("dbsk9012@gmail.com");
		mailSenderImpl.setPassword("zxhfpticqdaqbgpg");
		prop.put("mail.smtp.auth", true);
		prop.put("mail.smtp.starttls.enable", true);
        
		mailSenderImpl.setJavaMailProperties(prop);
		
		if (user != null) {
			map.put("exist", "이미 존재하는 이메일입니다.");
		} else {
			Random random = new Random(); // 난수 생성을 위한 랜덤 클래스
			String key = ""; // 인증번호 담을 String key 변수 생성
            
			MimeMessage message = mailSender.createMimeMessage();
			// true는 멀티파트 메세지를 사용하겠다는 의미
			MimeMessageHelper mailHelper = new MimeMessageHelper(message, true, "UTF-8");
			
			// 입력 키를 위한 난수 생성 코드 
			for (int i = 0; i < 3; i++) {
				int index = random.nextInt(26) + 65;
				key += (char) index;
			}
			for (int i = 0; i < 6; i++) {
				int numIndex = random.nextInt(10);
				key += numIndex;
			}
			
			String htmlMsg = "<h2>Traveen 회원가입 이메일 인증 번호</h2>"
					+ "인증번호는 " + key + " 입니다.\n올바른 인증번호를 입력해주세요.";
			mailHelper.setSubject("[Traveen] Traveen 회원가입 이메일 인증번호"); // 이메일 제목
			mailHelper.setText(htmlMsg, true); // 이메일 내용
			mailHelper.setTo(email);
			mailHelper.setFrom("dbsk9012@gmail.com");
            try {
            	mailSender.send(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
			map.put("key", key);
			map.put("user", user);
		}
		return map;
	}
	
	@GetMapping("/following/{idx}")
	@ApiOperation(value = "팔로잉 목록 API", notes = "회원의 팔로잉 목록을 조회하는 역할을 합니다. /user/following/{userIdx}")
	public ResponseEntity<?> list(@PathVariable("idx") int idx) throws Exception {
		logger.debug("following list user Idx : {}", idx);
		List<User> followingList = userService.listFollowing(idx);
		System.out.println(followingList);
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return ResponseEntity.ok().headers(header).body(followingList);
	}
}
