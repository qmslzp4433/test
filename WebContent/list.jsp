<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원관리</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
	<style>
		table {border-collapse: collapse;
			   text-align: center;
			   margin-bottom: 100px;}
	
		table,th,td {border: 1px solid black;}
		
		th {width: 100px;}
		
		#h1 { display: inline-block;}
		
		#frame { position: relative;
				 width: 625px;}
		
		#login { position: absolute;
				 right: 10px;
				 top: 20px;}
			
	</style>
</head>
<body>

<div id="frame">

	<h1 id="h1">회원관리</h1>
	
	<div id="login">	
	<input type="button" value="로그인">
	</div>
	
	<table>
	
	<tr>
	<th>ID</th>
	<th>PW</th>
	<th>Name</th>
	<th>Point</th>
	<th>수정</th>
	<th>삭제</th>
	</tr>
	
	<c:forEach var="dto" items="${list}">
	<tr>
	<td>${dto.id}</td>
	<td>${dto.pw}</td>
	<td>${dto.name}</td>
	<td>${dto.point}</td>
	<td><input class="revise" type="button" value="수정"><input type="hidden" value="${dto.id}"></td>
	<td><input class="delete" type="button" value="삭제"><input type="hidden" value="${dto.id}"></td>
	</tr>
	</c:forEach>
	
	</table>
	
	<form id="form" action="Controller" method="post">
	<input type="hidden" name="command" value="revise_check">
	<input id="h_id" type="hidden" name="id">
	</form>

	<h1>스케줄러관리</h1>
	<input id="scheduler_start" type="button" value="스케줄러(20초마다 포인트 1증가) 실행 시작">
	<input id="scheduler_stop" type="button" value="스케줄러 실행 종료">
	
	
</div>
	
	<script>
		$(function() {
			$("#login").click(function() {
				location.href = "Controller?command=login";
			});
			
			$(".revise").click(function() {
				$("#h_id").val($(this).next().val());
				$("form").submit();				
			});
			
			$(".delete").click(function() {
				let id = $(this).parent().parent();

 				$.ajax({
					type: "post",
					url: "Controller?command=delete",
					data: {"id": $(this).next().val()},
					dataType: "json",
					success:function(data) {
						if(data.check == "true") {
							alert("삭제되었습니다.");
							id.css("display", "none");
						}
						else {
							alert("삭제 X");
						}
					},
					error : function(r,e,s){
	                    alert("에러.");
	                }
				}); 
			});
			
		});
		
	</script>
</body>
</html>