<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { listCourseItem, deleteCourse } from "@/api/course";
import { useCourseStore } from "@/stores/course";
import { useMyTripStore } from "@/stores/mytrip";

const props = defineProps({
  course: Object,
});

const router = useRouter();
const show = ref(false);
const toggleMenu = () => (show.value = !show.value);

const courseStore = useCourseStore();
const { setCourseList, setCourse } = courseStore;

const myTripStore = useMyTripStore();
const { deleteMycourse } = myTripStore;

// 코스 수정 페이지로 이동
const goCourseModifyPage = async () => {
  // 코스 아이템 불러오기
  await listCourseItem(
    props.course.idx,
    ({ data }) => {
      setCourse({
        idx: data.courseIdx,
        title: data.courseTitle,
        startDate: data.startDate,
        endDate: data.endDate,
      });
      setCourseList(data.list);
    },
    (err) => console.log(err)
  );
  await router.push({ name: "course-modify", params: { idx: props.course.idx } });
};

const onDeleteCourse = (idx) => {
  const flag = confirm("정말로 삭제하시겠습니까?");
  if (flag) {
    deleteCourse(
      idx,
      () => {
        deleteMycourse(idx);
        alert("삭제되었습니다.");
      },
      (err) => console.log(err)
    );
  }
  show.value = false;
};

const goAftertraveenWritePage = () => router.push({ name: "aftertraveen-write" });
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
        <li v-if="props.course.flag === 0" @click="goAftertraveenWritePage">여행 후기 작성</li>
        <li v-else class="done">작성 완료</li>
        <li v-if="props.course.flag === 0" @click="goCourseModifyPage">수정하기</li>
        <li v-else>이 여행 또가기</li>
        <li @click="onDeleteCourse(props.course.idx)">삭제</li>
      </ul>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/mytrip/item/myTripCourseItem.scss";
</style>
