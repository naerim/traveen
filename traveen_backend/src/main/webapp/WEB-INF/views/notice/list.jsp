<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Traveen</title>
<link rel="stylesheet" href="./css/common.css" />
<link rel="stylesheet" href="./css/notice.css" />
<link rel="stylesheet" href="./css/notice-list.css" />
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
	integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
	<!-- header -->
	<%@ include file="../include/header.jsp"%>

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
				</select> <input type="text" name="keyword" id="keyword"
					placeholder="검색어를 입력해주세요." /> <input type="submit"
					id="btn-search" value="검색" />
				<button id="btn-insert">글 등록</button>
		</div>
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
				<c:forEach var="notice" items="${notices}">
					<tr>
						<td>1</td>
						<td class="subject"><a href=".">${notice.title}</a></td>
						<td>${notice.create_date}</td>
						<td>${notice.viewCount}</td>
					</tr>
					</c:forEach>
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

	<!-- footer -->
	<%@ include file="../include/footer.jsp"%>
</body>
</html>
