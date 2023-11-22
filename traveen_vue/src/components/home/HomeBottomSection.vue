<script setup>
import { ref, onMounted } from "vue";
import { listPopularTrip, listTrip } from "@/api/trip";
import { useRouter } from "vue-router";

const router = useRouter();

const popularTrips = ref([]);
const currentPage = ref(1);
const totalPage = ref(0);
const { VITE_TRIP_LIST_SIZE } = import.meta.env;

const trips = ref([]);

onMounted(() => {
  getPopularTripList();
});

const param = ref({
  pgno: currentPage.value,
  spp: VITE_TRIP_LIST_SIZE,
  word: "",
  type: "",
  order: "",
  category: "",
});

const onClickTrip = (placeName) => {
  param.value.word = placeName;
  listTrip(
    param.value,
    ({ data }) => {
      console.log(param.value);
      trips.value = data.tripinfos;
      currentPage.value = data.currentPage;
      totalPage.value = data.totalPageCount;
      router.push({ name: "trip-list", query: { param: param.value } });
    },
    (error) => console.log(error)
  );
};

const getPopularTripList = () => {
  listPopularTrip(({ data }) => {
    popularTrips.value = data;
  });
};
</script>

<template>
  <div class="container">
    <div class="wrap">
      <div class="title">#인기 여행지</div>
      <div class="content">
        <div class="item" v-for="popularTrip in popularTrips" :key="popularTrip.idx">
          <img :src="popularTrip.image" alt="" class="img-popular" />
          <div class="caption" @click="onClickTrip(popularTrip.placeName)">
            <h4 class="title">{{ popularTrip.title }}</h4>
            <p class="placeName">{{ popularTrip.placeName }}</p>
            <p class="address">{{ popularTrip.address }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/home/homeBottomSection.scss";
</style>
