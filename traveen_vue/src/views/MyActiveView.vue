<script setup>
import MyActivePost from "@/components/myactive/MyActivePost.vue";
import MyActiveComment from "@/components/myactive/MyActiveComment.vue";
</script>

<template>
  <h2>나의 활동</h2>
  <MyActivePost />
  <MyActiveComment />
</template>

<style scoped>
@import "@/assets/scss/views/myActiveView.scss";
</style>
