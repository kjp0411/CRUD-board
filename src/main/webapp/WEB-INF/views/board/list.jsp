<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
<link rel="stylesheet" href="/resources/assets/css/main.css">
<style>
	td, th{
		text-align: center !important;
		vertical-align: middle !important;
	}
	.small-width{
		display:none;
	}
	.big-width{
	
	}
	select{
		width:15%;
		display:inline;
	}
	#keyword{
		display:inline;
		width:55%;
	}
	@media(max-width : 918px){
		select[name='type']{
			width:80%;
		}
		#keyword{
			width:80%;
		}
		.fa-search{
			width:80%;		
		}
		.big-width{
			display:none;
		}
		.small-width{
			display:block;
		}
	}
</style>
</head>
<body>
	<div id="main">
		<div class="wrapper">
			<div class="inner">
				<header class="major">
					<h1 class="home">Board</h1>
					<p>게시판 목록</p>
				</header>
									<!-- cri.getListLink() : ?pagenum=4&amount=10... -->
				<a href="/board/regist${pageMaker.cri.listLink}" class="button primary small">글 등록</a>
				<br>
				<br>
				<!-- 게시글 띄우는 테이블 -->
				<div class="table-wrapper">
					<table>
						<thead>
							<tr>
								<th style="width:8%">번호</th>
								<th style="width:40%">제목</th>
								<th style="width:16%">작성자</th>
								<th style="width:18%" class="big-width">작성일</th>
								<th style="width:18%" class="big-width">수정일</th>
							</tr>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${list != null and list.size()>0}">
									<c:forEach items="${list}" var="board">
										<tr>
											<td>${board.boardnum }</td>
											<td><a class="get" href="${board.boardnum}">${board.boardtitle }</a></td>
											<td>${board.boardwriter }</td>
											<td>${board.regdate }</td>
											<td>${board.updatedate }</td>
										</tr>
									</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
										<td colspan="5">작성된 게시글이 없습니다.</td>
									</tr>
								</c:otherwise>
							</c:choose>				
						</tbody>
					</table>
				</div>
				
				<form action="/board/list" id="searchForm" method="get">
					<div class="col-12" style="text-align:center;">
						<select name="type">
							<option value="">검색</option>
							<option value="T" ${pageMaker.cri.type == "T"?"selected":""}>제목</option>
							<option value="C" ${pageMaker.cri.type == "C"?"selected":""}>내용</option>
							<option value="W" ${pageMaker.cri.type == "W"?"selected":""}>작성자</option>
							<option value="TC" ${pageMaker.cri.type == "TC"?"selected":""}>제목 또는 내용</option>
							<option value="TW" ${pageMaker.cri.type == "TW"?"selected":""}>제목 또는 작성자</option>
							<option value="TCW" ${pageMaker.cri.type == "TCW"?"selected":""}>제목 또는 내용 또는 작성자</option>
						</select>
						<input type="text" name="keyword" id="keyword" value="${pageMaker.cri.keyword}">
						<a href="#" class="button primary icon solid fa-search">검색</a>						
					</div>
					<input type="hidden" name="pagenum" value="${pageMaker.cri.pagenum}">
					<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
				</form>
				<!-- 페이징 처리 -->
				<div style="text-align: center">
					<c:if test="${pageMaker.prev}">
						<a class="changePage" href="${pageMaker.startPage-1}"><code>&lt;</code></a>
					</c:if>
					<c:forEach begin="${pageMaker.startPage}" end="${pageMaker.endPage}" var="i">
						<c:choose>
							<c:when test="${pageMaker.cri.pagenum == i}">
								<code>${i}</code>
							</c:when>
							<c:otherwise>
								<a class="changePage" href="${i}"><code>${i}</code></a>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${pageMaker.next }">
						<a class="changePage" href="${pageMaker.endPage+1}"><code>&gt;</code></a>
					</c:if>
				</div>
				<form id="pageForm" name="pageForm" action="/board/list" method="get">
					<input type="hidden" name="pagenum" value="${pageMaker.cri.pagenum}">
					<input type="hidden" name="amount" value="${pageMaker.cri.amount }">
					<input type="hidden" name="type" value="${pageMaker.cri.type }">
					<input type="hidden" name="keyword" value="${pageMaker.cri.keyword }">
				</form>
			</div>
		</div>
	</div>
</body>
<script src="/resources/assets/js/jquery.min.js"></script>
<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
<script src="/resources/assets/js/browser.min.js"></script>
<script src="/resources/assets/js/breakpoints.min.js"></script>
<script src="/resources/assets/js/util.js"></script>
<script src="/resources/assets/js/main.js"></script>
<script>
	const searchForm = $("#searchForm");
	const pageForm = $("#pageForm");
	
	$(".get").on("click",function(e){
		e.preventDefault();	
					   //<input type='hidden' name='boardnum' value='			123			 '>
		pageForm.append("<input type='hidden' name='boardnum' value='"+$(this).attr("href")+"'>");
		pageForm.attr("action","/board/get");
		pageForm.submit();
	})
	
	$("#searchForm a").on("click",function(e){
		if(!searchForm.find("option:selected").val()){
			alert("검색 기준을 선택하세요.");
			return false;
		}
		if(!searchForm.find("input[name='keyword']").val()){
			alert("키워드를 입력하세요.")
			return false;
		}
		searchForm.find("input[name='pagenum']").val("1");
		searchForm.submit();
	})
	
	$(".changePage").on("click",function(e){
		//e(이벤트)의 기본 작동 막기
		e.preventDefault();
		//$(this) : 현재 클릭된 a태그
		//.attr("href") : 그 태그의 href 속성에 써져있는 값
		pageForm.find("input[name='pagenum']").val($(this).attr("href"))
		pageForm.submit();
	})

	wn = "${wn}";
	//$(document).ready(함수) : 문서가 로딩이 완료되면 건네주는 함수 호출 
	$(document).ready(
		function(){
			if(wn == '' || history.state){
				return;
			}
			if(parseInt(wn) > 0){
				alert(wn+"번 게시글이 등록되었습니다.");
				history.replaceState({},null,null);
			}
		}
	)
	mn = "${mn}";
	$(document).ready(
		function(){
			if(mn == '' || history.state){
				return;
			}
			if(parseInt(mn) > 0){
				alert(mn+"번 게시글이 수정되었습니다.");
				history.replaceState({},null,null);
			}
		}
	)
</script>
</html>






