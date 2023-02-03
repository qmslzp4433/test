<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
.button {
	width: 233px;
}
</style>

</head>
<body>
	<h1>회원가입</h1>
	<form id="form" action="Controller" method="post">
		<table>
			<tr>
				<td>ID :</td>
				<td><input id="id" type="text" name="id"> <input id="check" type="button" value="중복확인"></td>
			</tr>

			<tr>
				<td>PW :</td>
				<td><input id="pw" type="password" name="pw"></td>
			</tr>

			<tr>
				<td>Name :</td>
				<td><input id="name" type="text" name="name"></td>
			</tr>

			<tr>
				<td colspan="2">
				<input class="button" type="button" value="작성완료">
				<input type="hidden" name="command" value="join_check">
				<input id="id_check" type="hidden" value="0">
				</td>
			</tr>
		</table>
	</form>
	
	<script>
		$(function() {
			$("#check").click(function() {
				var id = $("#id").val();
				$.ajax({
					type: "post",
					url: "Controller?command=id_check",
					data: {"id": id},
					dataType: "json",
					success:function(data) {
 						if(data.check == true) {
							alert("사용가능한 아이디입니다.");
							$("#id").attr("readonly", true);
							$("#id_check").val("1");
						}
						else {
							alert("이미 사용된 아이디입니다. 다른 아이디를 입력해주세요.");
						} 
					},
					error:function(r,e,s) {
						alert("에러");
					}
				});
			});
			
			$(".button").click(function() {
				
				if($("#id").val() == "") {
					alert("아이디를 입력해주세요.");
					return;
				}
				else if($("#pw").val() == "") {
					alert("비밀번호를 입력해주세요.");
					return;
				}
				else if($("#name").val() == "") {
					alert("이름을 입력해주세요.");
					return;
				}
				else if($("#id_check").val() != "1") {
					alert("아이디 중복확인을 해주세요.");
					return;
				}
				else {
					$("#form").submit();
				}
			});
		});
	</script>
</body>
</html>