package com.ssafy.qna.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QnaDto : QnA 정보", description = "QnA의 상세 정보를 나타낸다.")
public class Qna {
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

	@Override
	public String toString() {
		return "Qna [idx=" + idx + ", userIdx=" + userIdx + ", title=" + title + ", content=" + content + "]";
	}
}
