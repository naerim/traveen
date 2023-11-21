<script setup>
import { ref, watch } from "vue";
import { storeToRefs } from "pinia";
import TripListItem from "@/components/trip/item/TripListItem.vue";
import TripModal from "@/components/trip/TripModal.vue";
import VEmptyItem from "@/components/common/VEmptyItem.vue";
import { useMyTripStore } from "@/stores/mytrip";
import { useTripStore } from "@/stores/trip";
import { detailTrip } from "@/api/trip";

const tripStore = useTripStore();
const { setTrip } = tripStore;

const myTripStore = useMyTripStore();
const { mytripLike, mytripLikeCount } = storeToRefs(myTripStore);

const show = ref(false);
const trip = ref({});

// 아이템 클릭했을 때
const clickItem = (idx) => {
  getTrip(idx);
};

watch(
  () => trip.value,
  () => {
    setTrip(trip.value);
    show.value = true;
  }
);

const getTrip = (idx) => {
  detailTrip(
    idx,
    ({ data }) => {
      trip.value = data;
    },
    (error) => console.log(error)
  );
};

// 모달창 닫기
const closeModal = () => {
  show.value = false;
};
</script>

<template>
  <VEmptyItem v-if="mytripLikeCount === 0" text="찜한 여행지가 없습니다." />
  <div v-if="mytripLikeCount !== 0" class="container">
    <TripListItem
      v-for="trip in mytripLike"
      :key="trip.idx"
      :trip="trip"
      @click-item="clickItem(trip.idx)"
    />
  </div>
  <TripModal :show="show" @close-modal="closeModal" type="trip" :trip="trip" />
</template>

<style scoped>
@import "@/assets/scss/components/mytrip/myTripLikeTrip.scss";
</style>
