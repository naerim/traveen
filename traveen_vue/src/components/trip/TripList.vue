<script setup>
import { ref } from "vue";
import TripListItem from "./item/TripListItem.vue";
import VEmptyItem from "@/components/common/VEmptyItem.vue";
import TripModal from "@/components/trip/TripModal.vue";

// trip list 길이
const trip = ref(1);
const show = ref(false);

// 아이템 클릭했을 때
const clickItem = () => {
  show.value = true;
};

// 모달창 닫기
const closeModal = () => {
  show.value = false;
};
</script>

<template>
  <div v-if="trip === 0">
    <VEmptyItem text="검색 결과가 없습니다." />
  </div>
  <div v-else id="content-box">
    <TripListItem @click-item="clickItem" />
  </div>
  <TripModal :show="show" @close-modal="closeModal" type="trip" />
</template>

<style scoped>
#content-box {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  gap: 60px 50px;
  margin-bottom: 20px;
}
</style>
