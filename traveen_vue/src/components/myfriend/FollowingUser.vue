<script setup>
import FriendListItem from "@/components/myfriend/item/FriendListItem.vue";

defineProps({
  friends: Array,
});
</script>

<template>
  <section>
    <FriendListItem v-for="friend in friends" :key="friend.idx" :friend="friend" />
  </section>
</template>

<style scoped>
@import "@/assets/scss/components/myfriend/following.scss";
</style>
