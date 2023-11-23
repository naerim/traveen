<script setup>
import VEmptyItem from "@/components/common/VEmptyItem.vue";
import { onMounted, ref } from "vue";
import { listFollower, listFollowing } from "@/api/friend";
import { listLikeTrip } from "@/api/trip";
import { listPost } from "@/api/post";
import { useRouter } from "vue-router";
import { useCourseStore } from "@/stores/course";
import { listCourseItem } from "@/api/course";

const courseStore = useCourseStore();
const { setCourseList } = courseStore;

const router = useRouter();

const emit = defineEmits(["closeModal"]);
const onClickCloseModal = () => {
  emit("closeModal");
};

const props = defineProps({
  show: Boolean,
  friend: Object,
});

const followerLen = ref(0);
const followingLen = ref(0);
const friendLiketrip = ref([]);
const friendPost = ref([]);

onMounted(() => {
  getFollowerList();
  getFollowingList();
  getFriendLikeList();
  getFrinePostList();
});

const getFollowerList = () => {
  listFollower(
    props.friend.idx,
    ({ data }) => {
      followerLen.value = data.length;
    },
    (error) => console.log(error)
  );
};

const getFollowingList = () => {
  listFollowing(
    props.friend.idx,
    ({ data }) => {
      followingLen.value = data.length;
    },
    (error) => console.log(error)
  );
};

const getFriendLikeList = () => {
  listLikeTrip(
    props.friend.idx,
    ({ data }) => (friendLiketrip.value = data),
    (error) => console.log(error)
  );
};

const getFrinePostList = () => {
  listPost(
    { pgno: 1, spp: 20, userIdx: props.friend.idx },
    ({ data }) => {
      friendPost.value = data.posts;
    },
    (error) => console.log(error)
  );
};

const onClickTrip = (placeName) => {
  router.push({ name: "trip-list-popular", params: { word: placeName } });
};

const goAfterTraveenDetailPage = (courseIdx, postIdx) => {
  getListCourseitem(courseIdx);
  router.push({ name: "aftertraveen-detail", params: { idx: postIdx } });
};

// 미리 store의 courseList에 등록해주기
const getListCourseitem = (idx) => {
  listCourseItem(
    idx,
    ({ data }) => {
      setCourseList(data.list);
    },
    (err) => console.log(err)
  );
};
</script>

<template>
  <div class="modalContainer" v-if="props.show">
    <div class="modalBody" @click.stop>
      <img
        src="@/assets/img/icon_close.png"
        alt=""
        class="btn-close-modal"
        @click="onClickCloseModal"
      />
      <div class="friend-modal-container">
        <div class="top-wrap">
          <img src="@/assets/img/img_profile.png" alt="" />
          <div class="info-wrap">
            <p>
              <b>{{ props.friend.userName }}</b
              >({{ props.friend.userId }})
            </p>
            <div class="email">{{ props.friend.emailId }}@{{ props.friend.emailDomain }}</div>
            <div class="num-wrap">
              <span class="follower">팔로워 {{ followerLen }}</span>
              <span class="following">팔로워 {{ followingLen }}</span>
            </div>
          </div>
        </div>
        <label>{{ props.friend.userName }}님이 찜한 여행지</label>
        <ul class="ul-like" v-if="friendLiketrip.length === 0">
          <VEmptyItem text="찜한 여행지가 없습니다." />
        </ul>
        <ul class="ul-like" v-else>
          <li v-for="trip in friendLiketrip" :key="trip.idx" @click="onClickTrip(trip.placeName)">
            <div class="title">{{ trip.placeName }}</div>
            <div class="right">
              <img src="@/assets/img/icon_view.png" alt="" class="view" /><span>{{
                trip.viewCount
              }}</span>
              <img src="@/assets/img/icon_heart.png" alt="" class="heart" />
              <span>{{ trip.likeCount }}</span>
            </div>
          </li>
        </ul>
        <label>{{ props.friend.userName }}님이 쓴 글</label>
        <ul class="ul-post" v-if="friendPost.length === 0">
          <VEmptyItem text="작성한 글이 없습니다." />
        </ul>
        <ul class="ul-post" v-else>
          <li
            v-for="post in friendPost"
            :key="post.idx"
            @click="goAfterTraveenDetailPage(post.courseIdx, post.idx)"
          >
            <div class="title">{{ post.title }}</div>
            <div class="right">
              <img src="@/assets/img/icon_view.png" alt="" class="view" /><span>{{
                post.viewCount
              }}</span>
            </div>
          </li>
        </ul>
      </div>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/myfriend/friendInfoModal.scss";
</style>
