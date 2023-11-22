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
      following.value.push(user);
    };

    const addFollower = (user) => {
      follower.value.push(user);
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

    // 팔로잉한 사용자인지 확인
    const isMyFollowing = (idx) => {
      console.log(following.value);
      return following.value.some((item) => item.idx == idx);
    };

    return {
      following,
      follower,
      followingCount,
      followerCount,
      addFollowing,
      addFollower,
      setFollowingList,
      setFollowerList,
      deleteMyFollowing,
      deleteMyFollower,
      isMyFollowing,
    };
  },
  { persist: true }
);
