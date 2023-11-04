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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.user.model.User;
import com.ssafy.user.model.service.UserService;

import springfox.documentation.spring.web.json.Json;

@Controller
@RequestMapping("/user")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/idCheck/{userId}")
	@ResponseBody
	public ResponseEntity<?> idCheck(@PathVariable("userId") String userId) throws Exception {
		logger.debug("idCheck userid : {}", userId);
		int cnt = userService.idCheck(userId);
		System.out.println(cnt);
		Map<String, String> result = new HashMap<>();
		if (cnt != 0) { // 중복
			result.put("result", "중복됨");
			return new ResponseEntity<Map<String, String>>(result, HttpStatus.OK);
		} else {
			result.put("result", "중복안됨");
			return new ResponseEntity<Map<String, String>>(result, HttpStatus.OK);
		}
	}

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}

	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map,
			@RequestParam(name = "idSave", required = false) String idSave, Model model, HttpSession session,
			HttpServletResponse response) {
		logger.debug("login map : {}", map);
		try {
			User user = userService.login(map);
			if (user != null) {
				session.setAttribute("userinfo", user);
				Cookie cookie = new Cookie("login_id", map.get("userId"));
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

	@GetMapping("/join")
	public String join() {
		return "user/join";
	}

	@PostMapping("/join")
	public String join(@RequestParam Map<String, String> map, Model model) throws Exception {
		logger.debug("join map : {}", map);
		try {
			userService.join(map);
			model.addAttribute("msg", "회원가입이 완료되었습니다!");
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원가입 중 문제가 발생했습니다.");
			return "error/500";
		}
		return "redirect:/user/login";
	}
	
	@GetMapping("/myinfo")
	public String myinfo(HttpSession session, Model model) throws Exception {
		User userinfo = (User) session.getAttribute("userinfo");
		User user = userService.getUser(userinfo.getUserId());
		model.addAttribute("user", user);
		return "mypage/myinfo";
	}

	@PostMapping("/myinfo")
	public String myinfo(@RequestParam Map<String, String> map, HttpSession session) throws Exception {
		logger.debug("myinfo map : {}");
		userService.updateUser(map);
		User user = userService.getUser(map.get("userId"));
		session.setAttribute("userinfo", user);
		return "redirect:/user/myinfo";
	}

	@PostMapping("/myinfo/pwd")
	public String mypwd(@RequestParam Map<String, String> map, HttpSession session, RedirectAttributes rttr) throws Exception {
		int cnt = userService.pwdCheck(map);
		System.out.println(cnt);
		if(cnt==1) { // 비밀번호가 일치할 때
			userService.updatePwd(map);
			rttr.addFlashAttribute("msg", "비밀번호가 변경되었습니다.");
		} else { // 비밀번호가 일치하지 않을때
			rttr.addFlashAttribute("msg", "비밀번호가 일치하지 않습니다.");
		}
		return "redirect:/user/myinfo";
	}
}
