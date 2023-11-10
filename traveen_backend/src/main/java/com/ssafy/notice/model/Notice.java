package com.ssafy.notice.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "NoticeDto : 공지사항 정보", description = "공지사항의 상세 정보를 나타낸다.")
public class Notice {
	/* 고유번호 */
	@ApiModelProperty(value = "고유번호")
	private int idx;
	/* user 고유번호 */
	@ApiModelProperty(value = "user 고유번호")
	private int userIdx;
	/* 제목 */
	@ApiModelProperty(value = "제목")
	private String title;
	/* 내용 */
	@ApiModelProperty(value = "내용")
	private String content;
	/* 작성일시 */
	@ApiModelProperty(value = "작성일시")
	private String createDate;
	/* 조회수 */
	@ApiModelProperty(value = "조회수")
	private String viewCount;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
	@Override
	public String toString() {
		return "Notice [idx=" + idx + ", user_idx=" + userIdx + ", title=" + title + ", content=" + content
				+ ", createDate=" + createDate + ", viewCount=" + viewCount + "]";
	}
}
