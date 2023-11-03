package com.ssafy.notice.model;

public class Notice {
	/* 고유번호 */
	private int idx;
	/* user 고유번호 */
	private String userIdx;
	/* 제목 */
	private String title;
	/* 내용 */
	private String content;
	/* 작성일시 */
	private String createDate;
	/* 조회수 */
	private String viewCount;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(String userIdx) {
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
