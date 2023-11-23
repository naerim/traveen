<script setup>
import { ref, computed, onMounted, watch } from "vue";
import VEmptyItem from "@/components/common/VEmptyItem.vue";
import MyActivePostItemVue from "@/components/myactive/item/MyActivePostItem.vue";
import { useMemberStore } from "@/stores/member";
import { listPost } from "@/api/post";

const memberStore = useMemberStore();
const userInfo = computed(() => memberStore.userInfo);

const param = ref({
  pgno: 1,
  spp: 20,
  key: "title",
  word: "",
  userIdx: userInfo.value.idx,
});

const len = ref(0);
const posts = ref([]);

onMounted(() => {
  // 내가 쓴 여행 후기 글 불러오기
  getPostList();
  len.value = posts.value.length;
});

const getPostList = () => {
  listPost(
    param.value,
    ({ data }) => {
      posts.value = data.posts;
    },
    (error) => console.log(error)
  );
};

// 글 갯수 세기
watch(posts, (newValue) => {
  len.value = newValue.length;
});
</script>

<template>
  <div class="subtitle">내가 쓴 글</div>
  <div class="container">
    <div class="search-wrap">
      <input type="text" placeholder="글 제목을 입력해주세요." v-model="param.word" />
      <button @click="getPostList">검색</button>
    </div>
    <ul v-if="len === 0">
      <VEmptyItem text="내가 쓴 글이 없습니다." />
    </ul>
    <ul v-else>
      <MyActivePostItemVue v-for="post in posts" :key="post.idx" :post="post" />
    </ul>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/myactive/myActivePost.scss";
</style>
