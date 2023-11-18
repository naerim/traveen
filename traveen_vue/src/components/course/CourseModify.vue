<script setup>
import CourseSearchForm from "@/components/course/CourseSearchForm.vue";
import CourseList from "@/components/course/CourseList.vue";
</script>

<template>
  <h1 class="title">
    "코스 이름"<br />
    코스를 수정해보세요.
  </h1>
  <div class="course-modify-container">
    <CourseSearchForm />
    <CourseList />
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/course/courseModify.scss";
</style>
