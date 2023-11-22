<script setup>
import { ref } from "vue";
import CourseListItem from "@/components/course/item/CourseListItem.vue";
import { VueDraggableNext } from "vue-draggable-next";
import { useCourseStore } from "@/stores/course";
import CourseModal from "@/components/course/CourseModal.vue";

const show = ref(false);

const props = defineProps({
  type: String,
});

const courseStore = useCourseStore();
const { updateCourseListOrder } = courseStore;

const handleDrag = (e) => {
  const { oldIndex, newIndex } = e;
  updateCourseListOrder(oldIndex, newIndex);
};

const openModal = () => {
  show.value = true;
};

// 모달창 닫기
const closeModal = () => {
  show.value = false;
};
</script>

<template>
  <div class="container">
    <div class="course-top">나의 여행 코스</div>
    <VueDraggableNext v-model="courseStore.courseList" @change="handleDrag">
      <ul>
        <CourseListItem
          :course="course"
          v-for="(course, index) in courseStore.courseList"
          :key="index"
          :index="courseStore.courseList.indexOf(course) + 1"
        />
      </ul>
    </VueDraggableNext>
    <!-- <button id="btn-sort-path">최단경로로 정렬</button> -->
    <button v-if="props.type === 'write'" id="btn-regist-course" @click="openModal">
      등록하기
    </button>
    <button v-else id="btn-regist-course" @click="openModal">수정하기</button>
  </div>
  <CourseModal :show="show" @close-modal="closeModal" :type="props.type" />
</template>

<style scoped>
@import "@/assets/scss/components/course/courseList.scss";
</style>
