<script setup>
import { ref } from "vue";``
import { storeToRefs } from "pinia";
import { useMemberStore } from "@/stores/member";
import {useFriendStore } from "@/stores/friend";
import {followUser} from "@/api/friend";

const memberStore = useMemberStore();
const friendStore = useFriendStore();
const { userInfo } = storeToRefs(memberStore);
const { addFollowing } = friendStore;

const props = defineProps({ user: Object });

const followUserParam = ref({
  fromIdx: userInfo.value.idx,
  toIdx: "",
})

const onClickFollow = () => {
  followUserParam.value.toIdx = props.user.idx;
  if (followUserParam.value.toIdx !== userInfo.value.idx) {
  followUser(
    followUserParam.value,
    () => {
      addFollowing(props.user);
      alert("팔로우 완료!");
      console.log("팔로우 완료");
    },
    (error) => console.log(error)
  );
  }
};

</script>

<template>
  <div v-if="props.user.idx !== userInfo.idx" class="container">
    <img src="@/assets/img/img_profile.png" alt="" id="profile" />
    <div class="info-box">
      <div class="name">{{ props.user.userName }} ({{props.user.userId}})</div>
      <div class="email">{{ props.user.emailId }}@{{props.user.emailDomain}}</div>
    </div>
    <img src="@/assets/img/icon_plus_g.png" alt="" id="plus" @click="onClickFollow"/>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/myfriend/item/searchFriendListItem.scss";
</style>
