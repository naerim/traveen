<script setup>
import { ref, onMounted } from "vue";
import { listPopularTrip } from "@/api/trip";
import { useRouter } from "vue-router";

const router = useRouter();

const popularTrips = ref([]);


onMounted(() => {
  getPopularTripList();
});

const onClickTrip = (placeName) => {
  router.push({ name: "trip-list-popular", params: { word: placeName }});
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
