package com.ssafy.tripinfo.model;

public class Tripinfo {
	/* 고유번호 */
	private int idx;
	/* 카테고리 */
	private String categoryCode;
	/* 작품이름 */
	private String title;
	/* 장소이름 */
	private String placeName;
	/* 장소 카테고리 */
	private String type;
	/* 장소설명 */
	private String desc;
	/* 운영시간 */
	private String operTime;
	/* 휴식시간 */
	private String restTime;
	/* 휴무일 안내내용 */
	private String restdateContent;
	/* 주소 */
	private String address;
	/* 위도 */
	private String lat;
	/* 경도 */
	private String loc;
	/* 시도 고유번호 */
	private String sidoIdx;
	/* 구군 공유번호 */
	private String gugunIdx;
	/* 전화번호 */
	private String tel;
	/* 찜수 */
	private String likeCount;
	/* 조회수 */
	private String viewCount;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCategoryCode() {
		return categoryCode;
	}
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
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
	public String getSidoIdx() {
		return sidoIdx;
	}
	public void setSidoIdx(String sidoIdx) {
		this.sidoIdx = sidoIdx;
	}
	public String getGugunIdx() {
		return gugunIdx;
	}
	public void setGugunIdx(String gugunIdx) {
		this.gugunIdx = gugunIdx;
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
		return "Tripinfo [idx=" + idx + ", categoryCode=" + categoryCode + ", title=" + title + ", placeName="
				+ placeName + ", type=" + type + ", desc=" + desc + ", operTime=" + operTime + ", restTime=" + restTime
				+ ", restdateContent=" + restdateContent + ", address=" + address + ", lat=" + lat + ", loc=" + loc
				+ ", sidoIdx=" + sidoIdx + ", gugunIdx=" + gugunIdx + ", tel=" + tel + ", likeCount=" + likeCount
				+ ", viewCount=" + viewCount + "]";
	}
	
	
}
