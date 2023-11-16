<script setup>
import { ref, onMounted, watch } from "vue";
import TripListItem from "@/components/trip/item/TripListItem.vue";
import TripModal from "@/components/trip/TripModal.vue";
import VEmptyItem from "@/components/common/VEmptyItem.vue";
import VKakaoMapLine from "@/components/common/VKakaoMapLine.vue";
import { listTrip, detailTrip, listSido } from "@/api/trip";
import VSelect from "@/components/common/VSelect.vue";
import { useTripStore } from "@/stores/trip";

const tripStore = useTripStore();
const { setTrip } = tripStore;

// trip list 길이
const len = ref(0);
const show = ref(false);
const selectOption = ref([]);
const param = ref({
  sido: "",
  word: "",
  type: "",
  category: "",
});
// 검색했을 때 나온 여행지들 저장할 배열
const trips = ref([]);
const trip = ref({});

onMounted(() => {
  loadSido();
});

const loadSido = () => {
  listSido(
    ({ data }) => {
      selectOption.value = data;
      selectOption.value.unshift({
        idx: 0,
        code: "",
        name: "전체",
      });
    },
    (error) => console.log(error)
  );
};

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

// 여행지 검색
const searchTrip = () => {
  listTrip(
    param.value,
    ({ data }) => {
      trips.value = data.tripinfos;
    },
    (error) => console.log(error)
  );
};

const keySelect = (val) => (param.value.sido = val);

// 여행지 글 갯수 세기
watch(trips, (newValue) => {
  len.value = newValue.length;
});
</script>

<template>
  <div class="container">
    <VKakaoMapLine :height="`${600}px`" />
    <form class="form-search-course-regist" @submit.prevent="">
      <select name="type" v-model="param.type">
        <option value="">전체</option>
        <option value="restaurant">식당</option>
        <option value="cafe">카페</option>
        <option value="stay">숙소</option>
        <option value="playground">장소</option>
      </select>
      <select name="category" v-model="param.category">
        <option value="">전체</option>
        <option value="drama">드라마</option>
        <option value="movie">영화</option>
        <option value="show">예능</option>
        <option value="artist">아티스트</option>
      </select>
      <VSelect :selectOption="selectOption" @on-key-select="keySelect" />
      <input
        type="text"
        placeholder="검색어를 입력해주세요."
        id="input-course-regist"
        v-model="param.word"
      />
      <button type="button" @click.prevent="searchTrip">검색</button>
    </form>
    <div>총 {{ len }}개의 검색 결과가 있습니다.</div>
    <div v-if="len === 0">
      <VEmptyItem text="검색 결과가 없습니다." />
    </div>
    <div v-else id="content-box">
      <TripListItem
        v-for="trip in trips"
        :key="trip.idx"
        :trip="trip"
        @click-item="clickItem(trip.idx)"
      />
    </div>
  </div>
  <TripModal :show="show" @close-modal="closeModal" type="course" :trip="trip" />
</template>

<style scoped>
@import "@/assets/scss/components/course/courseSearchForm.scss";
</style>
