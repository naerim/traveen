<script setup>
const emit = defineEmits(["clickItem"]);

const onClickItem = () => {
  emit("clickItem");
};

defineProps({
  trip: Object,
});
</script>

<template>
  <div class="item" @click="onClickItem">
    <div class="imgDiv">
      <img src="@/assets/img/img_tripinfo.png" alt="" />
    </div>
    <div class="tag-box">
      <div class="left">{{ trip.title }}</div>
      <div class="right">
        <div class="type">{{ trip.type }}</div>
        <div :class="[category, trip.categoryName]">{{ trip.categoryName }}</div>
        <!-- <div class="category drama">{{ trip.categoryName }}</div> -->
      </div>
    </div>
    <div class="place_name">{{ trip.placeName }}</div>
    <div class="desc">
      {{ trip.desc }}
    </div>
    <div class="bottom-box">
      <div class="hit"><img src="@/assets/img/icon_view.png" alt="" /> {{ trip.viewCount }}</div>
      <div class="like"><img src="@/assets/img/icon_heart.png" alt="" /> {{ trip.likeCount }}</div>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/trip/item/tripListItem.scss";
</style>
