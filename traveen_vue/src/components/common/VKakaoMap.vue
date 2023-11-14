<script setup>
import { ref, watch, onMounted } from "vue";

var map;
const positions = ref([]);
const markers = ref([]);

const props = defineProps({ height: String, destinations: Array, selectDestination: Object });

watch(
  () => props.selectDestination.value,
  () => {
    var moveLatLon = new kakao.maps.LatLng(
      props.selectDestination.lat,
      props.selectDestination.lng
    );
    // 지도 중심을 부드럽게 이동시킴
    map.panTo(moveLatLon);
  },
  { deep: true }
);

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

watch(
  () => props.destinations.value,
  () => {
    positions.value = [];
    props.destinations.forEach((des) => {
      let obj = {};
      obj.latlng = new kakao.maps.LatLng(des.lat, des.lng);
      obj.title = des.title;

      positions.value.push(obj);
    });
    loadMarkers();
  },
  { deep: true }
);

const initMap = () => {
  const container = document.getElementById("map");
  const options = {
    center: new kakao.maps.LatLng(33.450701, 126.570667),
    level: 3,
  };
  map = new kakao.maps.Map(container, options);
};

const laodMarkers = () => {
  // 현재 표시되어있는 marker들 제거
  deleteMarkers();
  // 마커 생성
  markers.value = [];
  positions.value.forEach((pos) => {
    const marker = new kakao.maps.marker({
      map: map,
      position: pos.latlng,
      title: pos.title,
      clickable: true,
    });
    marker.value.push(marker);
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
