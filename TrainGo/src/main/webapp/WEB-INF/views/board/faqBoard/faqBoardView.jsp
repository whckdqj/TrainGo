<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-main-style">
	<form:form action="faqdetail.do" commandName="faqBoardCommand" cssClass="form-horizontal" enctype="multipart/form-data" id="write_form" method="post">
	<legend>FAQ</legend>
		<h4>${faqBoardCommand.faq_title}</h4>
		<input type="hidden" name="id" value="${userId}">
		<div class="form-group">
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=1'">Food Information</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=2'">Festival Information</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=3'">Sightseeing Information</button>
		
		<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqlist.do'">FAQ</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/freeBoard/freelist.do'">FREE BOARD</button>
		</div>
			
			<ul>
				<li>번호 : ${faqBoardCommand.num}</li>
				<li>IP : ${faqBoardCommand.ip}</li>
				<li>ID : ${faqBoardCommand.id}</li>
				<li>등록날짜 : ${faqBoardCommand.register}</li>
				<c:if test="${!empty faqBoardCommand.faq_filename01}">
					<li>첨부파일 : <a href="faqfile.do?num=${faqBoardCommand.num}&imageNum=1">${faqBoardCommand.faq_filename01}</a></li>
				</c:if>
				<c:if test="${!empty faqBoardCommand.faq_filename02}">
					<li>첨부파일 : <a href="faqfile.do?num=${faqBoardCommand.num}&imageNum=2">${faqBoardCommand.faq_filename02}</a></li>
				</c:if>
				<c:if test="${!empty faqBoardCommand.faq_filename03}">
					<li>첨부파일 : <a href="faqfile.do?num=${faqBoardCommand.num}&imageNum=3">${faqBoardCommand.faq_filename03}</a></li>
				</c:if>
				<c:if test="${!empty faqBoardCommand.faq_filename04}">
					<li>첨부파일 : <a href="faqfile.do?num=${faqBoardCommand.num}&imageNum=4">${faqBoardCommand.faq_filename04}</a></li>
				</c:if>
			</ul>
			<hr size="1" width="100%">
			<c:if test="${faqBoardCommand.faq_filename01.endsWith('.jpg') ||
			 			  faqBoardCommand.faq_filename01.endsWith('.JPG') ||
			 			  faqBoardCommand.faq_filename01.endsWith('.gif') ||
			 			  faqBoardCommand.faq_filename01.endsWith('.GIF') ||
			 			  faqBoardCommand.faq_filename01.endsWith('.png') ||
			 			  faqBoardCommand.faq_filename01.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/faqBoard/faqimageview.do?num=${faqBoardCommand.num}&imageNum=1" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${faqBoardCommand.faq_filename02.endsWith('.jpg') ||
			 			  faqBoardCommand.faq_filename02.endsWith('.JPG') ||
			 			  faqBoardCommand.faq_filename02.endsWith('.gif') ||
			 			  faqBoardCommand.faq_filename02.endsWith('.GIF') ||
			 			  faqBoardCommand.faq_filename02.endsWith('.png') ||
			 			  faqBoardCommand.faq_filename02.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/faqBoard/faqimageview.do?num=${faqBoardCommand.num}&imageNum=2" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${faqBoardCommand.faq_filename03.endsWith('.jpg') ||
			 			  faqBoardCommand.faq_filename03.endsWith('.JPG') ||
			 			  faqBoardCommand.faq_filename03.endsWith('.gif') ||
			 			  faqBoardCommand.faq_filename03.endsWith('.GIF') ||
			 			  faqBoardCommand.faq_filename03.endsWith('.png') ||
			 			  faqBoardCommand.faq_filename03.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/faqBoard/faqimageview.do?num=${faqBoardCommand.num}&imageNum=3" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${faqBoardCommand.faq_filename04.endsWith('.jpg') ||
			 			  faqBoardCommand.faq_filename04.endsWith('.JPG') ||
			 			  faqBoardCommand.faq_filename04.endsWith('.gif') ||
			 			  faqBoardCommand.faq_filename04.endsWith('.GIF') ||
			 			  faqBoardCommand.faq_filename04.endsWith('.png') ||
			 			  faqBoardCommand.faq_filename04.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/faqBoard/faqimageview.do?num=${faqBoardCommand.num}&imageNum=4" style="max-width:500px;">
			 	</div>		
			</c:if>
			<p>
				${faqBoardCommand.faq_content}
			</p>		  
			<hr size="1" width="100%">
		<div class="form-group">
     	    <div class="col-xs-10 col-xs-offset-2">
                <div class="btn-group btn-group-justified" role="group">
                    <c:if test="${!empty userId && userId=='admin'}">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqupdate.do?num=${faqBoardCommand.num}'">수정</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqdelete.do?num=${faqBoardCommand.num}'">삭제</button>
                    </div>
                    </c:if>
                    <c:if test="${!empty userId && userId!='admin'}">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" disabled="disabled" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqupdate.do?num=${faqBoardCommand.num}'">수정</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" disabled="disabled" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqdelete.do?num=${faqBoardCommand.num}'">삭제</button>
                    </div>
                    </c:if>
                     <c:if test="${empty userId}">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" disabled="disabled" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqupdate.do?num=${faqBoardCommand.num}'">수정</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" disabled="disabled" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqdelete.do?num=${faqBoardCommand.num}'">삭제</button>
                    </div>
                    </c:if>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqlist.do'">FAQ게시판</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/home.do'">홈으로</button>
                    </div>
                </div>
       		 </div>
   		 </div>
		</form:form>
</div>