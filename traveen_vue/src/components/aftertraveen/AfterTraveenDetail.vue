<script setup>
import { ref, onMounted } from "vue";
import { storeToRefs } from "pinia";
import { useRoute, useRouter } from "vue-router";
import KakaoMapLine from "@/components/common/VKakaoMapLine.vue";
import AfterTraveenDetailListItem from "@/components/aftertraveen/item/AfterTraveenDetailListItem.vue";
import AfterTraveenCommentItem from "@/components/aftertraveen/item/AfterTraveenCommentItem.vue";
import { detailPost, deletePost } from "@/api/post";
import { listFollowing, deleteFollowing, followUser } from "@/api/friend";
import { useMemberStore } from "@/stores/member";
import { useFriendStore } from "@/stores/friend";

const route = useRoute();
const router = useRouter();
const post = ref({});

const { idx } = route.params;
const items = ref([]);
const memberStore = useMemberStore();
const friendStore = useFriendStore();
const { setFollowingList } = friendStore;
const { userInfo } = storeToRefs(memberStore);
const { addFollowing, isMyFollowing, deleteMyFollowing } = friendStore;

const followUserParam = ref({
  fromIdx: userInfo.value.idx,
  toIdx: "",
});

onMounted(() => {
  // 여행 후기 글 불러오기
  getPost();

  listFollowing(
    userInfo.value.idx,
    ({ data }) => {
      setFollowingList(data);
    },
    (error) => console.log(error)
  );
});

const getPost = () => {
  detailPost(
    idx,
    ({ data }) => {
      post.value = data.post;
      items.value = data.postItem;
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

const onClickFollow = () => {
  followUserParam.value.toIdx = post.value.userIdx;
  if (followUserParam.value.toIdx !== userInfo.value.idx) {
    if (!isMyFollowing(followUserParam.value.toIdx)) {
      followUser(
        followUserParam.value,
        () => {
          addFollowing(post.value.userIdx);
          alert("팔로우가 완료됐습니다.");
          location.reload();
        },
        (error) => console.log(error)
      );
    } else {
      alert("이미 팔로우한 회원입니다.");
    }
  }
};

const onDeleteFollow = (idx) => {
  deleteFollowing(
    idx,
    () => {
      deleteMyFollowing(idx);
      alert("팔로우가 취소됐습니다.");
    },
    (error) => console.log(error)
  );
};
</script>

<template>
  <div class="info-wrap">
    <div class="title-wrap">
      <div class="title">{{ post.title }}</div>
      <div v-if="post.userIdx === userInfo.idx" class="button-wrap">
        <button @click="onPostDelete">삭제</button>
        <button>수정</button>
      </div>
      <div v-else class="button-wrap"></div>
    </div>

    <div class="profile-wrap">
      <img src="@/assets/img/img_profile.png" alt="" />
      <div class="name">{{ post.userName }}</div>
      <div v-if="isMyFollowing(post.userIdx)">
        <button @click="onDeleteFollow(post.userIdx)">팔로우 취소</button>
      </div>
      <div v-if="post.userIdx !== userInfo.idx">
        <button @click="onClickFollow">팔로우</button>
      </div>
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
      <AfterTraveenDetailListItem v-for="trip in items" :key="trip.idx" :trip="trip" />
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
