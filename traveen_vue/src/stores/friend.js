import { computed, ref } from "vue";
import { defineStore } from "pinia";

export const useFriendStore = defineStore(
  "friend",
  () => {
    const following = ref([]);
    const follower = ref([]);
    const followingCount = computed(() => following.value.length);
    const followerCount = computed(() => follower.value.length);

    const addFollowing = (user) => {
      const check = following.value.some((item) => item.idx === user.idx);
      if (check) {
        alert("이미 팔로잉한 회원입니다.");
      } else following.value.push(user);
    };

    const addFollower = (user) => {
      const check = follower.value.some((item) => item.idx === user.idx);
      if (check) {
        alert("이미 팔로우한 회원입니다.");
      } else follower.value.push(user);
    };

    const deleteMyFollowing = (idx) => {
      following.value = following.value.filter((item) => item.idx !== idx);
    };

    const deleteMyFollower = (idx) => {
      follower.value = follower.value.filter((item) => item.idx !== idx);
    };

    const setFollowingList = (list) => {
      following.value = list;
    };

    const setFollowerList = (list) => {
      follower.value = list;
    };

    return {
      following,
      follower,
      followingCount,
      followerCount,
      addFollowing,
      setFollowingList,
      setFollowerList,
      addFollower,
      deleteMyFollowing,
      deleteMyFollower,
    };
  },
  { persist: true }
);
