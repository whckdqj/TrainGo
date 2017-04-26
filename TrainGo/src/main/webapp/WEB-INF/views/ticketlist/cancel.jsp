<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   

<!DOCTYPE html >
<html>
<head>
<meta  charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function mysubmit(){
	
	var form = document.getElementById('form'); 
	var id=document.getElementById('id');
 	var check=document.getElementById('check');
 	var seatnum=document.getElementById('seatnum');
		var trainnum=document.getElementById('trainnum');
		var ticketnum=document.getElementById('ticketnum');
		id.value='${id}';
		trainnum.value='${trainnum }';
		ticketnum.value='${ticketnum }';
		seatnum.value='${seatnum}';
		alert(id.value);
		alert(trainnum.value);
		form.action="cancelConfirm.do";
		form.submit();
	
	


}
</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/passConfirm.js"></script>
</head>
<body>
취소하시 겠습니까? 비밀번호를 입력하세요
<input type="password" id="check">
<input type="hidden" id="id2" value="${id }">
<input type="button" value="확인" id="confirmPass">


 
<form id="form" method="post">
<input type="hidden" name="passwd" id="passwd">
<input type="hidden" name="id" id="id">
<input type="hidden" name="ticketnum" id="ticketnum">
<input type="hidden" name="trainnum" id="trainnum">
<input type="hidden" name="seatnum"	id="seatnum">
</form>
</body>
</html>