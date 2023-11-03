<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Traveen</title>
    <link rel="stylesheet" href="../css/common.css" />
    <link rel="stylesheet" href="../css/mypage.css" />
    <link rel="stylesheet" href="../css/myinfo.css" />
  </head>
  <body>
    <!-- header -->
    <%@ include file="../include/header.jsp"%>
    
    <!-- title -->
    <h1 class="title">마이페이지</h1>
    <!-- content -->
    <div class="container">
      <!-- aside -->
      <aside>
        <div class="aside-container">
          <!-- profile -->
          <div class="profile-box">
            <img
              src="../img/img_profile.png"
              alt=""
              id="profile-img"
              name="profile-img"
            />
            <div class="btn-select-profile">
              <img src="../img/icon_plus.png" alt="" />
            </div>
          </div>
          <!-- name -->
          <div id="user_name">김유냐냐</div>
          <!-- follower -->
          <div id="follower">팔로워 10</div>
          <ul class="menu">
            <li>나의 정보</li>
            <li>나의 여행</li>
            <li>나의 활동</li>
            <li>나의 친구</li>
          </ul>
          <!-- line -->
          <div class="line"></div>
          <!-- link-box -->
          <div class="link-box">
            <a href="${root}/user/logout">로그아웃</a>
            <a href="#">회원탈퇴</a>
          </div>
        </div>
        <div class="bottom-logo">Traveen</div>
      </aside>
      <!-- section -->
      <section>
        <h2>나의 정보</h2>
        <div class="top-box">
          <div class="subtitle">내 정보 수정</div>
          <button id='btn-modify-myinfo'>수정하기</button>
        </div>
        <div class="info-container">
          <form action="">
            <div class="input-title">아이디</div>
            <input type="text" id='userId' name='userId' value='ssafy' readonly>
            <div class="input-title">이름</div>
            <input type="text" id='userName' name='userName' value='김싸피'>
            <div class="input-title">이메일</div>
            <input type="text" id='emailId' name='emailId' value='ssafy'>
            <span>@</span>
            <select name="emailDomain" id="emailDomain">
              <option value="#naver.com">naver.com</option>
              <option value="#google.com">google.com</option>
            </select>
            <div class="input-title">전화번호</div>
            <input type="text" id='mobile' name='mobile' value='01028283737'>
          </form>
        </div>
        <div class="top-box">
          <div class="subtitle">비밀번호 변경</div>
          <button id='btn-modify-pwd'>변경하기</button>
        </div>
        <div class="pwd-container">
          <form action="">
            <div class="input-title">현재 비밀번호</div>
            <input type="password" id='cPwd' name='cPwd' value=''>
            <div class="pwd-bottom-box">
              <div class="left">
                <div class="input-title">바꿀 비밀번호</div>
                <input type="password" id='userPwd' name='userPwd' value=''>
              </div>
              <div class="right">
                <div class="input-title">비밀번호 확인</div>
                <input type="password" id='pwdChk' name='pwdChk' value=''>
              </div>
            </div>
          </form>
        </div>
      </section>
    </div>
    
    <!-- footer -->
	<%@ include file="../include/footer.jsp"%>
  </body>
</html>
