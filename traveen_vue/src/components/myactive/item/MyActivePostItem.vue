<script setup>
import { useRouter } from "vue-router";
import { useCourseStore } from "@/stores/course";
import { listCourseItem } from "@/api/course";

const router = useRouter();

const props = defineProps({
  post: Object,
});

const courseStore = useCourseStore();
const { setCourseList } = courseStore;

const goAfterTraveenDetailPage = () => {
  getListCourseitem(props.post.courseIdx);
  router.push({ name: "aftertraveen-detail", params: { idx: props.post.idx } });
};

// 미리 store의 courseList에 등록해주기
const getListCourseitem = (idx) => {
  listCourseItem(
    idx,
    ({ data }) => {
      setCourseList(data.list);
    },
    (err) => console.log(err)
  );
};
</script>

<template>
  <li @click="goAfterTraveenDetailPage">
    <span class="title">{{ props.post.title }}</span>
    <div class="right">
      <span class="date">{{ props.post.createDate }}</span>
      <img src="@/assets/img/icon_view.png" alt="" class="view" />
      <span class="view-count">{{ props.post.viewCount }}</span>
    </div>
  </li>
</template>

<style scoped>
@import "@/assets/scss/components/myactive/item/myActivePostItem.scss";
</style>
