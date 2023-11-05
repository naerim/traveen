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
          <div id="user_name">${user.userName}</div>
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
          <form action="" id="form-modify-myinfo" method="post">
            <div class="input-title">아이디</div>
            <input type="text" id='userId' name='userId' value='${user.userId}' readonly>
            <div class="input-title">이름</div>
            <input type="text" id='userName' name='userName' value='${user.userName}'>
            <div class="input-title">이메일</div>
            <input type="text" id='emailId' name='emailId' value='${user.emailId}'>
            <span>@</span>
            <select name="emailDomain" id="emailDomain">
              <option value="naver.com">naver.com</option>
              <option value="google.com">google.com</option>
            </select>
            <div class="input-title">전화번호</div>
            <input type="text" id='mobile' name='mobile' value='${user.mobile}'>
          </form>
        </div>
        <div class="top-box">
          <div class="subtitle">비밀번호 변경</div>
          <button id='btn-modify-pwd'>변경하기</button>
        </div>
        <div class="pwd-container">
          <form action="" id="form-modify-pwd" method="post">
            <input type="hidden" id='p-userId' name='userId' value='${user.userId}'>
            <input type="hidden" id='p-salt' name='salt' value='${user.salt}'>
            <div class="input-title">현재 비밀번호</div>
            <input type="password" id='userPwd' name='userPwd' value=''>
            <div class="pwd-bottom-box">
              <div class="left">
                <div class="input-title">바꿀 비밀번호</div>
                <input type="password" id='newPwd' name='newPwd' value=''>
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
  <script>
    // selectbox default 값 가져오기
    let selectbox = document.querySelector("#emailDomain");
    let len = selectbox.options.length;
    for(let i = 0; i < len; i++) {
      if(selectbox.options[i].value == "${user.emailDomain}") {
        selectbox.options[i].selected = true;
        break;
      }
    }

    // 회원정보 수정하기
    document.querySelector("#btn-modify-myinfo").addEventListener("click", function() {
      if (!document.querySelector("#userName").value) {
        alert("이름을 입력해주세요.");;
        return;
      } else if (!document.querySelector("#emailId").value) {
        alert("이메일을 입력해주세요.");
        return;
      } else if (!document.querySelector("#emailDomain").value) {
        alert("이메일을 선택해주세요.");
        return;
      } else if (!document.querySelector("#mobile").value) {
        alert("전화번호를 입력해주세요.");
        return;
      }
      else {
        let form = document.querySelector("#form-modify-myinfo");
        form.setAttribute("action", "${root}/user/myinfo");
        form.submit();
      }
    })

    // 비밀번호 수정하기
    document.querySelector("#btn-modify-pwd").addEventListener("click", function() {
      if (!document.querySelector("#userPwd").value) {
        alert("비밀번호를 입력해주세요.");;
        return;
      } else if (!document.querySelector("#newPwd").value) {
        alert("변경할 비밀번호를 입력해주세요.");
        return;
      } else if (!document.querySelector("#pwdChk").value) {
        alert("비밀번호를 확인해주세요.");
        return;
      }
      else {
        let form = document.querySelector("#form-modify-pwd");
        form.setAttribute("action", "${root}/user/myinfo/pwd");
        form.submit();
      }
    })
  </script>
  </body>
</html>
