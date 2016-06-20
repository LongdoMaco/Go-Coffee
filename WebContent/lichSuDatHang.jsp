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
	  		<div style="margin: 0 auto">
	  		<center>
	  			<h2>CHÀO MỪNG QUÝ KHÁCH ĐẾN VỚI CỬA HÀNG COFFEE ONLINE</h2><Br/>
				<h5>Sự hài lòng của khách hàng là niềm hạnh phúc của chúng tôi</h5><Br/>
				<div style="font-size: 35px;font-family: Blackletter; font-weight: bold;"  >
					LỊCH SỬ ĐẶT HÀNG
				</div>
				</center>
	  		</div>
				
			</div>
		</div>
	</div>
	<div class="panel panel-default panelnth">
	 <div class="bs-example">
        <table class="table table-striped">
            <thead>
            <tr>
                <th>STT</th>
                <th>Thời gian đặt hàng</th>
                <th>Địa chỉ giao hàng</th>
                <th>Tổng tiền</th>
                <th>Thời gian giao</th>
                <th>Xem chi tiết</th>
                <th>Trạng thái</th>
                <th>Sửa</th>
                <th>Hủy</th>
                <th>Feelback</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <logic:iterate name="danhSachDatHangForm" property="listdonhang" id="sv">
            	<tr>
                <th scope="row">
              
                	<bean:write name="sv" property="madonhang"/>
 
				</th>
				 <td>
                	<bean:write name="sv" property="thoigiandat"/>
                </td>
                 <td>
                	<bean:write name="sv" property="diachi"/>
                </td>
                <td>
                	<bean:write name="sv" property="thanhtien"/>
                </td>
                <td>
                	<bean:write name="sv" property="thoigiangiao"/>
                </td>
                <bean:define id="madonhang" name="sv" property="madonhang"></bean:define>
                 <td>
                	
                	<html:link action="/chiTietDonHang?madonhang=${madonhang}"> Xem chi tiết</html:link>
                </td>
                 <td>
                	<bean:write name="sv" property="tentrangthai"/>
                </td>
                
                 <td>
                 	<logic:equal name="sv" property="matrangthai" value="TT01">
    				<html:link action="/suaDonHang?madonhang=${madonhang}"> Sửa</html:link>
                	</logic:equal>
                </td>
                 <td>
                 	<logic:equal name="sv" property="matrangthai" value="TT01">
    				<html:link action="/huyGiaoHang?madonhang=${madonhang}"> Hủy</html:link>
                	</logic:equal>
                	
                 	
                </td>
                 <td>
    				<html:link action="/showPhanHoi.do?maDonHang=${madonhang}"> Feelback</html:link>
                </td>
                
            </tr>
            </logic:iterate>
            </tbody>
        </table>
    </div>
	</div>
<!-- /code -->
<%@include file="footer.html"%>