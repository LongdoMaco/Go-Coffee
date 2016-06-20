
<%@page import="form.SanPhamForm"%>
<%@page import="model.bean.*"%>
<%@page import="common.StringProcess"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<%@include file="header.jsp" %>
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
		
			var img = document.getElementById("uploadImage");
			oFReader.onload = function(oFREvent) {
				document.getElementById("uploadPreview").src = oFREvent.target.result;
			};
		}
	}
</script>
<div class="container" style="padding-top:120px">
    <div class="panel panel-default">
   		<div class="panel-body">
    	<div class="panel panel-info col-sm-6" style="margin:0 auto; float:none">
    		<div class="panel-body">
    		<h3>Thêm sản phẩm</h3>
    		<label style="color:red"><html:errors property="loiaddsp"/></label>
    		<html:form action="themsanpham.do" enctype="multipart/form-data">
		        <div class="row form-group">
		            <label class="col-sm-12">Tên Sản Phẩm</label>
		            <div class="col-sm-12">
		                <html:text name ="sanPhamForm" property="tenSanPham" styleClass="form-control"></html:text>
		            </div>
		        </div>
		        <div class="row form-group">
		            <label class="col-sm-12">Giá Bán</label>
		            <div class="col-sm-12">
		            	<html:text name ="sanPhamForm" property="giaBan" styleClass="form-control"></html:text>
		            </div>
		        </div>
		        <div class="row form-group">
		        	<label class="col-sm-12">Phân loại:</label>
		        	<div class="col-sm-12">
			             <html:select name="sanPhamForm" property="maLoaiSP" styleClass="form-control">
							<html:optionsCollection name="sanPhamForm" property="listMaLoai" value="maLoaiSP" label="tenLoai"/>
						</html:select>
					</div>
		        </div>
		        <div class="form-group row col-sm-12" style="margin-left:0px;border: 2px solid #ccc; border-radius: 4px">
					<img  id="uploadPreview" style="margin-top: 15px;width:100%; height:100%" width="100%" height="100%" src="images/imagesp/add_default.JPG" /> <br/>
						<br />
					<html:file styleId="uploadImage" style="margin-bottom: 15px" property="image" name="sanPhamForm" onchange="PreviewImage();" />
				</div>
		        <div class="row form-group" style="margin-top:20px">
            		<div class="space col-md-1"></div>
            		<html:submit styleClass= "btn btn-primary col-md-4" property="submit" value="Submit"/>
            		<div class="space col-md-1"></div>
            		<html:button styleClass= "btn btn-primary col-md-4" property="submit" value="Quay Lại" onclick="window.location = 'showTrangChu.do'"></html:button>
		        </div>
        	</html:form>
    	</div>
    	</div>
    	<div class="space col-md-3"></div>
    </div>	
    </div>
</div>
<%@include file="footer.html"%>