<script setup></script>

<template>
  <section>
    <h2>고객센터</h2>
    <div class="center-menu-wrap">
      <router-link :to="{ name: 'notice' }">공지사항</router-link>
      <router-link :to="{ name: 'qna-list' }">QnA</router-link>
    </div>
  </section>
</template>

<style scoped>
@import "@/assets/scss/components/center/theCenterNavbar.scss";
</style>
