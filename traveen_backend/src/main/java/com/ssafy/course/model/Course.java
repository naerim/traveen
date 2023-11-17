package com.ssafy.course.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CourseDto : 코스 정보", description = "코스의 상세 정보를 나타낸다.")
public class Course {
	/* 고유번호 */
	@ApiModelProperty(value = "고유번호")
	private int idx;
	/* 코스 제목 */
	@ApiModelProperty(value = "코스 제목")
	private String title;
	/* 코스를 생성한 사용자의 고유 번호 */
	@ApiModelProperty(value = "코스를 생성한 사용자의 고유 번호")
	private String userIdx;
	/* 코스 생성 날짜 */
	@ApiModelProperty(value = "코스 생성 날짜")
	private String createDate;
	/* 여행 시작일 */
	@ApiModelProperty(value = "여행 시작일")
	private String startDate;
	/* 여행 종료일 */
	@ApiModelProperty(value = "여행 종료일")
	private String endDate;
	/* flag */
	@ApiModelProperty(value = "flag(여행전:0, 여행완료:1)")
	private int flag;
	
	
}




