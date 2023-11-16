import { computed, ref } from "vue";
import { defineStore } from "pinia";

export const useCourseStore = defineStore("course", () => {
  const courseList = ref([]);
  const courseListCount = computed(() => courseList.value.length);

  const addCourse = (trip) => {
    const check = courseList.value.some((item) => item.idx === trip.idx);
    if (check) {
      alert("이미 추가된 항목입니다.");
    } else courseList.value.push(trip);
  };

  const deleteCourse = (idx) => {
    if (courseListCount.value === 1) {
      alert("적어도 하나는 존재해야 합니다.");
    } else courseList.value = courseList.value.filter((item) => item.idx !== idx);
  };

  return { courseList, courseListCount, addCourse, deleteCourse };
});
