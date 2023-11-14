<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import VKakaoMap from "@/components/common/VKakaoMap.vue";

const router = useRouter();
const destinations = ref([]);
const selectDestination = ref([{ lat: 33.450701, lng: 126.570667, title: "라라무리" }]);

const props = defineProps({
  show: Boolean,
  type: String,
});

const emit = defineEmits(["closeModal"]);
const onClickCloseModal = () => {
  emit("closeModal");
};

// 코스짜는 페이지로 이동
const goWriteCourse = () => {
  router.replace({ name: "course" });
};

// 코스에 추가하기
const addCourse = () => {
  console.log("코스에 추가합니다.");
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
            <div class="detail-title">도깨비</div>
            <div class="detail-type">드라마</div>
          </div>
          <div class="place-name-box">
            <div class="detail-place-name">리라무리무리</div>
            <div class="detail-place-like-hit">
              <div class="hit"><img src="@/assets/img/icon_view.png" alt="" /> 10</div>
              <div class="like"><img src="@/assets/img/icon_heart.png" alt="" /> 20</div>
            </div>
          </div>
          <div class="detail-place-category">레스토랑</div>
          <div class="detail-desc">
            1회에서 이곳은 지은탁(김고은)이 도깨비에서 어린 소녀였을 때 사는 곳이기도 하다.
          </div>
          <div class="detail-info-box">
            <div>
              <span>운영시간</span>
              <span>매일 00시 - 24시</span>
            </div>
            <div>
              <span>휴식시간</span>
              <span>정보 없음</span>
            </div>
            <div>
              <span>휴식시간</span>
              <span>연중무휴</span>
            </div>
            <div>
              <span>전화번호</span>
              <span>25424073</span>
            </div>
            <div>
              <span>주소</span>
              <span>경기도 파주시 회동길 445-1</span>
            </div>
          </div>
          <div class="button-wrap">
            <button v-if="props.type === 'trip'" @click="goWriteCourse">여행코스 만들기</button>
            <button v-else @click="addCourse">추가하기</button>
            <button>
              찜하기
              <img src="@/assets/img/icon_heart.png" alt="" />
            </button>
          </div>
        </div>
        <div class="right">
          <VKakaoMap :destinations="destinations" :selectDestination="selectDestination" />
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
