<script setup>
import { storeToRefs } from "pinia";
import AfterTraveenRightListItem from "@/components/aftertraveen/item/AfterTraveenRightListItem.vue";
import { useCourseStore } from "@/stores/course";

const courseStore = useCourseStore();
const { courseList } = storeToRefs(courseStore);
</script>

<template>
  <div class="wrap">
    <div class="wrap-top">나의 여행 코스</div>
    <div class="wrap-content">
      <AfterTraveenRightListItem
        v-for="(trip, index) in courseList"
        :trip="trip"
        :key="trip.idx"
        :index="index + 1"
      />
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/aftertraveen/item/afterTraveenRightForm.scss";
</style>
