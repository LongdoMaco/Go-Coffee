<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="form.KhachHangForm"%>
<%@page import="common.StringProcess"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@include file="/header.jsp"%>
<script src="http://cdn.jsdelivr.net/webshim/1.12.4/extras/modernizr-custom.js"></script>
<script src="http://cdn.jsdelivr.net/webshim/1.12.4/polyfiller.js"></script>
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
		var s = document.getElementById("uploadImage").value;
		
		var ss = s.substring(s.lastIndexOf("."));
		console.log(ss);
		if( ss != ".jpg"  && ss != ".png" && ss != ".JPG"  && ss != ".PNG"){
			alert("Vui lòng chọn đúng định dạng ảnh là jpg hoặc png");
			return;
		}
		var img = document.getElementById("uploadImage");
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
<html:errors property="updateError"/>
<form class="form" method="post" enctype="multipart/form-data" action="suaTT.do">
	<div class="col-sm-6">
		<div class="form-group"><label for="usr">Username: </label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<bean:write name="khachHangForm" property="userName" /> 
			<html:hidden
			styleClass="form-control" name="khachHangForm" property="userName"></html:hidden>
		</div>
		<div class="form-group"><label for="usr">Họ Tên:</label> <html:text
			styleClass="form-control" styleId="tenkh" name="khachHangForm" property="tenKhachHang"></html:text>
		</div>
		<div class="form-group"><label for="pwd">Địa chỉ:</label> 
		<html:text
			styleClass="form-control" styleId="dckh" name="khachHangForm" property="diaChi"></html:text>
		</div>
		<div class="form-group"><label for="usr">Số Điện Thoại:</label> 
		<html:text
			styleClass="form-control" styleId="sdtkh" name="khachHangForm" property="sDT"></html:text>
		</div>
		<div class="form-group"><label for="pwd">Ngày Sinh:</label> <input
			type="date" class="form-control" id="nskh" name="ngaySinh"
			value="<bean:write name="khachHangForm" property="ngaySinh"></bean:write>" />
		
		</div>
		
		<div class="form-group">
			<label for="pwd">Giới Tính:<Br/></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<html:radio name="khachHangForm" property="gioiTinh" value="1">Nam</html:radio>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<html:radio name="khachHangForm" property="gioiTinh" value="0">Nữ</html:radio>
		</div>
		
		<div class="form-group">
			<label for="pwd">Email:</label><Br />
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
			<html:text styleClass="form-control" styleId="emailkh" name="khachHangForm" property="email"/> 
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		</div>
		<logic:equal name="khachHangForm" property="mucDoSua" value="1">
			<div class="form-group">
				<label for="pwd">Thiết lập quyền hạn:</label><Br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<html:select  name="khachHangForm" property="quyenhan" styleClass="form-control" styleId="sel1">
					<html:option value="3">Khách Hàng</html:option>
					<html:option value="2">Nhân Viên</html:option>
				</html:select>
			</div>
			<div class="form-group">
				<label for="pwd">Block:<Br/>
				</label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<div class="checkbox">
					<logic:equal name="khachHangForm" property="block" value="1">
						<input type="checkbox" checked="checked" name="block" value="1"> 
						blocked
					</logic:equal> 
					<logic:equal name="khachHangForm" property="block" value="0">
						<input type="checkbox" name="block" value="1">
					</logic:equal>
				</div>
			</div>
		</logic:equal>
		
		<logic:notEqual name="khachHangForm" property="mucDoSua" value="1">
			<div class="form-group"><label for="pwd">Thiết lập quyền hạn:</label><Br/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
				<html:select  name="khachHangForm" property="quyenhan" disabled="true" styleClass="form-control" styleId="sel1">
					<html:option value="3">Khách Hàng</html:option>
					<html:option value="2">Nhân Viên</html:option>
					<html:option value="1">Admin</html:option>
				</html:select>
			</div>
			<div class="form-group">
				<label for="pwd">Block:<Br/></label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<div class="checkbox">
					<logic:equal name="khachHangForm" property="block" value="1">
						<input type="checkbox" checked="checked" disabled="disabled" name="block" value="1"> 
						blocked
					</logic:equal> 
					<logic:equal name="khachHangForm" property="block" value="0">
						<input type="checkbox" disabled="disabled" name="block" value="1">
					</logic:equal>
				</div>
			</div>
		</logic:notEqual>
		
			<div class="form-group">
				<input type="submit" class="btn btn-primary" value="submit" name="submit">
			</div>
		</div>
		<div class="col-sm-6" style="margin-top: 80px; border: 2px solid #ccc; border-radius: 4px">
			<img id="uploadPreview" style="margin-top: 15px" width="100%" src="images/avatar/<bean:write name="khachHangForm" property="hinhAnh"></bean:write>" /> <br/><br/>
			<html:hidden property="hinhAnh" name="khachHangForm"/>
			<logic:notEqual name="khachHangForm" property="mucDoSua" value="3">
				<input type="file" id="uploadImage" style="margin-bottom: 15px" name="image" onchange="PreviewImage();" />
			</logic:notEqual>	
			
		</div>
	</form>


</div>
</div>
</div>
<!-- /code -->
<%@include file="/footer.html"%>
