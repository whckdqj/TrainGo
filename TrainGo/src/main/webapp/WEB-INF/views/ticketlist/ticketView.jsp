<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta  charset="UTF-8">
<title>티켓 예매취소</title>
<style>
	table td{
		width:100px;
		text-align: center;
	}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/ticketlist.js"></script> 
<script type="text/javascript">
	
	function mysubmit(type,index){
	
		if(type==1){
		var data = document.getElementById(index);
 		var form = document.getElementById('form'); 
	 	
 		var trainnum=document.getElementById('trainnum');
 		var ticketnum=document.getElementById('ticketnum');
 		var id=document.getElementById('id');
 		var seatnum=document.getElementById('seatnum');
 		trainnum.value=data.cells[1].innerHTML;
 		ticketnum.value=data.cells[0].innerHTML;
 		seatnum.value=data.cells[7].innerHTML;
 		id.value='${id}';
 
 		form.action="ticketlist.do";
		form.submit();
		}else if(type==2){
			var data = document.getElementById(index);
	 		var form = document.getElementById('form'); 
		 	
	 		var trainnum=document.getElementById('trainnum');
	 		var ticketnum=document.getElementById('ticketnum');
	 		var seatnum=document.getElementById('seatnum');
	 		var id=document.getElementById('id');
	 		trainnum.value=data.cells[1].innerHTML;
	 		ticketnum.value=data.cells[0].innerHTML;
	 		seatnum.value=data.cells[7].innerHTML;
	 		id.value='${id}';
	 		form.action="cancel.do";
			form.submit();
			
		}else if(type==3){
		    var data = document.getElementById(index);
	 		var form = document.getElementById('form'); 
	 		var id=document.getElementById('id');
	 		var trainnum=document.getElementById('trainnum');
	 		var ticketnum=document.getElementById('ticketnum');
	 		var seatnum=document.getElementById('seatnum');
	 		var id=document.getElementById('id');
	 		trainnum.value=data.cells[1].innerHTML;
	 		ticketnum.value=data.cells[0].innerHTML;
	 		seatnum.value=data.cells[7].innerHTML;
	 		id.value='${id}';
	 		form.action="reserveF.do";
	 		form.submit();
		}
	}
	
	


		
</script>
</head>
<body>
<div class="align-center">	
<h2>예매 내역</h2>
<hr size="1" noshade>
<c:if test="${empty list }">
 예매 내역이 없습니다. 
</c:if>
<c:if test="${!empty list }">
<table id="table">
<TR>
	<td>티켓 번호</td>
	<td>기차 번호</td>
	<td>열차 이름</td>
	<td>출발역</td>
	<td>도착역</td>
	<td>기차 출발시간</td>
	<td>기차 도착시간</td>
	<td>좌석번호</td>
    <td>가격</td>
	<td>예매 취소</td>
</TR>
<c:forEach var="cs" items="${ list}" varStatus="status" >

<TR id="a${status.count }">

	<TD>${cs.ticketnum}</TD>
	<TD>${cs.trainnum }</TD>
	<TD>${cs.trainname }</TD>
	<TD>${cs.departsta }</TD>
	<TD>${cs.arrivalsta }</TD>
	<TD>${cs.departtime }</TD>
	<TD>${cs.arrivaltime }</TD>
    
	<td>${cs.seatnum }</td>
	<td>${cs.cost }</td>
	<td><input type="button" value="취소" onclick='mysubmit(2,"a"+${status.count})'></td>
</TR>

</c:forEach> 
</table>
</c:if>	
<h2>취소 내역</h2> <br>
<hr size="1" noshade>
<c:if test="${empty list2 }">
취소내역이 없습니다. 
</c:if>
<c:if test="${!empty list2 }">
<table id="table">
<TR>
	<td>티켓 번호</td>
	<td>기차 번호</td>
	<td>열차 이름</td>
	<td>출발역</td>
	<td>도착역</td>
	<td>기차 출발시간</td>
	<td>기차 도착시간</td>
	<td>좌석번호</td>
    <td>가격</td>
	<td>예매 수정</td>
</TR>
<c:forEach var="cs" items="${ list2}" varStatus="status" >

<TR id="b${status.count }">

	<TD>${cs.ticketnum}</TD>
	<TD>${cs.trainnum }</TD>
	<TD>${cs.trainname }</TD>
	<TD>${cs.departsta }</TD>
	<TD>${cs.arrivalsta }</TD>
	<TD>${cs.departtime }</TD>
	<TD>${cs.arrivaltime }</TD>
	<td>${cs.seatnum }</td>
    <td>${cs.cost }</td>
	<td><input type="button" value="처음부터" onclick='mysubmit(3,"b"+${status.count})'><br>
    <input type="button" value="재예매" onclick='mysubmit(1,"b"+${status.count})'></td>
</TR>

</c:forEach> 
</table>
</c:if>	

</div>
<form:form id="form" commandName="command" >
<input type="hidden" name="id" id="id">
<input type="hidden" name="ticketnum" id="ticketnum">
<input type="hidden" name="trainnum" id="trainnum">
<input type="hidden" name="seatnum" id="seatnum">

</form:form>




			


</body>
</html>
