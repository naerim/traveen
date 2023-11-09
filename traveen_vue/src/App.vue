<script setup>
import { RouterView } from "vue-router";
import TheHeadingNavbar from "@/components/layout/TheHeadingNavbar.vue";
import TheFooter from "@/components/layout/TheFooter.vue";
</script>

<template>
  <TheHeadingNavbar />
  <section>
    <RouterView />
  </section>
  <TheFooter />
</template>

<style scoped>
section {
  padding-top: 70px;
}
</style>
