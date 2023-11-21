<script setup>
import { ref, shallowRef, computed, onMounted } from "vue";
import { listFollowing } from "@/api/friend";
import Follower from "@/components/myfriend/Follower.vue";
import Following from "@/components/myfriend/FollowingUser.vue";
import AddFriendModal from "@/components/myfriend/AddFriendModal.vue";
import { useMemberStore } from "@/stores/member";

const current = shallowRef(Follower);
const active = ref("follower");
const change = (val) => {
  active.value = val;
  current.value = val == "follower" ? Follower : Following;
};

const memberStore = useMemberStore();
const userInfo = computed(() => memberStore.userInfo);
const friends = ref([]);

onMounted(() => {
  getFollowingList();
});

const getFollowingList = () => {
  listFollowing(
    userInfo.value.idx,
    ({ data }) => {
      console.log(data);
      friends.value = data;
    },
    (error) => console.log(error)
  );
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
      <span @click="change('follower')" :class="{ active: active === 'follower' }">팔로워</span>
      <span
        @click="change('following')"
        :class="{ active: active === 'following' }"
        :friends="friends"
        >팔로잉</span
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
