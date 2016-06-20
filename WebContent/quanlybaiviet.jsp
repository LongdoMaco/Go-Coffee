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
<script type="text/javascript" src="javascript/com/alert.js"> </script>
<script type="text/javascript">
	function deleteBaiViet(){
		if (confirm("Bạn Có Chắc Muốn Xóa Bài Viết Này....?")) return true;
		else return false;
	}
	function goChiTiet(){
		
	}
</script>

<link rel="stylesheet" href="css/com.css">

</head>
<%@include file="/header.jsp" %>
<body>
	<div class="container" style="margin-top:120px">
		<div class="col-sm-10">
			<div class="panel panel-default panelcom col-sm-12">
		  		<div class="panel-body">
					<div style="color: #66FF66">
						<center> <h2> BÀI VIẾT VÀ SỰ KIỆN </h2> </center>
					</div>
				</div>
			</div>
			
			<!-- Div button them bai viet -->
			<logic:equal name="baiVietForm" property="quyenHan" value="1">
			<html:form action="thembaiviet">
				<div style="float:right">
					<html:submit styleClass="btn btn-primary" value="Thêm Bài Viết"/>
				</div>
			</html:form>
			</logic:equal>
			
			<logic:equal name="baiVietForm" property="quyenHan" value="2">
			<html:form action="thembaiviet">
				<div style="float:right ; margin-bottom:10px">
					<html:submit styleClass="btn btn-primary" value="Thêm Bài Viết"/>
				</div>
			</html:form>
			</logic:equal>
			<logic:iterate id="baiViet" name="baiVietForm" property="listBaiViet">
				<!-- div noi dung, Copy cai cua no nay ne..... -->
				<div class="panel panel-default panelcom col-sm-12">
			  		<div class="panel-body">
						<!-- image -->
						<div class="col-md-2 left">
							<bean:define id="ha" property="hinhAnh" name="baiViet"></bean:define>
							<html:img src="${ha}" height="120px" width="120px"/>
						</div>
						
						<!-- noi dung -->
						<div class="col-md-10 right">
							<div style=" height: 75%">
									<strong style="font-size: 18px; color: black;"> 
										<bean:write name="baiViet" property="tieuDeBaiViet"/>
									</strong> <br>
									<strong style="color: red;"> 
										<bean:write name="baiViet" property="tenLoaiBaiViet"/> 
									</strong>  
									 &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
									<strong style="color: #38B50E;"> 
										Ngày đăng: <bean:write name="baiViet" property="thoiGian"/>
									</strong> <br>
									
									<div class="col-sm-10">
										 <i> "<bean:write name="baiViet" property="noiDungBaiViet"/>" </i>
									</div>
							</div>
							
							<div class="col-sm-12" style="margin-top: 22px; height: 25%;">
								<div  style=" margin-top:15px;float: left;">
									<bean:write name="baiViet" property="userName"/> 
								</div>
								
								<div style="float: right;" class="btn-group">
								
									<logic:equal name="baiVietForm" property="quyenHan" value="1">
										
											<html:form styleClass="btn" action="suabaiviet">
												<html:submit styleClass="btn btn-primary" value="Sửa" style="margin-left: -7px"/>
												<bean:define id="mbv" name="baiViet" property="maBaiViet"/>
												<html:hidden property="maBaiViet" value="${mbv}"/>
											</html:form>
						
									</logic:equal>
									
									<logic:equal name="baiVietForm" property="quyenHan" value="2">
									<bean:define id="x" name="baiViet" property="userName"/>
									<logic:equal name="baiVietForm" property="userDangNhap" value="${x}">
										
											<html:form styleClass="btn" action="suabaiviet">
												<html:submit styleClass="btn btn-primary" value="Sửa" style="margin-left: -7px"/>
												<bean:define id="mbv" name="baiViet" property="maBaiViet"/>
												<html:hidden property="maBaiViet" value="${mbv}"/>
											</html:form>
									
									</logic:equal>
									</logic:equal>
									
									<logic:equal name="baiVietForm" property="quyenHan" value="1">
										
											<html:form styleClass="btn" action="xoabaiviet">
												<html:submit styleClass="btn btn-primary" value="Xóa" onclick="return deleteBaiViet()" style="margin-left: 0px"/>
												<bean:define id="mbv" name="baiViet" property="maBaiViet"/>
												<html:hidden property="maBaiViet" value="${mbv}"/>
											</html:form>
										
									</logic:equal>
									
									<logic:equal name="baiVietForm" property="quyenHan" value="2">
									<bean:define id="x" name="baiViet" property="userName"/>
									<logic:equal name="baiVietForm" property="userDangNhap" value="${x}">
										
											<html:form styleClass="btn" action="xoabaiviet">
												<html:submit styleClass="btn btn-primary" value="Xóa" onclick="return deleteBaiViet()" style="margin-left: 0px"/>
												<bean:define id="mbv" name="baiViet" property="maBaiViet"/>
												<html:hidden property="maBaiViet" value="${mbv}"/>
											</html:form>
										
									</logic:equal>
									</logic:equal>
									
									
										<html:form styleClass="btn" action="xemchitietbaiviet">
											<html:submit styleClass="btn btn-primary" value="Xem thêm" style="margin-left: 12px"/>
											<bean:define id="mbv" name="baiViet" property="maBaiViet"/>
											<html:hidden property="maBaiViet" value="${mbv}"/>
										</html:form>
									
								</div>
							</div>
						</div>
						
					</div>
				</div>
				<!--End div noi dung -->
			</logic:iterate>
			
			
			
	</div>
		<!-- ben phai -->
	<div class="col-sm-2" >
		<div class="panel panel-default panelcom col-sm-12">
	  		<div class="panel-body">
				<div style="color: black;">
					<h4> <strong>  Chủ đề </strong> </h4> <br>
					<html:link action="/showQuanLyBaiViet"> Tất Cả </html:link> <br>
					<html:link action="/showQuanLyBaiViet?dieuKien=LBV02"> Video </html:link> <br>
					<html:link action="/showQuanLyBaiViet?dieuKien=LBV01"> Bài viết </html:link> <br>
					<html:link action="/showQuanLyBaiViet?dieuKien=LBV03"> Music </html:link> <br>
				</div>
				
				<div style="color: black;">
					<h4> <strong>  Bài viết mới đăng </strong> </h4> <br>
					
					<logic:iterate id="x" name="baiVietForm" property="listBaiVietMoi">
						<bean:define id="mbv" name="x" property="maBaiViet"></bean:define>
						<bean:define id="tieude" name="x" property="tieuDeBaiViet"></bean:define>
						<html:link action="/xemchitietbaiviet.do?maBaiViet=${mbv}"> <bean:write name="x" property="tieuDeBaiViet"/> </html:link> <br>
					</logic:iterate>
				</div>
			</div>
		</div>
	</div>
		
	</div>
	
</body>
</html>