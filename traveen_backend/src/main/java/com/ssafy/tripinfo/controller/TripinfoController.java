package com.ssafy.tripinfo.controller;

import java.util.List;
import java.util.Map;

import com.ssafy.tripinfo.model.Tripinfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.notice.model.Notice;
import com.ssafy.tripinfo.model.service.TripinfoService;

@Controller
@RequestMapping("/tripinfo")
public class TripinfoController {
	private final Logger logger = LoggerFactory.getLogger(TripinfoController.class);
	
	private TripinfoService tripinfoService;

	public TripinfoController(TripinfoService tripinfoService) {
		super();
		this.tripinfoService = tripinfoService;
	}
	
	@GetMapping("/list")
	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
		// logger.debug("list parameter pgno : {}", map.get("pgno"));
		ModelAndView mav = new ModelAndView();
		List<Tripinfo> list = tripinfoService.listTripinfo(map);
		System.out.println(list);
		mav.addObject("tripinfo", list);
//		List<Notice> list = noticeService.listNotice(map);
//		PageNavigation pageNavigation = noticeService.makePageNavigation(map);
//		mav.addObject("notices", list);
//		mav.addObject("navigation", pageNavigation);
//		mav.addObject("pgno", map.get("pgno"));
//		mav.addObject("key", map.get("key"));
//		mav.addObject("word", map.get("word"));
		mav.setViewName("tripinfo/list");
		return mav;
	}
}
