<script setup>
import { ref, onMounted, watch } from "vue";
import AfterTraveenListItem from "@/components/aftertraveen/item/AfterTraveenListItem.vue";
import PageNavigation from "@/components/common/PageNavigation.vue";
import VEmptyItem from "@/components/common/VEmptyItem.vue";
import { listPost } from "@/api/post";

const currentPage = ref(1);
const totalPage = ref(0);
const { VITE_AFTERTRAVEEN_LIST_SIZE } = import.meta.env;

const param = ref({
  pgno: currentPage.value,
  spp: VITE_AFTERTRAVEEN_LIST_SIZE,
  key: "",
  word: "",
  userIdx: "",
});

const len = ref(0);
const posts = ref([]);

onMounted(() => {
  // 여행 후기 글 불러오기
  getPostList();
  len.value = posts.value.length;
});

const onPageChange = (val) => {
  currentPage.value = val;
  param.value.pgno = val;
  getPostList();
};

const getPostList = () => {
  listPost(
    param.value,
    ({ data }) => {
      posts.value = data.posts;
      currentPage.value = data.currentPage;
      totalPage.value = data.totalPageCount;
      len.value = posts.value.length;
    },
    (error) => console.log(error)
  );
};

const searchPost = () => {
  param.value.pgno = 1;
  getPostList();
};

// 글 갯수 세기
watch(posts, (newValue) => {
  len.value = newValue.length;
});
</script>

<template>
  <article>
    <h1 class="title">애프터 트래빈</h1>
    <div class="subtitle">
      나의 여행 코스가 마음에 들었다면 후기를 통해 다른 사람들에게 공유해볼까요?
    </div>
    <div class="top-box">
      <div class="left">총 {{ len }}건</div>
      <form class="right" id="form-search" action="#" method="post">
        <select name="select-notice" id="select-notice" v-model="param.key">
          <option value="">전체</option>
          <option value="title">제목</option>
        </select>
        <input type="text" placeholder="검색어를 입력해주세요." v-model="param.word" />
        <input type="submit" id="btn-search" value="검색" @click.prevent="searchPost" />
      </form>
    </div>
    <div class="line"></div>
    <div v-if="len == 0">
      <VEmptyItem text="검색 결과가 없습니다." />
    </div>
    <div v-else class="content-box">
      <AfterTraveenListItem v-for="post in posts" :key="post.idx" :post="post" />
    </div>
    <PageNavigation
      :current-page="currentPage"
      :total-page="totalPage"
      @pageChange="onPageChange"
    ></PageNavigation>
  </article>
</template>

<style scoped>
@import "@/assets/scss/components/aftertraveen/afterTraveenList.scss";
</style>
