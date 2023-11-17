<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { join, idCheck } from "@/api/user";

const router = useRouter();

const joinUser = ref({
  userId: "",
  userName: "",
  emailId: "",
  emailDomain: "naver.com",
  emailCode: "1234",
  mobile: "",
  userPwd: "",
  pwdCheck: "",
  salt: "",
});
const idCheckState = ref(false);

const onIdCheck = (id) => {
  const blank_pattern = /[\s]/g;
  if (id === "") alert("아이디를 입력해주세요.");
  else if (blank_pattern.test(id)) alert("공백을 제거해주세요.");
  else {
    idCheck(
      id,
      ({ data }) => {
        console.log(data);
        if (data === "사용가능") {
          idCheckState.value = true;
          alert(id + "는 사용가능한 아이디입니다.");
        } else {
          alert("이미 존재하는 아이디입니다.");
        }
      },
      (error) => console.log(error)
    );
  }
};

// 아이디 input 변경 감지하는 함수
const onIdChange = () => {
  idCheckState.value = false;
};

const onSubmit = () => {
  const blank_pattern = /[\s]/g;
  if (!idCheckState.value) {
    alert("아이디 중복 확인이 필요합니다.");
  } else if (blank_pattern.test(joinUser.value.userName)) {
    alert("이름을 입력해주세요.");
  } else if (blank_pattern.test(joinUser.value.emailId)) {
    alert("이메일을 입력해주세요.");
  } else if (blank_pattern.test(joinUser.value.mobile)) {
    alert("전화번호를 입력해주세요.");
  } else if (blank_pattern.test(joinUser.value.userPwd)) {
    alert("비밀번호를 입력해주세요.");
  } else if (joinUser.value.userPwd !== joinUser.value.pwdCheck) {
    alert("비밀번호가 일치하지 않습니다.");
  } else {
    join(
      joinUser.value,
      ({ data }) => {
        console.log(data);
        alert("회원가입이 완료되었습니다.");
        router.push({ name: "login" });
      },
      (error) => console.log(error)
    );
  }
};
</script>

<template>
  <form class="input-box" id="form-join" method="post" @submit.prevent="onSubmit">
    <div class="input-title">아이디</div>
    <div class="input-id-box">
      <input
        placeholder="아이디를 입력해주세요."
        id="userId"
        v-model="joinUser.userId"
        @input="onIdChange"
      />
      <button
        type="button"
        id="btn-check-id"
        :disabled="idCheckState"
        @click.prevent="onIdCheck(joinUser.userId)"
      >
        중복 확인
      </button>
    </div>
    <div class="input-title">이름</div>
    <input
      class="input-default"
      placeholder="이름을 입력해주세요."
      id="userName"
      v-model="joinUser.userName"
    />
    <div class="input-title">이메일</div>
    <div class="input-email-box">
      <input
        type="text"
        placeholder="이메일을 입력해주세요."
        id="emailId"
        v-model="joinUser.emailId"
      />
      <span>@</span>
      <select name="emailDomain" id="emailDomain" v-model="joinUser.emailDomain">
        <option value="naver.com">naver.com</option>
        <option value="google.com">google.com</option>
      </select>
      <button id="btn-send-code" @click.prevent="">인증번호 받기</button>
    </div>
    <div class="input-title">인증번호</div>
    <div class="input-confirm-box">
      <input id="code" v-model="joinUser.code" />
      <button id="btn-check-code" @click.prevent="">인증번호 확인</button>
    </div>
    <div class="input-title">전화번호</div>
    <input
      class="input-default"
      placeholder="전화번호를 입력해주세요."
      id="mobile"
      v-model="joinUser.mobile"
    />
    <div class="input-title">비밀번호</div>
    <input
      type="password"
      class="input-default"
      placeholder="비밀번호를 입력해주세요."
      id="userPwd"
      v-model="joinUser.userPwd"
    />
    <div class="input-title">비밀번호 확인</div>
    <input
      type="password"
      class="input-default"
      placeholder="비밀번호를 확인해주세요."
      id="pwdCheck"
      v-model="joinUser.pwdCheck"
    />
    <input type="submit" id="btn-join" value="가입하기" />
  </form>
</template>

<style scoped>
@import "@/assets/scss/components/join/joinForm.scss";
</style>
