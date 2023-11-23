<script setup>
import { ref, onMounted } from "vue";
import { useTripStore } from "@/stores/trip";

var map;
const positions = ref([]);
const markers = ref([]);

const props = defineProps({ height: String });

const tripStore = useTripStore();

onMounted(() => {
  if (window.kakao && window.kakao.maps) {
    initMap();
  } else {
    const script = document.createElement("script");
    script.src = `//dapi.kakao.com/v2/maps/sdk.js?autoload=false&appkey=${
      import.meta.env.VITE_KAKAO_MAP_SERVICE_KEY
    }&libraries=services,clusterer`;
    /* global kakao */
    script.onload = () => kakao.maps.load(() => initMap());
    document.head.appendChild(script);
  }
});

// watch(
//   () => props.selectDestination,
//   () => {
//     console.log();
//     var moveLatLon = new kakao.maps.LatLng(
//       props.selectDestination.lat,
//       props.selectDestination.loc
//     );
//     // 지도 중심을 부드럽게 이동시킴
//     map.panTo(moveLatLon);
//   },
//   { deep: true }
// );

// watch(
//   () => props.selectDestination,
//   () => {
//     positions.value = [];
//     let obj = {};
//     obj.latlng = new kakao.maps.LatLng(props.selectDestination.lat, props.selectDestination.loc);
//     obj.title = props.selectDestination.title;
//     positions.value.push(obj);
//   },
//   { deep: true }
// );

const initMap = () => {
  const container = document.getElementById("map");
  const options = {
    center: new kakao.maps.LatLng(tripStore.selectTrip.lat, tripStore.selectTrip.loc),
    level: 3,
  };
  map = new kakao.maps.Map(container, options);

  positions.value = [];
  let obj = {};
  obj.latlng = new kakao.maps.LatLng(tripStore.selectTrip.lat, tripStore.selectTrip.loc);
  obj.title = tripStore.selectTrip.title;
  positions.value.push(obj);

  loadMarkers();
};

const loadMarkers = () => {
  // 현재 표시되어있는 marker들 제거
  deleteMarkers();
  // 마커 생성
  markers.value = [];

  positions.value.forEach((pos) => {
    const marker = new kakao.maps.Marker({
      map: map,
      position: pos.latlng,
      title: pos.title,
      clickable: true,
    });
    markers.value.push(marker);
  });
  // 지도 이동시키기
  const bounds = positions.value.reduce(
    (bounds, position) => bounds.extend(position.latlng),
    new kakao.maps.LatLngBounds()
  );

  map.setBounds(bounds);
};

const deleteMarkers = () => {
  if (markers.value.length > 0) {
    markers.value.forEach((marker) => marker.setMap(null));
  }
};
</script>

<template>
  <div id="mapBox" :style="{ height: height }">
    <div id="map"></div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/common/vKakaoMap.scss";
</style>
