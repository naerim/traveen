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
.modalContainer {
  position: fixed; /* Stay in place */
  z-index: 1000; /* Sit on top */
  padding-top: 180px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

.modalContent {
  display: flex;
}

.modalBody {
  position: relative;
  display: flex;
  width: 1000px;
  height: 500px;
  padding: 30px 30px;
  margin: 0 auto;
  background-color: #fff;
  border-radius: 12px;
}

.modalBody .btn-close-modal {
  position: absolute;
  top: 10px;
  right: 10px;
  cursor: pointer;
  width: 36px;
  height: 36px;
}

.tripinfo-modal-container {
  display: flex;
  justify-content: space-around;
  width: 100%;
  padding: 30px;
}

.tripinfo-modal-container .left {
  display: flex;
  flex-direction: column;
  width: 46%;
  box-sizing: border-box;
}

.title-box {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.detail-title {
  color: #6b7684;
  font-size: 1em;
}

.detail-type {
  background-color: #eb635b;
  color: #fff;
  border-radius: 4px;
  padding: 3px 6px;
  font-size: 0.6em;
}

.place-name-box {
  display: flex;
  justify-content: space-between;
  margin-top: 10px;
}

.detail-place-name {
  font-weight: bold;
  font-size: 1.4em;
}

.detail-place-like-hit {
  display: flex;
  align-items: flex-end;
}

.hit {
  display: flex;
  align-items: center;
}

.like {
  display: flex;
  align-items: center;
}

.hit img {
  width: 14px;
  height: 14px;
  margin-right: 2px;
}

.like img {
  width: 10px;
  height: 10px;
  margin-left: 6px;
  margin-right: 2px;
}

.detail-place-category {
  font-size: 0.9em;
  margin-top: 20px;
}

.detail-desc {
  margin-top: 6px;
  color: #8b95a1;
}

.detail-info-box {
  margin-top: 20px;
}

.detail-info-box div {
  font-size: 0.9em;
}

.detail-info-box div span:first-child {
  display: inline-block;
  color: #61676f;
  width: 80px;
}

.button-wrap {
  display: flex;
  margin-top: auto;
}

.button-wrap button {
  display: flex;
  align-items: center;
  height: 40px;
  border: none;
  border-radius: 6px;
  cursor: pointer;
  padding: 4px 20px;
}

.button-wrap button:first-child {
  background-color: #51cd89;
  color: #fff;
  padding: 4px 20px;
}

.button-wrap button:last-child {
  background-color: #f7f8fa;
  color: #6b7684;
  margin-left: 20px;
  border: 1px solid #ddd;
}

.button-wrap button img {
  width: 10px;
  height: 10px;
  margin-left: 10px;
}

.tripinfo-modal-container .right {
  display: flex;
  flex-direction: column;
  box-sizing: border-box;
  width: 40%;
  height: 100%;
}

.comment-title {
  font-weight: bold;
  margin: 20px 0 10px 0;
}

.comment-box {
  display: flex;
  flex-direction: column;
  height: 110px;
  overflow-y: scroll;
}

.comments {
  display: flex;
  font-size: 0.8em;
  margin-bottom: 4px;
}

.comments .userName {
  color: #61676f;
  font-weight: bold;
  margin-right: 1%;
  width: 20%;
}

.comments .comment-content {
  width: 79%;
}

#form-detail-comment {
  margin-top: auto;
}

#form-detail-comment input {
  background-color: #f2f4f6;
  border: 1px solid #ddd;
  height: 40px;
  padding: 4px;
  border-radius: 6px;
  box-sizing: border-box;
  width: 60%;
}

#form-detail-comment input::placeholder {
  color: #6b7684;
}

#form-detail-comment button {
  height: 40px;
  width: 60px;
  border-radius: 6px;
  border: none;
  background-color: #51cd89;
  color: #fff;
  cursor: pointer;
}

#btn-comment-trip {
  margin-left: 10px;
}
</style>
