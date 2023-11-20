<script setup>
import { ref, shallowRef, onMounted, computed } from "vue";
import { useMemberStore } from "@/stores/member";
import { useMyTripStore } from "@/stores/mytrip";
import { listCourse } from "@/api/course";
import { listLikeTrip } from "@/api/trip";
import MyTripCourse from "@/components/mytrip/MyTripCourse.vue";
import MyTripLikeTrip from "@/components/mytrip/MyTripLikeTrip.vue";

const current = shallowRef(MyTripCourse);
const active = ref("course");
const change = (val) => {
  active.value = val;
  current.value = val == "course" ? MyTripCourse : MyTripLikeTrip;
};

const memberStore = useMemberStore();
const userInfo = computed(() => memberStore.userInfo);

const myTripStore = useMyTripStore();
const mycourseCount = computed(() => myTripStore.mycourseCount);
const mytripLikeCount = computed(() => myTripStore.mytripLikeCount);
const { addMycourse, setMytripLike } = myTripStore;

onMounted(() => {
  getMyCourseList();
  getMyTripLikeList();
});

const getMyCourseList = () => {
  listCourse(
    userInfo.value.idx,
    ({ data }) => {
      addMycourse(data);
    },
    (error) => console.log(error)
  );
};

const getMyTripLikeList = () => {
  listLikeTrip(
    userInfo.value.idx,
    ({ data }) => setMytripLike(data),
    (error) => console.log(error)
  );
};
</script>

<template>
  <h2>나의 여행</h2>
  <div class="trip-menu-wrap">
    <span @click="change('course')" :class="{ active: active === 'course' }" id="menuItem"
      >내 여행 코스<span class="num">{{ mycourseCount }}</span></span
    >
    <span @click="change('liketrip')" :class="{ active: active === 'liketrip' }" id="menuItem"
      >찜한 여행지<span class="num">{{ mytripLikeCount }}</span></span
    >
  </div>
  <component :is="current"></component>
</template>

<style scoped>
@import "@/assets/scss/views/myTripView.scss";
</style>
