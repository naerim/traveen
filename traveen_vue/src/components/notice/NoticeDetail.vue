<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { detailNotice, deleteNotice } from "@/api/notice";
import NoticeGoListButton from "@/components/notice/item/NoticeGoListButton.vue";

const route = useRoute();
const router = useRouter();

const { idx } = route.params;

const notice = ref({});

onMounted(() => {
  getNotice();
});

const getNotice = () => {
  detailNotice(
    idx,
    ({ data }) => {
      notice.value = data;
    },
    (error) => console.log(error)
  );
};

// 공지사항 수정 페이지로 이동
const goNoticeModify = () => {
  router.push({ name: "notice-modify", params: { idx } });
};

// 공지사항 삭제
const onNoticeDelete = () => {
  deleteNotice(
    idx,
    () => {
      alert("공지사항이 삭제되었습니다.");
      router.push({ name: "notice-list" });
    },
    (error) => console.log(error)
  );
};
</script>

<template>
  <section>
    <div class="table-container">
      <div class="top-box">
        <div class="left">{{ notice.title }}</div>
        <div class="right">
          <div class="date">{{ notice.createDate }}</div>
          <div class="hit">조회수 {{ notice.viewCount }}</div>
        </div>
      </div>
      <div class="content-box">
        <div class="content-title">{{ notice.title }}</div>
        <div class="content">{{ notice.content }}</div>
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
@import "@/assets/scss/components/notice/noticeDetail.scss";
</style>
