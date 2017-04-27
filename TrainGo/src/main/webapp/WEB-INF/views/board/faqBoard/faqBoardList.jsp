<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="page-main-style">
	<form action="faqlist.do" cssClass="form-horizontal" enctype="multipart/form-data" id="write_form" method="get">
	<legend>FAQ</legend>
		<h4>FAQ List</h4>
		<div class="form-group">
		
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=1'">Food Information</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=2'">Festival Information</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=3'">Sightseeing Information</button>
		
		<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqlist.do'">FAQ</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/freeBoard/freelist.do'">FREE BOARD</button>
		</div>	
		
		<div class="search">
				<select name="keyfield" class="form-control">
					<option value="faq_title">제목</option>
					<option value="id">ID</option>
					<option value="faq_content">내용</option>
					<option value="all">전체</option>
				</select>
				<input type="text" class="form-control" name="keyword" placeholder="키워드를 입력하세요">
				<div class="btn-group btn-group-justified" role="group">
                    <div class="btn-group" role="group">
                        <button type="submit" class="btn btn-default">찾기</button>
                    </div>
                </div>
		</div>
	
		<c:if test="${count==0}">
		<div class="form-horizontal">등록된 게시물이 없습니다.</div>
		</c:if>
		<c:if test="${count>0}">
			<table class="table table-striped">
				<tr>
					<th>번호</th>
					<th width="400">제목</th>
					<th>ID</th>
					<th>등록날짜</th>
				</tr>
				<c:forEach var="article" items="${faqList}">
					<tr>
						<td>${article.num}</td>
						<td><a href="faqdetail.do?num=${article.num}">${article.faq_title}</a></td>
						<td>${article.id}</td>
						<td>${article.register}</td>
					</tr>
				</c:forEach>
			</table>
			<div>${pagingHtml}</div>
		</c:if>
	<div class="form-group">
         <div class="col-xs-10 col-xs-offset-2">
                <div class="btn-group btn-group-justified" role="group">
                    <div class="btn-group" role="group">
                    	<c:if test="${!empty userId && userId=='admin'}">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqwrite.do'">글쓰기</button>
                        </c:if>
                        <c:if test="${!empty userId && userId!='admin'}">
                        <button type="button" class="btn btn-danger" disabled="disabled" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqwrite.do'">글쓰기</button>
                        </c:if>
                        <c:if test="${empty userId}">
                        <button type="button" class="btn btn-danger" disabled="disabled" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqwrite.do'">글쓰기</button>
                        </c:if>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/home.do'">홈으로</button>
                    </div>
                </div>
         </div>
    </div>
    </form>
</div>