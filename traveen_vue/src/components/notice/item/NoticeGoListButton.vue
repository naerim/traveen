<script setup>
import { useRouter } from "vue-router";

const router = useRouter();

// 공지사항 목록페이지로 이동
const goNoticeList = () => {
  router.push({ name: "notice-list" });
};
</script>

<template>
  <div class="btn-notice-box">
    <button id="btn-notice-list" @click="goNoticeList">목록</button>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/notice/item/noticeGoListButton.scss";
</style>
