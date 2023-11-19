<script setup>
import { useRouter } from "vue-router";

const router = useRouter();

const goTripPage = () => router.push({ name: "trip-list" });
</script>

<template>
  <div class="bg">
    <h1>
      <b>감각적</b>인 여행, <b class="g">촬영지</b>에서 만나는 아름다움.<br />
      당신만의 특별한 여행을 <b class="g">계획</b>하세요.
    </h1>
    <div class="bg-wrap" @click="goTripPage">
      <div class="line"></div>
      <span>검색하기</span>
      <img src="@/assets/img/icon_right_arrow_w.png" alt="" />
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/home/homeFirstSection.scss";
</style>
