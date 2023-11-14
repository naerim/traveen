<script setup>
import { ref, onMounted } from "vue";
import { registQnaComment, viewQnaComment, deleteQnaComment, modifyQnaComment } from "@/api/qna";

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

let content = "";

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
      console.log(data);
      qnaComment.value.content = data.content;
      content = data.content;
      console.log(data.content);
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
      content = "";
    },
    (error) => console.log(error)
  );
};

// QnA Comment 수정하기
const onModifyQnaComment = () => {
  modifyQnaComment(
    qnaComment.value,
    () => {
      alert("QnA 답변이 수정되었습니다.");
    },
    (error) => console.log(error)
  );
};
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
      <div v-if="content == null" class="btn-wrap">
        <button @click="writeQnaComment">등록</button>
      </div>
      <div v-else class="btn-wrap">
        <button @click="onModifyQnaComment">수정</button>
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
@import "@/assets/scss/components/qna/item/qnaAccordionItem.scss";
</style>
