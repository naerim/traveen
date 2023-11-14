<script setup>
import { ref, watch, onMounted } from "vue";
import { registNotice, modifyNotice, detailNotice } from "@/api/notice";
import { useRoute, useRouter } from "vue-router";

const route = useRoute();
const router = useRouter();

const { idx } = route.params;
const props = defineProps({ type: String });

const isUseId = ref(false);

const notice = ref({
  idx: idx,
  userIdx: 1,
  title: "",
  content: "",
  createDate: "",
  viewCount: 0,
});

onMounted(() => {
  props.type === "modify" &&
    detailNotice(
      idx,
      ({ data }) => {
        notice.value = data;
      },
      (error) => console.log(error)
    );
});

if (props.type === "modify") {
  let { idx } = route.params;
  console.log(idx + "번글 얻어와서 수정할거야");
  // API 호출
  isUseId.value = true;
}

const subjectErrMsg = ref("");
const contentErrMsg = ref("");
watch(
  () => notice.value.title,
  (value) => {
    let len = value.length;
    if (len == 0 || len > 30) {
      subjectErrMsg.value = "제목을 확인해 주세요.";
    } else subjectErrMsg.value = "";
  },
  { immediate: true }
);
watch(
  () => notice.value.content,
  (value) => {
    let len = value.length;
    if (len == 0 || len > 500) {
      contentErrMsg.value = "내용을 확인해 주세요.";
    } else contentErrMsg.value = "";
  },
  { immediate: true }
);

// 글 등록 or 글 수정
function onSubmit(e) {
  e.preventDefault();
  if (subjectErrMsg.value) {
    alert(subjectErrMsg.value);
  } else if (contentErrMsg.value) {
    alert(contentErrMsg.value);
  } else {
    props.type === "write" ? writeArticle() : updateArticle();
  }
}

// 글 등록
function writeArticle() {
  // API 호출
  registNotice(
    notice.value,
    ({ data }) => {
      console.log(data);
      alert("공지사항이 등록되었습니다.");
      router.push({ name: "notice-list" });
      // currentPage.value = data.currentPage;
      // totalPage.value = data.totalPageCount;
    },
    (error) => console.log(error)
  );
}

// 글 수정
function updateArticle() {
  // API 호출
  modifyNotice(
    notice.value,
    () => {
      alert("수정되었습니다.");
      router.push({ name: "notice-detail", params: { idx: idx } });
      // currentPage.value = data.currentPage;
      // totalPage.value = data.totalPageCount;
    },
    (error) => console.log(error)
  );
}
</script>

<template>
  <div class="table-container">
    <form id="form-regist-notice" action="#" method="post">
      <div class="input-title">제목</div>
      <input
        type="text"
        placeholder="제목을 입력해주세요."
        id="input-subject"
        v-model="notice.title"
      />
      <div class="input-title">내용</div>
      <textarea
        v-model="notice.content"
        id="content"
        cols="30"
        rows="10"
        placeholder="내용을 입력해주세요."
      ></textarea>
      <div class="line-notice"></div>
      <div class="notice-two-btn-box">
        <input type="reset" value="초기화" id="btn-reset" />
        <input v-if="type == 'write'" type="button" value="등록" @click="onSubmit" />
        <input v-else type="button" value="수정" @click="onSubmit" />
      </div>
    </form>
  </div>
</template>

<style scoped>
@import "@/assets/scss/components/notice/item/noticeFormItem.scss";
</style>
