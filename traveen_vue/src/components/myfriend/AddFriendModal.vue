<script setup>
import { ref } from "vue";
import {listUser} from "@/api/user";
import SearchFriendListItem from "@/components/myfriend/item/SearchFriendListItem.vue";
import VEmptyItem from "@/components/common/VEmptyItem.vue";
defineProps({
  show: Boolean,
});

const users = ref([]);
const len = ref(0);
const param = ref({
  word: "",
});

const searchUser = () => {
  if (param.value.word == "") {
    alert("아이디 혹은 이메일을 입력해주세요.");
  } else {
    getUserList();
  }
};

const getUserList = () => {
  // API 호출
  listUser(
    param.value,
    ({ data }) => {
      users.value = data;
      console.log(users);
    },
    (error) => console.log(error)
  );

  len.value = users.value.length;
};

const emit = defineEmits(["closeModal"]);
const onClickCloseModal = () => {
  emit("closeModal");
  param.value.word = "";
  users.value = "";
};
</script>

<template>
  <div class="modalContainer" v-if="show">
    <div class="modalBody" @click.stop>
      <img
        src="@/assets/img/icon_close.png"
        alt=""
        class="btn-close-modal"
        @click="onClickCloseModal"
      />
      <div class="add-friend-modal-container">
        <div class="modal-top">
          <img src="@/assets/img/icon_plus_friend.png" alt="" />
          <h4>친구 추가</h4>
        </div>
        <div class="line"></div>
        <div class="input-box">
          <input type="text" placeholder="친구의 아이디나 이메일을 검색해보세요." v-model="param.word"/>
          <button @click="searchUser">검색</button>
        </div>
        <div v-if="len !== 0" class="searh-list-box">
          <SearchFriendListItem v-for="user in users" :key="user.idx" :user="user"/>
        </div>
        <div v-else class="searh-list-box">
          <VEmptyItem text="해당 회원이 존재하지 않습니다." />
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/myfriend/addFriendModal.scss";
</style>
