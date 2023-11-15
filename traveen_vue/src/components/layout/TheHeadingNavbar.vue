<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";

const router = useRouter();

// 임시 - 로그인한 유저가 있을 때
const loginUser = ref(false);

const goLoginPage = () => router.push({ name: "login" });
const goMyPage = () => router.push({ name: "mypage" });
</script>

<template>
  <header>
    <div class="container">
      <div class="header-left">
        <div id="logo">
          <RouterLink to="/">Traveen</RouterLink>
        </div>
        <div id="menulist">
          <router-link :to="{ name: 'trip-list' }">여행지</router-link>
          <router-link :to="{ name: 'aftertraveen-list' }">애프터 트래빈</router-link>
          <router-link to="/center">고객센터</router-link>
        </div>
      </div>
      <button v-if="loginUser" @click="goMyPage">마이페이지</button>
      <button v-else @click="goLoginPage">로그인</button>
    </div>
    <i class="fa-solid fa-bars fa-2x" style="color: #454545" id="hamburger"></i>
  </header>
</template>

<style scoped>
@import "@/assets/scss/components/layout/theHeadingNavbar.scss";
</style>
