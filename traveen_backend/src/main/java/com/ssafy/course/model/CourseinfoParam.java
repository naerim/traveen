package com.ssafy.course.model;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CourseinfoParamDto : 코스의 아이템들을 보낼 때 파라미터", description = "코스에 속한 여행지들에 대한 정보와 코스의 고유번호, 이름, 여행 시작일, 여행 종료일을 포함한다.")
public class CourseinfoParam {
	/* 코스 고유 번호 */
	@ApiModelProperty(value = "코스 고유 번호")
	private String courseIdx;
	/* 코스 제목 */
	@ApiModelProperty(value = "코스 제목")
	private String courseTitle;
	/* 여행 시작일 */
	@ApiModelProperty(value = "여행 시작일")
	private String startDate;
	/* 여행 종료일 */
	@ApiModelProperty(value = "여행 종료일")
	private String endDate;
	/* 코스에 속하는 여행지 리스트 */
	@ApiModelProperty(value = "코스에 속하는 여행지 리스트")
	private List<Courseinfo> list;
	
	
	public String getCourseIdx() {
		return courseIdx;
	}
	public void setCourseIdx(String courseIdx) {
		this.courseIdx = courseIdx;
	}
	public String getCourseTitle() {
		return courseTitle;
	}
	public void setCourseTitle(String courseTitle) {
		this.courseTitle = courseTitle;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public List<Courseinfo> getList() {
		return list;
	}
	public void setList(List<Courseinfo> list) {
		this.list = list;
	}
	
	
	@Override
	public String toString() {
		return "CourseinfoParam [courseIdx=" + courseIdx + ", courseTitle=" + courseTitle + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", list=" + list + "]";
	}
	
}
