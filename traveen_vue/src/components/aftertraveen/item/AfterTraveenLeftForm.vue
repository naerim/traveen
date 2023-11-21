<script setup>
import VKakaoMapLine from "@/components/common/VKakaoMapLine.vue";
</script>

<template>
  <div class="wrap">
    <div class="wrap-top">기본 정보</div>
    <div class="wrap-content">
      <label>글 제목</label>
      <input type="text" placeholder="제목을 입력해주세요." />
      <label>여행코스</label>
      <div class="course-title">나만의 제주도 여행 코스</div>
      <label>여행일</label>
      <div class="date">2023-11-21 ~ 2023-11-21</div>
      <label>여행 후기 요약</label>
      <textarea
        name=""
        id=""
        cols="30"
        rows="10"
        placeholder="여행 후기를 요약해주세요."
      ></textarea>
      <label>지도</label>
      <VKakaoMapLine :height="`${220}px`" />
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/aftertraveen/item/afterTraveenLeftForm.scss";
</style>
