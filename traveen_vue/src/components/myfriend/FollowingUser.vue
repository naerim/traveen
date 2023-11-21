<script setup>
import FriendListItem from "@/components/myfriend/item/FriendListItem.vue";
import { storeToRefs } from "pinia";
import { useFriendStore } from "@/stores/friend";

const type = "following";

const friendStore = useFriendStore();
const { following } = storeToRefs(friendStore);
</script>

<template>
  <section>
    <FriendListItem v-for="friend in following" :key="friend.idx" :friend="friend" :type="type" />
  </section>
</template>

<style scoped>
@import "@/assets/scss/components/myfriend/following.scss";
</style>
