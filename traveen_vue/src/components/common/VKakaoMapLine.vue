<script setup>
import { ref, onMounted, watch } from "vue";
import { useCourseStore } from "@/stores/course";

const courseStore = useCourseStore();

var map;
const positions = ref([]);
const markers = ref([]);
const lines = ref([]);

const props = defineProps({ height: String });

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
  () => courseStore.courseList,
  () => {
    positions.value = [];
    courseStore.courseList.forEach((des) => {
      let obj = {};
      obj.latlng = new kakao.maps.LatLng(des.lat, des.loc);
      obj.title = des.placeName;

      positions.value.push(obj);
    });
    loadMarkers();
    addLines();
  },
  { deep: true }
);

const initMap = () => {
  const container = document.getElementById("map1");
  const options = {
    center: new kakao.maps.LatLng(33.450701, 126.570667),
    level: 3,
  };
  map = new kakao.maps.Map(container, options);

  positions.value = [];
  courseStore.courseList.forEach((des) => {
    let obj = {};
    obj.latlng = new kakao.maps.LatLng(des.lat, des.loc);
    obj.title = des.placName;

    positions.value.push(obj);
  });

  loadMarkers();
  addLines();
};

const loadMarkers = () => {
  // 현재 표시되어있는 marker들 제거
  deleteMarkers();
  // 마커 생성
  markers.value = [];

  let imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png";
  let imageSize = new kakao.maps.Size(24, 35);
  let markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize);

  positions.value.forEach((pos) => {
    const marker = new kakao.maps.Marker({
      map: map,
      position: pos.latlng,
      title: pos.title,
      clickable: true,
      image: markerImage,
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

// 마커 삭제
const deleteMarkers = () => {
  if (markers.value.length > 0) {
    markers.value.forEach((marker) => marker.setMap(null));
  }
};

// 라인 생성
const addLines = () => {
  deleteLines();
  let linePath = [];
  markers.value.forEach((marker) => {
    linePath.push(marker.getPosition());
  });

  let polyline = new kakao.maps.Polyline({
    path: linePath,
    strokeWeight: 3,
    strokeColor: "red",
    strokeOpacity: 0.7,
    strokeStyle: "solid",
  });

  lines.value.push(polyline);
  polyline.setMap(map);
};

// 라인 삭제
const deleteLines = () => {
  if (lines.value.length > 0) {
    lines.value.forEach((line) => line.setMap(null));
  }
};
</script>

<template>
  <div id="mapBox" :style="{ height: props.height }">
    <div id="map1"></div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/common/vKakaoMap.scss";
</style>
