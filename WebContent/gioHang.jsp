<%@page import="common.StringProcess"%>
<%@page import="model.bean.SanPham"%>
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

<script src="//cdn.jsdelivr.net/webshim/1.14.5/polyfiller.js"></script>
<script>
	webshims.setOptions('forms-ext', {
		types : 'date'
	});
	webshims.polyfill('forms forms-ext');
	function check(form)
	{
		if(form.diachigiaohang.value==''){
			
			alert('bạn chưa điền địa chỉ giao hàng ');return false;
		}
		
		else if(form.masanpham.value==null){ 
			alert('Giỏ hàng trống ');return false;
		}		
		else
		{alert('Bạn Đã Thêm Đơn Hàng Thành Công!!');
		form.submit();
			return true;
		}
	}
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
				<div style="font-size: 35px;font-family: Blackletter; font-weight: bold;"  >GIỎ HÀNG CỦA BẠN</div><Br/> 
	  		</center>
				
			</div>
		</div>
	<html:form  action="/datDon" method="post">		
		<div   class="panel panel-default panelnth">
	 	<div class="bs-example">
		
        <table class="table table-striped">
            <thead>
            <tr>
                <th>STT</th>
                <th>Tên sản phẩm</th>
                <th>Giá bán</th>
                <th>Số lượng</th>
            </tr>
            </thead>
            <tbody>
           	 <logic:iterate name="gioHangTamForm" property="listGH" id="sv">
            	
				<tr>
				<th scope="row">
              		<html:text name="sv" property="masanpham" readonly="true"></html:text>
 
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
    </div>
	</div>

		<div class="panel panel-default panelnth">
	  		<div class="panel-body" >
	  		 
	  		 <div class="row col-sm-12">
	  		 	<div class="col-sm-4">
	  		 		<button class="btn btn-primary" onclick="history.go(-1);">
	  		 			Thêm sản phẩm
	  		 		</button></div>
	  		 	<div class="col-sm-8">
	  		 		Tổng thành tiền <bean:write name="gioHangTamForm" property="tongthanhtien"/>
	  		 	</div>
	  		 </div>
	  		 <!--  -->
	  		 <div class="row col-sm-12">
	  		 	<div class="col-sm-4">
	  		 		<label>Địa chỉ giao hàng</label>
	  		 	</div>
	  		 	<div class="col-sm-8">
	  		 		<input id="địa chỉ" class="form-control" type="text" name="diachigiaohang">
	  		 	</div>
	  		 </div>
	  		  <!--  -->
	  		 <div class="row col-sm-12">
	  		 	<div class="col-sm-4">
	  		 		<label>Ghi chú</label>
	  		 	</div>
	  		 	<div class="col-sm-8">
	  		 		<html:textarea property="ghichu" cols="60" rows="8" styleClass="form-control"></html:textarea>
		  		 			
	  		 	</div>
	  		 </div>
	  		  <div class="row col-sm-12">
	  		 	<div  class="bt col-sm-3 rightnth">
          			<html:submit styleClass= "btn btn-primary" property="submit" value="Dat Hang" onclick="return checkInputNormal('địa chỉ',50)"></html:submit>
				</div>
         		<div  class="bt col-sm-3 rightnth">
          			<html:submit styleClass= "btn btn-primary" property="submit" value="Xoa Gio Hang"></html:submit>
				</div>
	  		 </div>
	  		 	
	  		 
			</div>
		</div>
	</html:form>
	</div>
<!-- /code -->
