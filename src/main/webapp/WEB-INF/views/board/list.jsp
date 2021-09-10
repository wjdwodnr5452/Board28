<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- JSTL 버젼으로 바뀌니, import 의 번잡함 사라진다! JAVA 변수 선언도 사라진다! --%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
<style>
table {width: 100%;}
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}
</style>
</head>
<body>
		<hr>
		<h2>리스트</h2>
		<table>
			<tr>
				<th>uid</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>등록일</th>
			</tr>
			
			<c:choose>
			<c:when test="${empty list || fn:length(list) == 0 }">
			</c:when>
			<c:otherwise>
				<c:forEach var="dto" items="${list }">
					<tr>
						<td>${dto.uid }</td>
						<td><a href="view.do?uid=${dto.uid }">${dto.subject }</a></td>
						<td>${dto.name }</td>
						<td>${dto.viewCnt }</td>
						<td>${dto.regDateTime }</td> <%-- getRegDateTime() 사용 --%>
					</tr>
				</c:forEach>
			</c:otherwise>
			</c:choose>			
		</table>
		<br>
		<button onclick="location.href = 'write.do'">신규등록</button>

<%-- 위에서 필요한 트랜잭션이 마무리 되면 페이지 만들어주기 --%>
</body>
</html>






































