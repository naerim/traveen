<script setup>
import { ref, onMounted } from "vue";

const show = ref(false);

const props = defineProps({ friend: Object });

onMounted(() => {
  console.log(props.friend);
});
</script>

<template>
  <div class="item-container">
    <img src="@/assets/img/icon_vertical_menu.png" alt="" id="img-menu" />
    <img src="@/assets/img/img_profile.png" alt="" id="img-profile" />
    <div class="userName"></div>
    <div class="userId"></div>
    <div v-show="show" id="menu">
      <ul>
        <li>친구 정보</li>
        <li>삭제</li>
      </ul>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/myfriend/item/friendListItem.scss";
</style>
