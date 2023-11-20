package com.ssafy.course.controller;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

import com.ssafy.course.model.Course;
import com.ssafy.course.model.CourseinfoParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.course.model.service.CourseService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

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
	
	@PostMapping("/regist")
	@ApiOperation(value = "코스 등록 API", notes = "코스를 등록하는 역할을 합니다. /course/regist")
	public ResponseEntity<?> regist(@RequestBody Map<String, Object> map) throws Exception {
		logger.debug("write course : {}", map);
		courseService.registCourse(map);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}

	@GetMapping("/{userIdx}/list")
	@ApiOperation(value = "코스 목록 API", notes = "코스 목록을 조회하는 역할을 합니다. /course/{userId}/list")
	public ResponseEntity<?> list(@PathVariable("userIdx") String userIdx) throws Exception {
		logger.debug("course list user Idx : {}", userIdx);
		List<Course> courseList = courseService.listCourse(userIdx);
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return ResponseEntity.ok().headers(header).body(courseList);
	}

	@GetMapping("/list/{courseIdx}")
	@ApiOperation(value = "코스 여행지 목록 API", notes = "코스에 속하는 여행지 목록을 조회하는 역할을 합니다. /course/list/{courseIdx}")
	public ResponseEntity<?> infoList(@PathVariable("courseIdx") String courseIdx) throws Exception {
		logger.debug("course item list user Idx : {}", courseIdx);
		CourseinfoParam param = courseService.listCourseinfo(courseIdx);
		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
		return ResponseEntity.ok().headers(header).body(param);
	}
	
	@DeleteMapping("/delete/{courseIdx}")
	@ApiOperation(value = "코스 삭제 API", notes = "코스의 idx를 PathVariable으로 받아 코스를 삭제하는 역할을 합니다. /notice/delete")
	public ResponseEntity<?> delete(@PathVariable("courseIdx") String courseIdx)
			throws Exception {
		logger.debug("delete course idx : {}", courseIdx);
		courseService.deleteCourse(courseIdx);
		return ResponseEntity.ok().build();
	}

	@PostMapping("/modify")
	@ApiOperation(value = "코스 수정 API", notes = "코스를 수정하는 역할을 합니다. /course/modify")
	public ResponseEntity<?> modify(@RequestBody Map<String, Object> map) throws Exception {
		logger.debug("modify course : {}", map);
		courseService.modifyCourse(map);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
}
