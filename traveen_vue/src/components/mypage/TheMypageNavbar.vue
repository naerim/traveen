<script setup>
import { computed } from "vue";
import { storeToRefs } from "pinia";
import { useRouter } from "vue-router";
import { useMemberStore } from "@/stores/member";
import { useFriendStore } from "@/stores/friend";
import { deleteUser } from "@/api/user";

const friendStore = useFriendStore();
const followerCount = computed(() => friendStore.followerCount);

const router = useRouter();
const memberStore = useMemberStore();
const { userLogout } = memberStore;
const { userInfo, isLogin } = storeToRefs(memberStore);

const logout = async () => {
  router.push("/");
  await userLogout(userInfo.value.userId);
  if (isLogin) {
    sessionStorage.clear();
    alert("로그아웃 되었습니다.");
  }
};

const removeUser = () => {
  deleteUser(
    userInfo.value.userId,
    () => {
      sessionStorage.clear();
      userInfo.value = "";
      alert("회원탈퇴가 완료되었습니다.");
      router.push("/");
    },
    (error) => console.log(error)
  );
};
</script>

<template>
  <aside>
    <div class="aside-container">
      <!-- profile -->
      <div class="profile-box">
        <img src="@/assets/img/img_profile.png" alt="" id="profile-img" name="profile-img" />
        <div class="btn-select-profile">
          <img src="@/assets/img/icon_plus.png" alt="" />
        </div>
      </div>
      <!-- name -->
      <div id="user_name">{{ userInfo.userName }}</div>
      <!-- follower -->
      <div id="follower">팔로워 {{ followerCount }}</div>
      <ul class="menu">
        <li><router-link :to="{ name: 'myinfo' }">나의 정보</router-link></li>
        <li><router-link :to="{ name: 'mytrip' }">나의 여행</router-link></li>
        <li><router-link :to="{ name: 'myactive' }">나의 활동</router-link></li>
        <li><router-link :to="{ name: 'myfriend' }">나의 친구</router-link></li>
      </ul>
      <!-- line -->
      <div class="line"></div>
      <!-- link-box -->
      <div class="link-box">
        <a href="#" @click="logout">로그아웃</a>
        <a href="#" @click="removeUser">회원탈퇴</a>
      </div>
    </div>
    <div class="bottom-logo">Traveen</div>
  </aside>
</template>

<style scoped>
@import "@/assets/scss/components/mypage/theMypageNavbar.scss";
</style>
