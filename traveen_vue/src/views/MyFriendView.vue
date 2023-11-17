<script setup>
import { ref, shallowRef } from "vue";
import Follower from "../components/myfriend/Follower.vue";
import Following from "../components/myfriend/Following.vue";

const current = shallowRef(Follower);
const active = ref("follower");
const change = (val) => {
  active.value = val;
  current.value = val == "follower" ? Follower : Following;
};
</script>

<template>
  <h2>나의 친구</h2>
  <div class="friend-menu-wrap">
    <div>
      <span @click="change('follower')" :class="{ active: active === 'follower' }">팔로워</span>
      <span @click="change('following')" :class="{ active: active === 'following' }">팔로잉</span>
    </div>
    <img src="@/assets/img/icon_plus_friend.png" alt="" />
  </div>
  <component :is="current"></component>
</template>

<style scoped>
@import "@/assets/scss/views/myFriendView.scss";
</style>
