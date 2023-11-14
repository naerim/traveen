<script setup>
import CourseSearchForm from "../components/course/CourseSearchForm.vue";
import CourseList from "../components/course/CourseList.vue";
</script>

<template>
  <article>
    <h1 class="title">나만의 여행코스를<br />만들어보세요.</h1>
    <div class="course-regist-container">
      <CourseSearchForm />
      <CourseList />
    </div>
  </article>
</template>

<style scoped>
@import "@/assets/scss/views/courseView.scss";
</style>
