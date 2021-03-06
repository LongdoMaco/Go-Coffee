
<%@page import="form.KhachHangForm"%>
<%@page import="common.StringProcess"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>Đổi mật khẩu</title>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/quenmatkhau.css"/>
    <script src="js/jquery-1.11.2.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
</head>
<body>
<body>
	<div class="center">
        <div class="container">
        	<div class="space col-md-4"></div>
        	<div class="box panel panel-info col-md-4">
            	<h3>Quên mật khẩu</h3>
            	<div class="image">
            		<div class="space col-md-4"></div>
            		<div class="img col-md-4">
            			<div id="logo">
							<a href="index.html"><img  src="img/cafe-image1.jpg" alt="quenmatkhau" style="width:100px;height:40px;"></a>
						</div>
            		</div>
            		<div class="space col-md-4"></div>
            	</div>
                <html:form action="checkDoiMatKhau">
                        
                        <div class="row form-group">
                            <label class="col-md-12">Tài khoản đăng nhập(*)</label><br>
                            <div class="col-md-12">
                                <html:text property="password" styleClass="form-control" value=""></html:text>
                            </div>
                        </div>
                        <div class="row form-group">
                            <label class="col-md-12">Email đăng ký ban đầu(*)</label><br>
                            <div class="col-md-12">
                                <html:text  property="matKhauMoi" styleClass="form-control" value=""></html:text>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="">
                            		 <div class="space col-md-1"></div>
                                    <html:submit styleClass= "btn btn-primary col-md-4" property="submit" value="Xác nhận"/>
                                     <div class="space col-md-1"></div>
                                    <html:button styleClass= "btn btn-primary col-md-4" property="submit" value="Hủy" onclick="window.location = 'showTrangChu.do'"></html:button>
                                     <div class="space col-md-1"></div>
                            </div>
                        </div>
                    </html:form>     
            </div>
            <div class="space col-md-4"></div>
        </div>    
    </div>
</body>
</html>