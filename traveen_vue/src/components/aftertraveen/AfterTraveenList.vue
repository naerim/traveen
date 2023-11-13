<script setup>
import AfterTraveenListItem from "@/components/aftertraveen/item/AfterTraveenListItem.vue";
</script>

<template>
  <article>
    <h1 class="title">애프터 트래빈</h1>
    <div class="subtitle">
      나의 여행 코스가 마음에 들었다면 후기를 통해 다른 사람들에게 공유해볼까요?
    </div>
    <div class="top-box">
      <div class="left">총 4건</div>
      <form class="right" id="form-search" action="#" method="post">
        <select name="select-notice" id="select-notice">
          <option value="">전체</option>
          <option value="subject">제목</option>
        </select>
        <input type="text" name="keyword" id="keyword" placeholder="검색어를 입력해주세요." />
        <input type="submit" id="btn-search" value="검색" />
      </form>
    </div>
    <div class="line"></div>
    <div class="content-box">
      <AfterTraveenListItem />
      <AfterTraveenListItem />
      <AfterTraveenListItem />
      <AfterTraveenListItem />
    </div>
  </article>
</template>

<style scoped>
article {
  padding-top: 40px;
}

.title {
  font-size: 2em;
  font-weight: 700;
  white-space: pre-line;
  margin: 0;
}
.subtitle {
  color: #8b95a1;
  margin-bottom: 40px;
}

.top-box {
  display: flex;
  justify-content: space-between;
  align-items: center;
  width: 100%;
  min-width: 1000px;
  margin-bottom: 10px;
}

.right select {
  height: 34px;
  border: 1px solid #e3e3e3;
  border-radius: 6px;
  width: 80px;
  box-sizing: border-box;
  padding: 4px;
}

.right input {
  box-sizing: border-box;
  height: 34px;
  border: none;
  border-bottom: 1px solid #e3e3e3;
  padding: 4px;
  padding-right: 10px;
  margin: 0 10px;
}

input[type="text"] {
  width: 200px;
}

input[type="submit"] {
  height: 34px;
  background-color: #51cd89;
  border-radius: 6px;
  color: #fff;
  border: none;
  cursor: pointer;
  padding: 0 16px;
}

.line {
  display: flex;
  align-items: flex-end;
  margin: 10px 0;
  height: 1px;
  background-color: #e3e3e3;
}

.content-box {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  gap: 60px 50px;
  margin-bottom: 20px;
}
</style>
