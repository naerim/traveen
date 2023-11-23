package com.ssafy.post.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PostItemDto : 여행 후기에 해당하는 코스의 아이템 정보", description = "여행 후기 게시글에 해당하는 코스의 아이템 정보를 나타낸다.")
public class PostItem {
	/* 고유번호 */
	@ApiModelProperty(value = "고유번호")
	private int idx;
	/* 글 고유번호 */
	@ApiModelProperty(value = "글 고유번호")
	private int postIdx;
	/* 여행지 고유번호 */
	@ApiModelProperty(value = "여행지 고유번호")
	private int tripinfoIdx;
	/* 코스 고유번호 */
	@ApiModelProperty(value = "코스 고유번호")
	private int courseIdx;
	/* 이미지 링크 */
	@ApiModelProperty(value = "이미지 링크")
	private String image;
	/* 장소이름 */
	@ApiModelProperty(value = "장소이름")
	private String placeName;
	/* 장소 카테고리 */
	@ApiModelProperty(value = "장소 카테고리")
	private String type;
	/* 카테고리 */
	@ApiModelProperty(value = "카테고리")
	private String categoryName;
	/* 주소 */
	@ApiModelProperty(value = "주소")
	private String address;
	/* 내용 */
	@ApiModelProperty(value = "내용")
	private String content;
	/* 순서 */
	@ApiModelProperty(value = "order")
	private int order;
	/* 위도 */
	@ApiModelProperty(value = "위도")
	private String lat;
	/* 경도 */
	@ApiModelProperty(value = "경도")
	private String loc;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getPostIdx() {
		return postIdx;
	}
	public void setPostIdx(int postIdx) {
		this.postIdx = postIdx;
	}
	public int getTripinfoIdx() {
		return tripinfoIdx;
	}
	public void setTripinfoIdx(int tripinfoIdx) {
		this.tripinfoIdx = tripinfoIdx;
	}
	public int getCourseIdx() {
		return courseIdx;
	}
	public void setCourseIdx(int courseIdx) {
		this.courseIdx = courseIdx;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
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
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
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
	
	@Override
	public String toString() {
		return "PostItem [idx=" + idx + ", postIdx=" + postIdx + ", tripinfoIdx=" + tripinfoIdx + ", courseIdx="
				+ courseIdx + ", image=" + image + ", placeName=" + placeName + ", type=" + type + ", categoryName="
				+ categoryName + ", address=" + address + ", content=" + content + ", order=" + order + ", lat=" + lat
				+ ", loc=" + loc + ", getIdx()=" + getIdx() + ", getPostIdx()=" + getPostIdx() + ", getTripinfoIdx()="
				+ getTripinfoIdx() + ", getCourseIdx()=" + getCourseIdx() + ", getImage()=" + getImage()
				+ ", getPlaceName()=" + getPlaceName() + ", getType()=" + getType() + ", getCategoryName()="
				+ getCategoryName() + ", getAddress()=" + getAddress() + ", getContent()=" + getContent()
				+ ", getOrder()=" + getOrder() + ", getLat()=" + getLat() + ", getLoc()=" + getLoc() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	
	
}
