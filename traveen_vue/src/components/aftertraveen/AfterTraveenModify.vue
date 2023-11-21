<script setup>
import AfterTraveenLeftForm from "@/components/aftertraveen/item/AfterTraveenLeftForm.vue";
import AfterTraveenRightFormVue from "@/components/aftertraveen/item/AfterTraveenRightForm.vue";
</script>

<template>
  <article>
    <h2>여행 후기 수정</h2>
    <h5>나의 여행 코스가 마음에 들었다면 후기를 통해 다른 사람들에게 공유해볼까요?</h5>
    <div class="container">
      <AfterTraveenLeftForm />
      <AfterTraveenRightFormVue />
    </div>
    <div class="btn-container">
      <button>취소</button>
      <button>수정하기</button>
    </div>
  </article>
</template>

<style scoped>
@import "@/assets/scss/components/aftertraveen/afterTraveenModify.scss";
</style>
