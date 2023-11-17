package com.ssafy.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "UserDto : 회원 정보", description = "회원의 상세 정보를 나타낸다.")
public class User {
	/* 고유번호 */
	@ApiModelProperty(value = "고유번호")
	private int idx;
	/* 아이디 */
	@ApiModelProperty(value = "아이디")
	private String userId;
	/* 비밀번호 */
	@ApiModelProperty(value = "비밀번호")
	private String userPwd;
	/* 이름 */
	@ApiModelProperty(value = "이름")
	private String userName;
	/* 이메일 아이디 */
	@ApiModelProperty(value = "이메일 아이디")
	private String emailId;
	/* 이메일 도메인 */
	@ApiModelProperty(value = "이메일 도메인")
	private String emailDomain;
	/* 휴대전화 번호 */
	@ApiModelProperty(value = "휴대전화 번호")
	private String mobile;
	/* 해당 아이디의 고유한 salt */
	@ApiModelProperty(value = "salt")
	private String salt;
	/* 가입일 */
	@ApiModelProperty(value = "가입일")
	private String joinDate;
	/* 토큰 */
	@ApiModelProperty(value = "토큰")
	private String token;
	/* 등급 */
	@ApiModelProperty(value = "등급")
	private String position;
	/* 이메일 인증번호 */
	@ApiModelProperty(value = "이메일 인증번호")
	private String emailCode;
	/* refresh token */
	@ApiModelProperty(value = "refresh token")
	private String refreshToken;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getEmailDomain() {
		return emailDomain;
	}
	public void setEmailDomain(String emailDomain) {
		this.emailDomain = emailDomain;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getEmailCode() {
		return emailCode;
	}
	public void setEmailCode(String emailCode) {
		this.emailCode = emailCode;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	@Override
	public String toString() {
		return "User [idx=" + idx + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", emailId=" + emailId + ", emailDomain=" + emailDomain + ", mobile=" + mobile + ", salt=" + salt
				+ ", joinDate=" + joinDate + ", token=" + token + ", position=" + position + ", emailCode=" + emailCode
				+ ", refreshToken=" + refreshToken + "]";
	}
}
