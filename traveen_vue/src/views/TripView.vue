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
article {
  width: 80%;
  max-width: 1100px;
  min-width: 1100px;
  margin: 0 auto;
  padding-bottom: 100px;
  padding-top: 40px;
}

.title {
  font-size: 2em;
  font-weight: 700;
  text-align: center;
  margin-bottom: 60px;
  white-space: pre-line;
}
</style>
