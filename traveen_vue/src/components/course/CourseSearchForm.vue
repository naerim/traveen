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
.container {
  display: flex;
  flex-direction: column;
  width: 70%;
}

/* #mapBox {
  margin-inline: auto;
  width: 100%;
  height: 600px;
}
#map {
  width: 100%;
  height: 100%;
} */

.form-search-course-regist {
  display: flex;
  margin: 20px 0;
}

.form-search-course-regist select {
  border: 1px solid #dadee2;
  border-radius: 6px;
  box-sizing: border-box;
  padding: 4px;
  height: 40px;
  width: 120px;
  margin-right: 20px;
}

#input-course-regist {
  border: 1px solid #dadee2;
  box-sizing: border-box;
  padding: 4px;
  border-radius: 6px;
  width: 220px;
  margin-right: 20px;
}

#input-course-regist::placeholder {
  color: #d3d3d3;
}

.form-search-course-regist button {
  background-color: #51cd89;
  border: none;
  color: #fff;
  width: 60px;
  border-radius: 6px;
}

#content-box {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
  gap: 60px 50px;
  margin-bottom: 20px;
  margin-top: 40px;
}
</style>
