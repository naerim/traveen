<script setup>
import NoticeGoListButton from "@/components/notice/item/NoticeGoListButton.vue";
import NoticeFormItem from "@/components/notice/item/NoticeFormItem.vue";
</script>

<template>
  <section>
    <h2>공지사항 등록</h2>
    <NoticeFormItem type="write" />
    <NoticeGoListButton />
  </section>
</template>

<style scoped>
@import "@/assets/scss/components/notice/noticeWrite.scss";
</style>
