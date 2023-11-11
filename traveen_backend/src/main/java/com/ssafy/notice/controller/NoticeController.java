package com.ssafy.notice.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
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

import com.ssafy.notice.model.Notice;
import com.ssafy.notice.model.service.NoticeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/notice")
@Api(tags = "공지사항 API", value="Traveen")
public class NoticeController {
	private final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	private NoticeService noticeService;

	public NoticeController(NoticeService noticeService) {
		super();
		this.noticeService = noticeService;
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "공지사항 목록 조회 API", notes = "공지사항 목록을 조회하는 역할을 합니다. /notice/list")
	public ResponseEntity<?> list() throws Exception {
		List<Notice> list = noticeService.listNotice();
//		int totalCnt = noticeService.getTotalNoticeCount(notice);
//		PageNavigation pageNavigation = noticeService.makePageNavigation(map);
//		Map<String, Object> result = new HashMap<>();
//		result.put("notices", list);
//		result.put("totalCnt", totalCnt);
//		result.put("navigation", pageNavigation);
//		result.put("pgno", map.get("pgno"));
//		result.put("key", map.get("key"));
//		result.put("word", map.get("word"));
//		mav.setViewName("notice/list");
		return ResponseEntity.ok(list);
//		return new ResponseEntity<Map<String, Object>>(result, HttpStatus.OK);
	}
	
	@GetMapping("/view/{idx}")
	@ApiOperation(value = "공지사항 상세 조회 API", notes = "Notice의 idx를 RequestParam으로 받아서 해당 공지사항을 상세 조회하는 역할을 합니다. /notice/view")
	public ResponseEntity<?> view(@PathVariable(value="idx") int idx, Model model)
			throws Exception {
		logger.debug("view notice idx : {}", idx);
		Notice notice = noticeService.viewNotice(idx);
		noticeService.updateHit(idx);
		
//		Map<String, Object> result = new HashMap<>();Notice
//		result.put("notice", notice);
//		result.put("pgno", map.get("pgno"));
//		result.put("key", map.get("key"));
//		result.put("word", map.get("word"));
		return ResponseEntity.ok(notice);
	}
	
//	@GetMapping("/regist")
//	@ApiOperation(value = "공지사항 목록 조회 API", notes = "공지사항 목록을 조회하는 역할을 합니다. /notice/list")
//	public String regist() {
////		logger.debug("write call parameter {}", map);
////		model.addAttribute("pgno", map.get("pgno"));
////		model.addAttribute("key", map.get("key"));
////		model.addAttribute("word", map.get("word"));
//		return "notice/regist";
//	}
	
	@PostMapping("/regist")
	@ApiOperation(value = "공지사항 등록 API", notes = "공지사항을 등록하는 역할을 합니다. /notice/regist")
	public ResponseEntity<?> regist(@RequestBody Notice notice, HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("write notice : {}", notice);
//		User user = (User) session.getAttribute("userinfo");
//		notice.setUserIdx(user.getIdx());
		noticeService.registNotice(notice);

//		map.put("userIdx", user.getIdx() + "");
//		redirectAttributes.addAttribute("pgno", "1");
//		redirectAttributes.addAttribute("key", "");
//		redirectAttributes.addAttribute("word", "");
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/modify/{idx}")
	@ApiOperation(value = "공지사항 수정 API", notes = "Notice의 idx를 PathVariable으로 받아서 해당 공지사항을 수정하는 역할을 합니다. /notice/modify")
	public ResponseEntity<?> modify(@PathVariable(value="idx") int idx, Model model)
			throws Exception {
		logger.debug("modify idx : {}", idx);
		Notice notice = noticeService.getNotice(idx);
		
//		Map<String, Object> result = new HashMap<>();
//		result.put("notice", notice);
//		result.put("pgno", map.get("pgno"));
//		result.put("key", map.get("key"));
//		result.put("word", map.get("word"));
		return ResponseEntity.ok(notice);
	}

	@PutMapping("/modify")
	@ApiOperation(value = "공지사항 수정 조회 API", notes = "공지사항 수정을 조회하는 역할을 합니다. /notice/modify")
	public ResponseEntity<?> modify(@RequestBody Notice notice,
			RedirectAttributes rttr) throws Exception {
		logger.debug("modify notice : {}", notice);
		noticeService.modifyNotice(notice);
//		rttr.addAttribute("pgno", map.get("pgno"));
//		rttr.addAttribute("key", map.get("key"));
//		rttr.addAttribute("word", map.get("word"));
		rttr.addFlashAttribute("msg", "게시글이 수정되었습니다.");
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/delete/{idx}")
	@ApiOperation(value = "공지사항 삭제 API", notes = "Notice의 idx를 PathVariable으로 받아서 공지사항을 삭제하는 역할을 합니다. /notice/delete")
	public ResponseEntity<?> delete(@PathVariable("idx") int idx, Model model, RedirectAttributes rttr)
			throws Exception {
		logger.debug("delete notice idx : {}", idx);
		noticeService.deleteNotice(idx);
//		rttr.addAttribute("key", map.get("key"));
//		rttr.addAttribute("word", map.get("word"));
		rttr.addFlashAttribute("msg", "게시글이 삭제되었습니다.");
		return ResponseEntity.ok().build();
	}
}