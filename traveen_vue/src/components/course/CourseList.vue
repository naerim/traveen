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
.container {
  display: flex;
  flex-direction: column;
  width: 29%;
  background-color: #fff;
  border: 1px solid #e3e3e3;
  border-radius: 6px;
  height: 800px;
}

.course-top {
  display: flex;
  align-items: center;
  background-color: #51cd89;
  color: #fff;
  height: 40px;
  width: 100%;
  box-sizing: border-box;
  padding-left: 20px;
  border-radius: 6px 6px 0 0;
}

ul {
  display: flex;
  flex-direction: column;
  padding: 20px;
  box-sizing: border-box;
  height: 620px;
  overflow-y: scroll;
}

li {
  display: flex;
  background-color: #fff;
  margin-bottom: 20px;
  border: 1px solid #e3e3e3;
  border-radius: 6px;
  box-sizing: border-box;
  padding: 10px;
}

li .num {
  display: flex;
  background-color: #51cd89;
  width: 26px;
  height: 26px;
  line-height: 26px;
  color: #fff;
  border-radius: 6px;
  align-items: center;
  justify-content: center;
  margin-right: 10px;
  font-size: 0.9em;
}

.course-list li {
  cursor: pointer;
  user-select: none;
}

.course-list img {
  pointer-events: none;
}

.imgDiv {
  width: 70px;
  height: 70px;
  margin-right: 10px;
}

.imgDiv img {
  width: 100%;
  height: 100%;
}

#btn-sort-path {
  background-color: #f7f8fa;
  margin: auto 20px 0 20px;
  border: 1px solid #e3e3e3;
  height: 40px;
  border-radius: 6px;
  cursor: pointer;
  color: #6b7684;
  font-weight: bold;
}

#btn-regist-course {
  background-color: #51cd89;
  margin: 20px;
  border: none;
  color: #fff;
  height: 40px;
  border-radius: 6px;
  cursor: pointer;
  font-weight: bold;
}
</style>
