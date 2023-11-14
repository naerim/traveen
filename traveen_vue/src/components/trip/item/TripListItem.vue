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
        <div class="category">{{ trip.categoryName }}</div>
      </div>
    </div>
    <div class="place_name">{{ trip.placeName }}</div>
    <div class="desc">
      {{ trip.desc }}
    </div>
    <div class="bottom-box">
      <div class="hit"><img src="@/assets/img/icon_view.png" alt="" /> 10</div>
      <div class="like"><img src="@/assets/img/icon_heart.png" alt="" /> 20</div>
    </div>
  </div>
</template>

<style scoped>
.item {
  display: flex;
  flex-direction: column;
  border-radius: 12px;
  background: #fff;
  box-shadow: 0px 12px 40px 0px rgba(112, 144, 176, 0.2);
  cursor: pointer;
  transition: all 0.2s linear;
}

.item:hover {
  transform: scale(1.03);
}

.imgDiv {
  width: 200px;
  height: 200px;
  margin: 0 auto;
  transform: translateY(-15px);
}

.imgDiv img {
  width: 100%;
  height: 100%;
}

.tag-box {
  display: flex;
  justify-content: space-between;
  width: 190px;
  margin: 0 auto;
  align-items: center;
}

.tag-box .left {
  font-size: 0.8em;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
  width: 80px;
}

.tag-box .right {
  display: flex;
  font-size: 0.7em;
  color: #fff;
}

.tag-box .right .type {
  background-color: #1f1f1f;
  padding: 2px 4px;
  border-radius: 4px;
}

.tag-box .right .category {
  background-color: #eb635b;
  padding: 2px 4px;
  border-radius: 4px;
  margin-left: 6px;
}

.place_name {
  width: 190px;
  margin: 0 auto;
  font-weight: bold;
  font-size: 1em;
  margin-bottom: 6px;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}

.desc {
  width: 190px;
  margin: 0 auto;
  font-size: 0.8em;
  color: #6b7684;
  text-overflow: ellipsis;
  overflow: hidden;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  -webkit-line-clamp: 3;
  min-height: 50px;
}

.bottom-box {
  display: flex;
  justify-content: flex-end;
  width: 190px;
  align-items: center;
  box-sizing: border-box;
  font-size: 0.8em;
  margin: 10px auto;
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
</style>
