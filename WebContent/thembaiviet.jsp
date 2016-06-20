<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	
<link rel="stylesheet" href="css/alert.css">
<script type="text/javascript" src="javascript/com/alert.js">
</script>
<script type="text/javascript" src="javascript/com/validateInput.js">
</script>
<script type="text/javascript">
	function goQuanLyBaiViet() {
		window.location = "showQuanLyBaiViet.do";
	}
</script>
	
</head>
<body>
	<%@include file="/header.jsp" %>
	
	<!-- ..Body.. -->
	<div class="container" style="margin-top:120px">
			<div class="panel panel-default panelnth2 ">
		  		<div class="panel-body">
					<div style="color: #66FF66">
						<center> <h2> THÊM BÀI ĐĂNG </h2> </center>
					</div>
				</div>
			</div>
			
			<!-- Noi dung o day ne........................ -->
			<div class="panel panel-default panelnth2 ">
		  		<div class="panel-body">
			  		<html:form action="thembaiviet" styleClass="form" enctype="multipart/form-data">
						<div class="row form-group">
							<div class="col-sm-2">
								<label> Tiêu đề: </label>
							</div>
							<div class="col-sm-8">
								<html:text styleId="Tiêu Đề" name="baiVietForm" property="tieuDeBaiViet" value="" styleClass="form-control col-sm-12" ></html:text>
								<div style="color: red;">
									<html:messages id="err_tieude" property="noidung_Error">
									<bean:write name="err_tieude"/>
									</html:messages>
								</div>
							</div>
						</div>		
							<div class="row form-group">
							<div class="col-sm-2">
								<label> Chủ đề: </label>
							</div>
							<div class="col-sm-8">
									<html:select name="baiVietForm" property="maLoaiBaiViet" styleClass="btn btn-primary dropdown-toggle">
										<html:optionsCollection name="baiVietForm" property="listLoaiBaiViet" label="tenLoaiBaiViet" value="maLoaiBaiViet"/>
									</html:select>
								</div>
							</div>
								
							<div class="row form-group">
								<div class="col-sm-2">
									<label> Hình Ảnh: </label>
								</div>
								<div class="col-sm-8">
										<div class="col-sm-12"  style=" border: 2px solid #ccc; border-radius: 4px">
											<img id="uploadPreview" width="100%" style="margin: 15px 15px 15px 0" src="images/logo2.jpg"></img> <br/>
										</div>
										<br />
										<html:hidden property="hinhAnh" name="baiVietForm"/>
										<input type="file" id="uploadImage" style="margin-bottom: 15px" name="image" onchange="PreviewImage();" />
									</div>
								</div>
							
							<div class="row form-group">
								<div class="col-sm-2">
									<label> Nội dung: </label>
								</div>
								<div class="col-sm-8">
									<html:textarea styleId="Nội Dung Bài Viết" name="baiVietForm" property="noiDungBaiViet" styleClass="form-control" style="height: 200px"></html:textarea>
									
								</div>
							</div>	
								
							
								<td style="width: 100px"> </td>
								<td>
									<div style="" class="row form-group col-sm-6 rightnth">
										<html:submit property="submit" styleClass="btn btn-primary col-sm-3 rightnth" onclick="return checkThemBaiViet('Tiêu Đề', 50, 'Nội Dung Bài Viết', 3000)"/>
										<input type="button" class="btn btn-primary col-sm-3 rightnth" value="Quay lại" onclick="goQuanLyBaiViet()">
									</div>  
									
								</td>
						</html:form>
				</div>
			</div>
	</div>	
<%@include file="footer.html"%>