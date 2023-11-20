import { computed, ref } from "vue";
import { defineStore } from "pinia";

export const useMyTripStore = defineStore("mytrip", () => {
  const mycourse = ref([]);
  const mycourseCount = computed(() => mycourse.value.length);

  //   const addMycourse = (trip) => {
  //     const check = courseList.value.some((item) => item.idx === trip.idx);
  //     if (check) {
  //       alert("이미 추가된 항목입니다.");
  //     } else courseList.value.push(trip);
  //   };

  const addMycourse = (list) => {
    mycourse.value = list;
  };

  const deleteMycourse = (idx) => {
    mycourse.value = mycourse.value.filter((item) => item.idx !== idx);
  };

  return { mycourse, mycourseCount, addMycourse, deleteMycourse };
});
