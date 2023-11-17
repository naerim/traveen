<script setup>
import { ref } from "vue";
import { useCourseStore } from "@/stores/course";
import CourseListModalItem from "@/components/course/item/CourseListModalItem.vue";

const courseStore = useCourseStore();

const course = ref({
  title: "",
  startDate: "",
  endDate: "",
});

const props = defineProps({
  show: Boolean,
  type: String,
});

const emit = defineEmits(["closeModal"]);
const onClickCloseModal = () => {
  emit("closeModal");
};
</script>

<template>
  <div class="modalContainer" v-if="show">
    <div class="modalBody" @click.stop>
      <img
        src="@/assets/img/icon_close.png"
        alt=""
        class="btn-close-modal"
        @click="onClickCloseModal"
      />
      <div class="course-modal-container">
        <h1>나의 여행 코스</h1>
        <label>제목</label>
        <input
          type="text"
          placeholder="여행 코스 제목을 입력해주세요."
          id="course-title"
          v-model="course.title"
        />
        <div class="date-wrap">
          <div class="date-item">
            <div>여행 시작일</div>
            <input type="date" v-model="course.startDate" />
          </div>
          <div class="date-item">
            <div>여행 종료일</div>
            <input type="text" readonly v-model="course.startDate" />
          </div>
        </div>
        <ul class="course-list-wrap">
          <CourseListModalItem
            v-for="(course, index) in courseStore.courseList"
            :key="course.idx"
            :index="index + 1"
            :course="course"
          />
        </ul>
        <div class="btn-wrap">
          <button>코스 등록</button>
          <button>닫기</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/course/courseModal.scss";
</style>
