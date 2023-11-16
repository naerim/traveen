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
	/* 여행지 고유 번호 */
	@ApiModelProperty(value = "여행지 고유 번호")
	private String tripinfoIdx;
	/* 순서 */
	@ApiModelProperty(value = "순서")
	private int order;
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
	/* 장소 이름 */
	@ApiModelProperty(value = "장소 이름")
	private String placeName;
	/* 주소 */
	@ApiModelProperty(value = "주소")
	private String address;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(String userIdx) {
		this.userIdx = userIdx;
	}
	public String getTripinfoIdx() {
		return tripinfoIdx;
	}
	public void setTripinfoIdx(String tripinfoIdx) {
		this.tripinfoIdx = tripinfoIdx;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
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
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Course [idx=" + idx + ", title=" + title + ", userIdx=" + userIdx + ", tripinfoIdx=" + tripinfoIdx
				+ ", order=" + order + ", createDate=" + createDate + ", startDate=" + startDate + ", endDate="
				+ endDate + ", flag=" + flag + ", placeName=" + placeName + ", address=" + address + "]";
	}
	
	
}




