<script setup>
import { ref } from "vue";

const isOpen = ref(false);

const toggleAccordion = () => {
  isOpen.value = !isOpen.value;
};
</script>

<template>
  <section>
    <div class="top-box">
      <div class="left">
        <label><input type="checkbox" />내가 쓴 글</label>
      </div>
      <form class="right" id="form-search" action="#" method="post">
        <select name="select-notice" id="select-notice">
          <option value="">전체</option>
          <option value="subject">제목</option>
        </select>
        <input type="text" name="keyword" id="keyword" placeholder="검색어를 입력해주세요." />
        <input type="submit" id="btn-search" value="검색" />
        <button id="btn-insert" @click="goNoticeWrite">글쓰기</button>
      </form>
    </div>
    <div class="line"></div>
    <div>
      <div class="accordion-header" @click="toggleAccordion">
        <div class="left">Q</div>
        <div class="right">
          <div class="title">사용방법?</div>
          <div class="content">트래빈 사용방법이 궁금합니다.</div>
        </div>
      </div>
      <div v-show="isOpen" class="accordion-content">
        <div class="left">A</div>
      </div>
    </div>
  </section>
</template>

<style scoped>
section {
  width: 80%;
  max-width: 1000px;
  margin: 0 auto;
  padding-bottom: 100px;
  min-height: 40vh;
}

label {
  cursor: pointer;
}

input[type="checkbox"] {
  box-sizing: border-box;
  accent-color: var(--tv-c-green);
  margin-right: 8px;
}

.top-box {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  min-width: 1000px;
  margin-bottom: 10px;
}

.right select {
  height: 34px;
  border: 1px solid #e3e3e3;
  border-radius: 6px;
  width: 80px;
  box-sizing: border-box;
  padding: 4px;
}

.right input {
  box-sizing: border-box;
  height: 34px;
  border: none;
  border-bottom: 1px solid #e3e3e3;
  padding: 4px;
  padding-right: 10px;
  margin: 0 10px;
}

.right button,
input[type="submit"] {
  height: 34px;
  background-color: #51cd89;
  border-radius: 6px;
  color: #fff;
  border: none;
  cursor: pointer;
  padding: 0 16px;
}

.right button:last-child {
  margin-left: 10px;
}

.line {
  display: flex;
  align-items: flex-end;
  margin-top: 20px;
  height: 1px;
  background-color: #e3e3e3;
}
.accordion-header {
  display: flex;
  align-items: center;
  cursor: pointer;
  padding: 10px;
  background-color: #fff;
  border-top: 1px solid #e3e3e3;
  border-bottom: 1px solid #e3e3e3;
  box-sizing: border-box;
  padding: 30px;
}

.accordion-header .left {
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: var(--tv-c-green);
  color: #fff;
  width: 40px;
  height: 40px;
  border-radius: 6px;
}

.accordion-header .right {
  /* display: flex;
  flex-direction: column; */
  width: 100%;
  margin-left: 40px;
}

.accordion-header .right .title {
  font-size: 0.9em;
  color: #6b7684;
}

.accordion-content {
  display: flex;
  padding: 10px;
  background-color: #f9fbfc;
  border-bottom: 1px solid #e3e3e3;
  box-sizing: border-box;
  padding: 30px;
  height: 140px;
}

.accordion-content .left {
  display: flex;
  align-items: center;
  justify-content: center;
  background-color: #000;
  color: #fff;
  width: 40px;
  height: 40px;
  border-radius: 6px;
}
</style>
