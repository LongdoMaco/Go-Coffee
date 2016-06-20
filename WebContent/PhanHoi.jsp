<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="common.StringProcess"%>
<%@page import="model.bean.KhachHang"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<%@include file="/header.jsp"%>
    <link rel="stylesheet" href="css/jquery-ui.css">

<script src="js/jquery-ui.js"></script>

<script>
	$(function() {
		$("#slider-range-max1").slider( {
			range : "max",
			min : -10,
			max : 10,
			value : 0,
			slide : function(event, ui) {
				$("#amount1").val(ui.value);
			}
		});
		$("#amount1").val($("#slider-range-max1").slider("value"));

		$("#slider-range-max2").slider( {
			range : "max",
			min : -10,
			max : 10,
			value : 0,
			slide : function(event, ui) {
				$("#amount2").val(ui.value);
			}
		});
		$("#amount2").val($("#slider-range-max2").slider("value"));
		$("#slider-range-max3").slider( {
			range : "max",
			min : -10,
			max : 10,
			value : 0,
			slide : function(event, ui) {
				$("#amount3").val(ui.value);
			}
		});
		/*$("#amount3").val($("#slider-range-max3").slider("value"));*/
	});
</script>

<div class="panel panel-default panelnth2" style="margin-top: 120px">
<div class="panel-body">
<H1>Phản hồi của khách hàng</H1>
<p>Mọi ý kiến đóng góp của quý khách là một bài học quý để chúng tôi
ngày càng phát triển</p>
<html:form action="phanhoi.do">
	<div class="form-group row">
	<div class="col-sm-1"></div>
	<label class="col-sm-3">Mã Đơn Hàng:</label>
	<div class="col-sm-8"><html:text property="maDonHang" styleClass="form-control"
		readonly="true" value="001" /></div>

	</div>
	
	<div class="form-group row" style="height:30px">
		<div class="col-sm-1"></div>
		<label class="col-sm-3" for="amount1">Thái độ nhân viên:</label>
		<div class="col-sm-6" style="margin-top: 7px">
		<div id="slider-range-max1"></div>
	</div>
	<div class="col-sm-2">
		<html:text property="thaiDoNhanVien" readonly="true" styleClass="form-control" styleId="amount1"></html:text></div>
	</div>
	<div class="form-group row"  style="height:30px">
		<div class="col-sm-1"></div>
		<label class="col-sm-3" for="amount2">Chất lượng sản phẩm:</label>
		<div class="col-sm-6" style="margin-top: 7px">
		<div id="slider-range-max2"></div>
	</div>
	<div class="col-sm-2"><html:text property="chatLuongSanPham" readonly="true"
		styleClass="form-control" styleId="amount2"></html:text></div>
	</div>
		<div class="form-group row"  style="height:30px">
		<div class="col-sm-1"></div>
		<label class="col-sm-3" for="amount3">Độ hài lòng:</label>
		<div class="col-sm-6" style="margin-top: 7px">
	<div id="slider-range-max3"></div>
	</div>
	<div class="col-sm-2"><html:text property="doHaiLong" readonly="true"
		styleClass="form-control" styleId="amount3"></html:text></div>
	</div>
	<div class="form-group row">
	<div class="col-sm-1"></div>
	<label class="col-sm-3" for="amount">Nội dung phản hồi:</label>
	<div class="col-sm-8"><html:textarea styleClass="form-control"
		rows="5" property="noiDungKhac"></html:textarea></div>
	</div>
	<br />
	<div class="form-group col-sm-2 rightnth"><html:submit
		styleClass="btn btn-primary  heightnth" value="Gửi phản hồi"></html:submit>
	</div>
</html:form></div>
</div>

<%@include file="/footer.html"%>