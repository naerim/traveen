<script setup>
import FriendListItem from "@/components/myfriend/item/FriendListItem.vue";
import { storeToRefs } from "pinia";
import { useFriendStore } from "@/stores/friend";
import VEmptyItem from "@/components/common/VEmptyItem.vue";

const type = "following";

const friendStore = useFriendStore();
const { following, followingCount } = storeToRefs(friendStore);
</script>

<template>
  <VEmptyItem v-if="followingCount === 0" text="팔로잉이 없습니다." />
  <section v-if="followingCount !== 0">
    <FriendListItem v-for="friend in following" :key="friend.idx" :friend="friend" :type="type" />
  </section>
</template>

<style scoped>
@import "@/assets/scss/components/myfriend/following.scss";
</style>
