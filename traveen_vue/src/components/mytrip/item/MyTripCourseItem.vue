<script setup>
import { ref } from "vue";

const props = defineProps({
  course: Object,
});

const done = ref(false);
</script>

<template>
  <div class="item-container">
    <img src="@/assets/img/icon_vertical_menu.png" alt="" id="menu" />
    <div class="top">코스 이름</div>
    <div class="courseName">{{ props.course.title }}</div>
    <div class="date">{{ props.course.startDate }} ~ {{ props.course.endDate }}</div>
    <img v-if="done" src="@/assets/img/icon_course_done.png" alt="" id="course-done" />
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/mytrip/item/myTripCourseItem.scss";
</style>
