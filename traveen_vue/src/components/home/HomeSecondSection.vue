<script setup>
import { useRouter } from "vue-router";

const router = useRouter();

const goAfterTraveenPage = () => router.push({ name: "aftertraveen-list" });
</script>

<template>
  <div class="container">
    <div class="title">ABOUT TRAVEEN</div>
    <div class="content">
      <div class="introduce">
        여행은 삶에 새로운 활력을 불어넣는 특별한 경험입니다. 우리는 여행이라는 특별한 순간을 누릴
        수 있는 공간을 만들었습니다. 트래빈은 여러분이 촬영지에서 만나는 아름다움을 더욱 감각적이고
        특별하게 느낄 수 있도록 도와드립니다.
      </div>
      <div class="introduce">
        트래빈에서는 여행 후기를 나누고, 다양한 코스를 공유하는 플랫폼을 제공합니다. 여러분의 여행이
        특별하고 기억에 남는 순간으로 가득 차기를 바라며, 새로운 여정이 여러분을 기다리고 있습니다.
      </div>
    </div>
    <div class="bg-wrap" @click="goAfterTraveenPage">
      <div class="line"></div>
      <span>애프터 트래빈</span>
      <img src="@/assets/img/icon_right_arrow.png" alt="" />
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/home/homeSecondSection.scss";
</style>
