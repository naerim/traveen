package com.ssafy.tripinfo.controller;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tripinfo.model.LikeTripParam;
import com.ssafy.tripinfo.model.Sido;
import com.ssafy.tripinfo.model.Tripinfo;
import com.ssafy.tripinfo.model.TripinfoList;
import com.ssafy.tripinfo.model.service.TripinfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/tripinfo")
@Api(tags = "여행지 API", value="Traveen")
public class TripinfoController {
	private final Logger logger = LoggerFactory.getLogger(TripinfoController.class);
	
	private TripinfoService tripinfoService;

	public TripinfoController(TripinfoService tripinfoService) {
		super();
		this.tripinfoService = tripinfoService;
	}
	
	@GetMapping("/list")
	@ApiOperation(value = "여행지 목록 조회 API", notes = "여행지 목록을 조회하는 역할을 합니다. /tripinfo/list")
	public ResponseEntity<?> list(@RequestParam @ApiParam(value = "여행지 목록을 얻기위한 부가정보.", required = true) Map<String, String> map) throws Exception {
		logger.info("listNotice map = {}", map);
		TripinfoList tripinfoList = tripinfoService.listTripinfo(map);
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return ResponseEntity.ok().headers(header).body(tripinfoList);
	}
	
	@GetMapping("/view/{idx}")
	@ApiOperation(value = "여행지 상세 조회 API", notes = "Tripinfo의 idx를 RequestParam으로 받아서 해당 여행지를 상세 조회하는 역할을 합니다. /tripinfo/view")
	public ResponseEntity<?> view(@PathVariable(value="idx") int idx)
			throws Exception {
		logger.debug("view notice idx : {}", idx);
		Tripinfo tripinfo = tripinfoService.viewTripinfo(idx);
		tripinfoService.updateHit(idx);
		return ResponseEntity.ok(tripinfo);
	}
	
	@GetMapping("/sidoList")
	@ApiOperation(value = "시도 목록 조회 API", notes = "시도 목록을 조회하는 역할을 합니다. /tripinfo/sidoList")
	public ResponseEntity<?> sidoList() throws Exception {
		List<Sido> list = tripinfoService.listSido();
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return ResponseEntity.ok().headers(header).body(list);
	}
	
	@PostMapping("/like")
	@ApiOperation(value = "여행지 찜하기 API", notes = "여행지를 찜하는 역할을 합니다. /tripinfo/like")
	public ResponseEntity<?> like(@RequestBody LikeTripParam likeTripParam) throws Exception {
		logger.debug("like trip param : {}", likeTripParam);
		int tripinfoIdx = likeTripParam.getTripinfoIdx();
		tripinfoService.updateLike(tripinfoIdx);
		tripinfoService.likeTripinfo(likeTripParam);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@DeleteMapping("/like/delete/{idx}")
	@ApiOperation(value = "여행지 찜하기 취소 API", notes = "여행지 찜을 취소하는 역할을 합니다. /tripinfo/like/delete")
	public ResponseEntity<?> deletelike(@PathVariable("idx") int tripinfoIdx) throws Exception {
		logger.debug("like delete tripinfo idx : {}", tripinfoIdx);
//		tripinfoService.updateDeleteLike(tripinfoIdx);
		tripinfoService.deleteLikeTripinfo(tripinfoIdx);

		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
