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
article {
  width: 90%;
  max-width: 1400px;
  margin: 0 auto;
  padding-bottom: 100px;
  padding-top: 40px;
}

.title {
  font-size: 2em;
  font-weight: 700;
  text-align: center;
  margin-bottom: 40px;
  white-space: pre-line;
}

.course-regist-container {
  display: flex;
  justify-content: space-between;
}
</style>
