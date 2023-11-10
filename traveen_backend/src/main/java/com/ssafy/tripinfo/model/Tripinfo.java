package com.ssafy.tripinfo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TripinfoDto : 여행지 정보", description = "여행지의 상세 정보를 나타낸다.")
public class Tripinfo {
	/* 고유번호 */
	@ApiModelProperty(value = "고유번호")
	private int idx;
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
	/* 장소설명 */
	@ApiModelProperty(value = "장소 설명")
	private String desc;
	/* 운영시간 */
	@ApiModelProperty(value = "운영시간")
	private String operTime;
	/* 휴식시간 */
	@ApiModelProperty(value = "휴식시간")
	private String restTime;
	/* 휴무일 안내내용 */
	@ApiModelProperty(value = "휴무일 안내내용")
	private String restdateContent;
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
	/* 전화번호 */
	@ApiModelProperty(value = "전화번호")
	private String tel;
	/* 찜수 */
	@ApiModelProperty(value = "찜수")
	private String likeCount;
	/* 조회수 */
	@ApiModelProperty(value = "조회수")
	private String viewCount;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getOperTime() {
		return operTime;
	}
	public void setOperTime(String operTime) {
		this.operTime = operTime;
	}
	public String getRestTime() {
		return restTime;
	}
	public void setRestTime(String restTime) {
		this.restTime = restTime;
	}
	public String getRestdateContent() {
		return restdateContent;
	}
	public void setRestdateContent(String restdateContent) {
		this.restdateContent = restdateContent;
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(String likeCount) {
		this.likeCount = likeCount;
	}
	public String getViewCount() {
		return viewCount;
	}
	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
	
	@Override
	public String toString() {
		return "Tripinfo [idx=" + idx + ", categoryName=" + categoryName + ", title=" + title + ", placeName="
				+ placeName + ", type=" + type + ", desc=" + desc + ", operTime=" + operTime + ", restTime=" + restTime
				+ ", restdateContent=" + restdateContent + ", address=" + address + ", lat=" + lat + ", loc=" + loc
				+ ", sidoCode=" + sidoCode + ", tel=" + tel + ", likeCount=" + likeCount
				+ ", viewCount=" + viewCount + "]";
	}
	
	
}
