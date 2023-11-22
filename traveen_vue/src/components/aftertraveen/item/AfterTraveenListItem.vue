<script setup>
import { useRouter } from "vue-router";
import noImage from "@/assets/img/no_image.jpeg";

const router = useRouter();

const props = defineProps({
  post: Object,
});

const goAfterTraveenDetailPage = () =>
  router.push({ name: "aftertraveen-detail", params: { idx: props.post.idx } });
</script>

<template>
  <div class="item-box" @click="goAfterTraveenDetailPage">
    <div class="course-img">
      <img :src="props.post.image || noImage" alt="" />
    </div>
    <div class="item-content">
      <div class="content-top">
        <div class="course-title">{{ props.post.title }}</div>
        <div class="course-view-count">조회수 {{ props.post.viewCount }}</div>
      </div>
      <p class="course-content">
        {{ props.post.content }}
      </p>
      <div class="course-date">{{ props.post.startDate }} ~ {{ props.post.endDate }}</div>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/aftertraveen/item/afterTraveenListItem.scss";
</style>
