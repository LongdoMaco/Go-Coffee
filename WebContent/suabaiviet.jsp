<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@include file="/header.jsp" %>
<!-- ..Body.. -->
<link rel="stylesheet" href="css/alert.css">
<script type="text/javascript" src="javascript/com/alert.js">
</script>
<script type="text/javascript" src="javascript/com/validateInput.js">
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


	$(document).ready(function(){
	    $('[data-toggle="tooltip"]').tooltip();   
	});

	function goQuanLyBaiViet() {
		window.location = "showQuanLyBaiViet.do";
	}
</script>
<div class="container" style="margin-top:120px">
		<div class="panel panel-default panelnth">
	  		<div class="panel-body">
				<div style="color: #66FF66">
					<center> <h2> SỬA BÀI ĐĂNG </h2> </center>
				</div>
			</div>
		</div>
		
		<!-- Noi dung o day ne........................ -->
		<div class="panel panel-default panelnth">
	  		<div class="panel-body">
	  		<html:form action="suabaiviet" enctype="multipart/form-data">
				<table>
					<tr>
						<td style="width: 100px"> Tiêu đề: </td>
						<td>  
							<html:text styleId="Tiêu Đề" name="baiVietForm" property="tieuDeBaiViet" styleClass="form-control" style="width: 700px"></html:text>
						</td>
					</tr>
						
					<tr >
						<td> Chủ đề: </td>
						<td>
							<html:select name="baiVietForm" property="maLoaiBaiViet" styleClass="btn btn-primary dropdown-toggle">
								<html:optionsCollection name="baiVietForm" property="listLoaiBaiViet" label="tenLoaiBaiViet" value="maLoaiBaiViet"/>
							</html:select>
						</td>
					</tr>
						
					<tr>
						<td> Hình ảnh: </td>
						<td>  
							<div class="col-sm-6" style="margin-top: 20px; border: 2px solid #ccc; border-radius: 4px">
								<img id="uploadPreview" style="margin-top: 15px" width="100%" src="<bean:write name="baiVietForm" property="hinhAnh"></bean:write>" /> <br/><br/>
								<html:hidden property="hinhAnh" name="baiVietForm"/>
								<input type="file" id="uploadImage" style="margin-bottom: 15px" name="image" onchange="PreviewImage();" />
							</div>
						</td>
					</tr>
					
					<tr height="200px" style="margin-top: 20px">
						<td style="width: 100px"> Nội dung: </td>
						<td>  
							<html:textarea styleId="Nội Dung Bài Viết" name="baiVietForm" title="Nếu loại bài viết thì vui lòng gõ nội dung vào đây.  còn nếu là video thì đưa link nhúng video vào Nếu là nhạc thì đưa link nhúng nhạc vào. chấm hết" property="noiDungBaiViet" styleClass="form-control" style="height: 200px"></html:textarea>
							
						</td>
					</tr>	
						
					<tr >
						<td style="width: 100px"> </td>
						<td>
							<div style="float: right;">
								<html:submit property="submit" value="Sửa" onclick="return checkThemBaiViet('Tiêu Đề', 50, 'Nội Dung Bài Viết', 3000)" styleClass="btn btn-primary"/>
								<bean:define id="x" name="baiVietForm" property="maBaiViet"/>
								<bean:define id="y" name="baiVietForm" property="userName"/>
								<html:hidden property="maBaiViet" value="${x}"/>
								<html:hidden property="userName" value="${y}"/>
								<input type="button" class="btn btn-primary" onclick="goQuanLyBaiViet()" value="Quay lại">
							</div>  
							
						</td>
					</tr>
					
				</table>
				</html:form>
			</div>
		</div>
</div>	
<%@include file="footer.html"%>