<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { sendEmailPwd, resetPwd } from "@/api/user";

const router = useRouter();

const info = ref({
  userId: "",
  email: "",
  code: "",
  newPwd: "",
});

const getEmailCode = () => {
  if (info.value.email == "") {
    alert("이메일을 입력해주세요.");
  } else {
    sendEmailPwd(
      info.value.email,
      ({ data }) => {
        alert("임시 비밀번호가 발급되었습니다.");
        info.value.newPwd = data.key;
      },
      (error) => console.log(error)
    );
  }
};

const onResetPwd = () => {
  const blank_pattern = /[\s]/g;
  if (blank_pattern.test(info.value.userId)) {
    alert("아이디를 입력해주세요.");
  } else if (info.value.email == "") {
    alert("이메일을 입력해주세요.");
  } else if (info.value.newPwd != info.value.code || info.value.code == "") {
    alert("임시 비밀번호가 올바르지 않습니다.");
  } else {
    resetPwd(
      info.value,
      () => {
        alert("비밀번호가 초기화되었습니다.");
        router.push({ name: "login" });
      },
      (error) => console.log(error)
    );
  }
};
</script>

<template>
  <article>
    <div class="auth-top">
      <h2>비밀번호 찾기</h2>
      <h5>회원정보에 등록한 이메일과 입력한 이메일이 동일해야 인증번호를 받을 수 있습니다.</h5>
    </div>
    <div class="form-wrap">
      <label>아이디</label>
      <input type="text" placeholder="아이디를 입력해주세요." v-model="info.userId" />
      <label>이메일</label>
      <div class="email-wrap">
        <input type="text" placeholder="이메일을 입력해주세요." v-model="info.email" />
        <button @click="getEmailCode">발급 받기</button>
      </div>
      <input type="text" placeholder="임시 비밀번호 입력" v-model="info.code" />
    </div>
    <button id="btn-reset-pwd" @click="onResetPwd">비밀번호 초기화</button>
    <div class="bottom-wrap">
      <a href="/login">로그인하기</a>
      <a>아이디 찾기</a>
    </div>
  </article>
</template>

<style scoped>
@import "@/assets/scss/views/findPwdView.scss";
</style>
