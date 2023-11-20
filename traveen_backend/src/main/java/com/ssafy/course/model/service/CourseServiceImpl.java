package com.ssafy.course.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.course.model.Courseinfo;
import com.ssafy.course.model.CourseinfoParam;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.course.model.Course;
import com.ssafy.course.model.mapper.CourseMapper;
import com.ssafy.tripinfo.model.Tripinfo;
import com.ssafy.tripinfo.model.TripinfoList;

@Service
public class CourseServiceImpl implements CourseService {
	private CourseMapper courseMapper;

	public CourseServiceImpl(CourseMapper courseMapper) {
		super();
		this.courseMapper = courseMapper;
	}

	@Override
	public void registCourse(Map<String, Object> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("course", map.get("course") == null ? "" : map.get("course"));
		param.put("courseList", map.get("courseList") == null ? "" : map.get("courseList"));

		// Course객체로 cast
		Course course =  new ObjectMapper().convertValue(param.get("course"), Course.class);
		courseMapper.registCourse(course);
		
		// 생성된 코스의 고유 아이디
		int idx = course.getIdx();
		param.put("courseIdx", idx);
		courseMapper.registCourseinfo(param);
	}

	@Override
	public List<Course> listCourse(String userIdx) throws Exception {
		return courseMapper.listCourse(userIdx);
	}

	@Override
	public CourseinfoParam listCourseinfo(String courseIdx) throws Exception {
		Course course = courseMapper.getCourse(courseIdx);
		List<Courseinfo> list = courseMapper.listCourseinfo(courseIdx);
		
		CourseinfoParam param = new CourseinfoParam();
		param.setList(list);
		param.setCourseIdx(courseIdx);
		param.setCourseTitle(course.getTitle());
		param.setStartDate(course.getStartDate());
		param.setEndDate(course.getEndDate());
		return param;
	}

	@Override
	public void deleteCourse(String courseIdx) throws Exception {
		courseMapper.deleteCourse(courseIdx);
	}

	@Override
	public void modifyCourse(Map<String, Object> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("course", map.get("course") == null ? "" : map.get("course"));
		param.put("courseList", map.get("courseList") == null ? "" : map.get("courseList"));

		// Course객체로 cast
		Course course =  new ObjectMapper().convertValue(param.get("course"), Course.class);

		// 코스 삭제
		courseMapper.deleteCourse(Integer.toString(course.getIdx()));

//		Map<String, Object> modifyParam = new HashMap<String, Object>();
//		modifyParam.put("course", course);
		courseMapper.registCourse(course);

//		modifyParam.put("courseList", param.get("courseList"));
		int idx = course.getIdx();
		System.out.println("course Idx : " + idx);
		param.put("courseIdx", idx);
		courseMapper.registCourseinfo(param);
	}

}
