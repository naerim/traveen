<script setup>
import noImage from "@/assets/img/no_image.jpeg";
defineProps({
  course: Object,
  index: Number,
  imageSrc: String,
});
</script>

<template>
  <li>
    <div class="num">{{ index }}</div>
    <img :src="course.image ? course.image : noImage" alt="" />
    <div class="content">
      <div class="top-box">
        <span>{{ course.type }}</span>
        <span :id="course.categoryName">{{ course.categoryName }}</span>
      </div>
      <div class="name">{{ course.placeName }}</div>
      <div class="address">{{ course.address }}</div>
    </div>
  </li>
</template>

<style scoped>
@import "@/assets/scss/components/course/item/courseListModalItem.scss";
</style>
