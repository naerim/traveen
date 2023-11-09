<script setup>
import TheHeadingNavbar from "@/components/layout/TheHeadingNavbar.vue";
</script>

<template>
  <div>공지사항 페이지</div>
  <the-heading-navbar></the-heading-navbar>

  <!-- section -->
	<section>
		<h2 class="title">공지사항</h2>
		<h4 class="subtitle">Traveen의 공지사항을 확인해보세요.</h4>
		<!-- top-box -->
		<div class="top-box">
			<div class="left">총 ${totalCnt}건</div>
			<form class="right" id="form-search" method="get">
				<input type="hidden" name="pgno" value="1" />
				<select
					name="key" id="key">
					<option value="">전체</option>
					<option value="title">제목</option>
				</select> <input type="text" name="word" id="word"
					placeholder="검색어를 입력해주세요." />
					<button id="btn-search" type="button">검색</button>
				<button type="button" id="btn-regist" style="<c:if test="${userinfo.position ne M}">display: none</c:if>">글 등록</button>
				
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

					<c:if test="${not empty notices}">
						<c:forEach var="notice" items="${notices}" varStatus="status">
							<tr>
								<td>${fn:length(notices) - status.index}</td>
									<td class="subject"><a
									href=# class="notice-title link-dark" data-no="${notice.idx}">${notice.title}</a></td>
								<td><c:out
										value="${fn:substring(notice.createDate, 0, 10)}" /></td>
								<td>${notice.viewCount}</td>
							</tr>
						</c:forEach>
					</c:if>

					<c:if test="${empty notices}">
						<tr>
							<td colspan="5">작성된 글이 없습니다.</td>
						</tr>
					</c:if>

				</tbody>
			</table>
			</form>
		</div>
		<!-- pagination -->
		<div class="pagination-container">
        	${navigation.navigator}
      	</div>
	</section>

	<form id="form-param" method="get" action="">
		<input type="hidden" name="pgno" id="pgno" value="${pgno}">
	</form>
	<form id="form-no-param" method="get" action="${root}/notice/view">
	  <input type="hidden" name="pgno" value="${pgno}">
	  <input type="hidden" name="key" value="${key}">
	  <input type="hidden" name="word" value="${word}">
	  <input type="hidden" id="idx" name="idx" value="">
	</form>
</template>

<style scoped>

</style>
