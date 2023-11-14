<script setup>
import AfterTraveenListItem from "@/components/aftertraveen/item/AfterTraveenListItem.vue";
</script>

<template>
  <article>
    <h1 class="title">애프터 트래빈</h1>
    <div class="subtitle">
      나의 여행 코스가 마음에 들었다면 후기를 통해 다른 사람들에게 공유해볼까요?
    </div>
    <div class="top-box">
      <div class="left">총 4건</div>
      <form class="right" id="form-search" action="#" method="post">
        <select name="select-notice" id="select-notice">
          <option value="">전체</option>
          <option value="subject">제목</option>
        </select>
        <input type="text" name="keyword" id="keyword" placeholder="검색어를 입력해주세요." />
        <input type="submit" id="btn-search" value="검색" />
      </form>
    </div>
    <div class="line"></div>
    <div class="content-box">
      <AfterTraveenListItem />
      <AfterTraveenListItem />
      <AfterTraveenListItem />
      <AfterTraveenListItem />
    </div>
  </article>
</template>

<style scoped>
@import "@/assets/scss/components/aftertraveen/afterTraveenList.scss";
</style>
