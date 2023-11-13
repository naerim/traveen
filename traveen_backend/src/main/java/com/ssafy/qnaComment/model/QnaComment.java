package com.ssafy.qnaComment.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QnaCommentDto : QnA 댓글 정보", description = "QnA 댓글의 상세 정보를 나타낸다.")
public class QnaComment {
	/* 고유번호 */
	@ApiModelProperty(value = "고유번호")
	private int idx;
	
	/* user 고유번호 */
	@ApiModelProperty(value = "user 고유번호")
	private int userIdx;
	
	/* qna 고유번호 */
	@ApiModelProperty(value = "qna 고유번호")
	private int qnaIdx;
	
	/* 내용 */
	@ApiModelProperty(value = "내용")
	private String content;
	
	/* 작성일시 */
	@ApiModelProperty(value = "작성일시")
	private String createDate;

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

	public int getQnaIdx() {
		return qnaIdx;
	}

	public void setQnaIdx(int qnaIdx) {
		this.qnaIdx = qnaIdx;
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

	@Override
	public String toString() {
		return "QnaComment [idx=" + idx + ", userIdx=" + userIdx + ", qnaIdx=" + qnaIdx + ", content=" + content
				+ ", createDate=" + createDate + "]";
	}
}
