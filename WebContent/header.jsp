<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="form.LoginForm"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html>
 <html class="no-js"> 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Chào mừng đến với GoCoffee</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel="stylesheet">
	<link href="css/lucas.css" rel="stylesheet">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/normalize.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/templatemo_misc.css">
    <link rel="stylesheet" href="css/templatemo_style.css">
    <link rel="stylesheet" href="css/nth.css">
    <script src="//code.jquery.com/jquery-1.10.2.js"></script>
    <script src="js/vendor/modernizr-2.6.2.min.js"></script>
    <script>
		$(document).ready(function(){
		    $("#templatemo_logo2").hover(function(){
		        $("#templatemo_logo2").animate({
		            width: 'toggle'
		        });
		    });
		});
	</script>
</head>
<body>
    <div >
        <div class="site-header">
            <div class="container">
                <div class="row">
                    <div class="col-sm-3">
                        <div id="templatemo_logo2" style=" padding-top:10px;width:120px;height:90px" >
                           <img src="images/templatemo_logo.png" width="100%" height="100%"></img>
                        </div> <!-- /.logo -->
                    </div> <!-- /.col-md-4 -->
                    <div class="col-sm-9" style="height:100px">
                        <a href="#" class="toggle-menu"><i class="fa fa-bars"></i></a>
                        <div id="menu" class="min-menu" style="height:100px">
                        	<div style="height:70px">
                            <ul class="">
                            
                                <li><a href="showTrangChu.do">Trang chủ</a></li>
                                <li><a href="showQuanLyBaiViet.do">Go Blog</a></li>
                            	<%LoginForm login = new LoginForm();
									login = (LoginForm)session.getAttribute("loginForm");
									
									if(login != null){
										System.out.println("session");
										if(login.getQuyenHan() == 1){%>
										
											<li><a href="thongke.do">Thống Kê</a></li>
											<li><a>Quản lý</a>
												<ul >
													<li><a href="danhSachDonHang.do" >Quản lý đơn hàng</a></li>
													<li><a href="danhsachnhanvien.do">Quản lý nhân viên</a></li>
													<li><a href="danhsachkhachhang.do">Quản lý khách hàng</a></li>
													<li><a href="themsanpham.do">Thêm sản phẩm</a></li>
												</ul>
											</li>
											<li><a href="dsphanhoi.do">Phản Hồi</a></li>
											
										<% }%>
										<%if(login.getQuyenHan() == 2){%>
											<li><a href="danhSachDonHang.do">Quản lý đơn hàng</a></li>
									  <%}%>
										<li><a href="danhSachDatHang.do">LS đặt hàng</a></li>
								  <%}%>
                                <li><a href="gioHangTam.do">Giỏ Hàng</a></li>
								<li><a href="http://lmgtfy.com/?q=GoCoffee">Tìm chúng tôi</a></li>
                            </ul>
                            </div>
                            <div class="btn-group " style="height: 30px; width: 100%;  float: right">
							 
							<%if(login != null){%>
								<input class="btn btn-default buttonnth btn-sm" type="button" onclick="window.location='logout.do';" value="Đăng Xuất" />
								<div id="chonTT" class="dropdown rightnth">
									  <button class="btn btn-link dropdown-toggle" style="color:white;" type="button" data-toggle="dropdown">Xin Chào: <%=login.getUserName()%>
									  <span class="caret"></span></button>
									  <ul class="dropdown-menu">
										    <li><a href="suaTT.do?userName=<%=login.getUserName()%>">Sửa thông tin</a></li>
										    <li><a href="checkDoiMatKhau.do?userName=<%=login.getUserName()%>">Đổi mật khẩu</a></li>
									  </ul>
								</div>
							<%}else{%>
								<input class="btn btn-default buttonnth btn-sm" type="button" onclick="window.location='showDangNhap.do';" value="Đăng nhập" /> 
								<input class="btn btn-default buttonnth btn-sm" type="button" onclick="window.location='checkDangKy.do';" value="Đăng ký" />
						
							<%}%>
						</div>
                        </div> <!-- /.main-menu -->
						
                    </div> <!-- /.col-md-8 -->
					
                </div> <!-- /.row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="responsive">
                            <div class="main-menu">
                               <div style="height:70px">
                            <ul class="">
                            
                                <li><a href="showTrangChu.do">Trang chủ</a></li>
                                <li><a href="showQuanLyBaiViet.do">Go Blog</a></li>
                            	<%
									if(login != null){
										System.out.println("session");
										if(login.getQuyenHan() == 1){%>
											<li><a href="thongke.do">Thống Kê</a></li>
											<li><a>Quản lý</a>
												<ul >
													<li style="width:200px"><a href="danhSachDonHang.do" >Quản lý đơn hàng</a></li>
													<li style="width:200px"><a href="danhsachnhanvien.do">Quản lý nhân viên</a></li>
													<li style="width:200px"><a href="danhsachkhachhang.do">Quản lý khách hàng</a></li>
													<li style="width:200px"><a href="themsanpham.do">Thêm sản phẩm</a></li>
												</ul>
											</li>
											<li><a href="dsphanhoi.do">Phản Hồi</a></li>
										<% }%>
										<%if(login.getQuyenHan() == 2){%>
											<li><a href="danhSachDonHang.do">Quản lý đơn hàng</a></li>
									  <%}%>
										<li><a href="danhSachDatHang.do">LS đặt hàng</a></li>
								  <%}%>
                                <li><a href="gioHangTam.do">Giỏ Hàng</a></li>
								<li><a href="http://lmgtfy.com/?q=GoCoffee">Tìm chúng tôi</a></li>
                            </ul>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- /.container -->
        </div> <!-- /.site-header -->
    </div> <!-- /#front -->