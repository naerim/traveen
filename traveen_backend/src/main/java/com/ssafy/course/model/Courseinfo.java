package com.ssafy.course.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CourseinfoDto : 코스의 아이템 정보", description = "코스 아이템의 상세 정보를 나타낸다.")
public class Courseinfo {
	/* 고유번호 */
	@ApiModelProperty(value = "고유번호")
	private int idx;
	/* 여행지 고유 번호 */
	@ApiModelProperty(value = "여행지 고유 번호")
	private String tripinfoIdx;
	/* 순서 */
	@ApiModelProperty(value = "순서")
	private int order;
	/* 카테고리 */
	@ApiModelProperty(value = "카테고리")
	private String categoryName;
	/* 작품이름 */
	@ApiModelProperty(value = "작품이름")
	private String title;
	/* 장소이름 */
	@ApiModelProperty(value = "장소이름")
	private String placeName;
	/* 장소 카테고리 */
	@ApiModelProperty(value = "장소 카테고리")
	private String type;
	/* 주소 */
	@ApiModelProperty(value = "주소")
	private String address;
	/* 위도 */
	@ApiModelProperty(value = "위도")
	private String lat;
	/* 경도 */
	@ApiModelProperty(value = "경도")
	private String loc;
	/* 시도 코드 */
	@ApiModelProperty(value = "시도 코드")
	private int sidoCode;
}
