<%@page import="common.StringProcess"%>
<%@page import="model.bean.DonHang"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>

    
<%@include file="/header.jsp" %>
<script src="//cdn.jsdelivr.net/webshim/1.14.5/polyfiller.js"></script>
<script>
	webshims.setOptions('forms-ext', {
		types : 'date'
	});
	webshims.polyfill('forms forms-ext');

	function xoa(){
		if (confirm("Ban co muon xoa don hang khong?")) return true;
		else return false;
		} 
</script>
<!-- code -->
	<div class="container" style="margin-top:120px">
		<div class="panel panel-default panelnth">
	  		<div class="panel-body" >
	  		<center>
	  			<h2>CHÀO MỪNG QUÝ KHÁCH ĐẾN VỚI CỬA HÀNG COFFEE ONLINE</h2><Br/>
				<h5>Sự hài lòng của khách hàng là niềm hạnh phúc của chúng tôi</h5><Br/>
	  			<div style="font-size: 35px;font-family: Blackletter; font-weight: bold;"  >DANH SÁCH ĐƠN HÀNG</div><Br/>
	  		</center>
				
			</div>
		</div>
	
	<div class="panel panel-default panelnth"  >
	  	<div class="panel-body" >
	 <!-- ----------------------------------------- -->
		 <table class="table table-striped bottom0nth">
		 	<tr class="success">
		 		<td>
	            		<div class="form-group rightnth">
		  				Tìm Kiếm 
		  				</div>
	            </td>
	            <td>
	                	<html:form action="/timkiemdanhSachDonHang">
			  			<html:text  styleClass="form-control rightnth bottom0nth" property="search" ></html:text>
						</html:form  >	
	            </td>
	            <td>
	            		<div class="form-group rightnth">
		  				Lọc Trạng Thái 
		  				</div>
	            </td>
	            <td>
	            		<html:form action="/timkiemTrangThai" >
		  			<div style="float: left" class="form-group rightnth ">
			  			
			  			<html:select onchange="this.form.submit()" name="danhSachDonHangForm" property="trangthaitk" styleClass="form-control bottom0nth" styleId="sel1">
							<html:option value="0">Tất Cả</html:option>
							<html:option value="1">Đang Giao</html:option>
							<html:option value="2">Đã Giao</html:option>
							<html:option value="3">Đã Hủy</html:option>
							<html:option value="4">Đã Từ Chối</html:option>
						</html:select>
			  			
		  			</div>
		  			</html:form>
	            </td>
	           <td>
	           			<th>Ngày đặt</th>
	           </td>
	           <td>
	           				<html:form action="/timkiemNgay" >
		  			<div style="float: left" class="form-group rightnth col-sm-12">
		  				<input onchange="this.form.submit()" class="col-sm-12 form-control bottom0nth"  type="date" name="ngaythang" min="1970-01-01" min="2012-12-31" />
			  		</div>
		  			</html:form>
	           </td>
           </tr>
	 	</table>
	  	<!-- ----------------------------------------- -->		
	  	
	  	</div><!-- end panel-body -->
	</div>	
	<div   class="panel panel-default panelnth">
	 <div class="bs-example">
		
        <table class="table table-striped">
            <thead>
            <tr>
                <th>STT</th>
                <th>Tên khách hàng</th>
                <th>Địa chỉ giao hàng</th>
                <th>Số điện thoại</th>
                <th>Thời gian đặt</th>
                <th>Trạng thái</th>
                <th>Chi tiết</th>
                <th>Xóa</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
           	 <logic:iterate name="danhSachDonHangForm" property="listchitietdonhang" id="sv">
            	<tr>
                <th scope="row">
              
                	<bean:write name="sv" property="madonhang"/>
 
				</th>
				<td>
                	<bean:write name="sv" property="tenkhachhang"/>
                </td>
                 <td>
                	<bean:write name="sv" property="diachigiaohang"/>
                </td>
                 <td>
                	<bean:write name="sv" property="sodienthoai"/>
                </td>
				 <td>
                	<bean:write name="sv" property="thoigiandat"/>
                </td>
                 <td>
                	<bean:write name="sv" property="trangthai"/>
                </td>
                <bean:define id="madonhang" name="sv" property="madonhang"></bean:define>
                 <td>
                	<html:link action="/chiTietDonHang?madonhang=${madonhang}"> Xem chi tiết</html:link>
                </td>
                 <td>
                 	<logic:equal name="loginForm" property="quyenHan" value="1">
                	<html:link action="/xoaDonHang?madonhang=${madonhang}" onclick="return xoa()"> Xóa</html:link>
                	</logic:equal>
                </td>
                 
                
                
            </tr>
            </logic:iterate>
            </tbody>
        </table>
    </div>
	</div>
	</div>
<!-- /code -->
<%@include file="/footer.html"%>