<script setup>
import SearchFriendListItem from "@/components/myfriend/item/SearchFriendListItem.vue";
defineProps({
  show: Boolean,
});

const emit = defineEmits(["closeModal"]);
const onClickCloseModal = () => {
  emit("closeModal");
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
          <input type="text" placeholder="친구의 아이디나 이메일을 검색해보세요." />
          <button>검색</button>
        </div>
        <div class="searh-list-box">
          <SearchFriendListItem />
          <SearchFriendListItem />
          <SearchFriendListItem />
        </div>
      </div>
    </div>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/myfriend/addFriendModal.scss";
</style>
