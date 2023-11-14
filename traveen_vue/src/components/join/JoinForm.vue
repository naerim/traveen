<script setup></script>

<template>
  <form class="input-box" id="form-join" method="post" action="#">
    <div class="input-title">아이디</div>
    <div class="input-id-box">
      <input placeholder="아이디를 입력해주세요." id="userId" name="userId" />
      <button disabled id="btn-check-id">중복 확인</button>
    </div>
    <div class="input-title">이름</div>
    <input class="input-default" placeholder="이름을 입력해주세요." id="userName" name="userName" />
    <div class="input-title">이메일</div>
    <div class="input-email-box">
      <input type="text" placeholder="이메일을 입력해주세요." id="emailId" name="emailId" />
      <span>@</span>
      <select name="emailDomain" id="emailDomain">
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
    <input class="input-default" placeholder="전화번호를 입력해주세요." id="mobile" name="mobile" />
    <div class="input-title">비밀번호</div>
    <input
      class="input-default"
      placeholder="비밀번호를 입력해주세요."
      id="userPwd"
      name="userPwd"
    />
    <div class="input-title">비밀번호 확인</div>
    <input
      class="input-default"
      placeholder="비밀번호를 확인해주세요."
      id="pwdCheck"
      name="pwdCheck"
    />
    <input type="submit" id="btn-join" value="가입하기" />
  </form>
</template>

<style scoped>
@import "@/assets/scss/components/join/joinForm.scss";
</style>
