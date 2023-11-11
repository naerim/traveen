<script setup>
import { ref } from "vue";
import QnaAccordionItem from "@/components/qna/item/QnaAccordionItem.vue";

const QnaData = [
  {
    idx: 0,
    userIdx: 1,
    title: "트래빈 사용방법",
    content: "트래빈은 어떻게 사용하나요?",
  },
  {
    idx: 1,
    userIdx: 1,
    title: "글을 수정하고 싶습니다.",
    content: "글 수정하는 버튼이 어딨을까요?",
  },
];

const QnaList = ref(QnaData);
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
      <QnaAccordionItem v-for="qna in QnaList" :key="qna.idx" :qna="qna" />
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
</style>
