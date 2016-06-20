
<%@page import="form.SanPhamForm"%>
<%@page import="common.StringProcess"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@include file="/header.jsp" %>
<script>
	function PreviewImage() {
		var oFReader = new FileReader();
		oFReader.readAsDataURL(document.getElementById("uploadImage").files[0]);
		var s = document.getElementById("uploadImage").value;
		
		var ss = s.substring(s.lastIndexOf("."));
		console.log(ss);
		if( ss != ".jpg"  && ss != ".png" && ss != ".JPG"  && ss != ".PNG"){
			alert("Vui lòng chọn đúng định dạng ảnh là jpg hoặc png");
			return;
		}else{	
			var img = document.getElementById("uploadImage");
			oFReader.onload = function(oFREvent) {
				document.getElementById("uploadPreview").src = oFREvent.target.result;
			};
		
		}
	}
</script>
<div class="container">
<div class = col-sm-6>
	<h3>Tên Sản Phẩm: &nbsp; <bean:write name="sanPhamForm" property="tenSanPham"/></h3>
	
    <br>
    	<html:form action="/suaSP" enctype="multipart/form-data" method="post">
        <div class="row form-group">
            <label class="col-lg-2">Mã Sản Phẩm</label>
            <div class="col-lg-3">
            	 <html:text name ="sanPhamForm"  property="maSanPham" styleClass="form-control" readonly="true"></html:text>
            	
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Tên Sản Phẩm</label>
            <div class="col-lg-3">
                <html:text name ="sanPhamForm"  property="tenSanPham" styleClass="form-control"></html:text>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Giá Bán</label>
            <div class="col-lg-3">
            	<html:text name ="sanPhamForm"  property="giaBan" styleClass="form-control"></html:text>
            </div>
        </div>
        <div class="row form-group">
            <label class="col-lg-2">Loại Sản Phẩm</label><Br/>
            <div class="col-lg-6">
            	 <html:select name="sanPhamForm" property="maLoaiSP" styleClass="form-control">
					<html:optionsCollection name="sanPhamForm" property="listMaLoai" value="maLoaiSP" label="tenLoai"/>
				 </html:select>            
        	</div>
        </div>
        <div class="row form-group" style="margin:0px;border: 2px solid #ccc; border-radius: 4px">
        	<bean:define name="sanPhamForm" id="anh" property="hinhAnh"></bean:define>
			<img  id="uploadPreview" style="margin: 15px 15px 15px 15px;width:95%; height:95%" width="100%" height="100%" src="images/imagesp/${anh}" /> <br/>
				<br />
			<html:hidden property="hinhAnh" name="sanPhamForm" value="${anh}"/>
			<html:file styleId="uploadImage" style="margin-bottom: 15px" property="image" name="sanPhamForm" onchange="PreviewImage();" />
				</div>
        <div class="row form-group">
            <div class="col-lg-3 col-lg-offset-2">
            		<html:submit   styleClass= "btn btn-primary" property="submit" value="submit"/>
           			<html:button styleClass= "btn btn-primary" property="submit" value="Quay Lại" onclick="window.location = 'showTrangChu.do'"></html:button>
           			
            </div>
        </div>
        </html:form>
        </div>
</div>
<%@include file="/footer.html"%>