<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
   .h2{
      text-align:center;
      color:blue;
   }
   img{ 
      width:1000px;
      height:600px;
      display:block;
      margin:0 auto; 
   }
   .align-center{
      text-align:center;
   }
   .align-center input{
      inputfloat:left; 
      width:140px; 
      text-align:center; 
      line-height:35px; 
      color:#3c3f91;
   }
</style>
<img src="${pageContext.request.contextPath}/resources/img/EP.png"><br>
   
<div class="align-center">
  <input type="button" onclick="location.href='home.do'" value="메인페이지로">
</div>
<%
	Throwable e = (Throwable)request.getAttribute("exception");
	e.printStackTrace();
%>