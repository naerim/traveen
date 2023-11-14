<script setup>
defineProps({
  text: String,
});
</script>

<template>
  <div class="empty-box">{{ text }}</div>
</template>

<style scoped>
@import "@/assets/scss/components/common/vEmptyItem.scss";
</style>
