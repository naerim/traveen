<script setup></script>

<template>
  <section>
    <h2>고객센터</h2>
    <div class="center-menu-wrap">
      <router-link :to="{ name: 'notice' }">공지사항</router-link>
      <router-link :to="{ name: 'qna-list' }">QnA</router-link>
    </div>
  </section>
</template>

<style scoped>
section {
  width: 80%;
  max-width: 1000px;
  margin: 0 auto;
  padding-top: 70px;
}

h2 {
  font-size: 2em;
  font-weight: 700;
}

.center-menu-wrap {
  margin-bottom: 40px;
}

a {
  color: #6b7684;
  background-color: #f7f8fa;
  padding: 8px 25px;
  border-radius: 16px;
  margin-right: 20px;
}

.router-link-active,
a:hover {
  color: #fff;
  background-color: var(--tv-c-green);
  padding: 8px 25px;
}
</style>
