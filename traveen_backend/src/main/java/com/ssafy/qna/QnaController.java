package com.ssafy.qna;

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

import com.ssafy.qna.model.Qna;
import com.ssafy.qna.model.service.QnaService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/qna")
public class QnaController {
	private final Logger logger = LoggerFactory.getLogger(QnaController.class);
	
	private QnaService qnaService;

	public QnaController(QnaService qnaService) {
		super();
		this.qnaService = qnaService;
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "QnA 목록 조회 API", notes = "QnA 목록을 조회하는 역할을 합니다. /qna/list")
	public ResponseEntity<?> list() throws Exception {
		List<Qna> list = qnaService.listQna();
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/view")
	@ApiOperation(value = "QnA 상세 조회 API", notes = "QnA의 idx를 RequestParam으로 받아서 해당 QnA를 상세 조회하는 역할을 합니다. /qna/view")
	public ResponseEntity<?> view(@RequestParam(value="idx") int idx, Model model)
			throws Exception {
		logger.debug("view qna idx : {}", idx);
		Qna qna = qnaService.viewQna(idx);
		return ResponseEntity.ok(qna);
	}
	
	@PostMapping("/regist")
	@ApiOperation(value = "QnA 등록 API", notes = "QnA을 등록하는 역할을 합니다. /qna/regist")
	public ResponseEntity<?> regist(@RequestBody Qna qna, HttpSession session,
			RedirectAttributes redirectAttributes) throws Exception {
		logger.debug("write qna : {}", qna);
		qnaService.registQna(qna);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{idx}")
	@ApiOperation(value = "QnA 삭제 API", notes = "QnA의 idx를 PathVariable으로 받아서 QnA를 삭제하는 역할을 합니다. /qna/delete")
	public ResponseEntity<?> delete(@PathVariable("idx") int idx, Model model, RedirectAttributes rttr)
			throws Exception {
		logger.debug("delete qna idx : {}", idx);
		qnaService.deleteQna(idx);
		rttr.addFlashAttribute("msg", "QnA가 삭제되었습니다.");
		return ResponseEntity.ok().build();
	}
}
