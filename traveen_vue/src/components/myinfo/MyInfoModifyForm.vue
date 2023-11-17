<script setup>
import { storeToRefs } from "pinia";
import { useRoute, useRouter } from "vue-router";
import { modifyUser } from "@/api/user";
import { useMemberStore } from "@/stores/member";

const memberStore = useMemberStore();
const { userInfo } = storeToRefs(memberStore);

const route = useRoute();
const router = useRouter();

const { userId } = route.params;

// const onUserModify = () => {
//   modifyUser(
//     user.value,
//     () => {
//       console.log(user.value);
//       alert("수정되었습니다.");
//       router.push({ name: "myinfo", params: { userId: userId } });
//     },
//     (error) => console.log(error)
//   );
// };
</script>

<template>
  <div class="top-box">
    <div class="subtitle">내 정보 수정</div>
    <button id="btn-modify-myinfo" @click="onUserModify">수정하기</button>
  </div>
  <div class="info-container">
    <form action="">
      <div class="input-title">아이디</div>
      <input type="text" id="userId" name="userId" v-model="userInfo.userId" readonly />
      <div class="input-title">이름</div>
      <input type="text" id="userName" name="userName" v-model="userInfo.userName" />
      <div class="input-title">이메일</div>
      <input type="text" id="emailId" name="emailId" v-model="userInfo.emailId" />
      <span>@</span>
      <select name="emailDomain" id="emailDomain" v-model="userInfo.emailDomain">
        <option value="naver.com">naver.com</option>
        <option value="google.com">google.com</option>
      </select>
      <div class="input-title">전화번호</div>
      <input type="text" id="mobile" name="mobile" v-model="userInfo.mobile" />
    </form>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/myinfo/myInfoModifyForm.scss";
</style>
