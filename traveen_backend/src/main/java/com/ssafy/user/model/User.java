package com.ssafy.user.model;

public class User {
	/* 고유번호 */
	private int idx;
	/* 아이디 */
	private String userId;
	/* 비밀번호 */
	private String userPwd;
	/* 이름 */
	private String userName;
	/* 이메일 아이디 */
	private String emailId;
	/* 이메일 도메인 */
	private String emailDomain;
	/* 휴대전화 번호 */
	private String mobile;
	/* 해당 아이디의 고유한 salt */
	private String salt;
	/* 가입일 */
	private String joinDate;
	/* 등급 */
	private String position;
	
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
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	@Override
	public String toString() {
		return "User [idx=" + idx + ", userId=" + userId + ", userPwd=" + userPwd + ", userName=" + userName
				+ ", emailId=" + emailId + ", emailDomain=" + emailDomain + ", mobile=" + mobile + ", salt=" + salt
				+ ", joinDate=" + joinDate + ", position=" + position + "]";
	}
}
