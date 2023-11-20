<script setup>
import { ref, onMounted, watch } from "vue";
import { useRouter } from "vue-router";
import { listNotice } from "@/api/notice";
import NoticeListItem from "@/components/notice/item/NoticeListItem.vue";
import PageNavigation from "@/components/common/PageNavigation.vue";
import VEmpimport { storeToRefs } from "pinia";tyItem from "@/components/common/VEmptyItem.vue";

import { useMemberStore } from "@/stores/member";

const memberStore = useMemberStore();
const { userInfo } = storeToRefs(memberStore);

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
      notices.value = data.notices;
      currentPage.value = data.currentPage;
      totalPage.value = data.totalPageCount;
    },
    (error) => console.log(error)
  );
};

const onPageChange = (val) => {
  currentPage.value = val;
  param.value.pgno = val;
  getNoticeList();
};

const searchNotice = () => {
  param.value.pgno = 1;
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
        <input type="submit" id="btn-search" value="검색" @click="searchNotice"/>
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
        <tbody v-if="len !== 0">
          <NoticeListItem
            v-for="(notice, index) in notices"
            :key="notice.idx"
            :notice="notice"
            :index="len - index"
          />
        </tbody>
        <tbody v-else>
          <td colspan="4">
            <VEmptyItem text="데이터가 존재하지 않습니다." />
          </td>
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
@import "@/assets/scss/components/notice/noticeList.scss";
</style>
