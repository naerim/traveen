<script setup>
import FriendListItem from "@/components/myfriend/item/FriendListItem.vue";
import { storeToRefs } from "pinia";
import { useFriendStore } from "@/stores/friend";
defineProps({
  friends: Array,
});

const type = "follower";

const friendStore = useFriendStore();
const { follower } = storeToRefs(friendStore);
</script>

<template>
  <section>
    <FriendListItem v-for="friend in follower" :key="friend.idx" :friend="friend" :type="type" />
  </section>
</template>

<style scoped>
@import "@/assets/scss/components/myfriend/follower.scss";
</style>
