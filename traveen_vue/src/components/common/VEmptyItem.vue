<script setup>
defineProps({
  text: String,
});
</script>

<template>
  <div class="empty-box">{{ text }}</div>
</template>

<style scoped>
.empty-box {
  display: flex;
  width: 100%;
  background-color: #f9fbfc;
  height: 200px;
  align-items: center;
  justify-content: center;
}
</style>
