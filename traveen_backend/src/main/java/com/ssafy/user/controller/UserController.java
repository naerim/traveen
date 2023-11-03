package com.ssafy.user.controller;

import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.user.model.User;
import com.ssafy.user.model.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}

	@GetMapping("/join/{userId}")
	@ResponseBody
	public void idCheck(@PathVariable("userId") String userId, Model model) throws Exception {
		logger.debug("idCheck userid : {}", userId);
		int cnt = userService.idCheck(userId);
		System.out.println(cnt);
		if (cnt != 0) {
			model.addAttribute("checkId", 1);
			System.out.println("우~실패");
		} else {
			model.addAttribute("checkId", 0);
			System.out.println("우~성공");
		}
	}

	@GetMapping("/login")
	public String login() {
		return "user/login";
	}

	@PostMapping("/login")
	public String login(@RequestParam Map<String, String> map,
			@RequestParam(name = "idSave", required = false) String idSave, Model model, HttpSession session,
			HttpServletResponse response, HttpServletRequest req) {
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
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("msg", "회원가입 중 문제가 발생했습니다.");
			return "error/500";
		}
		return "redirect:/";
	}
	
	@GetMapping("/myinfo")
	public String myinfo(HttpSession session) {
		return "mypage/myinfo";
	}
}
