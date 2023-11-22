<script setup>
import { ref, onMounted, watch, computed } from "vue";
import { storeToRefs } from "pinia";
import AfterTraveenLeftForm from "@/components/aftertraveen/item/AfterTraveenLeftForm.vue";
import AfterTraveenRightForm from "@/components/aftertraveen/item/AfterTraveenRightForm.vue";
import { useCourseStore } from "@/stores/course";
import { useMemberStore } from "@/stores/member";
import { registPost } from "@/api/post";

const courseStore = useCourseStore();
const { currentCourse, courseList } = storeToRefs(courseStore);

const memberStore = useMemberStore();
const userInfo = computed(() => memberStore.userInfo);

const postParam = ref({
  post: {
    title: "테스트글1",
    userIdx: userInfo.value.idx,
    courseIdx: currentCourse.value.idx,
    content: "테스트내용1",
  },
  list: courseList,
});

const writePost = () => {
  if (postParam.value.post.title === "") {
    alert("제목을 입력해주세요.");
  } else if (postParam.value.post.content === "") {
    alert("여행 후기 요약을 입력해주세요.");
  } else {
    console.log("선택");
    registPost(
      postParam.value,
      () => {
        router.push({ name: "aftertraveen-list" });
      },
      (error) => console.log(error)
    );
  }
  // courseList.value.map((item) => console.log(JSON.stringify(item)));
};
</script>

<template>
  <article>
    <h2>여행 후기 작성</h2>
    <h5>나의 여행 코스가 마음에 들었다면 후기를 통해 다른 사람들에게 공유해볼까요?</h5>
    <div class="container">
      <AfterTraveenLeftForm />
      <AfterTraveenRightForm />
    </div>
    <div class="btn-container">
      <button>취소</button>
      <button @click="writePost">작성하기</button>
    </div>
  </article>
</template>

<style scoped>
@import "@/assets/scss/components/aftertraveen/afterTraveenWrite.scss";
</style>
