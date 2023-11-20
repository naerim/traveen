package com.ssafy.friend.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "FriendDto : 친구 정보", description = "친구의 상세 정보를 나타낸다.")
public class Friend {
	/* 고유번호 */
	@ApiModelProperty(value = "고유번호")
	private int idx;
	/* 팔로워 고유번호 */
	@ApiModelProperty(value = "팔로워 고유번호")
	private String fromIdx;
	/* 팔로잉 고유번호 */
	@ApiModelProperty(value = "팔로잉 고유번호")
	private String toIdx;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getFromIdx() {
		return fromIdx;
	}
	public void setFromIdx(String fromIdx) {
		this.fromIdx = fromIdx;
	}
	public String getToIdx() {
		return toIdx;
	}
	public void setToIdx(String toIdx) {
		this.toIdx = toIdx;
	}
	@Override
	public String toString() {
		return "Friend [idx=" + idx + ", fromIdx=" + fromIdx + ", toIdx=" + toIdx + "]";
	}
}
