<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.KhachHang"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/header.jsp" %>
<%@include file="/headerslider.jsp"%>
<link href='http://fonts.googleapis.com/css?family=Open+Sans:400,300,600,700&subset=latin,vietnamese' rel='stylesheet' type='text/css'>

<script type="text/javascript" src="js/jquery/jquery.mmenu.min.all.js"></script>
<script type="text/javascript" src="js/jquery/jquery.flexslider-min.js"></script>
<script type="text/javascript" src="js/main.js"></script>
    <link type="text/css" href="css/plug_mmenu.all.css" rel="stylesheet"/>
    <link type="text/css" href="css/flexslider.css" rel="stylesheet"/>
    <link rel="stylesheet" href="css/bootstrap.min.css"/>
    <link rel="stylesheet" href="css/trangchu_v2.css"/>
    <link type="text/css" href="css/styles-responsive.css" rel="stylesheet"/>


<div class="main">
    <div class="container">
    <html:errors property="loikhixoa"/>
    <div class="panel panel-default panelnth3" >
	<div class="panel-body">
        <div class="row">
            <div class="bg" style="padding: 0 10px; float:left;width:100%; ">
            <div class="bg" style="float:left; padding-bottom:20px;">
	            <div class="col-sm-9 product right">
	                <div class="intro">
	                    <div class="row">
	                        <div class="bg">
	                        <div class="col-sm-4 icon-1 hovernth">
	                            <h4>cam kết vàng</h4>
	                            <p>Chúng tôi cam kết cung cấp cho quý vị sản phẩm chất lượng, thơm ngon, tốt cho sức khỏe.-Đặt biệt chúng tôi cam kết sẽ hướng dẫn, hỗ trợ đem đến cho bạn...</p>
	                        </div>
	                        <div class="col-sm-4 icon-2 hovernth">
	                            <h4>Về chúng tôi</h4>
	                            <p>Khởi nghiệp với một quán chuyên bán cà phê từ 1 năm về trước, GoCofee cố gắng hoàn thiện và tạo dựng một môi trường tốt hơn những gì mà GoCofee đã làm</p>
	                        </div>
	                        <div class="col-sm-4 icon-3 hovernth">
	                            <h4>Vì sao chọn chúng tôi</h4>
	                            <p>Giá rẻ bất ngờ, chất lượng được đảm bảo, phục vụ tận tình đến khách hàng nhanh nhất có thể.</p>
	                        </div>
	                        </div>
	                    </div><!-- row -->
	                </div><!-- intro -->
	                <div class="list-product">
	                    <div class="title">
	                        <a href="#">Sản phẩm nổi bật</a>
	                        <a href="showTrangChu.do" class="view-all">+ Xem tất cả</a>
	                    </div>
	                    <div class="list">
	                        <div class="row">
	                         <logic:iterate name="listSanPhamForm" property="list" id="sv">
	                            <div class="col-md-4 col-xs-6">
	                                <div class="item">
	                                    <div class="img">
	                                       <bean:define id="imag" property="hinhAnh" name="sv"/>
	                                            <html:img src="images/imagesp/${imag}" height="203" width="220" alt=""/>
	                                            <div class="bg"></div>
	                                    </div>
	                                    <div class="detail">
	                                        <div class="name">
	                                            <h2><bean:write name="sv" property="tenSanPham"/></h2>
	                                            <p><bean:write name="sv" property="giaBan"/></p> VNĐ
	                                        </div>
	                                    </div>
	                                    <div class="button">
	                                    	<bean:define id="maSanPham" name="sv" property="maSanPham"></bean:define>
	                                    	<html:link styleClass="btn btn-danger" action="/chiTietSanPham?maSanPham=${maSanPham}">Chi Tiết</html:link>
	                                    	<!--<html:submit property="view" styleClass="btn btn-info view" style="width:86px;" value="Chi tiết"></html:submit><br>
	                                      	-->
	                                      	<html:link styleClass="btn btn-danger" action="/gioHangTam?maSanPham=${maSanPham}">Mua Ngay</html:link>
	                                    </div>
	                                    <div class="clearfix"></div>
	                                </div>
	                            </div>
	                            </logic:iterate>
	                            <!-- col-md-4 -->
	                        </div>
	                    </div>
	                </div>
	            </div><!-- product -->
	            <div class="col-sm-3 col-xs-12 sidebar left ">
	                <div class="bg">
	                    <div class="block buy-phone">
	                        <p>Mua hàng trực tiếp</p>
	                        <h4>0902 835 110</h4>
	                    </div>
	                    <div class="block sale ">
	                        <p>
	                            <a href="#" class="icon yahoo"></a>
	                            <a href="#" class="icon skype"></a>
	                            Kinh doanh
	                        </p>
	                        <p>
	                            <a href="#" class="icon yahoo"></a>
	                            <a href="#" class="icon skype"></a>
	                            Kỹ thuật
	                        </p>
	                    </div>
	                    <div class="block menu-product">
	                        <div class="title">
	                            <a href="#">danh mục sản phẩm</a>
	                        </div>
	                        <ul>
	                        
	                        	
	                        	<li><html:form action="/showTrangChu.do" method="post">
	                        	<html:hidden name="listSanPhamForm" property="phanloai" value="4" />
	                        	<html:submit styleClass= "btn btn-link" property="submit" value="TẤT CẢ"></html:submit>
	                        	</html:form> </li>
	                            <li><html:form action="/showTrangChu.do" method="post">
	                        	<html:hidden name="listSanPhamForm" property="phanloai" value="1" />
	                        	<html:submit styleClass= "btn btn-link" property="submit" value="COFFEE"></html:submit>
	                        	</html:form> </li>
	                            <li><html:form action="/showTrangChu.do" method="post">
	                        	<html:hidden name="listSanPhamForm" property="phanloai" value="2" />
	                        	<html:submit styleClass= "btn btn-link" property="submit" value="NƯỚC GIẢI KHÁT"></html:submit>
	                        	</html:form> </li>
	                            <li><html:form action="/showTrangChu.do" method="post">
	                        	<html:hidden name="listSanPhamForm" property="phanloai" value="3" />
	                        	<html:submit styleClass= "btn btn-link" property="submit" value="SẢN PHẨM KHÁC"></html:submit>
	                        	</html:form> </li>
	                        </ul>
	                    </div>
	                    <div class="block ads hovernthads">
	                        <a href="#"><img src="images/anhdong.gif" height="242" width="207" alt=""></a>
	                    </div>
	                </div><!-- bg -->
	            </div><!-- sidebar left -->
            </div>
            </div>
        </div><!-- row -->
        </div>
        </div>
    </div><!-- container -->
</div><!-- main-top -->
    
<%@include file="/footer.html"%>