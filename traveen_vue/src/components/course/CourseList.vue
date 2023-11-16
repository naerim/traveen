<script setup>
import CourseListItem from "@/components/course/item/CourseListItem.vue";
import { useCourseStore } from "@/stores/course";

const courseStore = useCourseStore();
</script>

<template>
  <div class="container">
    <div class="course-top">나의 여행 코스</div>
    <ul class="course-list">
      <CourseListItem
        v-for="(course, index) in courseStore.courseList"
        :key="course.idx"
        :course="course"
        :index="index + 1"
      />
    </ul>
    <button id="btn-sort-path">최단경로로 정렬</button>
    <button id="btn-regist-course">등록하기</button>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/course/courseList.scss";
</style>
