package com.ssafy.post.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "PostDto : 여행 후기 게시글 정보", description = "여행 후기 게시글의 상세 정보를 나타낸다.")
public class Post {
	/* 고유번호 */
	@ApiModelProperty(value = "고유번호")
	private int idx;
	/* user 고유번호 */
	@ApiModelProperty(value = "user 고유번호")
	private int userIdx;
	/* course 고유번호 */
	@ApiModelProperty(value = "course 고유번호")
	private int courseIdx;
	/* 작성일시 */
	@ApiModelProperty(value = "작성일시")
	private String createDate;
	/* 조회수 */
	@ApiModelProperty(value = "조회수")
	private String viewCount;
	/* 좋아요 수 */
	@ApiModelProperty(value = "좋아요 수")
	private String likeCount;
	/* 내용 */
	@ApiModelProperty(value = "내용")
	private String content;
	/* 제목 */
	@ApiModelProperty(value = "제목")
	private String title;
	/* 여행 시작일 */
	@ApiModelProperty(value = "여행 시작일")
	private String startDate;
	/* 여행 종료일 */
	@ApiModelProperty(value = "여행 종료일")
	private String endDate;
	/* 이미지 */
	@ApiModelProperty(value = "이미지")
	private String image;
	/* 작성자 이름 */
	@ApiModelProperty(value = "작성자 이름")
	private String userName;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public int getCourseIdx() {
		return courseIdx;
	}
	public void setCourseIdx(int courseIdx) {
		this.courseIdx = courseIdx;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getViewCount() {
		return viewCount;
	}
	public void setViewCount(String viewCount) {
		this.viewCount = viewCount;
	}
	public String getLikeCount() {
		return likeCount;
	}
	public void setLikeCount(String likeCount) {
		this.likeCount = likeCount;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	@Override
	public String toString() {
		return "Post [idx=" + idx + ", userIdx=" + userIdx + ", courseIdx=" + courseIdx + ", createDate=" + createDate
				+ ", viewCount=" + viewCount + ", likeCount=" + likeCount + ", content=" + content + ", title=" + title
				+ "]";
	}
	
	
}
