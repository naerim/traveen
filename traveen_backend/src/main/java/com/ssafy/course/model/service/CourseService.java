package com.ssafy.course.model.service;

import com.ssafy.course.model.Course;
import com.ssafy.course.model.CourseinfoParam;

import java.util.List;
import java.util.Map;

public interface CourseService {
	void registCourse(Map<String, Object> map) throws Exception;
	List<Course> listCourse(String userIdx) throws Exception;
	CourseinfoParam listCourseinfo(String courseIdx) throws Exception;
	void deleteCourse(String courseIdx) throws Exception;
	void modifyCourse(Map<String, Object> map) throws Exception;
}
