package com.ssafy.course.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CourseinfoDto : 코스의 아이템 정보", description = "코스 아이템의 상세 정보를 나타낸다.")
public class Courseinfo {
	/* 고유번호 */
	@ApiModelProperty(value = "고유번호")
	private int idx;
	/* 코스 고유 번호 */
	@ApiModelProperty(value = "코스 고유 번호")
	private String courseIdx;
	/* 여행지 고유 번호 */
	@ApiModelProperty(value = "여행지 고유 번호")
	private String tripinfoIdx;
	/* 순서 */
	@ApiModelProperty(value = "순서")
	private int order;
	/* 카테고리 */
	@ApiModelProperty(value = "카테고리")
	private String categoryName;
	/* 작품이름 */
	@ApiModelProperty(value = "작품이름")
	private String title;
	/* 장소이름 */
	@ApiModelProperty(value = "장소이름")
	private String placeName;
	/* 장소 카테고리 */
	@ApiModelProperty(value = "장소 카테고리")
	private String type;
	/* 주소 */
	@ApiModelProperty(value = "주소")
	private String address;
	/* 위도 */
	@ApiModelProperty(value = "위도")
	private String lat;
	/* 경도 */
	@ApiModelProperty(value = "경도")
	private String loc;
	/* 시도 코드 */
	@ApiModelProperty(value = "시도 코드")
	private int sidoCode;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCourseIdx() {
		return courseIdx;
	}
	public void setCourseIdx(String courseIdx) {
		this.courseIdx = courseIdx;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public int getSidoCode() {
		return sidoCode;
	}
	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}
	
	
	@Override
	public String toString() {
		return "Courseinfo [idx=" + idx + ", courseIdx=" + courseIdx + ", tripinfoIdx=" + tripinfoIdx + ", order="
				+ order + ", categoryName=" + categoryName + ", title=" + title + ", placeName=" + placeName + ", type="
				+ type + ", address=" + address + ", lat=" + lat + ", loc=" + loc + ", sidoCode=" + sidoCode + "]";
	}
	
	
	
}
