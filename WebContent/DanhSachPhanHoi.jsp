<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.PhanHoi"%>
<%@page import="java.util.ArrayList"%>

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@include file="/header.jsp"%>

<script>
	$(document).ready(function(){
	    $('[data-toggle="popover"]').popover();   
	});
	function submitform(id){
		document.getElementById("idpage").value = id;
		document.getElementById("formm").submit();
	}
</script>
<div class="panel panel-default panelnth2" style="margin-top: 120px">
	<div class="panel-body">

		<h1>Danh sách phản hồi</h1>
		<table class="table table-hover" >
			<thead>
				<tr>
					
					<th  style="text-align:center">Mã đơn hàng</th>
					<th style="text-align:center">Thời Gian</th>
					<th style="text-align:center">Thái độ NV</th>
					<th style="text-align:center">Chất lượng SP</th>
					<th style="text-align:center">Độ hài lòng</th>
					<th style="text-align:center">Nội dung khác</th>

				</tr>
			</thead>
			<tbody>
				<logic:iterate name="listPhanHoiForm" property="listPhanHoi" id="ph">
					<tr><bean:define name="ph" property="maDonHang" id="madh"></bean:define>
						<td scope="row" style="text-align:center"><a href="chiTietDonHang.do?maDonHang=${madh}">${madh}</a></td>
						<td style="text-align:center"><bean:write name="ph" property="thoiGianPH" /></td>
						<td style="text-align:center"><bean:write name="ph" property="thaiDoNhanVien" /></td>
						<td style="text-align:center"><bean:write name="ph" property="chatLuongSanPham" /></td>
						<td style="text-align:center"><bean:write name="ph" property="doHaiLong" /></td>
						<td>
							<div class="col-sm-12">
								  <a href="#" data-toggle="popover" data-placement="bottom" title="nội dung phản hồi" data-content="<bean:write name="ph" property="noiDungKhac" />">xem thêm</a>
							</div>
						</td>
					</tr>
				</logic:iterate>
			</tbody>
		</table>
		<bean:define name="listPhanHoiForm" property="page" id="pg"></bean:define>
		<bean:define name="listPhanHoiForm" property="soTrang" id="st"></bean:define>
		<div class="pagination rightnth col-sm-6">
			<div class="col-sm-3">
				<logic:equal name="listPhanHoiForm" property="page" value="1">
					<button class="btn btn-link"  onclick="submitform(1);" value="Previous">Previous</button>
				</logic:equal>
				
				<logic:notEqual name="listPhanHoiForm" property="page" value="1">
					<button class="btn btn-link"  onclick="submitform(${pg-1});" value="Previous">Previous</button>
				</logic:notEqual>
			</div>
			<div class="col-sm-2">
				<html:text name="listPhanHoiForm" styleClass="col-sm-8" styleId="idpage" property="page"></html:text>
				<div class="" style="margin-top:7px">
					<span>/</span>
					<bean:write name="listPhanHoiForm" property="soTrang"></bean:write>
				</div>
			</div>
			<div class="col-sm-3">
				<logic:equal name="listPhanHoiForm" property="page" value="${st}">
					<button class="btn btn-link"  onclick="submitform(${pg});" value="Next">Next</button>
				</logic:equal>
				
				<logic:notEqual name="listPhanHoiForm" property="page" value="${st}">
					<button class="btn btn-link" onclick="submitform(${pg+1});" value="Next">Next</button>
				</logic:notEqual>
			</div>
				
		</div>

	</div>
</div>

<%@include file="/footer.html"%>