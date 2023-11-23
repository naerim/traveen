<script setup>
import noImage from "@/assets/img/no_image.jpeg";

const props = defineProps({
  trip: Object,
});
</script>

<template>
  <li>
    <div class="num-wrap">
      <div class="num">{{ props.trip.order }}</div>
    </div>
    <div class="wrap">
      <div class="item-info">
        <img :src="props.trip.image || noImage" alt="" />
        <div class="content">
          <div class="top-box">
            <span>{{ props.trip.type }}</span>
            <span id="drama">{{ props.trip.categoryName }}</span>
          </div>
          <div class="name">{{ props.trip.placeName }}</div>
          <div class="address">{{ props.trip.address }}</div>
        </div>
      </div>
      <div class="memo">{{ props.trip.content }}</div>
    </div>
  </li>
</template>

<style scoped>
@import "@/assets/scss/components/aftertraveen/item/afterTraveenDetailListItem.scss";
</style>
