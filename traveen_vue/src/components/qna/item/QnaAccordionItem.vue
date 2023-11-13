<script setup>
import { ref, onMounted } from "vue";
import { registQnaComment, viewQnaComment, deleteQnaComment } from "@/api/qna";

const props = defineProps({
  qna: Object,
});

const isOpen = ref(false);
const userGrade = ref("M"); // 관리자: M, 회원: G

const qnaComment = ref({
  idx: 0,
  userIdx: 1,
  qnaIdx: props.qna.idx,
  content: "",
});

onMounted(() => {
  getQnaComment();
});

const toggleAccordion = () => {
  isOpen.value = !isOpen.value;
};

// QnA Comment 등록하기
const writeQnaComment = () => {
  registQnaComment(
    qnaComment.value,
    () => {
      alert("QnA 답변이 등록되었습니다.");
    },
    (error) => console.log(error)
  );
};
const getQnaComment = () => {
  viewQnaComment(
    props.qna.idx,
    ({ data }) => {
      qnaComment.value.content = data.content;
    },
    (error) => console.log(error)
  );
};
// QnA Comment 삭제하기
const onDeleteQnaComment = () => {
  deleteQnaComment(
    props.qna.idx,
    () => {
      console.log("qna.idx : " + props.qna.idx);
      alert("QnA 답변이 삭제되었습니다.");
    },
    (error) => console.log(error)
  );
};

// watch(qnaComment.value, () => {
//   getQnaComment();
// });
</script>

<template>
  <div class="accordion-header" @click="toggleAccordion">
    <div class="left">Q</div>
    <div class="right">
      <div class="title">{{ props.qna.title }}</div>
      <div class="content">{{ props.qna.content }}</div>
    </div>
    <div class="closeBtn-wrap">
      <img src="@/assets/img/icon_close.png" alt="" />
    </div>
  </div>
  <div v-show="isOpen" class="accordion-content">
    <div class="left">A</div>
    <!-- 사용자가 관리자일 때 -->
    <div v-if="userGrade === 'M'" class="right">
      <textarea
        cols="30"
        rows="8"
        placeholder="답변을 입력해주세요."
        v-model="qnaComment.content"
      ></textarea>
      <div class="btn-wrap">
        <button @click="writeQnaComment">등록</button>
        <button @click="onDeleteQnaComment">삭제</button>
      </div>
    </div>
    <!-- 사용자가 회원일 때 -->
    <div v-else class="right">
      <div v-if="qnaComment.content != null" class="content">{{ qnaComment.content }}</div>
      <div v-else class="title">답변이 아직 등록되지 않은 질문입니다.</div>
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
  cursor: pointer;
}

.btn-wrap button:first-child {
  margin-right: 10px;
}
</style>
