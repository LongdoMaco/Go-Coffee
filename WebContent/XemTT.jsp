<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="form.KhachHangForm"%>
<%@page import="common.StringProcess"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@include file="/header.jsp"%>
<script src="//cdn.jsdelivr.net/webshim/1.14.5/polyfiller.js"></script>
<script>
	webshims.setOptions('forms-ext', {
		types : 'date'
	});
	webshims.polyfill('forms forms-ext');
</script>
<script type="text/javascript">
	function PreviewImage() {
		var oFReader = new FileReader();
		oFReader.readAsDataURL(document.getElementById("uploadImage").files[0]);
		oFReader.onload = function(oFREvent) {
			document.getElementById("uploadPreview").src = oFREvent.target.result;
		};
	}
</script>
<!-- code -->
<div class="container" style="margin-top: 120px">
<div class="panel panel-default panelnth">
<div class="panel-body">

<h1>Sửa thông tin người dùng</h1>
<div class="form">
	<div class="col-sm-6">
		<div class="form-group"><label for="usr">Username: </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:write name="khachHangForm" property="userName" /> <html:hidden
			styleClass="form-control" name="khachHangForm" property="userName"></html:hidden>
		</div>
		<div class="form-group">
			<label for="usr">Họ Tên:</label> 
			<bean:write name="khachHangForm" property="tenKhachHang" />
		</div>
		<div class="form-group"><label for="pwd">Địa chỉ:</label> 
			<bean:write name="khachHangForm" property="diaChi" />
		</div>
		<div class="form-group"><label for="usr">Số Điện Thoại:</label> 
			<bean:write name="khachHangForm" property="sDT" />
		</div>
		<div class="form-group"><label for="pwd">Ngay Sinh:</label> 
			<bean:write name="khachHangForm" property="ngaySinh"></bean:write>
		</div>
		<div class="form-group">
			<label for="pwd">Giới Tính:<Br/></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<html:radio name="khachHangForm" property="gioiTinh" value="1">Nam</html:radio>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<html:radio name="khachHangForm" property="gioiTinh" value="0">Nữ</html:radio>
		</div>
		<div class="form-group"><label for="pwd">Email:<Br/>
			</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<bean:write name="khachHangForm" property="email"></bean:write>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<div class="form-group">
			<label for="pwd">Thiết lập quyền hạn:<Br/></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<logic:equal name="khachHangForm" property="quyenhan" value="3">Khách Hàng</logic:equal>
			<logic:equal name="khachHangForm" property="quyenhan" value="2">Nhân viên</logic:equal>
			<logic:equal name="khachHangForm" property="quyenhan" value="1">Admin</logic:equal>
		</div>
		<div class="form-group">
			<label for="pwd">Block:</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		
			<logic:equal name="khachHangForm" property="block" value="1">blocked</logic:equal> 
			<logic:equal name="khachHangForm" property="block" value="0">unblock</logic:equal>
		
		</div>
		<div class="form-group">
		<html:button styleClass="btn btn-primary"  value="Quay Lại" onclick="history.back(-1);" property="back"></html:button></div>
	</div>
	<div class="col-sm-6" style="border: 2px solid #ccc; border-radius: 4px">
		<!-- Hình ảnh --> 
		<img id="uploadPreview" style="margin-top: 15px" width="100%" src="C:/image/<bean:write name="khachHangForm" property="hinhAnh"></bean:write>" /> <br/>
		<br/>
	</div>
</div>


</div>
</div>
</div>
<!-- /code -->
<%@include file="/footer.html"%>
