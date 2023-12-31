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
    <link rel="stylesheet" href="../css/join.css" />
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
            id="userId"
            name="userId"
          />
          <button id="btn-check-id" type="button">중복 확인</button>
           <c:if test="${checkId} eq 1">
          	alert("존재하는 아이디")
           </c:if>
        </div>
        <div class="input-title">이름</div>
        <input
          class="input-default"
          placeholder="이름을 입력해주세요."
          id="userName"
          name="userName"
        />
        <div class="input-title">이메일</div>
        <div class="input-email-box">
          <input
            type="text"
            placeholder="이메일을 입력해주세요."
            id="emailId"
            name="emailId"
          />
          <span>@</span>
          <select name="emailDomain" id="emailDomain">
          	<option value="" disabled selected>선택</option>
            <option value="naver.com">naver.com</option>
            <option value="google.com">google.com</option>
            <option value="daum.net">daum.net</option>
            
          </select>
          <button type="button" id="btn-send-code">인증번호 받기</button>
        </div>
        <div class="input-title">인증번호</div>
        <div class="input-confirm-box">
          <input name="code" id="code" />
          <button id="btn-check-code" type="button">인증번호 확인</button>
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
          type="password"
          class="input-default"
          placeholder="비밀번호를 입력해주세요."
          id="userPwd"
          name="userPwd"
        />
        <div class="input-title">비밀번호 확인</div>
        <input
          type="password"
          class="input-default"
          placeholder="비밀번호를 확인해주세요."
          id="pwdCheck"
          name="pwdCheck"
        />
        <input type="button" id="btn-join" value="가입하기" />
      </form>
    </section>

    <!-- footer -->
	<%@ include file="../include/footer.jsp"%>
  </body>
  <script>
	document.querySelector("#btn-join").addEventListener("click", function() {
		if (!document.querySelector("#userId").value) {
			alert("아이디를 입력해주세요.");
			return;
		} else if (!document.querySelector("#userName").value) {
			alert("이름을 입력해주세요.");;
			return;
		} else if (!document.querySelector("#emailId").value) {
			alert("이메일을 입력해주세요.");
			return;
		} else if (!document.querySelector("#emailDomain").value) {
			alert("이메일을 선택해주세요.");
			return;
		} else if (!document.querySelector("#code").value) {
			alert("인증번호를 입력해주세요.");
			return;
		} else if (!document.querySelector("#mobile").value) {
			alert("전화번호를 입력해주세요.");
			return;
		} else if (!document.querySelector("#userPwd").value) {
			alert("비밀번호를 입력해주세요.");
			return;
		} else if (!document.querySelector("#pwdCheck").value) {
			alert("비밀번호 확인을 입력해주세요.");
			return;
		} else if(!document.querySelector("#btn-check-id").disabled) {
			alert("아이디 중복 확인을 해주세요.");
			return;
		} else if(document.querySelector("#pwdCheck").value != document.querySelector("#userPwd").value) {
			alert("비밀번호가 일치하지 않습니다.");
			document.querySelector("#pwdCheck").focus();
			return;
		} 
		else {
			let form = document.querySelector("#form-join");
			form.setAttribute("action", "${root}/user/join");
			form.submit();
		}
	});
	
	document.querySelector("#btn-check-id").addEventListener("click", function(e) {
		e.preventDefault();
		if (!document.querySelector("#userId").value) {
			alert("아이디를 입력해주세요.");
			return;
		} else {
			const userId = document.querySelector("#userId").value;
			const url = "${root}/user/idCheck/"+userId;
	          fetch(url)
	          .then((res)=>{
	        	return res.json();
	          })
	          .then((data) => {
	        	  if(data.result == "중복됨") {
	        		  alert("중복된 아이디입니다.");
	        		  document.querySelector("#userId").focus();
	        	  } else {
	        		  document.querySelector("#btn-check-id").disabled = true;
	        	  }
	          })
		}
	});
	
	document.querySelector("#userId").addEventListener("input", function(e) {
		document.querySelector("#btn-check-id").disabled = false;
	});
	
	document.querySelector("#btn-check-code").addEventListener("click", function(e) {
		e.preventDefault();
		this.disabled = true;
	});
</script>
</html>