<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="image" align="center">
  		<img src="${pageContext.request.contextPath}/resources/img/seust.jpg" alt="Gsdk thumbnail3" />
 	</div>
<div class="page-main-style">
	<h2>회원상세정보</h2>
	<div class="bs-example" data-example-id="contextual-table">
    <table class="table">
      <tbody>
        <tr class="active">
          <th scope="row">아이디 :  ${member.id}</th>
          <td></td>
        </tr>
        <tr>
          <th scope="row">이름 :  ${member.name}</th>
          <td class="col-xs-3"></td>
        </tr>
        <tr class="success">
          <th scope="row">전화번호 :  ${member.phone}</th>
          <td></td>
        </tr>
        <tr>
          <th scope="row">이메일 :  ${member.email}</th>
          <td></td>
        </tr>
        <tr class="info">
          <th scope="row">우편번호 :  ${member.zipcode}</th>
          <td></td>
        </tr>
        <tr>
          <th scope="row">주소 :  ${member.address1}</th>
          <td></td>
        </tr>
        <tr class="warning">
          <th scope="row">상세주소 :  ${member.address2}</th>
          <td></td>
        </tr>
        <tr>
          <th scope="row">가입일 :  ${member.reg_date}</th>
          <td></td>
        </tr>
      </tbody>
    </table>
  </div>
	<hr size="1" width="100%">
	<div class="align-right">
		<input type="button" class="btn btn-success" value="수정" onclick="location.href='memberModify.do'">
		<input type="button" class="btn btn-primary" value="회원탈퇴" onclick="location.href='memberDelete.do'">
	</div>
</div>