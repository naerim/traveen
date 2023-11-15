<script setup></script>

<template>
  <div class="top-box">
    <div class="subtitle">내 정보 수정</div>
    <button id="btn-modify-myinfo">수정하기</button>
  </div>
  <div class="info-container">
    <form action="">
      <div class="input-title">아이디</div>
      <input type="text" id="userId" name="userId" value="ssafy" readonly />
      <div class="input-title">이름</div>
      <input type="text" id="userName" name="userName" value="김싸피" />
      <div class="input-title">이메일</div>
      <input type="text" id="emailId" name="emailId" value="ssafy" />
      <span>@</span>
      <select name="emailDomain" id="emailDomain">
        <option value="#naver.com">naver.com</option>
        <option value="#google.com">google.com</option>
      </select>
      <div class="input-title">전화번호</div>
      <input type="text" id="mobile" name="mobile" value="01028283737" />
    </form>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/myinfo/myInfoModifyForm.scss";
</style>
