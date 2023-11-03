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
    <link rel="stylesheet" href="../css/error.css" />
  </head>
  <body>
    <!-- header -->
    <%@ include file="../include/header.jsp"%>
    <!-- section -->
    <section>
      <h1>페이지를 찾을 수 없습니다 :(</h1>
      <h3>
      존재하지 않는 주소를 입력하셨거나
      요청하신 페이지의 주소가 변경, 삭제되어 찾을 수 없습니다.

      주소를 다시 확인해주세요.</h3>
      <button id='btn-go-main'>메인으로</button>
    </section>
    <!-- footer -->
    <%@ include file="../include/footer.jsp"%>
  </body>
</html>
