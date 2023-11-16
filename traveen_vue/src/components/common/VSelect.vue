<script setup>
import { ref } from "vue";
defineProps({ selectOption: Array });
const emit = defineEmits(["onKeySelect"]);

const key = ref("");

const onSelect = () => {
  emit("onKeySelect", key.value);
};
</script>

<template>
  <select v-model="key" @change="onSelect">
    <option v-for="option in selectOption" :key="option.idx" :value="option.code">
      {{ option.name }}
    </option>
  </select>
</template>

<style scoped></style>
