<script setup>
import noImage from "@/assets/img/no_image.jpeg";

const props = defineProps({
  index: Number,
  trip: Object,
});
</script>

<template>
  <li>
    <div class="num-wrap">
      <div class="num">{{ index }}</div>
    </div>
    <div class="wrap">
      <div class="item-info">
        <img :src="props.trip.image || noImage" alt="" />
        <div class="content">
          <div class="top-box">
            <span>{{ props.trip.type }}</span>
            <span :id="props.trip.categoryName">{{ props.trip.categoryName }}</span>
          </div>
          <div class="name">{{ props.trip.placeName }}</div>
          <div class="address">{{ props.trip.address }}</div>
        </div>
      </div>
      <textarea
        name=""
        id=""
        cols="30"
        rows="10"
        placeholder="후기를 작성해주세요."
        v-model="props.trip.content"
      ></textarea>
    </div>
  </li>
</template>

<style scoped>
@import "@/assets/scss/components/aftertraveen/item/aftertraveenRightListItem.scss";
</style>
