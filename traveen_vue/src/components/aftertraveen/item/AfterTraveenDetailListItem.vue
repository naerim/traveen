<script setup>
import noImage from "@/assets/img/no_image.jpeg";
</script>

<template>
  <li>
    <div class="num-wrap">
      <div class="num">1</div>
    </div>
    <div class="wrap">
      <div class="item-info">
        <img :src="noImage" alt="" />
        <div class="content">
          <div class="top-box">
            <span>레스토랑</span>
            <span id="drama">드라마</span>
          </div>
          <div class="name">라라무리</div>
          <div class="address">경기도 파주시 회동길 445-1sadfsdafsadfas</div>
        </div>
      </div>
      <div class="memo">후기</div>
    </div>
  </li>
</template>

<style scoped>
@import "@/assets/scss/components/aftertraveen/item/afterTraveenDetailListItem.scss";
</style>
