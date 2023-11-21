import { computed, ref } from "vue";
import { defineStore } from "pinia";

export const useCourseStore = defineStore(
  "friend",
  () => {
    const following = ref([]);
    const follower = ref([]);
    const followerCount = computed(() => follower.value.length);

    const addFollowing = (user) => {
      const check = following.value.some((item) => item.idx === user.idx);
      if (check) {
        alert("이미 팔로잉한 회원입니다.");
      } else following.value.push(user);
    };

    const deleteFollowing = (idx) => {
      following.value = following.value.filter((item) => item.idx !== idx);
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
      followerCount,
      addFollowing,
      deleteFollowing,
      setFollowingList,
      setFollowerList,
    };
  },
  { persist: true }
);
