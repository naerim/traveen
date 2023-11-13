<script setup>
import { ref } from "vue";
import TripListItem from "./item/TripListItem.vue";
import VEmptyItem from "@/components/common/VEmptyItem.vue";

// trip list 길이
const trip = ref(1);
</script>

<template>
  <div v-if="trip === 0">
    <VEmptyItem text="검색 결과가 없습니다." />
  </div>
  <div v-else id="content-box">
    <TripListItem />
  </div>
</template>

<style scoped>
#content-box {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  gap: 60px 50px;
  margin-bottom: 20px;
}
</style>
