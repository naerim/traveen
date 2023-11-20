import { ref, computed } from "vue";
import { defineStore } from "pinia";

export const useTripLikeStore = defineStore("tripLike", () => {
  const likeTripList = ref([]);

  const likeCount = computed(() => likeTripList.value.length);

  const addLikeTrip = (tripLike) => {
    likeTripList.value.push(tripLike);
  };

  const removeLikeTrip = (tripIdx) => {
    likeTripList.value = likeTripList.value.filter((item) => item.tripinfoIdx !== tripIdx);
    console.log(likeTripList.value);
  };

  const isLikeTrip = (tripIdx) => {
    return likeTripList.value.some((item) => item.tripinfoIdx == tripIdx);
  };

  return { likeTripList, isLikeTrip, likeCount, addLikeTrip, removeLikeTrip };
});
