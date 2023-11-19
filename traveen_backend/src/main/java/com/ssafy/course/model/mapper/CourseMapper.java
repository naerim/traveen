package com.ssafy.course.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.course.model.Courseinfo;
import org.apache.ibatis.annotations.Mapper;

import com.ssafy.course.model.Course;

@Mapper
public interface CourseMapper {
	int registCourse(Course course) throws SQLException;
	void registCourseinfo(Map<String, Object> map) throws SQLException;
	List<Course> listCourse(String userIdx) throws SQLException;
	List<Courseinfo> listCourseinfo(String courseIdx) throws SQLException;
}
