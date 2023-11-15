<script setup>
import MyInfoModifyForm from "@/components/myinfo/MyInfoModifyForm.vue";
import MyInfoModifyPwdForm from "@/components/myinfo/MyInfoModifyPwdForm.vue";
</script>

<template>
  <h2>나의 정보</h2>
  <MyInfoModifyForm />
  <MyInfoModifyPwdForm />
</template>

<style scoped>
@import "@/assets/scss/views/myInfoView.scss";
</style>
