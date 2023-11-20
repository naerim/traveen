import { computed, ref } from "vue";
import { defineStore } from "pinia";

export const useMyTripStore = defineStore(
  "mytrip",
  () => {
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

    // 찜하기 리스트 설정
    const setMytripLike = (list) => {
      mytripLike.value = list;
    };

    // 찜하기
    const addMytripLike = (trip) => {
      mytripLike.value.push(trip);
    };

    // 찜취소
    const deleteMytripLike = (idx) => {
      mytripLike.value = mytripLike.value.filter((item) => item.idx !== idx);
    };

    // 찜 되었던 여행지인지 확인
    const isMytripLike = (idx) => mytripLike.value.some((item) => item.idx == idx);

    return {
      mycourse,
      mytripLike,
      mycourseCount,
      mytripLikeCount,
      addMycourse,
      deleteMycourse,
      addMytripLike,
      setMytripLike,
      deleteMytripLike,
      isMytripLike,
    };
  },
  { persist: true }
);
