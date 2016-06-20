<%@page import="common.StringProcess"%>
<%@page import="model.bean.DonHang"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

    
<%@include file="/header.jsp" %>
<link rel="stylesheet" href="css/alert.css">

<script type="text/javascript" src="javascripthieu/alert.js"> </script>
<script type="text/javascript" src="javascripthieu/validateInput.js"> </script>


<!-- code -->

	<div class="container" style="margin-top:150px">
		<div class="panel panel-default panelnth">
	  		<div class="panel-body" >
	  		<center>
	  			<h3>CHÀO MỪNG QUÝ KHÁCH ĐẾN VỚI CỬA HÀNG COFFEE ONLINE</h1>
				<h5>Sự hài lòng của khách hàng là niềm hạnh phúc của chúng tôi</h5>
	  			<div style="font-size: 35px;font-family: Blackletter; font-weight: bold;"  >SỬA ĐƠN HÀNG</div>
	  		</center>
				
			</div>
		</div>
	</div>
	<html:form  action="/danhSachDatHang" method="post">
	<div style="padding-left: 250px" >
	<h3>Mã Đơn Hàng:  
		<html:text name="chiTietDonHangForm" property="madonhang" readonly="true"></html:text>
	</h3>
	</div>
	<center>
	<hr style="width: 1000px">
	</center>
	<div class="container" style="margin-top:10px">
	<div class="panel panel-default panelnth">
	 <div class="bs-example">
        <table class="table table-striped">
            <tbody>
            <logic:iterate name="chiTietDonHangForm" property="listchitietdonhang" id="sv">
            	<tr class="success">
                <th scope="row">
                	Tên Khách Hàng: 
                	<br>
                	<br>
                	Địa Chỉ Giao Hàng: 
                	<br>
                	<br>
 					<br>
 					<br>
 					Số Điện Thoại:
 					
                	<br>
                	<br>
 					Thời Gian Đặt: 
 					<br>
 					<br>
 					Trạng Thái:
 					
				</th>
				<td>
					
					<bean:write name="sv" property="tenkhachhang"/>
                	<br>
                	<br>
                	<!--<input id="địa chỉ" type="text" name="sv" property="diachigiaohang" styleClass="form-control">
                	
                	--><html:text styleId="địa chỉ" name="sv" property="diachigiaohang" styleClass="form-control" ></html:text>
                	<br>
                	<br>
 					<bean:write name="sv" property="sodienthoai"/>
                	<br>
                	<br>
 					<bean:write name="sv" property="thoigiandat"/>
 					<br>
 					<br>
 					<bean:write name="sv" property="trangthai"/>
				</td>
				<th scope="row">
					Ghi Chú: 
				</th>
				 <td>
					<html:textarea name="sv" property="ghichu" cols="60" rows="8" styleClass="form-control"></html:textarea>
                </td>
                 
            </tr>
            </logic:iterate>
           
            </tbody>
        </table>
        <div>
        <center>
        <h3>DANH SÁCH SẢN PHẨM</h3>
        </center>
        </div>
        <table class="table table-striped">
        	 <thead>
            <tr class="success">
                <th>STT</th>
                <th>Tên Sản Phẩm</th>
                <th>Đơn Giá (VNĐ)</th>
                <th>Số Lượng</th>
                
            </tr>
            </thead>
            <tbody>
            <logic:iterate name="chiTietDonHangForm" property="listdanhsachsanpham" id="sv">
            	<tr class="success">
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
					<bean:define id="x" name ="sv" property="soluong"></bean:define>
					<input type="number" name="soluong" value="${x}" min="0" max="100">
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
				 </logic:iterate>
				<td>
					<div class="row form-group">
            			<div class="col-lg-3 col-lg-offset-2">
               			<html:submit   styleClass="btn btn-primary" property="submit" value="submit" onclick="return checkInputNormal('địa chỉ',50)" >Lưu lại</html:submit>
           				 </div>
        		</div>
				</td>
				
				<td>
				<div class="col-lg-2 pull-right">
		            	<html:link styleClass="btn btn-primary" action="/danhSachDatHang?userName=${username}">Hủy</html:link>
            	</div>
				</td>
        </table>
       
    </div>
	</div>
	</div>
	</html:form>
<!-- /code -->

