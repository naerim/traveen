package com.ssafy.course.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.course.model.service.CourseService;
import com.ssafy.notice.controller.NoticeController;
import com.ssafy.notice.model.service.NoticeService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/course")
@Api(tags = "코스 API", value="Traveen")
public class CourseController {
	private final Logger logger = LoggerFactory.getLogger(CourseController.class);
	
	private CourseService courseService;

	public CourseController(CourseService courseService) {
		super();
		this.courseService = courseService;
	}
}
