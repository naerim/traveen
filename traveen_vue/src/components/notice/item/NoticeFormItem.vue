<script setup>
import { ref, watch } from "vue";
import { useRoute, useRouter } from "vue-router";

const router = useRouter();
const route = useRoute();

const props = defineProps({ type: String });

const isUseId = ref(false);

const notice = ref({
  idx: 0,
  user_idx: 0,
  title: "",
  content: "",
  create_date: "",
  view_count: 0,
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
  console.log("글등록하자!!", notice.value);
  // API 호출
}

// 글 수정
function updateArticle() {
  console.log(notice.value.idx + "번글 수정하자!!", notice.value);
  // API 호출
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
.table-container {
  display: flex;
  flex-direction: column;
  border: 1px solid #e3e3e3;
  box-sizing: border-box;
  width: 100%;
  height: 720px;
  padding: 34px;
  min-width: 1000px;
  border-radius: 6px;
}

.input-title {
  margin-bottom: 8px;
}

#input-subject {
  width: 100%;
  height: 40px;
  border: 1px solid #dadee2;
  box-sizing: border-box;
  padding: 4px;
  border-radius: 6px;
  margin-bottom: 20px;
}

textarea {
  width: 100%;
  resize: none;
  border: 1px solid #dadee2;
  padding: 4px;
  border-radius: 6px;
  height: 440px;
  box-sizing: border-box;
  white-space: pre-wrap;
}

.line-notice {
  display: flex;
  align-items: flex-end;
  margin-top: 30px;
  height: 1px;
  background-color: #e3e3e3;
}

.notice-two-btn-box {
  display: flex;
  padding: 20px 0;
  justify-content: flex-end;
}

.notice-two-btn-box input[type="reset"] {
  background-color: #fff;
  border: 1px solid #e3e3e3;
  height: 30px;
  width: 80px;
  cursor: pointer;
}

.notice-two-btn-box input[type="button"] {
  margin-left: 10px;
  background-color: #51cd89;
  border: 1px solid #51cd89;
  color: #fff;
  height: 30px;
  width: 80px;
  cursor: pointer;
}
</style>
