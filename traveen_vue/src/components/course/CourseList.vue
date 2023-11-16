<script setup>
import CourseListItem from "@/components/course/item/CourseListItem.vue";
import draggable from "vuedraggable";
import { useCourseStore } from "@/stores/course";

const courseStore = useCourseStore();
const { updateCourseListOrder } = courseStore;

const handleDrag = (e) => {
  const { oldIndex, newIndex } = e;
  updateCourseListOrder(oldIndex, newIndex);
};

const registCourse = () => {
  courseStore.courseList.map((item) => {
    console.log(item.placeName);
  });
};
</script>

<template>
  <div class="container">
    <div class="course-top">나의 여행 코스</div>
    <draggable
      class="course-list"
      v-model="courseStore.courseList"
      tag="ul"
      @update="handleDrag"
      item-key="index"
    >
      <template #item="{ element: course }">
        <CourseListItem :course="course" :index="courseStore.courseList.indexOf(course) + 1" />
      </template>
    </draggable>
    <button id="btn-sort-path">최단경로로 정렬</button>
    <button id="btn-regist-course" @click="registCourse">등록하기</button>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/course/courseList.scss";
</style>
