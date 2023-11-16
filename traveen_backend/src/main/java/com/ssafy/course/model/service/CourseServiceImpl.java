package com.ssafy.course.model.service;

import org.springframework.stereotype.Service;

import com.ssafy.course.model.mapper.CourseMapper;

@Service
public class CourseServiceImpl implements CourseService {
	private CourseMapper courseMapper;

	public CourseServiceImpl(CourseMapper courseMapper) {
		super();
		this.courseMapper = courseMapper;
	}
}
