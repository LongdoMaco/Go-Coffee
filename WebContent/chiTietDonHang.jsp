<%@page import="common.StringProcess"%>
<%@page import="model.bean.DonHang"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

    
<%@include file="/header.jsp" %>
<!-- code -->
	<div class="container" style="margin-top:150px">
		<div class="panel panel-default panelnth">
	  		<div class="panel-body" >
	  		<center>
	  			<h1>CHI TIẾT ĐƠN HÀNG</h1>
				Xin chao <bean:write name="loginForm" property="userName"/>
	  		</center>
				
			</div>
		</div>
	</div>
	<html:form action="/chiTietDonHang" method="post">
	
	<div class="container" style="margin-top:10px">
	<div class="panel panel-default panelnth">
	 <div class="bs-example">
        <table class="table table-striped">
            <tbody>
            <logic:iterate name="chiTietDonHangForm" property="listchitietdonhang" id="sv">
            	<tr>
                <th scope="row">
              
                	Mã Đơn Hàng: 
                	<br>
                	<br>
                	Tên Khách Hàng: 
                	<br>
                	<br>
                	Số Điện Thoại: 
                	<br>
                	<br>
 					Địa Chỉ Giao Hàng:
                	<br>
                	<br>
 					Thời Gian Đặt: 
 					<br>
 					<br>
 					Trạng Thái:
 					
				</th>
				<td>
					<html:text name="chiTietDonHangForm" property="madonhang" style="margin-bottom: -7px;" readonly="true"></html:text>
                	<br>
                	<br>
                	<bean:write name="sv" property="tenkhachhang"/>
                	<br>
                	<br>
                	<bean:write name="sv" property="sodienthoai"/>
                	<br>
                	<br>
 					<bean:write name="sv" property="diachigiaohang"/>
                	<br>
                	<br>
 					<bean:write name="sv" property="thoigiandat"/>
 					<br>
 					<br>
 					<bean:write name="sv" property="trangthai"/>
 					
				</td>
				<td>
					Ghi Chú: 
				</td>
				 <td>
					<html:textarea name="sv" property="ghichu" cols="60" rows="8" styleClass="form-control" readonly="true"></html:textarea>
                </td>
                 
            </tr>
            </logic:iterate>
           
            </tbody>
        </table>
        <div>
        <center><h3>DANH SÁCH SẢN PHẨM</h3></center>
        </div>
        <table class="table table-striped">
        	 <thead>
            <tr>
                <th>STT</th>
                <th>Tên Sản Phẩm</th>
                <th>Đơn Giá (VNĐ)</th>
                <th>Số Lượng</th>
                
            </tr>
            </thead>
            <tbody>
            <logic:iterate name="chiTietDonHangForm" property="listdanhsachsanpham" id="sv">
            	<tr>
                <th scope="row">
              		<bean:write name="sv" property="masanpham"/>
				</th>
				<td>
					<bean:write name="sv" property="tensanpham"/>
				</td>
				<td>
					<bean:write name="sv" property="giaban"/>
				</td>
				<td>
					<bean:write name="sv" property="soluong"/>
				</td>
				
                 
            </tr>
            </logic:iterate>
           
            </tbody>
        </table> 
        
        <table class="table table-striped">
        		<logic:iterate name="chiTietDonHangForm" property="listtonggiathanh" id="sv">
        		<td>
					Tổng Tiền: <bean:write name="sv" property="tonggiathanh"/>
					
				</td>
					
				<td>
					<logic:notEqual name="loginForm" property="quyenHan" value="3">
						<logic:equal name="sv" property="matrangthai" value="TT01">
							<div class="row form-group">
		            			<div class="col-sm-12">
		               			<html:submit styleClass="btn btn-primary col-sm-12" property="submit" value="Xac Nhan Da Giao"></html:submit>
		           				 </div>
		        			</div>
		        		</logic:equal>
	        		</logic:notEqual>
				</td>
				<td>
					<logic:notEqual name="loginForm" property="quyenHan" value="3">
						<logic:equal name="sv" property="matrangthai" value="TT01">
							<div class="row form-group">
		            			<div class="col-sm-12">
		                			<html:submit styleClass="btn btn-primary col-sm-12" property="submit" value="Huy Giao Hang"></html:submit>
		           				 </div>
		           		
		        			</div>
		        		</logic:equal>
	        		</logic:notEqual>
				</td>
				<td>
					<logic:notEqual name="loginForm" property="quyenHan" value="2">
						<logic:equal name="sv" property="matrangthai" value="TT01">
							<div class="col-sm-12">
									<bean:define id="madonhang" name="chiTietDonHangForm" property="madonhang"></bean:define>
					            	<html:link styleClass="btn btn-primary" action="/suaDonHang?madonhang=${madonhang}">Sửa</html:link>
			            	</div>
		            	</logic:equal>
	            	</logic:notEqual>
				</td>
				<td>
					<div class="col-sm-12">
						<bean:define id="user" name="loginForm" property="userName"></bean:define>
			            <html:link styleClass="btn btn-primary" action="/danhSachDatHang?userName=${user}">Hủy</html:link>
	            	</div>
					
				</td>
			</logic:iterate>
        </table>
       
    </div>
	</div>
	</div>
	</html:form>
<!-- /code -->

