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
      <h1>서비스에 접속할 수 없습니다 :(</h1>
      <h3>
      지금 이 서비스와 연결할 수 없습니다.
      문제를 해결하기 위해 열심히 노력하고 있습니다.

      잠시후 다시 확인해주세요.</h3>
      <button id='btn-go-main'>메인으로</button>
    </section>
    <!-- footer -->
    <%@ include file="../include/footer.jsp"%>
  </body>
</html>
