<script setup>
import { ref } from "vue";
import { useRouter } from "vue-router";
import { join, idCheck, sendEmail } from "@/api/user";

const router = useRouter();

const joinUser = ref({
  userId: "",
  userName: "",
  emailId: "",
  emailDomain: "",
  emailCode: "",
  mobile: "",
  userPwd: "",
  pwdCheck: "",
  salt: "",
});

const emailCodeIsEqual = ref(false);
const idCheckState = ref(false);
const codeCheckState = ref(false);

const onIdCheck = (id) => {
  const blank_pattern = /[\s]/g;
  if (id === "") alert("아이디를 입력해주세요.");
  else if (blank_pattern.test(id)) alert("공백을 제거해주세요.");
  else {
    idCheck(
      id,
      ({ data }) => {
        if (data === "사용가능") {
          idCheckState.value = true;
          alert(id + "는 사용가능한 아이디입니다.");
        } else {
          idCheckState.value = false;
          alert("이미 존재하는 아이디입니다.");
        }
      },
      (error) => console.log(error)
    );
  }
};

const getEmailCode = () => {
  if (joinUser.value.emailId == "") {
    alert("이메일을 입력해주세요.");
  } else if (joinUser.value.emailDomain == "") {
    alert("이메일을 선택해주세요.");
  } else {
    sendEmail(
      joinUser.value.emailId + "@" + joinUser.value.emailDomain,
      ({ data }) => {
        alert("인증번호가 전송되었습니다.");
        joinUser.value.emailCode = data.key;
      },
      (error) => console.log(error)
    );
  }
};

const onCheckEmailCode = () => {
  const emailCode = document.getElementById("code").value;
  if (joinUser.value.emailCode == emailCode && joinUser.value.emailCode != "") {
    alert("이메일 인증이 완료되었습니다.");
    codeCheckState.value = true;
    emailCodeIsEqual.value = true;
  } else if (emailCode == "") {
    alert("인증번호를 입력해주세요.");
  } else {
    alert("인증번호가 일치하지 않습니다.");
    codeCheckState.value = false;
    emailCodeIsEqual.value = false;
  }
};

// 아이디 input 변경 감지하는 함수
const onIdChange = () => {
  idCheckState.value = false;
};

// 인증번호 input 변경 감지하는 함수
const onCodeChange = () => {
  codeCheckState.value = false;
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
  } else if (!emailCodeIsEqual.value) {
    alert("이메일 인증을 완료해주세요.");
  } else {
    join(
      joinUser.value,
      () => {
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
        <option value="">선택</option>
        <option value="naver.com">naver.com</option>
        <option value="google.com">gmail.com</option>
      </select>
      <button id="btn-send-code" @click.prevent="getEmailCode()">인증번호 받기</button>
    </div>
    <div class="input-title">인증번호</div>
    <div class="input-confirm-box">
      <input id="code" @input="onCodeChange" />
      <button id="btn-check-code" :disabled="codeCheckState" @click.prevent="onCheckEmailCode()">
        인증번호 확인
      </button>
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
