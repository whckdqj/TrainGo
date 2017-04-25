<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="page-main-style">
	<form:form action="infoupdate.do" commandName="command" cssClass="form-horizontal" enctype="multipart/form-data" id="update_form" method="post">
	<legend>Information</legend>
	<c:if test="${command.code==1}"><h4>Food Information</h4></c:if>
	<c:if test="${command.code==2}"><h4>Festival Information</h4></c:if>
	<c:if test="${command.code==3}"><h4>Sightseeing Information</h4></c:if>
	<input type="hidden" name="id" value="${userId}">
		<div class="form-group">
		<c:if test="${command.code==1}">
			<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=1'">Food Information</button>
			<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=2'">Festival Information</button>
			<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=3'">Sightseeing Information</button>
		</c:if>
		<c:if test="${command.code==2}">
			<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=1'">Food Information</button>
			<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=2'">Festival Information</button>
			<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=3'">Sightseeing Information</button>
		</c:if>
		<c:if test="${command.code==3}">
			<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=1'">Food Information</button>
			<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=2'">Festival Information</button>
			<button type="button" class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=3'">Sightseeing Information</button>
		</c:if>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/faqBoard/faqlist.do'">FAQ</button>
		<button type="button" class="btn btn-default" onclick="location.href='${pageContext.request.contextPath}/board/freeBoard/freelist.do'">FREE BOARD</button>
		</div>
		<div class="form-group">
			<label for="code" class="col-xs-2 control-label">게시판 설정</label>
			<div class="col-xs-10">
			<c:if test="${command.code==1}">
				<select name="code" class="form-control col-xs-9" id="code">
					<option value="1" selected>맛집</option>
					<option value="2">축제</option>
					<option value="3">관광지</option>
				</select>
			</c:if>
			<c:if test="${command.code==2}">
				<select name="code" class="form-control col-xs-9" id="code">
					<option value="1">맛집</option>
					<option value="2" selected>축제</option>
					<option value="3">관광지</option>
				</select>
			</c:if>
			<c:if test="${command.code==3}">
				<select name="code" class="form-control col-xs-9" id="code">
					<option value="1">맛집</option>
					<option value="2">축제</option>
					<option value="3" selected>관광지</option>
				</select>
			</c:if>
			</div>
			<!-- 
			  복구시킬 것
			<label for="areaCode" class="col-xs-2 control-label">지역</label>
			<div class="col-xs-3">
				<select class="form-control" id="areaCode">
					
				</select>
			</div>
			<label for="nodeId" class="col-xs-2 control-label">역 코드</label>
			<div class="col-xs-5">
				<select name="nodeId" class="form-control" id="nodeId">
					<option selected="selected">지역을 선택해 주십시요.</option>
				</select>
			</div> -->
			
			<!-- 이하 내용은 테스트용으로 구현시 삭제할 것 -->
			
			<select name="citycode" class="form-control col-xs-9" id="citycode">
				<option value="11">서울</option>
				<option value="25">대전</option>
				<option value="22">대구</option>
				<option value="21">부산</option>
			</select>
			
			
			<select name="nodeId" class="form-control col-xs-9" id="nodeId">
				<option value="NAT010000">서울역</option>
				<option value="NAT011668">대전역</option>
				<option value="NAT013239">대구역</option>
				<option value="NAT014445">부산역</option>
			</select>
			
		</div>
	
		<form:errors element="div" cssClass="error-color"/>
			<ul>
				<li>
					<label for="content_title">제목</label>
					<form:input path="content_title"/><br>
					<form:errors path="content_title" cssClass="error-color"/>
				</li>
				<li>
					<label for="content_introduction">내용</label>
					<form:input path="content_introduction"/><br>
					<form:errors path="content_introduction" cssClass="error-color"/>
				</li>
				<li>
					<label for="upload01">이미지 01</label>
					<input type="file" name="upload01" id="upload01"><br>
					<c:if test="${!empty command.info_filename01}">
						<br>
						<span>(${command.info_filename01})파일이 등록되어 있습니다.
						다시 업로드하면 기존 파일은 삭제됩니다.</span>
					</c:if>
				</li>
				<li>
					<label for="upload02">이미지 02</label>
					<input type="file" name="upload02" id="upload02"><br>
					<c:if test="${!empty command.info_filename02}">
						<br>
						<span>(${command.info_filename02})파일이 등록되어 있습니다.
						다시 업로드하면 기존 파일은 삭제됩니다.</span>
					</c:if>
				</li>
				<li>
					<label for="upload03">이미지 03</label>
					<input type="file" name="upload03" id="upload03"><br>
					<c:if test="${!empty command.info_filename03}">
						<br>
						<span>(${command.info_filename03})파일이 등록되어 있습니다.
						다시 업로드하면 기존 파일은 삭제됩니다.</span>
					</c:if>
				</li>
				<li>
					<label for="upload04">이미지 04</label>
					<input type="file" name="upload04" id="upload04"><br>
					<c:if test="${!empty command.info_filename04}">
						<br>
						<span>(${command.info_filename04})파일이 등록되어 있습니다.
						다시 업로드하면 기존 파일은 삭제됩니다.</span>
					</c:if>
				</li>
				<li>
					<label for="upload05">이미지 05</label>
					<input type="file" name="upload05" id="upload05"><br>
					<c:if test="${!empty command.info_filename05}">
						<br>
						<span>(${command.info_filename05})파일이 등록되어 있습니다.
						다시 업로드하면 기존 파일은 삭제됩니다.</span>
					</c:if>
				</li>
				<li>
					<label for="upload06">이미지 06</label>
					<input type="file" name="upload06" id="upload06"><br>
					<c:if test="${!empty command.info_filename06}">
						<br>
						<span>(${command.info_filename06})파일이 등록되어 있습니다.
						다시 업로드하면 기존 파일은 삭제됩니다.</span>
					</c:if>
				</li>
				<li>
					<label for="upload07">이미지 07</label>
					<input type="file" name="upload07" id="upload07"><br>
					<c:if test="${!empty command.info_filename07}">
						<br>
						<span>(${command.info_filename07})파일이 등록되어 있습니다.
						다시 업로드하면 기존 파일은 삭제됩니다.</span>
					</c:if>
				</li>
				<li>
					<label for="upload08">이미지 08</label>
					<input type="file" name="upload08" id="upload08"><br>
					<c:if test="${!empty command.info_filename08}">
						<br>
						<span>(${command.info_filename08})파일이 등록되어 있습니다.
						다시 업로드하면 기존 파일은 삭제됩니다.</span>
					</c:if>
				</li>
				<li>
					<label for="upload09">이미지 09</label>
					<input type="file" name="upload09" id="upload09"><br>
					<c:if test="${!empty command.info_filename09}">
						<br>
						<span>(${command.info_filename09})파일이 등록되어 있습니다.
						다시 업로드하면 기존 파일은 삭제됩니다.</span>
					</c:if>
				</li>
				<li>
					<label for="upload10">이미지 10</label>
					<input type="file" name="upload10" id="upload10"><br>
					<c:if test="${!empty command.info_filename10}">
						<br>
						<span>(${command.info_filename10})파일이 등록되어 있습니다.
						다시 업로드하면 기존 파일은 삭제됩니다.</span>
					</c:if>
				</li>
				<li>
					<c:if test="${!empty userId && userId=='admin'}">
					<input type="submit" value="수정">
					</c:if>
					<c:if test="${empty userId}">
					<input type="submit" value="수정" disabled="disabled">
					</c:if>
				</li>
			</ul>
			<div class="col-xs-10 col-xs-offset-2">
                <div class="btn-group btn-group-justified" role="group">
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/board/informationBoard/infolist.do?code=${command.code}'">게시판</button>
                    </div>
                    <div class="btn-group" role="group">
                        <button type="button" class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/home.do'">홈으로</button>
                    </div>
                </div>
         	</div>
	</form:form>
	
</div>