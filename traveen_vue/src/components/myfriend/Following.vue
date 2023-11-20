<script setup>
import { onMounted, ref } from "vue";
import { listFollowing } from "@/api/friend";
import FriendListItem from "@/components/myfriend/item/FriendListItem.vue";
import { useMemberStore } from "@/stores/member";
import { storeToRefs } from "pinia";

const memberStore = useMemberStore();
const { userInfo } = storeToRefs(memberStore);
const friends = ref([]);

onMounted(() => {
  getFollowingList();
});

const getFollowingList = () => {
  listFollowing(
    userInfo.userIdx,
    ({data}) => {
      friends.value = data.friends;
    },
    (error) => console.log(error)
  );
};

</script>

<template>
  <section>
    <FriendListItem v-for="(friend) in friends" :key="friend.idx" :friend="friend"/>
  </section>
</template>

<style scoped>
@import "@/assets/scss/components/myfriend/following.scss";
</style>
