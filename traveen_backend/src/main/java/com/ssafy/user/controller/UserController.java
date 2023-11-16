package com.ssafy.user.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.user.model.User;
import com.ssafy.user.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(tags = "회원 API", value="Traveen")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
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

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}

	@PostMapping("/login")
	@ApiOperation(value = "로그인 API", notes = "userId와 userPwd를 받아 아이디와 비밀번호가 일치하면 로그인해주는 역할을 합니다. /user/login")
	public String login(@RequestParam String userId, @RequestParam String userPwd,
			@RequestParam(name = "idSave", required = false) String idSave, Model model, HttpSession session,
			HttpServletResponse response) {
		logger.debug("login userId, userPwd : {}", userId + " " + userPwd);
		try {
			User user = userService.login(userId, userPwd); 
			if (user != null) {
				session.setAttribute("userinfo", user);
				Cookie cookie = new Cookie("login_id", userId);
				cookie.setPath("/user");
				if("on".equals(idSave)) {
					cookie.setMaxAge(60*60*24*365*40);
				} else {
					cookie.setMaxAge(0);
				}
				response.addCookie(cookie);
				return "redirect:/";
			} else {
				model.addAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인하세요!");
				return "user/login";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "로그인 중 문제가 발생했습니다.");
			return "error/500";
		}
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}

	@PostMapping("/join")
	@ApiOperation(value = "회원가입 API", notes = "가입할 회원 정보를 입력 받아 회원가입하는 역할을 합니다. /user/join")
	public ResponseEntity<?> join(@RequestBody User user) throws Exception {
		logger.debug("join user : {}", user);
		userService.join(user);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/delete")
	@ApiOperation(value = "회원 탈퇴 API", notes = "userId를 RequestParam으로 받아 회원 탈퇴를 하는 역할을 합니다. /user/delete")
	public String delete(@RequestParam("userId") String userId, HttpSession session, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rttr)
			throws Exception {
		logger.debug("delete user userId : {}", userId);
		userService.deleteUser(userId);
		session.invalidate();
		
		Cookie cookies[] = request.getCookies();
		if(cookies != null && cookies.length != 0) {
	         for(Cookie cookie : cookies) {
	            String name = cookie.getName(); //'쿠키변수'값 구하기
	            if("login_id".equals(name)) {//삭제할 쿠키 찾기
	               cookie.setMaxAge(0);
	               response.addCookie(cookie);//변경된 쿠키를 저장한다.
	            }
	         }
	      }
		
		rttr.addFlashAttribute("msg", "회원 탈퇴가 완료 되었습니다.");
		return "redirect:/";
	}
	
	@GetMapping("/myinfo/{userId}")
	@ApiOperation(value = "회원 정보 조회 API", notes = "User의 userId를 PathVariable으로 받아서 해당 회원을 상세 조회하는 역할을 합니다. /user/myinfo")
	public ResponseEntity<?> myinfo(@PathVariable(value="userId") String userId) throws Exception {
		User user = userService.getUser(userId);
		return ResponseEntity.ok(user);
	}

	@PutMapping("/myinfo/modify")
	@ApiOperation(value = "회원 정보 수정 API", notes = "User를 받아 회원정보를 업데이트 해주는 역할을 합니다. /user/myinfo/modify")
	public ResponseEntity<?> myinfo(@RequestBody User user, RedirectAttributes rttr) throws Exception {
		logger.debug("myinfo user : {}", user);
		userService.updateUser(user);
		System.out.println(user);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/myinfo/pwd")
	@ApiOperation(value = "비밀번호 변경 API", notes = "회원의 userPwd와 변경할 비밀번호를 받아 userPwd가 같다면 비밀번호를 변경하는 역할을 합니다. /user/myinfo/pwd")
	public String mypwd(@RequestParam User user, @RequestParam String newPwd, HttpSession session, RedirectAttributes rttr) throws Exception {
		int cnt = userService.pwdCheck(user.getUserId(), user.getUserPwd());
		if(cnt == 1) { // 비밀번호가 일치할 때
			userService.updatePwd(user, newPwd);
			rttr.addFlashAttribute("msg", "비밀번호가 변경되었습니다.");
		} else { // 비밀번호가 일치하지 않을때
			rttr.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
		}
		return "redirect:/user/myinfo";
	}
}
