<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${pageContext.request.contextPath}/resources/js/free_board_reply_hdl.js"></script>
<div class="page-main-style">
	<form:form action="freedetail.do" commandName="freeBoardCommand" cssClass="form-horizontal" enctype="multipart/form-data" id="write_form" method="post">
	<legend>Free Board</legend>
		<h4>${freeBoardCommand.free_title}</h4>
		<input type="hidden" name="id" value="${userId}">
		<div class="form-group">
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=1'">Food Information</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=2'">Festival Information</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=3'">Sightseeing Information</button>
		
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqlist.do'">FAQ</button>
		<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/board/freeBoard/freelist.do'">FREE BOARD</button>
		</div>
			
			<ul>
				<li>번호 : ${freeBoardCommand.num}</li>
				<li>IP : ${freeBoardCommand.ip}</li>
				<li>ID : ${freeBoardCommand.id}</li>
				<li>등록날짜 : ${freeBoardCommand.register}</li>
				<c:if test="${!empty freeBoardCommand.free_filename01}">
					<li>첨부파일 : <a href="freefile.do?num=${freeBoardCommand.num}&imageNum=1">${freeBoardCommand.free_filename01}</a></li>
				</c:if>
				<c:if test="${!empty freeBoardCommand.free_filename02}">
					<li>첨부파일 : <a href="freefile.do?num=${freeBoardCommand.num}&imageNum=2">${freeBoardCommand.free_filename02}</a></li>
				</c:if>
				<c:if test="${!empty freeBoardCommand.free_filename03}">
					<li>첨부파일 : <a href="freefile.do?num=${freeBoardCommand.num}&imageNum=3">${freeBoardCommand.free_filename03}</a></li>
				</c:if>
				<c:if test="${!empty freeBoardCommand.free_filename04}">
					<li>첨부파일 : <a href="freefile.do?num=${freeBoardCommand.num}&imageNum=4">${freeBoardCommand.free_filename04}</a></li>
				</c:if>
				<c:if test="${!empty freeBoardCommand.free_filename05}">
					<li>첨부파일 : <a href="freefile.do?num=${freeBoardCommand.num}&imageNum=5">${freeBoardCommand.free_filename05}</a></li>
				</c:if>
				<c:if test="${!empty freeBoardCommand.free_filename06}">
					<li>첨부파일 : <a href="freefile.do?num=${freeBoardCommand.num}&imageNum=6">${freeBoardCommand.free_filename06}</a></li>
				</c:if>
				<c:if test="${!empty freeBoardCommand.free_filename07}">
					<li>첨부파일 : <a href="freefile.do?num=${freeBoardCommand.num}&imageNum=7">${freeBoardCommand.free_filename07}</a></li>
				</c:if>
				<c:if test="${!empty freeBoardCommand.free_filename08}">
					<li>첨부파일 : <a href="freefile.do?num=${freeBoardCommand.num}&imageNum=8">${freeBoardCommand.free_filename08}</a></li>
				</c:if>
				<c:if test="${!empty freeBoardCommand.free_filename09}">
					<li>첨부파일 : <a href="freefile.do?num=${freeBoardCommand.num}&imageNum=9">${freeBoardCommand.free_filename09}</a></li>
				</c:if>
				<c:if test="${!empty freeBoardCommand.free_filename10}">
					<li>첨부파일 : <a href="freefile.do?num=${freeBoardCommand.num}&imageNum=10">${freeBoardCommand.free_filename10}</a></li>
				</c:if>
				
			</ul>
			<hr size="1" width="100%">
			<c:if test="${freeBoardCommand.free_filename01.endsWith('.jpg') ||
			 			  freeBoardCommand.free_filename01.endsWith('.JPG') ||
			 			  freeBoardCommand.free_filename01.endsWith('.gif') ||
			 			  freeBoardCommand.free_filename01.endsWith('.GIF') ||
			 			  freeBoardCommand.free_filename01.endsWith('.png') ||
			 			  freeBoardCommand.free_filename01.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/freeBoard/freeimageview.do?num=${freeBoardCommand.num}&imageNum=1" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${freeBoardCommand.free_filename02.endsWith('.jpg') ||
			 			  freeBoardCommand.free_filename02.endsWith('.JPG') ||
			 			  freeBoardCommand.free_filename02.endsWith('.gif') ||
			 			  freeBoardCommand.free_filename02.endsWith('.GIF') ||
			 			  freeBoardCommand.free_filename02.endsWith('.png') ||
			 			  freeBoardCommand.free_filename02.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/freeBoard/freeimageview.do?num=${freeBoardCommand.num}&imageNum=2" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${freeBoardCommand.free_filename03.endsWith('.jpg') ||
			 			  freeBoardCommand.free_filename03.endsWith('.JPG') ||
			 			  freeBoardCommand.free_filename03.endsWith('.gif') ||
			 			  freeBoardCommand.free_filename03.endsWith('.GIF') ||
			 			  freeBoardCommand.free_filename03.endsWith('.png') ||
			 			  freeBoardCommand.free_filename03.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/freeBoard/freeimageview.do?num=${freeBoardCommand.num}&imageNum=3" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${freeBoardCommand.free_filename04.endsWith('.jpg') ||
			 			  freeBoardCommand.free_filename04.endsWith('.JPG') ||
			 			  freeBoardCommand.free_filename04.endsWith('.gif') ||
			 			  freeBoardCommand.free_filename04.endsWith('.GIF') ||
			 			  freeBoardCommand.free_filename04.endsWith('.png') ||
			 			  freeBoardCommand.free_filename04.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/freeBoard/freeimageview.do?num=${freeBoardCommand.num}&imageNum=4" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${freeBoardCommand.free_filename05.endsWith('.jpg') ||
			 			  freeBoardCommand.free_filename05.endsWith('.JPG') ||
			 			  freeBoardCommand.free_filename05.endsWith('.gif') ||
			 			  freeBoardCommand.free_filename05.endsWith('.GIF') ||
			 			  freeBoardCommand.free_filename05.endsWith('.png') ||
			 			  freeBoardCommand.free_filename05.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/freeBoard/freeimageview.do?num=${freeBoardCommand.num}&imageNum=5" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${freeBoardCommand.free_filename06.endsWith('.jpg') ||
			 			  freeBoardCommand.free_filename06.endsWith('.JPG') ||
			 			  freeBoardCommand.free_filename06.endsWith('.gif') ||
			 			  freeBoardCommand.free_filename06.endsWith('.GIF') ||
			 			  freeBoardCommand.free_filename06.endsWith('.png') ||
			 			  freeBoardCommand.free_filename06.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/freeBoard/freeimageview.do?num=${freeBoardCommand.num}&imageNum=6" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${freeBoardCommand.free_filename07.endsWith('.jpg') ||
			 			  freeBoardCommand.free_filename07.endsWith('.JPG') ||
			 			  freeBoardCommand.free_filename07.endsWith('.gif') ||
			 			  freeBoardCommand.free_filename07.endsWith('.GIF') ||
			 			  freeBoardCommand.free_filename07.endsWith('.png') ||
			 			  freeBoardCommand.free_filename07.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/freeBoard/freeimageview.do?num=${freeBoardCommand.num}&imageNum=7" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${freeBoardCommand.free_filename08.endsWith('.jpg') ||
			 			  freeBoardCommand.free_filename08.endsWith('.JPG') ||
			 			  freeBoardCommand.free_filename08.endsWith('.gif') ||
			 			  freeBoardCommand.free_filename08.endsWith('.GIF') ||
			 			  freeBoardCommand.free_filename08.endsWith('.png') ||
			 			  freeBoardCommand.free_filename08.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/freeBoard/freeimageview.do?num=${freeBoardCommand.num}&imageNum=8" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${freeBoardCommand.free_filename09.endsWith('.jpg') ||
			 			  freeBoardCommand.free_filename09.endsWith('.JPG') ||
			 			  freeBoardCommand.free_filename09.endsWith('.gif') ||
			 			  freeBoardCommand.free_filename09.endsWith('.GIF') ||
			 			  freeBoardCommand.free_filename09.endsWith('.png') ||
			 			  freeBoardCommand.free_filename09.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/freeBoard/freeimageview.do?num=${freeBoardCommand.num}&imageNum=9" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${freeBoardCommand.free_filename10.endsWith('.jpg') ||
			 			  freeBoardCommand.free_filename10.endsWith('.JPG') ||
			 			  freeBoardCommand.free_filename10.endsWith('.gif') ||
			 			  freeBoardCommand.free_filename10.endsWith('.GIF') ||
			 			  freeBoardCommand.free_filename10.endsWith('.png') ||
			 			  freeBoardCommand.free_filename10.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/freeBoard/freeimageview.do?num=${freeBoardCommand.num}&imageNum=10" style="max-width:500px;">
			 	</div>		
			</c:if>
			<p>
				${freeBoardCommand.free_content}
			</p>	  
			<hr size="1" width="100%">
		<div class="form-group">
     	    <div class="col-xs-10 col-xs-offset-2">
                <div class="btn-group btn-group-justified" role="group">
                    <c:if test="${!empty userId && userId==freeBoardCommand.id}">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/board/freeBoard/freeupdate.do?num=${freeBoardCommand.num}'">수정</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/board/freeBoard/freedelete.do?num=${freeBoardCommand.num}'">삭제</button>
                    </div>
                    </c:if>
                    <c:if test="${!empty userId && userId!=freeBoardCommand.id}">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" disabled="disabled" onclick="location.href='${pageContext.request.contextPath}/board/freeBoard/freeupdate.do?num=${freeBoardCommand.num}'">수정</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" disabled="disabled" onclick="location.href='${pageContext.request.contextPath}/board/freeBoard/freedelete.do?num=${freeBoardCommand.num}'">삭제</button>
                    </div>
                    </c:if>
                    <c:if test="${empty userId}">
                     <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" disabled="disabled" onclick="location.href='${pageContext.request.contextPath}/board/freeBoard/freeupdate.do?num=${freeBoardCommand.num}'">수정</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" disabled="disabled" onclick="location.href='${pageContext.request.contextPath}/board/freeBoard/freedelete.do?num=${freeBoardCommand.num}'">삭제</button>
                    </div>
                    </c:if>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/board/freeBoard/freelist.do'">자유게시판</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/home.do'">홈으로</button>
                    </div>
                </div>
       		 </div>
   		 </div>
		</form:form>
		<div id="reply_div">
		<span class="reply-title">댓글 달기</span>
		<form id="re_form">
			<input type="hidden" name="num" value="${freeBoardCommand.num}" id="num">
			<input type="hidden" name="id" value="${userId}" id="userId">
			<textarea rows="3" cols="50" name="re_content"
			  id="re_content" maxlength="300" class="rep-content"
			  <c:if test="${empty userId}">disabled="disabled"</c:if>
			  ><c:if test="${empty userId}">로그인해야 작성할 수 있습니다.</c:if></textarea>
			<c:if test="${!empty userId}">
			<div id="re_first">
				<span class="letter-count">300/300</span>
			</div>
			<div id="re_second" class="align-right">
				<input type="submit" value="전송">
			</div>
			</c:if>	
		</form>
	    </div>
		<!-- 목록 출력 -->
		<div id="output"></div>
		<div class="paging_button" style="display:none;">
			<input type="button" value="다음글 보기">
		</div>
		<div id="loading" style="display:none;">
			<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif">
		</div>
		<div id="output"></div>
		<div class="rerepaging_button" style="display:none;">
			<input type="button" value="다음글 보기">
		</div>
		<div id="loading" style="display:none;">
			<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif">
		</div>
		<!-- 수정폼 -->
		<div id="modify_div" style="display:none;">
			<form id="mre_form">
				<input type="hidden" name="re_num" id="mre_num">
				<input type="hidden" name="id" id="muserId">
				<textarea rows="3" cols="50" name="re_content"
				  id="mre_content" class="rep-content"></textarea>
				<div id="mre_first">
					<span class="letter-count">300/300</span>
				</div>  
				<div id="mre_second" class="align-right">
					<input type="submit" value="수정">
					<input type="button" value="취소" class="re-reset">
				</div>
				<hr size="1" noshade width="96%">
			</form>
		</div>
</div>