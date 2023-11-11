<script setup>
import { ref } from "vue";

const sections = [
  { header: "Section 1", content: "Content for Section 1", open: false },
  { header: "Section 2", content: "Content for Section 2", open: false },
];

const toggleAccordion = (index) => {
  this.sections[index].open = !this.sections[index].open;
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
    <div>
      <div v-for="(section, index) in sections" :key="index" class="accordion-section">
        <div class="accordion-header" @click="toggleAccordion(index)">{{ section.header }}</div>
        <div v-show="section.open" class="accordion-content">
          <p>{{ section.content }}</p>
        </div>
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
}

label {
  cursor: pointer;
}

input[type="checkbox"] {
  box-sizing: border-box;
  accent-color: var(--tv-c-green);
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

.accordion-section {
  border: 1px solid #ccc;
  margin-bottom: 5px;
}

.accordion-header {
  cursor: pointer;
  padding: 10px;
  background-color: #f1f1f1;
  text-align: left;
}

.accordion-content {
  display: none;
  padding: 10px;
}
</style>
