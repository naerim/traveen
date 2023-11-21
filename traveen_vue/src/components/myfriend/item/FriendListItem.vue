<script setup>
import { ref } from "vue";
import { useFriendStore } from "@/stores/friend";
import { deleteFollowing, deleteFollower } from "@/api/friend";

const show = ref(false);
const props = defineProps({ friend: Object, type: String });
const toggleMenu = () => (show.value = !show.value);
const friendStore = useFriendStore();
const { deleteMyFollowing, deleteMyFollower } = friendStore;

const onDeleteFriend = (idx) => {
  if (props.type === "following") {
    console.log(idx);
    deleteFollowing(
      idx,
      () => {
        deleteMyFollowing(idx);
        alert("삭제되었습니다.");
      },
      (error) => console.log(error)
    );
  } else if (props.type === "follower") {
    deleteFollower(
      idx,
      () => {
        deleteMyFollower(idx);
        alert("삭제되었습니다.");
      },
      (error) => console.log(error)
    );
  }
  show.value = false;
};
</script>

<template>
  <div class="item-container">
    <img src="@/assets/img/icon_vertical_menu.png" alt="" id="img-menu" @click="toggleMenu" />
    <img src="@/assets/img/img_profile.png" alt="" id="img-profile" />
    <div class="userName">{{ props.friend.userName }}</div>
    <div class="userId">{{ props.friend.userId }}</div>
    <div v-show="show" id="menu">
      <ul>
        <li>친구 정보</li>
        <li @click="onDeleteFriend(props.friend.idx)">삭제</li>
      </ul>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/myfriend/item/friendListItem.scss";
</style>
