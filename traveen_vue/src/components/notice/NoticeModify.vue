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
section {
  width: 80%;
  max-width: 1000px;
  margin: 0 auto;
  padding-bottom: 100px;
}
</style>
