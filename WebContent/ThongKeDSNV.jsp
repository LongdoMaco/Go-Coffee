<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="form.KhachHangForm"%>
<%@page import="common.StringProcess"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@include file="/header.jsp"%>
<script src="//cdn.jsdelivr.net/webshim/1.14.5/polyfiller.js"></script>
<script>
	webshims.setOptions('forms-ext', {
		types : 'date'
	});
	webshims.polyfill('forms forms-ext');
</script>
<!-- code -->
<div class="container" style="margin-top: 120px">
	<div class="panel panel-default panelnth">
		<div class="panel-body"><html:form action="thongke.do">
			<div class="dropdownth">
				<html:select name="listThongKeForm"
					property="loaiThongKe" styleClass="form-control" styleId="sel1">
					<html:option value="1">Thống kê theo tháng</html:option>
					<html:option value="2">Thống kê theo doanh số của nhân viên</html:option>
					<html:option value="3">Thống kê khách hàng</html:option>
				</html:select>
			</div>
			<div class="form-group"><label for="pwd">Tháng:</label> <input
				type="date" class="form-control" name="thangHienTai"
				value="<bean:write name="listThongKeForm" property="thangHienTai" ></bean:write>"></input>
			</div>
			<div>
				<html:submit value="Thống kê" styleClass="btn btn-primary"></html:submit>
			</div>
		</html:form>
			<div class="form" style="margin-top: 20px;">
				<logic:equal name="listThongKeForm" property="loaiThongKe" value="2">
					<h1>Thống kê chung</h1>
					<table class="table table-hover" style="margin-top:20px;">
						<tbody>
							<tr>
								<td><label for="usr">Số đơn hàng: </label></td>
								<td><bean:write name="listThongKeForm" property="soLuongDonHang" /></td>
					
							</tr>
							<tr>
								<td><label for="usr">Số sản phẩm bán được: </label></td>
								<td><bean:write name="listThongKeForm"
									property="soLuongSanPhamBanDuoc" /></td>
							</tr>
							<tr>
								<td><label for="usr">Tổng chi phí bán được: </label></td>
								<td><bean:write name="listThongKeForm" property="tongChiPhi" /></td>
							</tr>
						</tbody>
					</table>
					<h1>Danh sách nhân viên</h1>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Họ Tên Nhân Viên</th>
								<th>Số Đơn Hàng đã giao</th>
								<th>Tổng tiền bán được</th>
							</tr>
						</thead>
						<tbody>
							<logic:iterate name="listThongKeForm" property="list" id="kh">
								<tr>
									<th scope="row">
										<bean:define name="kh" property="username" id="manv"></bean:define>
										<html:link action = "xemTT.do?userName=${manv}">
											<bean:write name="kh" property="tenNhanVien" />
										</html:link>
										
									</th>
									<td><bean:write name="kh" property="soDonHangDaGiao" /></td>
									<td><bean:write name="kh" property="tongTienBanDuoc" /></td>
								</tr>
							</logic:iterate>
						</tbody>
					</table>
				</logic:equal>
				<logic:notEqual name="listThongKeForm" property="loaiThongKe" value="2">
					<logic:notEqual name="listThongKeForm" property="loaiThongKe" value="3">
					<h1>Thống kê chung</h1>
					<table class="table table-hover">
						<tbody>
							<tr>
								<td><label for="usr">Số đơn hàng: </label></td>
								<td><bean:write name="listThongKeForm" property="soLuongDonHang" /></td>
					
							</tr>
							<tr>
								<td><label for="usr">Số sản phẩm bán được: </label></td>
								<td><bean:write name="listThongKeForm"
									property="soLuongSanPhamBanDuoc" /></td>
							</tr>
							<tr>
								<td><label for="usr">Tổng chi phí bán được: </label></td>
								<td><bean:write name="listThongKeForm" property="tongChiPhi" /></td>
							</tr>
						</tbody>
					</table>
					<h1>Danh sách Sản Phẩm</h1>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Tên Sản Phẩm</th>
								<th>Số lượng đã bán</th>
								<th>Tổng tiền bán được</th>
							</tr>
						</thead>
						<tbody>
							<logic:iterate name="listThongKeForm" property="list" id="kh">
								<tr>
									<th scope="row">
										<bean:define name="kh" property="maSanPham" id="masp"></bean:define>
										<html:link action = "suaSP.do?userName=${masp}" >
											<bean:write name="kh" property="tenSanPham" />
										</html:link>
										
									</th>
									<td><bean:write name="kh" property="soLuongBan" /></td>
									<td><bean:write name="kh" property="tongTienBanDuoc" /></td>
								</tr>
							</logic:iterate>
						</tbody>
					</table>
					</logic:notEqual>
				</logic:notEqual>
				<logic:equal name="listThongKeForm" property="loaiThongKe" value="3">
					<h1>Thống kê chung</h1>
					<table class="table table-hover">
						<tbody>
							<tr>
								<td><label for="usr">Số đơn hàng: </label></td>
								<td><bean:write name="listThongKeForm" property="soLuongDonHang" /></td>
					
							</tr>
							<tr>
								<td><label for="usr">Số sản phẩm bán được: </label></td>
								<td><bean:write name="listThongKeForm"
									property="soLuongSanPhamBanDuoc" /></td>
							</tr>
							<tr>
								<td><label for="usr">Tổng chi phí bán được: </label></td>
								<td><bean:write name="listThongKeForm" property="tongChiPhi" /></td>
							</tr>
						</tbody>
					</table>
					<h1>Danh sách khách hàng</h1>
					<table class="table table-hover">
						<thead>
							<tr>
								<th>Họ Tên Khách Hàng</th>
								<th>Số Đơn Hàng đã giao</th>
								<th>Tổng tiền bán được</th>
							</tr>
						</thead>
						<tbody>
							<logic:iterate name="listThongKeForm" property="list" id="kh">
								<tr>
									<th scope="row">
										<bean:define name="kh" property="username" id="makh"></bean:define>
										<html:link action = "xemTT.do?userName=${makh}" >
											<bean:write name="kh" property="tenKhachHang" />
										</html:link>
										
									</th>
									<td><bean:write name="kh" property="soDonHangDaGiao" /></td>
									<td><bean:write name="kh" property="tongTienDaThanhToan" /></td>
								</tr>
							</logic:iterate>
						</tbody>
					</table>
				</logic:equal>
			</div>
		</div>
	</div>
</div>

<!-- /code -->
<%@include file="/footer.html"%>
