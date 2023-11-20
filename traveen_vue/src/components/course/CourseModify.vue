<script setup>
import { computed } from "vue";
import CourseSearchForm from "@/components/course/CourseSearchForm.vue";
import CourseList from "@/components/course/CourseList.vue";
import { useCourseStore } from "@/stores/course";

const courseStore = useCourseStore();
const currentCourse = computed(() => courseStore.currentCourse);
</script>

<template>
  <h1 class="title">
    "{{ currentCourse.title }}"<br />
    코스를 수정해보세요.
  </h1>
  <div class="course-modify-container">
    <CourseSearchForm />
    <CourseList type="modify" />
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/course/courseModify.scss";
</style>
