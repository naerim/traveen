package com.ssafy.tripinfo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SidoDto : 시도 정보", description = "시도의 상세 정보를 나타낸다.")
public class Sido {
	/* 고유번호 */
	@ApiModelProperty(value = "고유번호")
	private int idx;
	/* 시도 코드 */
	@ApiModelProperty(value = "시도 코드")
	private int code;
	/* 시도 이름 */
	@ApiModelProperty(value = "시도 이름")
	private String name;
	
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "Sido [idx=" + idx + ", code=" + code + ", name=" + name + "]";
	}
	
}
