<script setup>
import { ref, shallowRef, onMounted, computed } from "vue";
import Follower from "@/components/myfriend/FollowerUser.vue";
import Following from "@/components/myfriend/FollowingUser.vue";
import AddFriendModal from "@/components/myfriend/AddFriendModal.vue";
import { listFollower, listFollowing } from "@/api/friend";
import { useMemberStore } from "@/stores/member";
import { useFriendStore } from "@/stores/friend";

const memberStore = useMemberStore();
const friendStore = useFriendStore();
const userInfo = computed(() => memberStore.userInfo);
const { setFollowerList, setFollowingList, following, follower } = friendStore;
const followerCount = computed(() => friendStore.followerCount);
const followingCount = computed(() => friendStore.followingCount);

const friends = ref([]);

onMounted(() => {
  getFollowingList();
  getFollowerList();
});

const getFollowerList = () => {
  listFollower(
    userInfo.value.idx,
    ({ data }) => {
      friends.value = data;
      setFollowerList(data);
    },
    (error) => console.log(error)
  );
};

const getFollowingList = () => {
  listFollowing(
    userInfo.value.idx,
    ({ data }) => {
      friends.value = data;
      setFollowingList(data);
    },
    (error) => console.log(error)
  );
};

const current = shallowRef(Follower);
const active = ref("follower");

const change = (val) => {
  active.value = val;
  current.value = val == "follower" ? Follower : Following;
};

const show = ref(false);
// 모달창 닫기
const closeModal = () => {
  show.value = false;
};
const openModal = () => {
  show.value = true;
};
</script>

<template>
  <h2>나의 친구</h2>
  <div class="friend-menu-wrap">
    <div>
      <span
        @click="change('follower')"
        :class="{ active: active === 'follower' }"
        :friends="friends"
        id="friend"
        >팔로워 <span class="num">{{ followerCount }}</span></span
      >
      <span
        @click="change('following')"
        :class="{ active: active === 'following' }"
        :friends="friends"
        id="friend"
        >팔로잉 <span class="num">{{ followingCount }}</span></span
      >
    </div>
    <img src="@/assets/img/icon_plus_friend.png" alt="" @click="openModal" />
  </div>
  <component :is="current"></component>
  <AddFriendModal :show="show" @close-modal="closeModal" />
</template>

<style scoped>
@import "@/assets/scss/views/myFriendView.scss";
</style>
