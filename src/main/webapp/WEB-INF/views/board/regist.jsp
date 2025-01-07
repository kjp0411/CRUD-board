<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resources/assets/css/main.css">
</head>
<body>
	<div id="main">
		<div class="wrapper">
			<div class="inner">
				<header class="major">
					<h1 class="home">Board</h1>
					<p>게시판 등록</p>
				</header>
				<a href="" class="button primary small">목록 보기</a>
				<br>
				<br>
				<div class="col-12">
					<form method="post" action="/board/regist">
						<div class="col-12">
							<h4>제목</h4>
							<input name="boardtitle" type="text" placeholder="Title">
						</div>
						<hr>
						<div class="col-12">
							<h4>내용</h4>
							<textarea name="boardcontents" placeholder="Contents" rows="10" style="resize:none;"></textarea>
						</div>
						<hr>
						<div class="col-12">
							<h4>작성자</h4>
							<input name="boardwriter" type="text" placeholder="Writer">
						</div>
						<hr>
						<div class="col-12">
							<input type="submit" value="등록" class="primary">
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>