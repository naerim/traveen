<script setup>
import TheMypageNavbar from "@/components/mypage/TheMypageNavbar.vue";
import { RouterView } from "vue-router";
</script>

<template>
  <h1 class="title">마이페이지</h1>
  <section>
    <TheMypageNavbar />
    <article>
      <RouterView />
    </article>
  </section>
</template>

<style scoped>
@import "@/assets/scss/views/mypageView.scss";
</style>
