<script setup>
import MyActivePostItemVue from "./item/MyActivePostItem.vue";
</script>

<template>
  <div class="subtitle">내가 쓴 글</div>
  <div class="container">
    <div class="search-wrap">
      <input type="text" placeholder="글 제목을 입력해주세요." />
      <button>검색</button>
    </div>
    <ul>
      <MyActivePostItemVue />
    </ul>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/myactive/myActivePost.scss";
</style>
