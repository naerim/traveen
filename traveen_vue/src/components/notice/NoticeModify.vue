<script setup>
import NoticeGoListButton from "@/components/notice/item/NoticeGoListButton.vue";
import NoticeFormItem from "@/components/notice/item/NoticeFormItem.vue";
</script>

<template>
  <section>
    <h2>공지사항 수정</h2>
    <NoticeFormItem type="modify" />
    <NoticeGoListButton />
  </section>
</template>

<style scoped>
@import "@/assets/scss/components/notice/noticeModify.scss";
</style>
