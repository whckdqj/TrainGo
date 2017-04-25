<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매 예약</title>


<!-- Custom Style -->
<link href="${pageContext.request.contextPath}/resources/css/main.css"
	rel="stylesheet">
<!-- BootStrap -->
<link
	href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"
	rel="stylesheet">
<!-- jQuery UI Component -->
<link
	href="${pageContext.request.contextPath}/resources/css/jquery-ui.min.css"
	rel="stylesheet">
<!-- Plugins-CSS -->
<link
	href="${pageContext.request.contextPath}/resources/css/slick-theme.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/slick.css"
	rel="stylesheet">
<!-- jQuery -->
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-3.1.1.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery-ui.min.js"></script>
<!-- Plugins-JS -->
<script src="${pageContext.request.contextPath}/resources/js/slick.js"></script>
<!-- CustomScript -->
<script
	src="${pageContext.request.contextPath}/resources/js/reservation_hdl.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/js/table_hdl.js"></script>
</head>
<body>
	${user_id} 이 오토시트는 뭐였지? ${autoseat}

	<div class="container">


		<%-- Contents Area --%>

		<div class="col-xs-12">
			<div class="col-xs-2 col-xs-offset-10">
				<div class="btn-group" role="group">
					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown" aria-expanded="false">
						관리자전용 <span class="caret"></span>
					</button>

					<ul class="dropdown-menu" role="menu">

						<c:if test="${!empty user_id && user_id=='admin'}">
							<li><a
								href="${pageContext.request.contextPath}/autotrain.do">좌석 생성</a></li>
							<c:choose>
								<c:when test="${autoseat eq 0}">
									<li><a
										href="${pageContext.request.contextPath}/autotrainon.do">좌석
											자동 생성 설정</a></li>
								</c:when>
								<c:otherwise>
									<li><a
										href="${pageContext.request.contextPath}/autotrainoff.do">좌석
											자동 생성 해제</a></li>
								</c:otherwise>
							</c:choose>
						</c:if>

						<li><a
							href="${pageContext.request.contextPath}/ticketlist.do?user_id=${user_id}">예약자
								확인</a></li>









					</ul>
				</div>
			</div>
		</div>

		<div class="col-xs-12">
			<form class="form-horizontal" id="reservation">
				<fieldset>
					<div class="form-group">
						<label for="area_dep" class="col-xs-2 control-label">출발지</label>
						<div class="col-xs-2">
							<select class="form-control" id="area_dep" name="dep_citycode">
								<option selected="selected" value="0">출발지 로딩중...</option>
							</select>
						</div>
						<label for="stn_dep" class="col-xs-2 control-label">출발역</label>
						<div class="col-xs-3">
							<select class="form-control" id="stn_dep" name="depplaceid">
								<option selected="selected">출발지를 선택해 주세요</option>
							</select>
						</div>
					</div>


					<div class="form-group">
						<label for="area_arr" class="col-xs-2 control-label">도착지</label>
						<div class="col-xs-2">
							<select class="form-control" id="area_arr" name="arr_citycode">
								<option selected="selected" value="0">도착지 로딩중...</option>
							</select>
						</div>
						<label for="stn_arr" class="col-xs-2 control-label">도착역</label>
						<div class="col-xs-3">
							<select class="form-control" id="stn_arr" name="arrplaceid">
								<option selected="selected">도착지를 선택해 주세요</option>
							</select>
						</div>
					</div>


					<div class="form-group">
						<label for="startdate" class="col-xs-2 control-label">출발일</label>
						<div class="col-xs-3">
							<input type="text" class="form-control col-xs-2" id="startdate"
								name="startdate" required="required">
						</div>
						<div class="col-xs-6"></div>
					</div>

					<!-- 인원수 설정 가능  -->
					<div class="form-group">
						<label for="area_arr" class="col-xs-1 control-label">어른</label>
						<div class="col-xs-1">
							<select class="form-control" id="mancount" name="mancount"
								required="required">
								<option value="0">0명</option>
								<option value="1">1명</option>
								<option value="2">2명</option>
								<option value="3">3명</option>
								<option value="4">4명</option>
								<option value="5">5명</option>
								<option value="6">6명</option>
								<option value="7">7명</option>
								<option value="8">8명</option>
								<option value="9">9명</option>
							</select> <label for="area_arr" class="col-xs-1 control-label">아이</label>
							<select class="form-control" id="childrencount"
								name="childrencount" required="required">
								<option value="0">0명</option>
								<option value="1">1명</option>
								<option value="2">2명</option>
								<option value="3">3명</option>
								<option value="4">4명</option>
								<option value="5">5명</option>
								<option value="6">6명</option>
								<option value="7">7명</option>
								<option value="8">8명</option>
								<option value="9">9명</option>
							</select> <label for="area_arr" class="col-xs-1 control-label">노약자</label>
							<select class="form-control" id="oldcount" name="oldcount"
								required="required">
								<option value="0">0명</option>
								<option value="1">1명</option>
								<option value="2">2명</option>
								<option value="3">3명</option>
								<option value="4">4명</option>
								<option value="5">5명</option>
								<option value="6">6명</option>
								<option value="7">7명</option>
								<option value="8">8명</option>
								<option value="9">9명</option>
							</select>





							<div class="col-xs-1">
								<input type="submit" class="btn btn-info" id="runCheck"
									value="자리확인">
							</div>
						</div>
					</div>


				</fieldset>
			</form>
		</div>



		<div class="col-xs-12" id="reservationcar" style="display: none;">
			<h4 class="text-center">
				<strong>*** 예약 가능한 차량이 아래 표시됩니다! 확인해주세요 ***</strong>
			</h4>
			<table class="table table-hover">
				<thead>
					<tr>
						<th>열차번호</th>
						<th>열차종류</th>
						<th>출발역</th>
						<th>출발시간</th>
						<th>도착역</th>
						<th>도착시간</th>
						<th>금액</th>
						<th>남은자릿수</th>
						<th>예매</th>
					</tr>
				</thead>
				<tbody id="resertable">

				</tbody>
			</table>
		</div>


	</div>



	<div class="container">
	
		<div class="modal fade" id="myModal">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">x</button>
						<h3 id="myModalLabel">가격 상세표</h3>
						<div class="modal-body">
							<table class="table table-hover">
								<thead>
									<tr>
										<th>구분</th>
										<th>인원</th>
										<th>금액</th>
										<th>합계</th>
									</tr>
								</thead>
								<tbody id="costtable">
								</tbody>
							</table>
							
							<label class="col-xs-7 control-label"></label>
							<label class="col-xs-2 control-label">총 금액:</label><label
							class="col-xs-3 control-label" id="totaltotalcost"></label>
							<br>													
							
							

						</div>
						<div class="modal-footer">
							<button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
						
						</div>
					</div>
				</div>
			</div>
		</div>



	</div>


















</body>
</html>