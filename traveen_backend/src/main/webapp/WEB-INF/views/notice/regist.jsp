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
    <link rel="stylesheet" href="../css/notice.css" />
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
      <h2 class="title">공지사항 등록</h2>
      <h4 class="subtitle">Traveen의 공지사항을 등록해보세요.</h4>
      <div class="table-container">
        <form id="form-regist-notice" action="#" method="post">
          <div class="input-title">제목</div>
          <input
            type="text"
            placeholder="제목을 입력해주세요."
            id="input-subject"
            name="title"
          />
          <div class="input-title">내용</div>
          <textarea
            name="content"
            id="content"
            cols="30"
            rows="10"
            placeholder="내용을 입력해주세요."
          ></textarea>
          <div class="line-notice"></div>
          <div class="notice-two-btn-box">
            <input type="reset" value="초기화" id="btn-reset" />
            <input type="submit" value="등록" id="btn-regist-notice" />
          </div>
        </form>
      </div>
      <div class="btn-notice-box">
        <button id="btn-notice-list">목록</button>
      </div>
    </section>
    
    <script>
    document.querySelector("#btn-regist-notice").addEventListener("click", function () {
  	  let form = document.querySelector("#form-regist-notice");
        form.setAttribute("action", "${root}/notice/regist");
        form.submit();
    });
    </script>

    <!-- footer -->
    <%@ include file="../include/footer.jsp"%>
  </body>
</html>
