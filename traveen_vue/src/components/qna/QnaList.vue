<script setup>
import { ref, onMounted, watch, computed } from "vue";
import QnaAccordionItem from "@/components/qna/item/QnaAccordionItem.vue";
import QnaWriteModal from "@/components/qna/QnaWriteModal.vue";
import VEmptyItem from "@/components/common/VEmptyItem.vue";
import { registQna, listQna, listQnaComment } from "@/api/qna";

import { useMemberStore } from "@/stores/member";

const memberStore = useMemberStore();
const userInfo = computed(() => memberStore.userInfo);

const qna = ref({
  idx: 0,
  userIdx: 1,
  title: "",
  content: "",
});

const QnaList = ref([]);
const QnaCommentList = ref([]);
const isModalOpen = ref(false);
const len = ref(0);

onMounted(() => {
  getQnaList();
  getQnaCommentList();
  len.value = QnaList.value.length;
});

const getQnaList = () => {
  // API 호출
  listQna(
    {},
    ({ data }) => {
      QnaList.value = data;
    },
    (error) => console.log(error)
  );
};

const getQnaCommentList = () => {
  // API 호출
  listQnaComment(
    {},
    ({ data }) => {
      QnaCommentList.value = data;
    },
    (error) => console.log(error)
  );
};

// 모달창 열기
const openModal = (e) => {
  e.preventDefault();
  isModalOpen.value = true;
};

// 모달창 닫기
const closeModal = () => {
  isModalOpen.value = false;
};

// Qna 등록하기
const writeQna = () => {
  registQna(
    qna.value,
    () => {
      QnaList.value.push(qna);
      qna.value.title = "";
      qna.value.content = "";
      alert("질문이 등록되었습니다.");
      closeModal();
    },
    (error) => console.log(error)
  );
};

// qna가 추가될때마다 qna 리스트 갱신
watch(qna.value, () => {
  getQnaList();
});

// qna 갯수 세기
watch(QnaList, (newValue) => {
  len.value = newValue.length;
});
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
        <button type="button" @click="openModal">글쓰기</button>
      </form>
    </div>
    <div class="line"></div>
    <!-- qna list -->
    <div v-if="len !== 0">
      <QnaAccordionItem v-for="qna in QnaList" :key="qna.idx" :qna="qna" />
    </div>
    <div v-else>
      <VEmptyItem text="데이터가 존재하지 않습니다." />
    </div>
    <!-- qna 생성 modal창 -->
    <QnaWriteModal :show="isModalOpen" @close="closeModal">
      <div class="modal-container">
        <div class="modal-top">
          <div>QnA 등록</div>
          <img src="@/assets/img/icon_close.png" alt="" @click="closeModal" />
        </div>
        <div class="line"></div>
        <div class="modal-content">
          <div class="qna-modal-title">제목</div>
          <input
            type="text"
            class="input-qna"
            placeholder="제목을 입력해주세요."
            v-model="qna.title"
          />
          <div class="qna-modal-title">내용</div>
          <textarea
            id="qna-content"
            cols="30"
            rows="10"
            placeholder="내용을 입력해주세요."
            v-model="qna.content"
          ></textarea>
        </div>
        <button @click="writeQna">글쓰기</button>
      </div>
    </QnaWriteModal>
  </section>
</template>

<style scoped>
@import "@/assets/scss/components/qna/qnaList.scss";
</style>
