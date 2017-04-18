<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-main-style">
	<form:form action="faqupdate.do" commandName="command" cssClass="form-horizontal" enctype="multipart/form-data" id="update_form" method="post">
	<legend>FAQ</legend>
		<h4>FAQ Update</h4>
		<input type="hidden" name="id" value="${userId}">
		<div class="form-group">
		
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=1'">Food Information</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=2'">Festival Information</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=3'">Sightseeing Information</button>
		
		<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqlist.do'">FAQ</button>
		<button type="button" class="btn btn-default" onclick="location.href='freelist.do'">FREE BOARD</button>
		</div>	
	
		<form:errors element="div" cssClass="error-color"/>
			<ul>
				<li>
					<label for="faq_title">제목</label>
					<form:input path="faq_title"/><br>
					<form:errors path="faq_title" cssClass="error-color"/>
				</li>
				<li>
					<label for="faq_content">내용</label>
					<form:input path="faq_content"/><br>
					<form:errors path="faq_content" cssClass="error-color"/>
				</li>
				<li>
					<label for="upload01">이미지 01</label>
					<input type="file" name="upload01" id="upload01"><br>
					<c:if test="${!empty command.faq_filename01}">
						<br>
						<span>(${command.faq_filename01})파일이 등록되어 있습니다.
						다시 업로드하면 기존 파일은 삭제됩니다.</span>
					</c:if>
				</li>
				<li>
					<label for="upload02">이미지 02</label>
					<input type="file" name="upload02" id="upload02"><br>
					<c:if test="${!empty command.faq_filename02}">
						<br>
						<span>(${command.faq_filename02})파일이 등록되어 있습니다.
						다시 업로드하면 기존 파일은 삭제됩니다.</span>
					</c:if>
				</li>
				<li>
					<label for="upload03">이미지 03</label>
					<input type="file" name="upload03" id="upload03"><br>
					<c:if test="${!empty command.faq_filename03}">
						<br>
						<span>(${command.faq_filename03})파일이 등록되어 있습니다.
						다시 업로드하면 기존 파일은 삭제됩니다.</span>
					</c:if>
				</li>
				<li>
					<label for="upload04">이미지 04</label>
					<input type="file" name="upload04" id="upload04"><br>
					<c:if test="${!empty command.faq_filename04}">
						<br>
						<span>(${command.faq_filename04})파일이 등록되어 있습니다.
						다시 업로드하면 기존 파일은 삭제됩니다.</span>
					</c:if>
				</li>
				<li>
					<input type="submit" value="수정">
				</li>
			</ul>
		</form:form>
		<div class="form-group">
        	 <div class="col-xs-10 col-xs-offset-2">
                <div class="btn-group btn-group-justified" role="group">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqlist.do'">FAQ게시판</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/home.do'">홈으로</button>
                    </div>
                </div>
       		</div>
        </div>
</div>