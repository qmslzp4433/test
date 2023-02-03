<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<h1>회원관리-수정관리자</h1>
	<form action="Controller" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="id" value="${id}" readonly="readonly"></td>
			</tr>

			<tr>
				<td>PW</td>
				<td><input id="pw" type="text" name="pw" value="${pw}"></td>
			</tr>

			<tr>
				<td>Name</td>
				<td><input id="name" type="text" name="name" value="${name}"></td>
			</tr>
			
			<tr>
				<td>Point</td>
				<td><input id="point" type="text" name="point" value="${point}"></td>
			</tr>

			<tr>
				<td colspan="2">
				<input class="button" type="submit"value="제출">
				<input type="hidden" name="command" value="update">
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		$(function() {
			$(".button").click(function() {
				if($("#pw").val() == "") {
					alert("비밀번호를 입력해주세요.");
					return;
				}
				else if($("#name").val() == "") {
					alert("이름을 입력해주세요.");
					return;
				}
				else if($("#point").val() == "") {
					alert("포인트를 입력해주세요.");
					return;
				}
				else {
					alert("수정되었습니다.");
					$("#form").submit();
				}
			});
		});
	</script>
</body>
</html>