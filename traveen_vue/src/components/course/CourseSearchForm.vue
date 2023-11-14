<script setup>
import { ref } from "vue";
import TripListItem from "@/components/trip/item/TripListItem.vue";
import TripModal from "@/components/trip/TripModal.vue";
import VEmptyItem from "@/components/common/VEmptyItem.vue";
import VKakaoMap from "@/components/common/VKakaoMap.vue";

const destinations = ref([]);
const selectDestination = ref([{ lat: 33.450701, lng: 126.570667, title: "라라무리" }]);

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
  <div class="container">
    <VKakaoMap
      :destinations="destinations"
      :selectDestination="selectDestination"
      :height="`${600}px`"
    />
    <form class="form-search-course-regist">
      <select name="type" id="type">
        <option value="drama">드라마</option>
      </select>
      <select name="category" id="category">
        <option value="restaurant">레스토랑</option>
      </select>
      <select name="sido" id="sido">
        <option value="경기도">경기도</option>
      </select>
      <input type="text" placeholder="검색어를 입력해주세요." id="input-course-regist" />
      <button type="button">검색</button>
    </form>
    <div>총 4개의 검색 결과가 있습니다.</div>
    <div v-if="trip === 0">
      <VEmptyItem text="검색 결과가 없습니다." />
    </div>
    <div v-else id="content-box">
      <TripListItem @click-item="clickItem" />
      <TripListItem @click-item="clickItem" />
      <TripListItem @click-item="clickItem" />
      <TripListItem @click-item="clickItem" />
      <TripListItem @click-item="clickItem" />
    </div>
  </div>
  <TripModal :show="show" @close-modal="closeModal" type="course" />
</template>

<style scoped>
@import "@/assets/scss/components/course/courseSearchForm.scss";
</style>
