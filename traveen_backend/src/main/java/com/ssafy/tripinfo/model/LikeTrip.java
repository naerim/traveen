package com.ssafy.tripinfo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "LikeTripDto : 여행지 찜하기 정보", description = "찜한 여행지의 상세 정보를 나타낸다.")
public class LikeTrip {
	/* 고유번호 */
	@ApiModelProperty(value = "고유번호")
	private int idx;
	/* 여행지 고유번호 */
	@ApiModelProperty(value = "여행지 고유번호")
	private int tripinfoIdx;
	/* user 고유번호 */
	@ApiModelProperty(value = "user 고유번호")
	private int userIdx;
	/* 작성일시 */
	@ApiModelProperty(value = "작성일시")
	private String createDate;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getTripinfoIdx() {
		return tripinfoIdx;
	}
	public void setTripinfoIdx(int tripinfoIdx) {
		this.tripinfoIdx = tripinfoIdx;
	}
	public int getUserIdx() {
		return userIdx;
	}
	public void setUserIdx(int userIdx) {
		this.userIdx = userIdx;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "LikeTrip [idx=" + idx + ", tripinfoIdx=" + tripinfoIdx + ", userIdx=" + userIdx + ", createDate="
				+ createDate + "]";
	}
}