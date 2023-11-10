<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import NoticeGoListButton from "@/components/notice/item/NoticeGoListButton.vue";

const route = useRoute();
const router = useRouter();

const { idx } = route.params;

const notice = ref({});

onMounted(() => {
  getNotice();
});

const getNotice = () => {
  console.log(idx + "번째 글");
};

// 공지사항 수정 페이지로 이동
const goNoticeModify = () => {
  router.push({ name: "notice-modify", params: { idx } });
};

// 공지사항 삭제
const onNoticeDelete = () => {
  console.log(idx + "번째 글 삭제하자");
};
</script>

<template>
  <section>
    <div class="table-container">
      <div class="top-box">
        <div class="left">공지사항 제목</div>
        <div class="right">
          <div class="date">2023.11.10</div>
          <div class="hit">조회수 1</div>
        </div>
      </div>
      <div class="content-box">
        <div class="content-title">공지사항 제목</div>
        <div class="content">공지사항 내용</div>
      </div>
      <div class="line"></div>
      <div class="btn-notice-admin-box">
        <button id="btn-modify" @click="goNoticeModify">수정</button>
        <button id="btn-delete" @click="onNoticeDelete">삭제</button>
      </div>
    </div>
    <NoticeGoListButton />
  </section>
</template>

<style scoped>
section {
  width: 80%;
  max-width: 1000px;
  margin: 0 auto;
  padding-bottom: 100px;
}

.table-container {
  display: flex;
  flex-direction: column;
  border: 1px solid #e3e3e3;
  box-sizing: border-box;
  width: 100%;
  height: 720px;
  padding: 34px;
  min-width: 1000px;
  border-radius: 6px;
}

.top-box {
  display: flex;
  justify-content: space-between;
  align-items: center;
  box-sizing: border-box;
  background-color: #f9fbfc;
  height: 100px;
  padding: 0 20px;
  border-radius: 6px;
}

.left {
  font-size: 1.2em;
}

.date {
  margin-right: 18px;
}

.right {
  display: flex;
}

.content-box {
  padding: 20px;
  box-sizing: border-box;
  margin-top: 20px;
}

.content-title {
  font-weight: bold;
  margin-bottom: 10px;
}

.content {
  display: flex;
  white-space: pre-wrap;
}

.btn-notice-admin-box {
  display: flex;
  padding: 20px 0;
  justify-content: flex-end;
}

.btn-notice-admin-box button {
  background-color: #fff;
  border: 1px solid #e3e3e3;
  height: 30px;
  width: 80px;
  cursor: pointer;
}

.btn-notice-admin-box button:first-child {
  margin-right: 10px;
}

.line {
  display: flex;
  align-items: flex-end;
  margin-top: auto;
  height: 1px;
  background-color: #e3e3e3;
}
</style>
