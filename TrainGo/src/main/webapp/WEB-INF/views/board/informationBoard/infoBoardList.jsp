<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-main-style">
	<form action="infolist.do" cssClass="form-horizontal" enctype="multipart/form-data" id="write_form" method="get">
	<legend>Information</legend>
	<c:if test="${code==1}"><h4>Food Information</h4></c:if>
	<c:if test="${code==2}"><h4>Festival Information</h4></c:if>
	<c:if test="${code==3}"><h4>Sightseeing Information</h4></c:if>
		<input type="hidden" name="code" value="${code}">
		<div class="form-group">
		<c:if test="${code==1}">
			<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=1'">Food Information</button>
			<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=2'">Festival Information</button>
			<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=3'">Sightseeing Information</button>
		</c:if>
		<c:if test="${code==2}">
			<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=1'">Food Information</button>
			<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=2'">Festival Information</button>
			<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=3'">Sightseeing Information</button>
		</c:if>
		<c:if test="${code==3}">
			<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=1'">Food Information</button>
			<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=2'">Festival Information</button>
			<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=3'">Sightseeing Information</button>
		</c:if>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqlist.do'">FAQ</button>
		<button type="button" class="btn btn-default" onclick="location.href='freelist.do'">FREE BOARD</button>
		
		</div>	
		<div class="search">
				<select name="keyfield" class="form-control">
					<option value="content_title">제목</option>
					<option value="id">ID</option>
					<option value="content_introduction">내용</option>
					<option value="all">전체</option>
				</select>
				<input type="text" class="form-control" name="keyword" placeholder="키워드를 입력하세요">
				<div class="btn-group btn-group-justified" role="group">
                    <div class="btn-group" role="group">
                        <button type="submit" class="btn btn-default">찾기</button>
                    </div>
                </div>
		</div>
	</form>
		<c:if test="${count==0}">
		<div class="form-horizontal">등록된 게시물이 없습니다.</div>
		</c:if>
		<c:if test="${count>0}">
			<table class="table table-striped">
				<tr>
					<th>번호</th>
					<th>지역</th>
					<th>역명</th>
					<th width="400">제목</th>
					<th>Reply</th>
					<th>ID</th>
					<th>등록날짜</th>
					<th>조회수</th>
				</tr>
				<c:forEach var="article" items="${infoList}">
					<tr>
						<td>${article.num}</td>
						<td>${article.cityname}</td>
						<td>${article.nodename}</td>
						<td><a href="infodetail.do?code=${article.code}&num=${article.num}">${article.content_title}</a></td>
						<td>${article.reply_cnt}</td>
						<td>${article.id}</td>
						<td>${article.register}</td>
						<td>${article.hit}</td>
					</tr>
				</c:forEach>
			</table>
			<div>${pagingHtml}</div>
		</c:if>
	<div class="form-group">
         <div class="col-xs-10 col-xs-offset-2">
                <div class="btn-group btn-group-justified" role="group">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infowrite.do?code=${code}'">글쓰기</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/home.do'">홈으로</button>
                    </div>
                </div>
         </div>
    </div>
</div>