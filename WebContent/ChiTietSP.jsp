
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
	function xacnhan(msp){
		var xn = confirm("Ban co dong y muon xoa?");
		if(xn == true){
			window.location="xoaSP.do?maSanPham="+masp;
		}else{
			return false;
		}
	}
</script>
<div class="container" style="margin-top:120px">
		<div class="panel panel-default panelnth">
	  		<div class="panel-body" >
	  		<center>
	  			<h2>CHÀO MỪNG QUÝ KHÁCH ĐẾN VỚI CỬA HÀNG COFFEE ONLINE</h2>
				<h4>Sự hài lòng của khách hàng là niềm hạnh phúc của chúng tôi</h4>
				
	  		</center>
				
		</div>
	</div>
	<div class="panel panel-default panelnth">
	 <div class="bs-example">
        <table class="table">
		<tr>
			<td>
				<div class="col-sm-12" style="margin:0 auto;">
					 <bean:define id="img" property="hinhAnh" name="sanPhamForm"/>
			         <html:img src="images/imagesp/${img}" width="300px" height="300px" style="margin: auto auto;"  alt=""/>
				</div>
			</td>
			
			<td>
			<form action="checkDangNhap.do" method="post">
		    <h3>
		    	Tên Sản Phẩm: <bean:write name="sanPhamForm" property="tenSanPham"/>
		    </h3>
		    <br>
		        <div class="row form-group">
		            <label class="col-lg-4">Mã Sản Phẩm</label>
		            <div class="col-lg-3">
		            	<html:text name="sanPhamForm" property="maSanPham" styleClass="form-control"  readonly="true"></html:text>
		            	
		            </div>
		        </div>
		        <div class="row form-group">
		            <label class="col-lg-4">Tên Sản Phẩm</label>
		            <div class="col-lg-3">
		                <bean:write name="sanPhamForm" property="tenSanPham"/>
		            </div>
		        </div>
		        <div class="row form-group">
		            <label class="col-lg-4">Giá Bán</label>
		            <div class="col-lg-3">
		            	<bean:write name="sanPhamForm" property="giaBan"/>
		            </div>
		        </div>
		        <div class="row form-group">
		            <label class="col-lg-4">Tên Loại Sản Phẩm</label>
		            <div class="col-lg-3">
		            	<bean:write name="sanPhamForm" property="tenLoai"/>
		            </div>
		        </div>
		        <div class="row form-group">
		            <label class="col-lg-4">Số Lượng</label>
		            <div class="col-lg-3">
		            	<input type="number" name="soluong" value="1" min="0" max="100" class="form-control" >
		            </div>
		        </div>
		            <div  class="">
		            	<div class=col-sm-4>
		            		<html:submit styleClass= "btn btn-primary" property="submit" value="Them Vao Gio Hang" ></html:submit>
						</div>
						<logic:equal name="sanPhamForm" property="quyenHan" value="1">
							<bean:define id="masp" name="sanPhamForm" property="maSanPham" />
							<div class="col-sm-4">
								<html:button styleClass= "btn btn-primary" property="suaSP" onclick="window.location='suaSP.do?maSanPham=${masp}';" value="Sua San Pham" ></html:button>
							</div>
							<div class="col-sm-4">
								<html:button property="xoa" value="Xoa San Pham" onclick="return xacnhan(${masp});" styleClass="btn btn-warning" />
							</div>
						</logic:equal>
		            </div>
		    </form>   
			</td>
		</tr>
	</table>
	 
           
	</div>
	</div>
	</div>

