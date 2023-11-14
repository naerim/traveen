<script setup>
defineProps({
  show: Boolean,
});
</script>

<template>
  <div v-if="show" class="modal-overlay">
    <div class="modal-container" @click.stop>
      <slot></slot>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/qna/qnaWriteModal.scss";
</style>
