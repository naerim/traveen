<script setup>
import { useRoute, useRouter } from "vue-router";

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
.btn-notice-box {
  display: flex;
  justify-content: center;
}

#btn-notice-list {
  background-color: #51cd89;
  border: none;
  border-radius: 6px;
  width: 140px;
  height: 40px;
  color: #fff;
  cursor: pointer;
  margin-top: 40px;
}
</style>
