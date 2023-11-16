<script setup>
import { ref, onMounted } from "vue";
import { useRoute, useRouter } from "vue-router";
import { detailUser, modifyUser } from "@/api/user";

// 임시 아이디
const loginId = "admin";
const user = ref({
  userName: "",
  emailId: "",
  emailDomain: "",
  mobile: "",
});

const route = useRoute();
const router = useRouter();

const { userId } = route.params;

onMounted(() => {
  getUser();
});

const getUser = () => {
  detailUser(
    loginId,

    ({ data }) => {
      user.value = data;
      console.log(user.value);
    },
    (error) => console.log(error)
  );
};

const onUserModify = () => {
  modifyUser(
    user.value,
    () => {
      console.log(user.value);
      alert("수정되었습니다.");
      router.push({ name: "myinfo", params: { userId: userId } });
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
