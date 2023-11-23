<script setup>
import { computed, onMounted } from "vue";
import MyInfoModifyForm from "@/components/myinfo/MyInfoModifyForm.vue";
import MyInfoModifyPwdForm from "@/components/myinfo/MyInfoModifyPwdForm.vue";
import { useMemberStore } from "@/stores/member";
import { useFriendStore } from "@/stores/friend";
import { listFollower } from "@/api/friend";

const memberStore = useMemberStore();
const userInfo = computed(() => memberStore.userInfo);

const friendStore = useFriendStore();

const { setFollowerList } = friendStore;

onMounted(() => {
  getFollowerList();
});

const getFollowerList = () => {
  listFollower(
    userInfo.value.idx,
    ({ data }) => {
      setFollowerList(data);
    },
    (error) => console.log(error)
  );
};
</script>

<template>
  <h2>나의 정보</h2>
  <MyInfoModifyForm />
  <MyInfoModifyPwdForm />
</template>

<style scoped>
@import "@/assets/scss/views/myInfoView.scss";
</style>
