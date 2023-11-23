<script setup>
import VEmptyItem from "@/components/common/VEmptyItem.vue";
</script>

<template>
  <div class="subtitle">내가 쓴 댓글</div>
  <div class="container">
    <ul>
      <VEmptyItem text="내가 쓴 댓글이 없습니다. " />
    </ul>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/myactive/myActiveComment.scss";
</style>
