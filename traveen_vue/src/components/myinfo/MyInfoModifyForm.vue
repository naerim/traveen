<script setup>
import { ref, onMounted } from "vue";
import { storeToRefs } from "pinia";
import { useRoute, useRouter } from "vue-router";
import { modifyUser } from "@/api/user";
import { useMemberStore } from "@/stores/member";

const memberStore = useMemberStore();
const { userInfo } = storeToRefs(memberStore);

const user = ref({})

const route = useRoute();
const router = useRouter();

const { userId } = route.params;

onMounted(() => {
  // user.value = userInfo.value;
  user.value.userId = userInfo.value.userId;
  user.value.userName = userInfo.value.userName;
  user.value.emailId = userInfo.value.emailId;
  user.value.emailDomain = userInfo.value.emailDomain;
  user.value.mobile = userInfo.value.mobile;
});

const onUserModify = () => {
  modifyUser(
    user.value,
    () => {
      alert("수정되었습니다.");
      router.push({ name: "myinfo", params: { userId: userId } });

      // userInfo.value = user.value;
      userInfo.value.userId = user.value.userId;
      userInfo.value.userName = user.value.userName;
      userInfo.value.emailId = user.value.emailId;
      userInfo.value.emailDomain = user.value.emailDomain;
      userInfo.value.mobile = user.value.mobile;
    },
    (error) => console.log(error)
  );
};
</script>

<template>
  <div class="top-box">
    <div class="subtitle">내 정보 수정</div>
    <button id="btn-modify-myinfo" @click="onUserModify">수정하기</button>
  </div>
  <div class="info-container">
    <form action="">
      <div class="input-title">아이디</div>
      <input type="text" id="userId" name="userId" v-model="user.userId" readonly />
      <div class="input-title">이름</div>
      <input type="text" id="userName" name="userName" v-model="user.userName" />
      <div class="input-title">이메일</div>
      <input type="text" id="emailId" name="emailId" v-model="user.emailId" />
      <span>@</span>
      <select name="emailDomain" id="emailDomain" v-model="user.emailDomain">
        <option value="naver.com">naver.com</option>
        <option value="google.com">google.com</option>
      </select>
      <div class="input-title">전화번호</div>
      <input type="text" id="mobile" name="mobile" v-model="user.mobile" />
    </form>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/myinfo/myInfoModifyForm.scss";
</style>
