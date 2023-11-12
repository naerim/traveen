<script setup>
import { ref, onMounted, watch } from "vue";
import { useRouter } from "vue-router";
import { listNotice } from "@/api/notice";
import NoticeListItem from "@/components/notice/item/NoticeListItem.vue";
import PageNavigation from "@/components/common/PageNavigation.vue";

const router = useRouter();

const notices = ref([]);
const len = ref(0);
const currentPage = ref(1);
const totalPage = ref(0);
const { VITE_NOTICE_LIST_SIZE } = import.meta.env;

const goNoticeWrite = (e) => {
  e.preventDefault();
  router.push({ name: "notice-write" });
};

const param = ref({
  pgno: currentPage.value,
  spp: VITE_NOTICE_LIST_SIZE,
  key: "",
  word: "",
});

onMounted(() => {
  getNoticeList();
  len.value = notices.value.length;
});

const getNoticeList = () => {
  console.log("서버에서 공지사항 목록 얻어오자");
  // API 호출
  listNotice(
    param.value,
    ({ data }) => {
      console.log(data);
      notices.value = data.notices;
      currentPage.value = data.currentPage;
      totalPage.value = data.totalPageCount;
    },
    (error) => console.log(error)
  );
};

const onPageChange = (val) => {
  console.log(val + "번 페이지로 이동 준비 끝!!!");
  currentPage.value = val;
  param.value.pgno = val;
  getNoticeList();
};

// 공지사항 글 갯수 세기
watch(notices, (newValue) => {
  len.value = newValue.length;
});
</script>

<template>
  <!-- section -->
  <section>
    <!-- top-box -->
    <div class="top-box">
      <div class="left">총 {{ len }}건</div>
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
    <div class="table-container">
      <!-- table -->
      <table>
        <!-- thead -->
        <thead>
          <tr>
            <th width="8%">NO.</th>
            <th width="67%">제목</th>
            <th width="15%">게시일</th>
            <th width="10%">조회수</th>
          </tr>
        </thead>
        <!-- tbody -->
        <tbody>
          <NoticeListItem
            v-for="(notice, index) in notices"
            :key="notice.idx"
            :notice="notice"
            :index="len - index"
          />
        </tbody>
      </table>
    </div>
    <!-- pagination -->
    <PageNavigation
      :current-page="currentPage"
      :total-page="totalPage"
      @pageChange="onPageChange"
    ></PageNavigation>
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

table {
  width: 100%;
  border-spacing: 0;
  table-layout: fixed;
  border-collapse: collapse;
}

thead {
  background-color: #f9fbfc;
}

tr {
  height: 58px;
  border-radius: 6px;
  align-items: center;
  text-align: center;
}

thead th:first-child,
th:last-child {
  border-radius: 6px 0 0 6px;
}

thead th:last-child {
  border-radius: 0 6px 6px 0;
}

tbody tr {
  border-bottom: 1px solid #e3e3e3;
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
</style>
