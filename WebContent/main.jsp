<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인페이지</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>

#frame {
	padding: 0;
	margin: 0 auto;
	width: 1000px;
	height: 800px;
	border: 1px solid black;
	position: relative;
}

h1 {
	display: inline-block;
}

#member {
	position: absolute;
	right: 10px;
	top: 50px;
}

#img {
	text-align: center;
	width: 980px;
	margin: 0 auto;
}

td img {
	max-width: 100%;
	cursor: pointer;
}

#ad {
	position: absolute;
	right: 10px;
	bottom: 100px;
	cursor: pointer;
}
</style>
</head>
<body>

	<div id="frame">
		<h1>메인페이지</h1>
		<div id="member">
			${name}(<span id="id">${id}</span>)님 안녕하세요. <input id="logout" type="button" value="로그아웃"><br>
			포인트 : <span id="point">${point}</span>점
		</div>
		<h3>구입할 컨텐츠를 선택하세요.</h3>
		<div id="img">
			<table>
				<tr>
					<td><img id="intro" src="img/intro.png"></td>
					<td><img id="java" src="img/java.png"></td>
					<td><img id="cpp" src="img/cpp.png"></td>
				</tr>
				<tr>
					<td>100000만포인트</td>
					<td>500000만포인트</td>
					<td>300000만포인트</td>
				</tr>
			</table>
		</div>

		<div id="ad">
			&lt;광고 &gt;<br> 
			<a href="https://koreaisacademy.com/" target="_blank"><img src="img/logo.png"></a>
		</div>

	</div>

	<script>
		$(function() {
			$("#logout").click(function() {
				alert("로그아웃 되었습니다.");
				location.href = "Controller?command=login";
			});
			
			$("#intro").click(function() {
				$.ajax({
					type: "post",
					url: "Controller?command=buy_content",
					data: {"point": $("#point").text(), "content": "intro", "id": $("#id").text()},
					dataType: "json",
					success:function(data) {
						if(data.check == "false") {
							alert("포인트가 부족합니다. 광고를 클릭하세요.");
						}
						else {
							alert("컨텐츠(intro)를 구입하였습니다.");
							$("#point").text(data.point);
						}
					},
					error : function(r,e,s){
	                    alert("에러.");
	                }
				});
			});

			$("#java").click(function() {
				$.ajax({
					type: "post",
					url: "Controller?command=buy_content",
					data: {"point": $("#point").text(), "content": "java", "id": $("#id").text()},
					dataType: "json",
					success:function(data) {
						if(data.check == "false") {
							alert("포인트가 부족합니다. 광고를 클릭하세요.");
						}
						else {
							alert("컨텐츠(java)를 구입하였습니다.");
							$("#point").text(data.point);
						}
					},
					error : function(r,e,s){
	                    alert("에러.");
	                }
				});
			});
					
			$("#cpp").click(function() {
				$.ajax({
					type: "post",
					url: "Controller?command=buy_content",
					data: {"point": $("#point").text(), "content": "cpp", "id": $("#id").text()},
					dataType: "json",
					success:function(data) {
						if(data.check == "false") {
							alert("포인트가 부족합니다. 광고를 클릭하세요.");
						}
						else {
							alert("컨텐츠(cpp)를 구입하였습니다.");
							$("#point").text(data.point);
						}
					},
					error : function(r,e,s){
	                    alert("에러.");
	                }
				});
			});
						
			$("#ad").click(function() {
				var ap = Math.floor(Math.random()*1000)+1;
				alert(ap + "점이 적립되었습니다.");
				$.ajax({
					type: "post",
					url: "Controller?command=ad_point",
					data: {"point": ap, "id": $("#id").text()},
					dataType: "json",
					success:function(data) {
						$("#point").text(data.point);
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