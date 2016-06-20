<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="common.StringProcess"%>
<%@page import="model.bean.KhachHang"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>   
<%@include file="/header.jsp" %>
<script>
//Flag to show/hide confirmation
function confirmdel(mkh){
	if(window.confirm("Bạn có đồng ý muốn xóa?") == false){
		return false;
	}
}
function submitform(id){
	document.getElementById("idpage").value = id;
	document.getElementById("formm").submit();
}
</script>
<!-- code -->
	<div class="container" style="margin-top:120px">
		<div class="panel panel-default panelnth">
	  		<div class="panel-body">
	  		<html:form action="danhsachnhanvien.do" method="get" styleId="formm">
	  			<div class="form-group btn-group rightnth col-sm-4">
	  				<div class="btn col-sm-4">
		  				<html:submit styleClass="btn btn-primary rightnth"></html:submit>
			  		</div>
					<div class="btn col-sm-7">	
			  			<html:text styleClass="form-control rightnth" name="listKhachHangForm" property="search"></html:text>
			  		</div>
					<div class="btn col-sm-1">	
			  			<span class="glyphicon glyphicon-search"></span>
			  		</div>	
			  			
		  			
	  			</div>
	  		
				<h1>Danh sách Nhân viên</h1>
				<table class="table table-hover">
				    <thead>
				      <tr>
				        <th>Username</th>
				        <th>SDT</th>
				        <th>Địa chỉ</th>
				        <th>Giới tính</th>
				        <th>Ngày sinh</th>
				        <th>Email</th>
				        <th>Thêm</th>
				        
				      </tr>
				    </thead>
				    <tbody>
					      <logic:iterate name="listKhachHangForm" property="listKH" id="kh">
			            	<tr>
			                <th scope="row">
			                	<bean:write name="kh" property="userName"/>
							</th>
			                <td>
			                	<bean:write name="kh" property="sDT"/>
			                </td>
			                <td>
			                	<bean:write name="kh" property="diaChi"/>
							</td>
			                <td>
			                	<logic:equal name="kh" property="gioiTinh" value="1">
									Nam
								</logic:equal>
								<logic:equal name="kh" property="gioiTinh" value="0">
									Nữ
								</logic:equal>
			                </td>
			                <td>
			                	<bean:write name="kh" property="ngaySinh"/>
							</td>
			                <td>
			                	<bean:write name="kh" property="email"/>
			                </td>
			                <td>
			                	<bean:define id="msv" name="kh" property="userName"></bean:define>
			                	<html:link action="/suaTT?userName=${msv}" style="margin-left: 30px;">
			                		<span class="glyphicon glyphicon-edit"></span>
			                	</html:link>
			                	
			                	
	               				<html:link action="/xoaTT?userName=${msv}" onclick="return confirmdel()" style="margin-left: 30px;">
			                		<span class="glyphicon glyphicon-trash"></span>
			                	</html:link>
			                	
			                	<logic:equal name="kh" property="block" value="1">
				                	<html:link action="/blockTT?userName=${msv}&block=1"  style="margin-left: 30px;">
				                		<span class="glyphicon glyphicon-lock" ></span>
				                		unblock
				                	</html:link>
			                	</logic:equal>
			                	<logic:equal name="kh" property="block" value="0">
			                		<html:link action="/blockTT?userName=${msv}&block=0"  style="margin-left: 30px;">
				                		<span class="glyphicon glyphicon-lock" ></span>
				                		block
				                	</html:link>
				                	</logic:equal>
			                </td>
			            </tr>
			            </logic:iterate>
				  	</tbody>
				 </table>
				 <bean:define name="listKhachHangForm" property="page" id="pg"></bean:define>
				<bean:define name="listKhachHangForm" property="soTrang" id="st"></bean:define>
				<div class="pagination rightnth col-sm-6">
					<div class="col-sm-3">
						<logic:equal name="listKhachHangForm" property="page" value="1">
							<button class="btn btn-link"  onclick="submitform(1);" value="Previous">Previous</button>
						</logic:equal>
						
						<logic:notEqual name="listKhachHangForm" property="page" value="1">
							<button class="btn btn-link"  onclick="submitform(${pg-1});" value="Previous">Previous</button>
						</logic:notEqual>
					</div>
					<div class="col-sm-2">
						<html:text name="listKhachHangForm" styleClass="col-sm-8" styleId="idpage" property="page"></html:text>
						<div class="" style="margin-top:7px">
							<span>/</span>
							<bean:write name="listKhachHangForm" property="soTrang"></bean:write>
						</div>
					</div>
					<div class="col-sm-3">
						<logic:equal name="listKhachHangForm" property="page" value="${st}">
							<button class="btn btn-link"  onclick="submitform(${pg});" value="Next">Next</button>
						</logic:equal>
						
						<logic:notEqual name="listKhachHangForm" property="page" value="${st}">
							<button class="btn btn-link" onclick="submitform(${pg+1});" value="Next">Next</button>
						</logic:notEqual>
					</div>
						
				</div>
				</html:form>
			</div>
		</div>
	</div>

<!-- /code -->

<%@include file="/footer.html" %>
