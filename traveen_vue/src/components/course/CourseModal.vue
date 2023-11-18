<script setup>
import { ref, computed } from "vue";
import { useCourseStore } from "@/stores/course";
import { useMemberStore } from "@/stores/member";
import CourseListModalItem from "@/components/course/item/CourseListModalItem.vue";
import { registCourse } from "@/api/course";

const courseStore = useCourseStore();
const memberStore = useMemberStore();

const userInfo = computed(() => memberStore.userInfo);

const param = ref({
  course: {
    title: "",
    userIdx: userInfo.value.idx,
    startDate: "",
    endDate: "",
    flag: 0,
  },
  courseList: [],
});

const props = defineProps({
  show: Boolean,
  type: String,
});

const emit = defineEmits(["closeModal"]);
const onClickCloseModal = () => {
  emit("closeModal");
};

const makeParamCourseList = (list) => {
  let paramList = [];
  list.forEach((item, index) => {
    const courseItem = {
      courseIdx: "",
      tripinfoIdx: item.idx,
      order: index + 1,
    };
    paramList.push(courseItem);
  });
  return paramList;
};

const onRegistCourse = (list) => {
  if (param.value.course.title === "") {
    alert("제목을 입력해주세요.");
  } else if (param.value.course.startDate === "") {
    alert("여행 시작일을 선택해주세요.");
  } else {
    param.value.course.endDate = param.value.course.startDate;
    param.value.courseList = makeParamCourseList(list);
    registCourse(
      param.value,
      (res) => {
        console.log(res);
      },
      (error) => console.log(error)
    );
  }
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
          v-model="param.course.title"
        />
        <div class="date-wrap">
          <div class="date-item">
            <div>여행 시작일</div>
            <input type="date" v-model="param.course.startDate" />
          </div>
          <div class="date-item">
            <div>여행 종료일</div>
            <input type="text" readonly v-model="param.course.startDate" />
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
          <button @click="onRegistCourse(courseStore.courseList)">코스 등록</button>
          <button>닫기</button>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/course/courseModal.scss";
</style>
