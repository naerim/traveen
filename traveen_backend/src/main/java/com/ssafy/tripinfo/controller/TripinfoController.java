package com.ssafy.tripinfo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.tripinfo.model.Tripinfo;
import com.ssafy.tripinfo.model.service.TripinfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	public ResponseEntity<Tripinfo> list(@RequestParam Tripinfo tripinfo) throws Exception {
		logger.debug("list parameter tripinfo : {}", tripinfo);

		List<Tripinfo> list = tripinfoService.listTripinfo(tripinfo);
		
//		PageNavigation pageNavigation = tripinfoService.makePageNavigation(map);
//		Map<String, Object> result = new HashMap<>();
//		result.put("tripinfo", tripinfo);
//		result.put("navigation", pageNavigation);
//		result.put("pgno", map.get("pgno"));
//		result.put("key", map.get("key"));
//		result.put("word", map.get("word"));
//		param.put("tripinfo/list");
		
		return ResponseEntity.ok(tripinfo);
	}
}
