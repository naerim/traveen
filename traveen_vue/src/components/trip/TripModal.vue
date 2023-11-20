<script setup>
import { ref, watch } from "vue";
import { storeToRefs } from "pinia";
import { useRouter } from "vue-router";
import { useMemberStore } from "@/stores/member";
import VKakaoMap from "@/components/common/VKakaoMap.vue";
import { useTripStore } from "@/stores/trip";
import { useCourseStore } from "@/stores/course";
import { likeTrip } from "@/api/trip";

const memberStore = useMemberStore();
const { userInfo } = storeToRefs(memberStore);
const tripStore = useTripStore();
const courseStore = useCourseStore();
const { addCourse, setCourseList } = courseStore;

const router = useRouter();

const props = defineProps({
  show: Boolean,
  type: String,
  trip: Object,
});

const tripLike = ref({
  idx: "",
  tripinfoIdx: "",
  userId: "",
  createDate: "",
});

const select = ref(tripStore.selectTrip);

watch(
  () => props.show,
  () => console.log("select : " + tripStore.selectTrip.placeName)
);

const emit = defineEmits(["closeModal"]);
const onClickCloseModal = () => {
  emit("closeModal");
};

// 코스짜는 페이지로 이동
const goWriteCourse = () => {
  router.replace({ name: "course" });
  setCourseList([]); // 코스리스트 초기화
  onAddCourse();
};

// 코스에 추가하기
const onAddCourse = () => {
  addCourse(tripStore.selectTrip);
  onClickCloseModal();
};

// 여행지 찜하기
const clickLike = () => {
  tripLike.value.userIdx = userInfo.value.idx;
  tripLike.value.tripinfoIdx = tripStore.selectTrip.idx;
  likeTrip(
    tripLike.value,
    () => {
      console.log("여행지 찜하기 완료");
    },
    (error) => console.log(error)
  );
};
</script>

<template>
  <div class="modalContainer" v-if="show">
    <div class="modalBody" @click.stop>
      <img
        src="@/assets/img/icon_close.png"
        alt=""
        class="btn-close-modal"
        @click="onClickCloseModal"
      />
      <div class="tripinfo-modal-container">
        <div class="left">
          <div class="title-box">
            <div class="detail-title">{{ tripStore.selectTrip.title }}</div>
            <div class="detail-type">{{ tripStore.selectTrip.categoryName }}</div>
          </div>
          <div class="place-name-box">
            <div class="detail-place-name">{{ tripStore.selectTrip.placeName }}</div>
            <div class="detail-place-like-hit">
              <div class="hit">
                <img src="@/assets/img/icon_view.png" alt="" />{{ tripStore.selectTrip.viewCount }}
              </div>
              <div class="like">
                <img src="@/assets/img/icon_heart.png" alt="" />{{ tripStore.selectTrip.likeCount }}
              </div>
            </div>
          </div>
          <div class="detail-place-category">{{ tripStore.selectTrip.type }}</div>
          <div class="detail-desc">
            {{ tripStore.selectTrip.desc }}
          </div>
          <div class="detail-info-box">
            <div class="detail-info">
              <span>운영시간</span>
              <span class="detail-info-right">{{ tripStore.selectTrip.operTime }}</span>
            </div>
            <div class="detail-info">
              <span>휴식시간</span>
              <span class="detail-info-right">{{ tripStore.selectTrip.restTime }}</span>
            </div>
            <div class="detail-info">
              <span>휴무일 안내</span>
              <span class="detail-info-right">{{ tripStore.selectTrip.restdateContent }}</span>
            </div>
            <div class="detail-info">
              <span>전화번호</span>
              <span class="detail-info-right">{{ tripStore.selectTrip.tel }}</span>
            </div>
            <div class="detail-info">
              <span>주소</span>
              <span class="detail-info-right">{{ tripStore.selectTrip.address }}</span>
            </div>
          </div>
          <div class="button-wrap">
            <button v-if="props.type === 'trip'" @click="goWriteCourse">여행코스 만들기</button>
            <button v-else @click="addCourse">추가하기</button>
            <button @click="clickLike">
              찜하기
              <img src="@/assets/img/icon_heart.png" alt="" />
            </button>
          </div>
        </div>
        <div v-if="select" class="right">
          <VKakaoMap />
          <div class="comment-title">Comments</div>
          <div class="comment-box">
            <div class="comments">
              <div class="userName">예핑고</div>
              <div class="comment-content">드라마 정주행 다시 하고 싶어졌어요 ㅎㅎ</div>
            </div>
            <div class="comments">
              <div class="userName">박핑가핑가</div>
              <div class="comment-content">
                드라마 정주행 다시 하고 싶어졌어요 ㅎㅎ드라마 정주행 다시 하고 싶어졌어요 ㅎㅎ드라마
                정주행 다시 하고 싶어졌어요 ㅎㅎ드라마 정주행 다시 하고 싶어졌어요 ㅎㅎ
              </div>
            </div>
            <div class="comments">
              <div class="userName">박핑가핑가</div>
              <div class="comment-content">
                드라마 정주행 다시 하고 싶어졌어요 ㅎㅎ드라마 정주행 다시 하고 싶어졌어요 ㅎㅎ드라마
                정주행 다시 하고 싶어졌어요 ㅎㅎ드라마 정주행 다시 하고 싶어졌어요 ㅎㅎ
              </div>
            </div>
          </div>
          <form action="" id="form-detail-comment">
            <input type="text" placeholder="댓글 달기.." id="input-detail-comment" />
            <button type="button" id="btn-comment-trip">등록</button>
          </form>
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/trip/tripModal.scss";
</style>
