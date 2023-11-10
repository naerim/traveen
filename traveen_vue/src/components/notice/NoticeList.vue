<script setup></script>

<template>
  <div>공지사항 페이지</div>

  <!-- section -->
  <section>
    <h2 class="title">공지사항</h2>
    <h4 class="subtitle">Traveen의 공지사항을 확인해보세요.</h4>
    <!-- top-box -->
    <div class="top-box">
      <div class="left">총 4건</div>
      <form class="right" id="form-search" action="#" method="post">
        <select name="select-notice" id="select-notice">
          <option value="">전체</option>
          <option value="subject">제목</option>
        </select>
        <input type="text" name="keyword" id="keyword" placeholder="검색어를 입력해주세요." />
        <input type="submit" id="btn-search" value="검색" />
        <button id="btn-insert">글 등록</button>
      </form>
    </div>
    <div class="table-container">
      <!-- table -->
      <table>
        <!-- thead -->
        <thead>
          <tr>
            <th width="8%">NO.</th>
            <th width="67%">제목</th>
            <th width="15%">게시일</th>
            <th width="10%">조회수</th>
          </tr>
        </thead>
        <!-- tbody -->
        <tbody>
          <tr>
            <td>1</td>
            <td class="subject">
              <a href="./notice-detail.html">트래빈 전체 공지사항 입니다.</a>
            </td>
            <td>2023.11.01</td>
            <td>2</td>
          </tr>
          <tr>
            <td>2</td>
            <td class="subject">
              <a href="#">트래빈 전체 공지사항 입니다.</a>
            </td>
            <td>2023.11.01</td>
            <td>2</td>
          </tr>
          <tr>
            <td>1</td>
            <td class="subject">트래빈 전체 공지사항 입니다.</td>
            <td>2023.11.01</td>
            <td>2</td>
          </tr>
          <tr>
            <td>1</td>
            <td class="subject">트래빈 전체 공지사항 입니다.</td>
            <td>2023.11.01</td>
            <td>2</td>
          </tr>
        </tbody>
      </table>
    </div>
    <!-- pagination -->
    <div class="pagination-container">
      <div class="btn-prev">&#60;이전</div>
      <span class="divider"></span>
      <ul>
        <li>1</li>
        <li>2</li>
      </ul>
      <span class="divider"></span>
      <div class="btn-next">다음&#62;</div>
    </div>
  </section>
</template>

<style scoped></style>
