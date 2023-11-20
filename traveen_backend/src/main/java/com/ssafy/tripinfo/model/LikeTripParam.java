package com.ssafy.tripinfo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "LikeTripParamDto : 여행지 찜하기 parameter의 정보", description = "찜한 여행지 parameter의 상세 정보를 나타낸다.")
public class LikeTripParam {
	/* 여행지 고유번호 */
	@ApiModelProperty(value = "여행지 고유번호")
	private int tripinfoIdx;
	/* user 고유번호 */
	@ApiModelProperty(value = "user 고유번호")
	private int userIdx;
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
	@Override
	public String toString() {
		return "LikeTripParam [tripinfoIdx=" + tripinfoIdx + ", userIdx=" + userIdx + "]";
	}
}
