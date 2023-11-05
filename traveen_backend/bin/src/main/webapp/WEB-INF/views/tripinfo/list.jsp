<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Traveen</title>
    <link rel="stylesheet" href="../css/common.css" />
    <link rel="stylesheet" href="../css/tripinfo-list.css" />
    <link
      rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.2/css/all.min.css"
      integrity="sha512-z3gLpd7yknf1YoNbCzqRKc4qyor8gaKU1qmn+CShxbuBusANI9QpRohGBreCFkKxLhei6S9CQXFEbbKuqLg0DA=="
      crossorigin="anonymous"
      referrerpolicy="no-referrer"
    />
  </head>
  <body>
    <!-- header -->
	<%@ include file="../include/header.jsp"%>
	
    <!-- section -->
    <section>
      <!-- title -->
      <h1 class="title">관심있는 촬영지를<br />검색해보세요.</h1>
      <!-- search box -->
      <div id="search-box">
        <select name="select-type" id="select-type">
          <option value="">전체</option>
          <option value="레스토랑">레스토랑</option>
          <option value="카페">카페</option>
        </select>
        <select name="select-order" id="select-order">
          <option value="view">조회수</option>
          <option value="hit">찜</option>
        </select>
        <input
          type="text"
          placeholder="작품이름을 입력해보세요."
          id="input-search"
        />
        <button id="btn-search-tripinfo">검색</button>
      </div>
      <!-- tab box -->
      <div id="tab-box">
        <ul class="tabnav">
          <li class="active">전체</li>
          <li>드라마</li>
          <li>영화</li>
          <li>예능</li>
          <li>뮤직비디오</li>
        </ul>
      </div>
      <!-- content box -->
      <div id="content-box">
        <!-- empty-tripinfo-box -->
        <!-- <div class="empty-tripinfo-box">검색 결과가 없습니다.</div> -->
        <!-- tripinfo-list-box -->
        <div class="item">
          <div class="imgDiv">
            <img src="../img/img_tripinfo.png" alt="" />
          </div>
          <div class="tag-box">
            <div class="left">도깨비</div>
            <div class="right">
              <div class="type">레스토랑</div>
              <div class="category">드라마</div>
            </div>
          </div>
          <div class="place_name">라라무리</div>
          <div class="desc">
            1회에서 이곳은 지은탁(김고은)이 도깨비에서 어린 소녀였을 때 사는
            곳이기도 하다.
          </div>
          <div class="bottom-box">
            <div class="hit">
              <img src="../img/icon_view.png" alt="" /> 10
            </div>
            <div class="like">
              <img src="../img/icon_heart.png" alt="" /> 20
            </div>
          </div>
        </div>
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
	
    <script>
      // tab 이벤트
      const tabnavItems = document.querySelectorAll(".tabnav li");
      tabnavItems.forEach(function (item) {
        item.addEventListener("click", function () {
          tabnavItems.forEach(function (item) {
            item.classList.remove("active");
          });
          this.classList.add("active");
        });
      });
    </script>
  </body>
</html>
