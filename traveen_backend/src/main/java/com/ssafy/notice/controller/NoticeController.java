package com.ssafy.notice.controller;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.notice.model.Notice;
import com.ssafy.notice.model.service.NoticeService;
import com.ssafy.user.controller.UserController;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	private NoticeService noticeService;

	public NoticeController(NoticeService noticeService) {
		super();
		this.noticeService = noticeService;
	}
	
	@GetMapping("/list")
	public ModelAndView list(@RequestParam Map<String, Object> map) throws Exception {
		logger.debug("list parameter pgno : {}", map.get("pgno"));
		ModelAndView mav = new ModelAndView();
		List<Notice> list = noticeService.listNotice(map);
//		PageNavigation pageNavigation = noticeService.makePageNavigation(map);
		mav.addObject("notices", list);
//		mav.addObject("navigation", pageNavigation);
//		mav.addObject("pgno", map.get("pgno"));
//		mav.addObject("key", map.get("key"));
//		mav.addObject("word", map.get("word"));
		mav.setViewName("notice/list");
		return mav;
	}
}
