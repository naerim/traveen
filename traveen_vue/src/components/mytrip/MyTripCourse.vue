<script setup>
import { computed } from "vue";
import { storeToRefs } from "pinia";
import MyTripCourseItem from "@/components/mytrip/item/MyTripCourseItem.vue";
import { useMyTripStore } from "@/stores/mytrip";

const myTripStore = useMyTripStore();
const { mycourse } = storeToRefs(myTripStore);
</script>

<template>
  <div class="container">
    <MyTripCourseItem v-for="course in mycourse" :key="course.idx" :course="course" />
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/mytrip/myTripCourse.scss";
</style>
