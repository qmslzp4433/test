<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
.button {
	width: 205px;
}
</style>
</head>
<body>
	<h1>로그인</h1>
	<form id="form" action="Controller" method="post">
		<table>
			<tr>
				<td>ID :</td>
				<td><input type="text" name="id"></td>
			</tr>

			<tr>
				<td>PW :</td>
				<td><input type="text" name="pw"></td>
			</tr>

			<tr>
				<td colspan="2">
				<input class="button" type="submit" value="로그인">
				<input type="hidden" name="command" value="login_check">
				</td>
			</tr>

			<tr>
				<td colspan="2">
				<a href="Controller?command=join">
				<input class="button" type="button" value="회원가입">
				</a>
				</td>
			</tr>
		</table>
	</form>
	

</body>
</html>