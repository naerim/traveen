<script setup>
import KakaoMapLine from "@/components/common/VKakaoMapLine.vue";
import AfterTraveenDetailListItem from "@/components/aftertraveen/item/AfterTraveenDetailListItem.vue";
import AfterTraveenCommentItem from "@/components/aftertraveen/item/AfterTraveenCommentItem.vue";
</script>

<template>
  <div class="info-wrap">
    <div class="title-wrap">
      <div class="title">내가 다녀왔던 아름다운 제주도</div>
      <div class="button-wrap">
        <button>삭제</button>
        <button>수정</button>
      </div>
    </div>

    <div class="profile-wrap">
      <img src="@/assets/img/img_profile.png" alt="" />
      <div class="name">김싸피</div>
      <button>팔로우</button>
    </div>

    <div class="line"></div>

    <div class="mid-wrap">
      <div class="left">
        <div class="left-item">
          <div class="left-text">여행일</div>
          <div class="left-content" id="date">2023-10-27 ~ 2023-10-27</div>
        </div>
        <div class="left-item">
          <div class="left-text">여행 후기 요약</div>
          <div class="left-content">
            다음번에 저주도를 가면 지금 이 코스 그대로 다시 가고 싶다. 너무 추천한다.
          </div>
        </div>
      </div>
      <div class="right">
        <KakaoMapLine :height="`${160}px`" />
      </div>
    </div>

    <div class="line"></div>

    <div class="content-wrap">
      <AfterTraveenDetailListItem />
      <AfterTraveenDetailListItem />
      <AfterTraveenDetailListItem />
    </div>
  </div>
  <div class="comments-wrap">
    <div class="comment-title">Comments</div>
    <div class="comment-content">
      <AfterTraveenCommentItem />
      <AfterTraveenCommentItem />
      <AfterTraveenCommentItem />
    </div>
    <div class="input-wrap">
      <input type="text" placeholder="댓글 달기.." />
      <button>등록</button>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/aftertraveen/afterTraveenDetail.scss";
</style>
