import { computed, ref } from "vue";
import { defineStore } from "pinia";

export const useMyTripStore = defineStore("mytrip", () => {
  const mycourse = ref([]);
  const mytripLike = ref([]);
  const mycourseCount = computed(() => mycourse.value.length);
  const mytripLikeCount = computed(() => mytripLike.value.length);

  const addMycourse = (list) => {
    mycourse.value = list;
  };

  const deleteMycourse = (idx) => {
    mycourse.value = mycourse.value.filter((item) => item.idx !== idx);
  };

  return { mycourse, mytripLike, mycourseCount, mytripLikeCount, addMycourse, deleteMycourse };
});
