<script setup>
import { RouterView } from "vue-router";
</script>

<template>
  <section>
    <RouterView />
  </section>
</template>

<style scoped>
section {
  width: 80%;
  max-width: 1100px;
  min-width: 1100px;
  margin: 0 auto;
  padding-bottom: 100px;
  padding-top: 40px;
}
</style>
