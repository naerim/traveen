<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { storeToRefs } from "pinia";
import { useMemberStore } from "@/stores/member";

const memberStore = useMemberStore();
const { isLogin } = storeToRefs(memberStore);

const router = useRouter();

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
      <button v-if="isLogin" @click="goMyPage">마이페이지</button>
      <button v-else @click="goLoginPage">로그인</button>
    </div>
    <i class="fa-solid fa-bars fa-2x" style="color: #454545" id="hamburger"></i>
  </header>
</template>

<style scoped>
@import "@/assets/scss/components/layout/theHeadingNavbar.scss";
</style>
