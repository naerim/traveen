<script setup>
import { storeToRefs } from "pinia";
import MyTripCourseItem from "@/components/mytrip/item/MyTripCourseItem.vue";
import VEmptyItem from "@/components/common/VEmptyItem.vue";
import { useMyTripStore } from "@/stores/mytrip";

const myTripStore = useMyTripStore();
const { mycourse, mycourseCount } = storeToRefs(myTripStore);
</script>

<template>
  <VEmptyItem v-if="mycourseCount === 0" text="만든 여행 코스가 없습니다." />
  <div v-if="mycourseCount !== 0" class="container">
    <MyTripCourseItem v-for="course in mycourse" :key="course.idx" :course="course" />
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/mytrip/myTripCourse.scss";
</style>
