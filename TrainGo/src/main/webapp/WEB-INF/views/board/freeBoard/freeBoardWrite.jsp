<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-main-style">
	<form:form action="freewrite.do" commandName="freeBoardCommandId" cssClass="form-horizontal" enctype="multipart/form-data" id="write_form" method="post">
	<legend>Free Board</legend>
		<h4>Free Board Write</h4>
		<input type="hidden" name="id" value="${userId}">
		<div class="form-group">
		
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=1'">Food Information</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=2'">Festival Information</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=3'">Sightseeing Information</button>
		
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqlist.do'">FAQ</button>
		<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/board/freeBoard/freelist.do'">FREE BOARD</button>
		</div>	
		
	
		<form:errors element="div" cssClass="error-color"/>
			<ul>
				<li>
					<label for="free_title">제목</label>
					<form:input path="free_title"/><br>
					<form:errors path="free_title" cssClass="error-color"/>
				</li>
				<li>
					<label for="free_content">내용</label>
					<form:input path="free_content"/><br>
					<form:errors path="free_content" cssClass="error-color"/>
				</li>
				<li>
					<label for="upload01">이미지 01</label>
					<input type="file" name="upload01" id="upload01"><br>
				</li>
				<li>
					<label for="upload02">이미지 02</label>
					<input type="file" name="upload02" id="upload02"><br>
				</li>
				<li>
					<label for="upload03">이미지 03</label>
					<input type="file" name="upload03" id="upload03"><br>
				</li>
				<li>
					<label for="upload04">이미지 04</label>
					<input type="file" name="upload04" id="upload04"><br>
				</li>
				<li>
					<label for="upload05">이미지 05</label>
					<input type="file" name="upload05" id="upload05"><br>
				</li>
				<li>
					<label for="upload06">이미지 06</label>
					<input type="file" name="upload06" id="upload06"><br>
				</li>
				<li>
					<label for="upload07">이미지 07</label>
					<input type="file" name="upload07" id="upload07"><br>
				</li>
				<li>
					<label for="upload08">이미지 08</label>
					<input type="file" name="upload08" id="upload08"><br>
				</li>
				<li>
					<label for="upload09">이미지 09</label>
					<input type="file" name="upload09" id="upload09"><br>
				</li>
				<li>
					<label for="upload10">이미지 10</label>
					<input type="file" name="upload10" id="upload10"><br>
				</li>
				<li>
					<c:if test="${!empty userId}">
					<input type="submit" value="전송">
					</c:if>
					<c:if test="${empty userId}">
					<input type="submit" value="전송" disabled="disabled">
					</c:if>
				</li>
			</ul>
	</form:form>		
	<div class="form-group">
         <div class="col-xs-10 col-xs-offset-2">
                <div class="btn-group btn-group-justified" role="group">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/board/freeBoard/freelist.do'">자유게시판</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/home.do'">홈으로</button>
                    </div>
                </div>
         </div>
    </div>
</div>