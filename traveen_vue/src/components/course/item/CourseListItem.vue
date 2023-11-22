<script setup>
import { useCourseStore } from "@/stores/course";

const courseStore = useCourseStore();
const { deleteCourse } = courseStore;

defineProps({
  course: Object,
  index: Number,
});

const deleteItem = (val) => {
  deleteCourse(val);
};
</script>

<template>
  <div draggable="true" id="course-draggable-item">
    <div class="num">{{ index }}</div>
    <div class="right">
      <div class="top">
        <span>{{ course.type }}</span>
        <span :id="course.categoryName">{{ course.categoryName }}</span>
        <img src="@/assets/img/icon_close.png" alt="" @click="deleteItem(course.idx)" />
      </div>
      <div class="title">{{ course.placeName }}</div>
      <div class="addr">{{ course.address }}</div>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/course/item/courseListItem.scss";
</style>
