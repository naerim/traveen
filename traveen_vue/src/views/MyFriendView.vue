<script setup>
import { shallowRef } from "vue";
import Follower from "../components/myfriend/Follower.vue";
import Following from "../components/myfriend/Following.vue";

const current = shallowRef(Follower);
const change = (val) => {
  current.value = val == "follower" ? Follower : Following;
};
</script>

<template>
  <div>나의 친구</div>
  <button @click="change('follower')">follower</button>
  <button @click="change('following')">following</button>
  <component :is="current"></component>
</template>

<style scoped></style>
