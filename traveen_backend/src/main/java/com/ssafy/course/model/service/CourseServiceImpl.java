package com.ssafy.course.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.course.model.Course;
import com.ssafy.course.model.mapper.CourseMapper;

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

}
