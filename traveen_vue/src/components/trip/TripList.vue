<script setup>
import { ref, onMounted } from "vue";
import { listTrip } from "../../api/trip";
import TripListItem from "./item/TripListItem.vue";
import PageNavigation from "@/components/common/PageNavigation.vue";
import VEmptyItem from "@/components/common/VEmptyItem.vue";
import TripModal from "@/components/trip/TripModal.vue";

// trip list 길이
const trip = ref(1);
const show = ref(false);

const trips = ref([]);
const currentPage = ref(1);
const totalPage = ref(0);
const { VITE_TRIP_LIST_SIZE } = import.meta.env;

// 아이템 클릭했을 때
const clickItem = () => {
  show.value = true;
};

const param = ref({
  pgno: currentPage.value,
  spp: VITE_TRIP_LIST_SIZE,
  key: "",
  word: "",
});

// 모달창 닫기
const closeModal = () => {
  show.value = false;
};

onMounted(() => {
  getTripList();
});

const getTripList = () => {
  console.log("서버에서 여행지 목록 얻어오자");
  listTrip(
    param.value,
    ({ data }) => {
      trips.value = data.tripinfos;
      console.log(data.tripinfos);
      currentPage.value = data.currentPage;
      totalPage.value = data.totalPageCount;

      console.log("page cur : " + currentPage.value + " total : " + totalPage.value);
    },
    (error) => console.log(error)
  );
};

const onPageChange = (val) => {
  currentPage.value = val;
  param.value.pgno = val;
  getTripList();
};
</script>

<template>
  <div v-if="trip === 0">
    <VEmptyItem text="검색 결과가 없습니다." />
  </div>
  <div v-else id="content-box">
    <TripListItem v-for="trip in trips" :key="trip.idx" :trip="trip" @click-item="clickItem" />
  </div>
  <TripModal :show="show" @close-modal="closeModal" type="trip" />
  <!-- pagination -->
  <PageNavigation
    :current-page="currentPage"
    :total-page="totalPage"
    @pageChange="onPageChange"
  ></PageNavigation>
</template>

<style scoped>
#content-box {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  gap: 60px 50px;
  margin-bottom: 20px;
}
</style>
