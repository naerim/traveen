<script setup></script>

<template>
  <footer>
    <div class="footer-container">
      <div>
        <img src="@/assets/ssafy_logo.png" alt="" />
      </div>
      <div id="footer-right">
        <p>이용약관 | 개인정보방침</p>
        <div>
          본 사이트의 콘텐츠는 저작권법의 보호를 받는 바 무단 전재, 복사, 배포 등을 금합니다.
        </div>
        <div>Copyright © SAMSUNG All Rights Reserved.</div>
      </div>
    </div>
  </footer>
</template>

<style scoped>
footer {
  display: flex;
  width: 100%;
  padding: 80px 0;
  background-color: #f9fbfc;
  color: #000000;
  font-size: 0.8em;
}

footer .footer-container {
  display: flex;
  width: 80%;
  max-width: 1200px;
  margin: 0 auto;
  align-items: center;
}

footer #footer-right {
  display: flex;
  flex-direction: column;
  margin-left: 40px;
}

footer #footer-right p {
  margin-bottom: 20px;
}
</style>
