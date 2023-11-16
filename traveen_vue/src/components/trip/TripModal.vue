<script setup>
import { useRouter } from "vue-router";
import VKakaoMap from "@/components/common/VKakaoMap.vue";

const router = useRouter();

const props = defineProps({
  show: Boolean,
  type: String,
  trip: Object,
  selectDestination: Object,
  destinations: Array,
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
            <div class="detail-title">{{ props.trip.title }}</div>
            <div class="detail-type">{{ props.trip.categoryName }}</div>
          </div>
          <div class="place-name-box">
            <div class="detail-place-name">{{ props.trip.placeName }}</div>
            <div class="detail-place-like-hit">
              <div class="hit">
                <img src="@/assets/img/icon_view.png" alt="" />{{ props.trip.viewCount }}
              </div>
              <div class="like">
                <img src="@/assets/img/icon_heart.png" alt="" />{{ props.trip.likeCount }}
              </div>
            </div>
          </div>
          <div class="detail-place-category">{{ props.trip.type }}</div>
          <div class="detail-desc">
            {{ props.trip.desc }}
          </div>
          <div class="detail-info-box">
            <div class="detail-info">
              <span>운영시간</span>
              <span class="detail-info-right">{{ props.trip.operTime }}</span>
            </div>
            <div class="detail-info">
              <span>휴식시간</span>
              <span class="detail-info-right">{{ props.trip.restTime }}</span>
            </div>
            <div class="detail-info">
              <span>휴무일 안내</span>
              <span class="detail-info-right">{{ props.trip.restdateContent }}</span>
            </div>
            <div class="detail-info">
              <span>전화번호</span>
              <span class="detail-info-right">{{ props.trip.tel }}</span>
            </div>
            <div class="detail-info">
              <span>주소</span>
              <span class="detail-info-right">{{ props.trip.address }}</span>
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
        <div v-if="selectDestination" class="right">
          <VKakaoMap
            :destinations="props.destinations"
            :selectDestination="props.selectDestination"
          />
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
