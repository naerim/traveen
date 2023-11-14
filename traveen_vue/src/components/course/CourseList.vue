<script setup></script>

<template>
  <div class="container">
    <div class="course-top">나의 여행 코스</div>
    <ul class="course-list">
      <li draggable="true">
        <div class="num">1</div>
        <div class="imgDiv">
          <img src="@/assets/img/img_tripinfo.png" alt="" />
        </div>
        <div>안녕1</div>
      </li>
      <li draggable="true">
        <div class="num">2</div>
        <div class="imgDiv">
          <img src="@/assets/img/img_tripinfo.png" alt="" />
        </div>
        <div>안녕2</div>
      </li>
      <li draggable="true">
        <div class="num">3</div>
        <div class="imgDiv">
          <img src="@/assets/img/img_tripinfo.png" alt="" />
        </div>
        <div>안녕3</div>
      </li>
      <li draggable="true">
        <div class="num">4</div>
        <div class="imgDiv">
          <img src="@/assets/img/img_tripinfo.png" alt="" />
        </div>
        <div>안녕4</div>
      </li>
    </ul>
    <button id="btn-sort-path">최단경로로 정렬</button>
    <button id="btn-regist-course">등록하기</button>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/course/courseList.scss";
</style>
