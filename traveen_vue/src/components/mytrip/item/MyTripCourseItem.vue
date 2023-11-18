<script setup>
import { ref } from "vue";

const props = defineProps({
  course: Object,
});

const show = ref(null);

const toggleMenu = () => (show.value = !show.value);
</script>

<template>
  <div class="item-container">
    <img src="@/assets/img/icon_vertical_menu.png" alt="" id="menu-icon" @click="toggleMenu" />
    <div class="top">코스 이름</div>
    <div class="courseName">{{ props.course.title }}</div>
    <div class="date">{{ props.course.startDate }} ~ {{ props.course.endDate }}</div>
    <img
      v-if="props.course.flag === 1"
      src="@/assets/img/icon_course_done.png"
      alt=""
      id="course-done"
    />
    <div v-if="show" id="menu">
      <ul>
        <li v-if="props.course.flag === 0">여행 후기 작성</li>
        <li v-else class="done">작성 완료</li>
        <li v-if="props.course.flag === 0">수정하기</li>
        <li v-else>이 여행 또가기</li>
        <li>삭제</li>
      </ul>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/mytrip/item/myTripCourseItem.scss";
</style>
