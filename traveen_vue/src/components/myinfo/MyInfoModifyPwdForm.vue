<script setup>
import { ref, onMounted } from "vue";
import { storeToRefs } from "pinia";
import { useRouter } from "vue-router";
import { useMemberStore } from "@/stores/member";
import { modifyPwd } from "@/api/user";

const memberStore = useMemberStore();
const { userInfo } = storeToRefs(memberStore);
const router = useRouter();

const param = ref({
  userId: "",
  userPwd: "",
  newPwd: "",
});

onMounted(() => {
  param.value.userId = userInfo.value.userId;
  param.value.userPwd = userInfo.value.userPwd;
  console.log(userInfo.value);
});

const modifyUserPwd = () => {
  const pwdCheck = document.getElementById("pwdChk").value;
  const userPwd = document.getElementById("cPwd").value;

  if (userPwd === "") alert("비밀번호를 입력해주세요.");
  else if (param.value.newPwd === "") alert("변경할 비밀번호를 입력해주세요.");
  else if (pwdCheck === "") alert("비밀번호 확인을 입력해주세요.");
  else if (param.value.newPwd !== pwdCheck) alert("비밀번호가 일치하지 않습니다.");
  else {
    modifyPwd(
      param.value, () => {
        alert("비밀번호가 변경되었습니다.");
        userInfo.value.userPwd = param.value.newPwd;
        router.go(0);
      },
      (error) => console.log(error)
      );
    } 
};

</script>

<template>
  <div class="top-box">
    <div class="subtitle">비밀번호 변경</div>
    <button id="btn-modify-pwd" @click="modifyUserPwd">변경하기</button>
  </div>
  <div class="pwd-container">
    <form action="">
      <div class="input-title">현재 비밀번호</div>
      <input type="password" id="cPwd" name="cPwd" />
      <div class="pwd-bottom-box">
        <div class="left">
          <div class="input-title">바꿀 비밀번호</div>
          <input type="password" id="userPwd" name="userPwd" v-model="param.newPwd"/>
        </div>
        <div class="right">
          <div class="input-title">비밀번호 확인</div>
          <input type="password" id="pwdChk" name="pwdChk" />
        </div>
      </div>
    </form>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/myinfo/myInfoModifyPwdForm.scss";
</style>
