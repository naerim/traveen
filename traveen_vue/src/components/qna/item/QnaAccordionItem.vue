<script setup>
import { ref, onMounted, computed } from "vue";
import {
  registQnaComment,
  viewQnaComment,
  deleteQnaComment,
  modifyQnaComment,
  deleteQna,
} from "@/api/qna";
import { useMemberStore } from "@/stores/member";

const memberStore = useMemberStore();
const userInfo = computed(() => memberStore.userInfo);

const qnaIdx = computed(() => props.qna.idx);
const currentComment = ref("");

const props = defineProps({
  qna: Object,
});

const isOpen = ref(false);

const qnaComment = ref({
  idx: 0,
  userIdx: userInfo.value.idx,
  qnaIdx: qnaIdx,
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
  console.log("등록할 답변 : " + qnaComment.value);
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
    qnaIdx.value,
    ({ data }) => {
      if (data) {
        qnaComment.value = data;
        currentComment.value = data;
      }
    },
    (error) => console.log(error)
  );
};

// QnA 질문 삭제
const onDeleteQna = () => {
  const flag = confirm("정말로 삭제하시겠습니끼?");
  if (flag) {
    deleteQna(
      qnaIdx.value,
      () => {
        alert("QnA가 삭제되었습니다.");
        location.reload();
      },
      (error) => console.log(error)
    );
  }
};

// QnA Comment 삭제하기
const onDeleteQnaComment = () => {
  deleteQnaComment(
    qnaComment.value.idx,
    () => {
      alert("QnA 답변이 삭제되었습니다.");
      qnaComment.value.comment = "";
      location.reload();
      getQnaComment();
    },
    (error) => console.log(error)
  );
};

// QnA Comment 수정하기
const onModifyQnaComment = () => {
  console.log(qnaComment.value);
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
    <div class="closeBtn-wrap" @click="onDeleteQna" v-show="qna.userIdx === userInfo.idx">
      <img src="@/assets/img/icon_close.png" alt="" />
    </div>
  </div>
  <div v-show="isOpen" class="accordion-content">
    <div class="left">A</div>
    <!-- 사용자가 관리자일 때 -->
    <div v-if="userInfo.userId === 'admin'" class="right">
      <textarea
        cols="30"
        rows="8"
        placeholder="답변을 입력해주세요."
        v-model="qnaComment.content"
      ></textarea>

      <div v-if="currentComment != ''" class="btn-wrap">
        <button @click="onModifyQnaComment">수정</button>
        <button @click="onDeleteQnaComment">삭제</button>
      </div>
      <div v-else class="btn-wrap">
        <button @click="writeQnaComment">등록</button>
      </div>
    </div>
    <!-- 사용자가 회원일 때 -->
    <div v-else class="right">
      <div v-if="qnaComment.content == null || qnaComment.content == ''" class="title">
        답변이 아직 등록되지 않은 질문입니다.
      </div>
      <div v-else class="content">
        {{ qnaComment.content }}
      </div>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/qna/item/qnaAccordionItem.scss";
</style>
