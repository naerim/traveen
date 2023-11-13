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
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 3;
}

.modal-container {
  background-color: #fff;
  padding: 20px;
  border-radius: 8px;
  width: 500px;
  height: 280px;
}
</style>
