<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.KhachHang"%>
<%@page import="java.util.ArrayList"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@include file="/header.jsp"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- code -->
<script type="text/javascript">

	function checkAll(id1, id2){
		if (checkInputNormal(id1, 30) && checkInputNormal(id2, 30)){
			return true;
		} else{ 
			return false;
		}
	}
	
	function checkInputNormal(id){
		if (checkNull(id)){
			if (checkAllSpace(id) && checkHaveSpace(id))
				if (checkMaxLength(id))
						return true;
		} else{ 
			return false;
		}	
	}
	
	function checkSDT(id){
		if (checkNull(id) && checkAllSpace(id) && checkMaxLength(id,12) && checkJustNumberic(id)){
			return true;
		}
			
			else return false;
	}
	
	function checkNull(id){
		var text = document.getElementById(id).value;
		if (text == null || text =="") {
			alert("Khong duoc de trong "+id);
			return false;
		} else {
			return true;
		}
	}
	
	function checkAllSpace(id){
		var text = document.getElementById(id).value;
		if (/^\s*$/.test(text)){
			alert("Loi: "+id +" chi chua khoang trang...");
			return false;
		}else return true;
	}
	
	function checkHaveSpace(id){
		var text = document.getElementById(id).value;
		
		if (text.indexOf(' ')>=0){
			alert(id+" co chua khoang trang.");
			return false;
		} else {
			return true;
		}
	}
	
	function checkMaxLength(id,gioiHan) {
		var text = document.getElementById(id).value;
		var textlength = text.length;
		
		if (textlength>=gioiHan) {
			alert(id+" qua do dai quy dinh");
			return false;
		}else {
			return true;
		}
	}
	
	function checkSpecialChar(id) {
		var text = document.getElementById(id).value;
		var regex = /[^\w\s]/gi;
		
		if (regex.test(text)){
			alert(id+ " chua ky tu dac biet.");
			return false;
		}else return true;
	}
	
	function checkJustNormalChar(id) {
		var text = document.getElementById(id).value;
		var regex = new RegExp("^[a-zA-Z]*$");
		
		if (!regex.test(text)){
			alert(id+ " chua ky tu khong phai la chu.");
			return false;
		} else return true;
	}
	
	function checkJustNumberic(id) {
		var text = document.getElementById(id).value;
		var regex = new RegExp("^[0-9]*$");
		
		if (!regex.test(text)){
			alert(id+ " chua ky tu khong phai la so.");
			return false;
		} else return true;
	}
</script>
<div class="container" style="margin-top: 120px; min-height:670px">
	<div class="panel panel-default panelnth">
		<div class="panel-body">
			<div class="col-sm-6">
				<h1>Đăng nhập vào hệ thống</h1>
				<div style="color:red;">
					<html:errors property="dangNhapError"/>
				</div>
				<html:form action="checkDangNhap.do" method="post" styleClass="form">
				
					<div class="form-group" style="width:100%">
						<label for="usr">Name:</label> 
						<html:text property="userName" styleId="username" styleClass="form-control"  />
						
					</div>
					<div class="form-group" style="width:100%">
						<label for="pwd">Password:</label> 
						<html:password styleClass="form-control" styleId="password"  property="password" />
					</div>
					<div class="form-group" style="width:100%">
						<div class="col-sm-6">
							<html:button styleClass="btn btn-primary" property="quenmk" value="Quên mật khẩu" onclick="window.alert('chức năng tạm thời chưa được update');"/> 
						</div>
						<div class="col-sm-6">
							<html:submit styleClass="btn btn-primary" onclick="return checkAll('username','password');"  value="Đăng nhập"/>
						</div>
					</div>
				</html:form>
				<i>Chào mừng đến với website bán cafe online, để có thể đặt hàng bạn phải có tài khoản, vui lòng nhập đầy đủ thông tin vào các ô bên dưới rồi nhấn nút <a style="color:green">Đăng Nhập</a>, nếu quên mật khẩu vui lòng click nút <a style="color:green">Quên mật khẩu</a></i>
			</div>
			<div class="col-sm-6"><img src="images/login.jpg" width="100%"></img></div>
			
		</div>
	</div>
</div>
<!-- /code -->
<%@include file="/footer.html"%>
