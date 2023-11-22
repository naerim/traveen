<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import KakaoMapLine from "@/components/common/VKakaoMapLine.vue";
import AfterTraveenDetailListItem from "@/components/aftertraveen/item/AfterTraveenDetailListItem.vue";
import AfterTraveenCommentItem from "@/components/aftertraveen/item/AfterTraveenCommentItem.vue";
import { detailPost, deletePost } from "@/api/post";

const route = useRoute();
const router = useRouter();
const post = ref({});

const { idx } = route.params;

onMounted(() => {
  // 여행 후기 글 불러오기
  getPost();
  console.log(post);
});

const getPost = () => {
  detailPost(
    idx,
    ({ data }) => {
      post.value = data;
    },
    (error) => console.log(error)
  );
};

// 여행 후기 글 삭제
const onPostDelete = () => {
  deletePost(
    idx,
    () => {
      alert("게시글이 삭제되었습니다.");
      post.value.flag = 0;
      router.push({ name: "aftertraveen" });
    },
    (error) => console.log(error)
  );
};

</script>

<template>
  <div class="info-wrap">
    <div class="title-wrap">
      <div class="title">{{ post.title }}</div>
      <div class="button-wrap">
        <button @click="onPostDelete">삭제</button>
        <button>수정</button>
      </div>
    </div>

    <div class="profile-wrap">
      <img src="@/assets/img/img_profile.png" alt="" />
      <div class="name">{{ post.userName }}</div>
      <button>팔로우</button>
    </div>

    <div class="line"></div>

    <div class="mid-wrap">
      <div class="left">
        <div class="left-item">
          <div class="left-text">여행일</div>
          <div class="left-content" id="date">{{ post.startDate }} ~ {{ post.endDate }}</div>
        </div>
        <div class="left-item">
          <div class="left-text">여행 후기 요약</div>
          <div class="left-content">
            {{ post.content }}
          </div>
        </div>
      </div>
      <div class="right">
        <KakaoMapLine :height="`${160}px`" />
      </div>
    </div>

    <div class="line"></div>

    <div class="content-wrap">
      <AfterTraveenDetailListItem />
      <AfterTraveenDetailListItem />
      <AfterTraveenDetailListItem />
    </div>
  </div>
  <div class="comments-wrap">
    <div class="comment-title">Comments</div>
    <div class="comment-content">
      <AfterTraveenCommentItem />
      <AfterTraveenCommentItem />
      <AfterTraveenCommentItem />
    </div>
    <div class="input-wrap">
      <input type="text" placeholder="댓글 달기.." />
      <button>등록</button>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/aftertraveen/afterTraveenDetail.scss";
</style>
