<script setup>
import { ref } from "vue";
import { storeToRefs } from "pinia";
import { RouterLink, useRouter } from "vue-router";
import { useMemberStore } from "@/stores/member";

const router = useRouter();

const memberStore = useMemberStore();

const { isLogin } = storeToRefs(memberStore);
const { userLogin, getUserInfo } = memberStore;

const loginUser = ref({
  userId: "",
  userPwd: "",
  refreshToken: "",
});

const login = async () => {
  await userLogin(loginUser.value);
  let token = sessionStorage.getItem("accessToken");
  if (isLogin) {
    getUserInfo(token);
    router.push("/");
  }
  else {
    alert("아이디 또는 비밀번호가 일치하지 않습니다.");
  }
};
</script>

<template>
  <form class="input-box" id="form-login" method="post" action="#">
    <div class="input-box-one">
      <label for="userId">아이디</label>
      <input
        type="text"
        id="userId"
        v-model="loginUser.userId"
        placeholder="아이디를 입력해주세요."
        autofocus
      />
    </div>
    <div class="input-box-one">
      <label for="userPwd">비밀번호</label>
      <input
        type="password"
        id="userPwd"
        v-model="loginUser.userPwd"
        placeholder="비밀번호를 입력해주세요."
      />
    </div>
    <div class="input-mid-box">
      <div class="checkbox-box">
        <label> <input type="checkbox" name="idSave"/> 아이디 기억하기 </label>
      </div>
      <RouterLink :to="{ name: 'join' }">회원가입</RouterLink>
    </div>
    <button type="button" id="btn-login" @click="login">로그인</button>
  </form>
  <div class="line"></div>
  <button id="kakao-login"><img src="@/assets/img/icon_kakao.png" alt="" />카카오 로그인</button>
  <div class="input-buttom-box">
    <a href="#">아이디 찾기</a>
    <div class="vertical"></div>
    <a href="#">비밀번호 찾기</a>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/login/LoginForm.scss";
</style>
