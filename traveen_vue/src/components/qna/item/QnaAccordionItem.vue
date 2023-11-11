<script setup>
import { ref } from "vue";

defineProps({
  qna: Object,
});

const isOpen = ref(false);
const userGrade = ref("M"); // 관리자: M, 회원: G

const toggleAccordion = () => {
  isOpen.value = !isOpen.value;
};
</script>

<template>
  <div class="accordion-header" @click="toggleAccordion">
    <div class="left">Q</div>
    <div class="right">
      <div class="title">{{ qna.title }}</div>
      <div class="content">{{ qna.content }}</div>
    </div>
    <div class="closeBtn-wrap">
      <img src="@/assets/img/icon_close.png" alt="" />
    </div>
  </div>
  <div v-show="isOpen" class="accordion-content">
    <div class="left">A</div>
    <!-- 사용자가 관리자일 때 -->
    <div v-if="userGrade === 'M'" class="right">
      <textarea cols="30" rows="8" placeholder="답변을 입력해주세요."></textarea>
      <div class="btn-wrap">
        <button>등록</button>
        <button>삭제</button>
      </div>
    </div>
    <!-- 사용자가 회원일 때 -->
    <div v-else class="right">
      <div>일반 내용</div>
    </div>
  </div>
</template>

<style scoped>
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

.closeBtn-wrap {
  width: 40px;
  height: 40px;
}

.closeBtn-wrap img {
  width: 100%;
  height: 100%;
}

.accordion-content {
  display: flex;
  padding: 10px;
  background-color: #f9fbfc;
  border-bottom: 1px solid #e3e3e3;
  box-sizing: border-box;
  padding: 30px;
  height: 160px;
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

.accordion-content .right {
  display: flex;
  flex-direction: column;
  width: 100%;
  margin-left: 40px;
}

textarea {
  border: 1px solid #e3e3e3;
  border-radius: 6px;
  resize: none;
  height: 60px;
  box-sizing: border-box;
  padding: 6px;
}

textarea::placeholder {
  color: #d3d3d3;
}

.btn-wrap {
  display: flex;
  justify-content: flex-end;
  margin-top: 10px;
}

.btn-wrap button {
  background-color: #fff;
  border-radius: 4px;
  border: 1px solid #e3e3e3;
  height: 30px;
  color: #000;
  width: 80px;
}

.btn-wrap button:first-child {
  margin-right: 10px;
}
</style>
