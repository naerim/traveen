<script setup>
import TripList from "../components/trip/TripList.vue";
import TripSearchForm from "../components/trip/TripSearchForm.vue";
</script>

<template>
  <article>
    <h1 class="title">관심있는 촬영지를<br />검색해보세요.</h1>
    <TripSearchForm />
    <TripList />
  </article>
</template>

<style scoped>
@import "@/assets/scss/views/tripView.scss";
</style>
