<script setup></script>

<template>
  <div class="top-box">
    <div class="subtitle">비밀번호 변경</div>
    <button id="btn-modify-pwd">변경하기</button>
  </div>
  <div class="pwd-container">
    <form action="">
      <div class="input-title">현재 비밀번호</div>
      <input type="password" id="cPwd" name="cPwd" value="" />
      <div class="pwd-bottom-box">
        <div class="left">
          <div class="input-title">바꿀 비밀번호</div>
          <input type="password" id="userPwd" name="userPwd" value="" />
        </div>
        <div class="right">
          <div class="input-title">비밀번호 확인</div>
          <input type="password" id="pwdChk" name="pwdChk" value="" />
        </div>
      </div>
    </form>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/myinfo/myInfoModifyPwdForm.scss";
</style>
