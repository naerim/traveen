<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Traveen</title>
    <link rel="stylesheet" href="./css/common.css" />
    <link rel="stylesheet" href="./css/join.css" />
  </head>
  <body>
    <!-- header -->
    <%@ include file="../include/header.jsp"%>

    <!-- section -->
    <section>
      <div class="auth-top">
        <h2>회원가입</h2>
        <h5>Traveen에 가입해서 더 많은 혜택을 누려보세요!</h5>
      </div>
      <form class="input-box" id="form-join" method="post" action="#">
        <div class="input-title">아이디</div>
        <div class="input-id-box">
          <input
            placeholder="아이디를 입력해주세요."
            id="user_id"
            name="user_id"
          />
          <button disabled id="btn-check-id">중복 확인</button>
        </div>
        <div class="input-title">이름</div>
        <input
          class="input-default"
          placeholder="이름을 입력해주세요."
          id="user_name"
          name="user_name"
        />
        <div class="input-title">이메일</div>
        <div class="input-email-box">
          <input
            type="text"
            placeholder="이메일을 입력해주세요."
            id="email_id"
            name="email_id"
          />
          <span>@</span>
          <select name="email_domain" id="email_domain">
            <option value="@ssafy.com">ssafy.com</option>
            <option value="@naver.com">naver.com</option>
            <option value="@google.com">google.com</option>
          </select>
          <button id="btn-send-code">인증번호 받기</button>
        </div>
        <div class="input-title">인증번호</div>
        <div class="input-confirm-box">
          <input name="code" id="code" />
          <button id="btn-check-code">인증번호 확인</button>
        </div>
        <div class="input-title">전화번호</div>
        <input
          class="input-default"
          placeholder="전화번호를 입력해주세요."
          id="mobile"
          name="mobile"
        />
        <div class="input-title">비밀번호</div>
        <input
          class="input-default"
          placeholder="비밀번호를 입력해주세요."
          id="user_pwd"
          name="user_pwd"
        />
        <div class="input-title">비밀번호 확인</div>
        <input
          class="input-default"
          placeholder="비밀번호를 확인해주세요."
          id="pwd_check"
          name="pwd_check"
        />
        <input type="submit" id="btn-join" value="가입하기" />
      </form>
    </section>
    
    <!-- footer -->
	<%@ include file="../include/footer.jsp"%>
    
  </body>
</html>
