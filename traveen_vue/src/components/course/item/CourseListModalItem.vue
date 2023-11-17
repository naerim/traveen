<script setup>
defineProps({
  course: Object,
  index: Number,
});
</script>

<template>
  <li>
    <div class="num">{{ index }}</div>
    <img src="@/assets/img/img_tripinfo.png" alt="" />
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
