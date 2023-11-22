<script setup>
import FriendListItem from "@/components/myfriend/item/FriendListItem.vue";
import { storeToRefs } from "pinia";
import { useFriendStore } from "@/stores/friend";
import VEmptyItem from "@/components/common/VEmptyItem.vue";

const type = "follower";

const friendStore = useFriendStore();
const { follower, followerCount } = storeToRefs(friendStore);
</script>

<template>
  <VEmptyItem v-if="followerCount === 0" text="팔로워가 없습니다." />
  <section v-if="followerCount !== 0">
    <FriendListItem v-for="friend in follower" :key="friend.idx" :friend="friend" :type="type" />
  </section>
</template>

<style scoped>
@import "@/assets/scss/components/myfriend/follower.scss";
</style>
