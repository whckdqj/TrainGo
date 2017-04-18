<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script src="${pageContext.request.contextPath}/resources/js/board_hdl.js"></script>
<div class="page-main-style">
	<form:form action="infodetail.do" commandName="infoBoardCommand" cssClass="form-horizontal" enctype="multipart/form-data" id="write_form" method="post">
	<legend>Information</legend>
		<c:if test="${infoBoardCommand.code==1}"><h4>Food Information</h4><h4>${infoBoardCommand.content_title}</h4></c:if>
		<c:if test="${infoBoardCommand.code==2}"><h4>Festival Information</h4><h4>${infoBoardCommand.content_title}</h4></c:if>
		<c:if test="${infoBoardCommand.code==3}"><h4>Sightseeing Information</h4><h4>${infoBoardCommand.content_title}</h4></c:if>
		<input type="hidden" name="code" value="${infoBoardCommand.code}">
		<input type="hidden" name="id" value="${userId}">
			<div class="form-group">
			<c:if test="${infoBoardCommand.code==1}">
				<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=1'">Food Information</button>
				<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=2'">Festival Information</button>
				<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=3'">Sightseeing Information</button>
			</c:if>
			<c:if test="${infoBoardCommand.code==2}">
				<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=1'">Food Information</button>
				<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=2'">Festival Information</button>
				<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=3'">Sightseeing Information</button>
			</c:if>
			<c:if test="${infoBoardCommand.code==3}">
				<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=1'">Food Information</button>
				<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=2'">Festival Information</button>
				<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=3'">Sightseeing Information</button>
			</c:if>
			<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqlist.do'">FAQ</button>
			<button type="button" class="btn btn-default" onclick="location.href='freelist.do'">FREE BOARD</button>
			</div>
			
			<ul>
				<li>번호 : ${infoBoardCommand.num}</li>
				<li>지역 : ${infoBoardCommand.cityname}</li>
				<li>역명 : ${infoBoardCommand.nodename}</li>
				<li>IP : ${infoBoardCommand.ip}</li>
				<li>ID : ${infoBoardCommand.id}</li>
				<li>등록날짜 : ${infoBoardCommand.register}</li>
				<c:if test="${!empty infoBoardCommand.info_filename01}">
					<li>첨부파일 : <a href="infofile.do?num=${infoBoardCommand.num}&imageNum=1">${infoBoardCommand.info_filename01}</a></li>
				</c:if>
				<c:if test="${!empty infoBoardCommand.info_filename02}">
					<li>첨부파일 : <a href="infofile.do?num=${infoBoardCommand.num}&imageNum=2">${infoBoardCommand.info_filename02}</a></li>
				</c:if>
				<c:if test="${!empty infoBoardCommand.info_filename03}">
					<li>첨부파일 : <a href="infofile.do?num=${infoBoardCommand.num}&imageNum=3">${infoBoardCommand.info_filename03}</a></li>
				</c:if>
				<c:if test="${!empty infoBoardCommand.info_filename04}">
					<li>첨부파일 : <a href="infofile.do?num=${infoBoardCommand.num}&imageNum=4">${infoBoardCommand.info_filename04}</a></li>
				</c:if>
				<c:if test="${!empty infoBoardCommand.info_filename05}">
					<li>첨부파일 : <a href="infofile.do?num=${infoBoardCommand.num}&imageNum=5">${infoBoardCommand.info_filename05}</a></li>
				</c:if>
				<c:if test="${!empty infoBoardCommand.info_filename06}">
					<li>첨부파일 : <a href="infofile.do?num=${infoBoardCommand.num}&imageNum=6">${infoBoardCommand.info_filename06}</a></li>
				</c:if>
				<c:if test="${!empty infoBoardCommand.info_filename07}">
					<li>첨부파일 : <a href="infofile.do?num=${infoBoardCommand.num}&imageNum=7">${infoBoardCommand.info_filename07}</a></li>
				</c:if>
				<c:if test="${!empty infoBoardCommand.info_filename08}">
					<li>첨부파일 : <a href="infofile.do?num=${infoBoardCommand.num}&imageNum=8">${infoBoardCommand.info_filename08}</a></li>
				</c:if>
				<c:if test="${!empty infoBoardCommand.info_filename09}">
					<li>첨부파일 : <a href="infofile.do?num=${infoBoardCommand.num}&imageNum=9">${infoBoardCommand.info_filename09}</a></li>
				</c:if>
				<c:if test="${!empty infoBoardCommand.info_filename10}">
					<li>첨부파일 : <a href="infofile.do?num=${infoBoardCommand.num}&imageNum=10">${infoBoardCommand.info_filename10}</a></li>
				</c:if>
			</ul>
			<hr size="1" width="100%">
			<c:if test="${infoBoardCommand.info_filename01.endsWith('.jpg') ||
			 			  infoBoardCommand.info_filename01.endsWith('.JPG') ||
			 			  infoBoardCommand.info_filename01.endsWith('.gif') ||
			 			  infoBoardCommand.info_filename01.endsWith('.GIF') ||
			 			  infoBoardCommand.info_filename01.endsWith('.png') ||
			 			  infoBoardCommand.info_filename01.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/informationBoard/infoimageview.do?num=${infoBoardCommand.num}&imageNum=1" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${infoBoardCommand.info_filename02.endsWith('.jpg') ||
			 			  infoBoardCommand.info_filename02.endsWith('.JPG') ||
			 			  infoBoardCommand.info_filename02.endsWith('.gif') ||
			 			  infoBoardCommand.info_filename02.endsWith('.GIF') ||
			 			  infoBoardCommand.info_filename02.endsWith('.png') ||
			 			  infoBoardCommand.info_filename02.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/informationBoard/infoimageview.do?num=${infoBoardCommand.num}&imageNum=2" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${infoBoardCommand.info_filename03.endsWith('.jpg') ||
			 			  infoBoardCommand.info_filename03.endsWith('.JPG') ||
			 			  infoBoardCommand.info_filename03.endsWith('.gif') ||
			 			  infoBoardCommand.info_filename03.endsWith('.GIF') ||
			 			  infoBoardCommand.info_filename03.endsWith('.png') ||
			 			  infoBoardCommand.info_filename03.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/informationBoard/infoimageview.do?num=${infoBoardCommand.num}&imageNum=3" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${infoBoardCommand.info_filename04.endsWith('.jpg') ||
			 			  infoBoardCommand.info_filename04.endsWith('.JPG') ||
			 			  infoBoardCommand.info_filename04.endsWith('.gif') ||
			 			  infoBoardCommand.info_filename04.endsWith('.GIF') ||
			 			  infoBoardCommand.info_filename04.endsWith('.png') ||
			 			  infoBoardCommand.info_filename04.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/informationBoard/infoimageview.do?num=${infoBoardCommand.num}&imageNum=4" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${infoBoardCommand.info_filename05.endsWith('.jpg') ||
			 			  infoBoardCommand.info_filename05.endsWith('.JPG') ||
			 			  infoBoardCommand.info_filename05.endsWith('.gif') ||
			 			  infoBoardCommand.info_filename05.endsWith('.GIF') ||
			 			  infoBoardCommand.info_filename05.endsWith('.png') ||
			 			  infoBoardCommand.info_filename05.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/informationBoard/infoimageview.do?num=${infoBoardCommand.num}&imageNum=5" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${infoBoardCommand.info_filename06.endsWith('.jpg') ||
			 			  infoBoardCommand.info_filename06.endsWith('.JPG') ||
			 			  infoBoardCommand.info_filename06.endsWith('.gif') ||
			 			  infoBoardCommand.info_filename06.endsWith('.GIF') ||
			 			  infoBoardCommand.info_filename06.endsWith('.png') ||
			 			  infoBoardCommand.info_filename06.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/informationBoard/infoimageview.do?num=${infoBoardCommand.num}&imageNum=6" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${infoBoardCommand.info_filename07.endsWith('.jpg') ||
			 			  infoBoardCommand.info_filename07.endsWith('.JPG') ||
			 			  infoBoardCommand.info_filename07.endsWith('.gif') ||
			 			  infoBoardCommand.info_filename07.endsWith('.GIF') ||
			 			  infoBoardCommand.info_filename07.endsWith('.png') ||
			 			  infoBoardCommand.info_filename07.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/informationBoard/infoimageview.do?num=${infoBoardCommand.num}&imageNum=7" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${infoBoardCommand.info_filename08.endsWith('.jpg') ||
			 			  infoBoardCommand.info_filename08.endsWith('.JPG') ||
			 			  infoBoardCommand.info_filename08.endsWith('.gif') ||
			 			  infoBoardCommand.info_filename08.endsWith('.GIF') ||
			 			  infoBoardCommand.info_filename08.endsWith('.png') ||
			 			  infoBoardCommand.info_filename08.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/informationBoard/infoimageview.do?num=${infoBoardCommand.num}&imageNum=8" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${infoBoardCommand.info_filename09.endsWith('.jpg') ||
			 			  infoBoardCommand.info_filename09.endsWith('.JPG') ||
			 			  infoBoardCommand.info_filename09.endsWith('.gif') ||
			 			  infoBoardCommand.info_filename09.endsWith('.GIF') ||
			 			  infoBoardCommand.info_filename09.endsWith('.png') ||
			 			  infoBoardCommand.info_filename09.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/informationBoard/infoimageview.do?num=${infoBoardCommand.num}&imageNum=9" style="max-width:500px;">
			 	</div>		
			</c:if>
			<c:if test="${infoBoardCommand.info_filename10.endsWith('.jpg') ||
			 			  infoBoardCommand.info_filename10.endsWith('.JPG') ||
			 			  infoBoardCommand.info_filename10.endsWith('.gif') ||
			 			  infoBoardCommand.info_filename10.endsWith('.GIF') ||
			 			  infoBoardCommand.info_filename10.endsWith('.png') ||
			 			  infoBoardCommand.info_filename10.endsWith('.PNG')}">
			 		
			 	<div class="align-center">
			 		<img src="${pageContext.request.contextPath}/board/informationBoard/infoimageview.do?num=${infoBoardCommand.num}&imageNum=10" style="max-width:500px;">
			 	</div>		
			</c:if>
			<p>
				${infoBoardCommand.content_introduction}
			</p>		  
			<hr size="1" width="100%">
		<div class="form-group">
     	    <div class="col-xs-10 col-xs-offset-2">
                <div class="btn-group btn-group-justified" role="group">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infoupdate.do?num=${infoBoardCommand.num}'">수정</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infodelete.do?num=${infoBoardCommand.num}'">삭제</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=${infoBoardCommand.code}'">게시판</button>
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
			<input type="hidden" name="num" value="${infoBoardCommand.num}" id="num">
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