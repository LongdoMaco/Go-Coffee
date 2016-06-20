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

</head>
<body>
	<%@include file="/header.jsp" %>
	<div class="container" style="margin-top:120px; width: 75%" >
	
	<!-- Button quay lai quan ly bai viet -->
		<div style="float: left;"> 
			<html:form action="showQuanLyBaiViet"> <html:submit value="<< Quay lại" styleClass="btn btn-primary"/> </html:form>
		</div>
			<!-- noi dung -->
			<div class="panel panel-default" style="margin-top: 50px">
		  		<div class="panel-body">
		  			<!-- Avata bai viet -->
		  			<div class="col-sm-2">
							<bean:define id="ha" property="hinhAnh" name="chiTietBaiVietForm"></bean:define>
							<html:img src="${ha}" width="855px" height="250px"/>
					</div>
		  		
					<div style="color: #66FF66; margin-top: 270px">
						<center> 
							<h1 style="color: brown; font-family: serif;" > 
								<bean:write name="chiTietBaiVietForm" property="tieuDeBaiViet"/>
							</h1> 
						</center>
					</div>
					
					<!-- Infor nguoi dang -->
					<div style="margin-top: 55px" class="col-sm-12">
						
						<div class="col-sm-8" style="margin-left: 0px">
							<span style="font-weight: bold;">Người đăng: &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;</span>  
								<strong style="color: #0662E8;"> <bean:write name="chiTietBaiVietForm" property="userName"/> </strong> <br>
							<span style="font-weight: bold;">Thời gian đăng: &nbsp;</span> 
								<strong style="color: maroon; font-family: cursive;"> <bean:write name="chiTietBaiVietForm" property="thoiGian"/> </strong>
						</div>
					</div> 
					
					
					<!-- Noi dung bai viet -->
					
					<div class="col-sm-11" style="background-color:blanchedalmond; margin:20px 20px 10px 14px;">
						<logic:equal name="chiTietBaiVietForm" property="tenLoaiBaiViet" value="Bai Viet">
							<pre><bean:write name="chiTietBaiVietForm" property="noiDungBaiViet"/></pre>
						</logic:equal>
						<logic:equal name="chiTietBaiVietForm" property="tenLoaiBaiViet" value="Video">
						<center>
							<iframe width="560" height="315" src="<bean:write name="chiTietBaiVietForm" property="noiDungBaiViet"/>" frameborder="1" allowfullscreen></iframe>
						</center>
						</logic:equal>
						<logic:equal name="chiTietBaiVietForm" property="tenLoaiBaiViet" value="Music">
							<center>
								<iframe width="560" height="168" src="<bean:write name="chiTietBaiVietForm" property="noiDungBaiViet"/>" frameborder="1" allowfullscreen></iframe>
							</center>
						</logic:equal>
					</div>
				</div>
			</div>
			
			
			<div style="text-align: center;">
				<p style="color: navy; font-size: 16px;"> <u> <i> Bình Luận </i> </u> </p> <br>
				
			</div>
			
			
			<!-- Comment o day........................ -->
			<logic:iterate id="x" name="chiTietBaiVietForm" property="listComment">
				<div class="panel panel-default" >
			  		<div class="panel-body">
			  			<!-- avata va info -->
			  			<div class="col-md-2"  style="background-color: ">
			  				<bean:define id="ha2" property="hinhDaiDien" name="x"></bean:define>
								<html:img src="${ha2}" height="80px" width="115px"/> <br>
							<span style="color: #020080; font-weight: bold"> <bean:write name="x" property="userName"/> </span> <br>
							<span style="color: #38B50E; font-family: cursive; font-size: 11px"> <bean:write name="x" property="thoiGian"/> </span>
						</div>
							
						<!-- noi dung comment -->
						<div class="col-md-8" style="margin-left: 0px">
							<div >
								<pre><bean:write name="x" property="noiDung"/> </pre>
							</div>
						</div>
						
						<!-- Button sua, xoa -->
						<!-- admin -->
				
						<div class="col-md-1">
						<logic:equal name="chiTietBaiVietForm" property="quyenHan" value="1"> 
							<div style="float: right;">
							
								<bean:define id="mbv" name="chiTietBaiVietForm" property="maBaiViet"></bean:define>
								<bean:define id="mcm" name="x" property="idComment"></bean:define>
								
								<html:link action="/suacomment?maBaiViet=${mbv}&idComment=${mcm}" style="margin-left: 10px;">
									<span class="glyphicon glyphicon-edit"></span>
								</html:link>
								
								<html:link action="/xoacomment?maBaiViet=${mbv}&idComment=${mcm}" onclick="return deleteComment()" style="margin-left: 10px;">
									<span class="glyphicon glyphicon-trash"></span>
								</html:link>
									
							</div>
						</logic:equal>
						</div>
						
						
						<!-- not admin -->
						<div class="col-md-2">
						<logic:notEqual name="chiTietBaiVietForm" property="quyenHan" value="1">
						<bean:define id="aaa" name="x" property="userName"/> 
						<logic:equal name="chiTietBaiVietForm" property="userDangNhap" value="${aaa}">
							<div style="float: right;">
							
								<bean:define id="mbv" name="chiTietBaiVietForm" property="maBaiViet"></bean:define>
								<bean:define id="mcm" name="x" property="idComment"></bean:define>
								
								<html:link action="/suacomment?maBaiViet=${mbv}&idComment=${mcm}" style="margin-left: 10px;">
									<span class="glyphicon glyphicon-edit"></span>
								</html:link>
								
								<html:link action="/xoacomment?maBaiViet=${mbv}&idComment=${mcm}" onclick="return deleteComment()" style="margin-left: 10px;">
									<span class="glyphicon glyphicon-trash"></span>
								</html:link>
									
							</div>
						</logic:equal>
						</logic:notEqual>
						</div>
					</div>
				</div>
			</logic:iterate>
			
			
			
			
			<!-- O nhap binh luan -->
			<logic:notEqual name="chiTietBaiVietForm" property="quyenHan" value="0">
			<div class="panel panel-default">
		  		<div class="panel-body">
		  			<strong> Bình luận bài viết: </strong>
		  			<html:form action="themcommnent">
		  				<html:textarea styleId="Bình luận" name="chiTietBaiVietForm" property="noiDungComment" value="" rows="5" cols="10" styleClass="form-control"/>
		  				
		  				<div class="col-sm-2 rightnth">
		  					<html:submit value="Đăng" onclick="return checkNoiDung('Bình luận', 3000)" styleClass="btn btn-primary" style="float: right;"/>
		  					<bean:define id="mbv" name="chiTietBaiVietForm" property="maBaiViet"/>
							<html:hidden property="maBaiViet" value="${mbv}"/>
						</div>
		  			</html:form>
				</div>
			</div>
			</logic:notEqual>
	</div>
</body>
</html>