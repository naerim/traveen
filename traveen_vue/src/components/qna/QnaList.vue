<script setup>
import { ref, onMounted, watch } from "vue";
import QnaAccordionItem from "@/components/qna/item/QnaAccordionItem.vue";
import QnaModal from "./item/QnaModal.vue";
import { registQna, listQna, listQnaComment } from "@/api/qna";

const qna = ref({
  idx: 0,
  userIdx: 1,
  title: "",
  content: "",
});

const QnaList = ref([]);
const QnaCommentList = ref([]);
const isModalOpen = ref(false);

onMounted(() => {
  getQnaList();
  getQnaCommentList();
});

const getQnaList = () => {
  console.log("서버에서 Qna 목록 얻어오자");
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
  console.log("서버에서 Qna 댓글 목록 얻어오자");
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
    <div>
      <QnaAccordionItem v-for="qna in QnaList" :key="qna.idx" :qna="qna" />
    </div>
    <!-- qna 생성 modal창 -->
    <QnaModal :show="isModalOpen" @close="closeModal">
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
    </QnaModal>
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
  margin-top: 10px;
  height: 1px;
  background-color: #e3e3e3;
}

.modal-container {
  display: flex;
  flex-direction: column;
}

.modal-top {
  display: flex;
  align-items: center;
  justify-content: space-between;
  font-weight: bold;
}

.modal-top img {
  width: 30px;
  height: 30px;
  cursor: pointer;
}

.qna-modal-title {
  margin-top: 10px;
}

.input-qna {
  width: 100%;
  border: 1px solid #e3e3e3;
  border-radius: 6px;
  box-sizing: border-box;
  height: 40px;
  padding: 6px;
}

.input-qna::placeholder {
  color: #d3d3d3;
}

#qna-content {
  resize: none;
  height: 60px;
  width: 100%;
  border: 1px solid #e3e3e3;
  border-radius: 6px;
  box-sizing: border-box;
  padding: 6px;
}
#qna-content::placeholder {
  color: #d3d3d3;
}

.modal-container button {
  background-color: var(--tv-c-green);
  border: none;
  color: #fff;
  width: 80px;
  border-radius: 6px;
  height: 30px;
  margin-top: 20px;
  margin-left: auto;
  cursor: pointer;
}
</style>
