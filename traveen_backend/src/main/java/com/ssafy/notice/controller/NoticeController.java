package com.ssafy.notice.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ssafy.notice.model.Notice;
import com.ssafy.notice.model.service.NoticeService;
import com.ssafy.user.model.User;
import com.ssafy.util.PageNavigation;

@Controller
@RequestMapping("/notice")
public class NoticeController {
	private final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	private NoticeService noticeService;

	public NoticeController(NoticeService noticeService) {
		super();
		this.noticeService = noticeService;
	}
	
	@GetMapping("/list")
	public ResponseEntity<Map<String, Object>> list(@RequestParam Map<String, String> map) throws Exception {
		logger.debug("list parameter pgno : {}", map.get("pgno"));
		Map<String, Object> result = new HashMap<>();
		List<Notice> list = noticeService.listNotice(map);
		int totalCnt = noticeService.getTotalNoticeCountString(map);
		PageNavigation pageNavigation = noticeService.makePageNavigation(map);
		
		result.put("notices", list);
		result.put("totalCnt", totalCnt);
		result.put("navigation", pageNavigation);
		result.put("pgno", map.get("pgno"));
		result.put("key", map.get("key"));
		result.put("word", map.get("word"));
//		mav.setViewName("notice/list");
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/view")
	public String view(@RequestParam("idx") int idx,  @RequestParam Map<String, String> map, Model model)
			throws Exception {
		logger.debug("view notice idx : {}", idx);;
		Notice notice = noticeService.viewNotice(idx);
		noticeService.updateHit(idx);
		model.addAttribute("notice", notice);
//		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "notice/detail";
	}
	
	@GetMapping("/regist")
	public String regist(@RequestParam Map<String, String> map, Model model) {
		logger.debug("write call parameter {}", map);
//		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "notice/regist";
	}
	
	@PostMapping("/regist")
	public String regist(@RequestParam Map<String, String> map, HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("write notice : {}", map);
		User user = (User) session.getAttribute("userinfo");
		map.put("userIdx", user.getIdx() + "");

		noticeService.registNotice(map);
//		redirectAttributes.addAttribute("pgno", "1");
		redirectAttributes.addAttribute("key", "");
		redirectAttributes.addAttribute("word", "");
		return "redirect:/notice/list";
	}
	
	@GetMapping("/modify")
	public String modify(@RequestParam("idx") int idx, @RequestParam Map<String, String> map, Model model)
			throws Exception {
		logger.debug("modify idx : {}", idx);
		Notice notice = noticeService.getNotice(idx);
		model.addAttribute("notice", notice);
//		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "notice/modify";
	}

	@PostMapping("/modify")
	public String modify(@RequestParam Map<String, String> map,
			RedirectAttributes rttr) throws Exception {
		logger.debug("modify map : {}", map);
		noticeService.modifyNotice(map);
//		redirectAttributes.addAttribute("pgno", map.get("pgno"));
		rttr.addAttribute("key", map.get("key"));
		rttr.addAttribute("word", map.get("word"));
		rttr.addFlashAttribute("msg", "게시글이 수정되었습니다.");
		return "redirect:/notice/list";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("idx") int idx, @RequestParam Map<String, String> map, Model model, RedirectAttributes rttr)
			throws Exception {
		logger.debug("delete notice idx : {}", idx);
		noticeService.deleteNotice(idx);
		rttr.addAttribute("key", map.get("key"));
		rttr.addAttribute("word", map.get("word"));
		rttr.addFlashAttribute("msg", "게시글이 삭제되었습니다.");
		return "redirect:/"
				+ "notice/list";
	}
}