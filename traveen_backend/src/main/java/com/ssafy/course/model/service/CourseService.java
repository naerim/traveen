package com.ssafy.course.model.service;

import com.ssafy.course.model.Course;
import com.ssafy.course.model.Courseinfo;

import java.util.List;
import java.util.Map;

public interface CourseService {
	void registCourse(Map<String, Object> map) throws Exception;
	List<Course> listCourse(String userIdx) throws Exception;
	List<Courseinfo> listCourseInfo(String courseIdx) throws Exception;
}
