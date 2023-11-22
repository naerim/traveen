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
	/* 내용 */
	@ApiModelProperty(value = "content")
	private String content;
	/* 순서 */
	@ApiModelProperty(value = "content")
	private int order;
	
	
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
	
	
	@Override
	public String toString() {
		return "PostItem [idx=" + idx + ", postIdx=" + postIdx + ", tripinfoIdx=" + tripinfoIdx + ", courseIdx="
				+ courseIdx + ", content=" + content + ", order=" + order + "]";
	}
	
	
}
