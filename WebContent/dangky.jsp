<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles" %>
<link rel="stylesheet" href="css/dangky_style.css"/>
<%@include file="header.jsp" %>     

<script>
	function checksamepass(){
		var pass1= document.getElementById("pass1");
		var pass2= document.getElementById("pass2");
		if(pass1 != pass2){
			document.getElementById("notsame").innerHTML  = "Pass nhap vao khong khop";
			
		}else{
			document.getElementById("notsame").innerHTML  = "Mat khau da khop";
		}
	}
</script>

<div class="container " style="margin-top:120px">
<div class="panel panel-default">
           	<div class="space col-md-1"></div>
 <div class="panel-body">
 			<h1 class="col-sm-12 row" style="height:30px">Đăng ký</h1><Br/><Br/><Br/>
            <div class="right col-sm-6">
                <html:form action="checkDangKy.do">
                        <div class="row form-group">
                            <label class="col-sm-12">Tên tài khoản(*)</label>
                            <div class="col-sm-12">
                                <html:text  property="userName" style="margin-bottom: 0px;" styleClass="form-control" ></html:text>
                            </div>
                            <div class="col-sm-12">
                            <font color="red"><html:errors property="msUser"/></font>
                            </div>
                            <label class="control-label col-md-4 " for="email"><font color="green"></font></label>
                        </div>
                        
                        <div class="row form-group">
                            <label class="col-sm-12">Tên khách hàng(*)</label>
                            <div class="col-sm-12">
                                <html:text property="tenKhachHang" style="margin-bottom: 0px;" styleClass="form-control" ></html:text>
                            </div>
                            <div class="col-sm-12">
                            <font color="red"><html:errors property="msName"/></font>
                            </div>
                            <label class="control-label col-sm-12 " for="email"><font color="green"></font></label>
                        </div>
                        
                        <div class="row form-group">
                            <label class="col-sm-12">Mật khẩu(*)</label>
                            <div class="col-sm-12">
                                <html:password  property="password" styleId="pass1" style="margin-bottom: 0px;" styleClass="form-control" ></html:password>
                            </div>
                            <div class="col-sm-12">
                            	<font color="red"><html:errors property="msPass"/></font>
                            </div>
                        	<label class="control-label col-sm-12" for="email"><font color="green"></font></label>
                        </div>
                        
                        
                        <div class="row form-group">
                             <label class="col-sm-12">Xác nhận(*)</label>
                            <div class="col-sm-12">
                                <input type="password" id="pass2" style="margin-bottom: 0px;" onchange="checksamepass();" class="form-control" />
                                <label style="color:red" id="notsame"></label>
                            </div>
                            <div class="col-sm-12">
                            	<font color="red"><html:errors property="msRePass"/></font>
                            </div>
                        	<label class="control-label col-sm-12" for="email"><font color="green"></font></label>
                        </div>
                        
                        <div class="row form-group">
                            <label class="col-sm-12">Địa chỉ(*)</label>
                            <div class="col-sm-12">
                                <html:text property="diaChi" style="margin-bottom: 0px;" styleClass="form-control" ></html:text>
                            </div>
                            <div class="col-sm-12">
                            	<font color="red"><html:errors property="msDiaChi"/></font>
                            </div>
                            <label class="control-label col-sm-12" for="email"><font color="green"></font></label>
                        </div>
                        
                        <div class="row form-group">
                            <label class="col-sm-12">Ngày sinh</label>
                            <div class="col-sm-12">
                                <input type="date" name="ngaySinh" style="margin-bottom: 0px;" class="form-control"/>
                            </div>
                            <div class="col-sm-12">
                            <font color="red"><html:errors property="msDate"/></font>
                            </div>
                            <label class="control-label col-sm-12" for="email"><font color="green"></font></label>
                        </div>
                        <div class="row form-group">
                            <label class="col-sm-3">Giới tính</label>
                            <div class="col-sm-6">
                                <html:radio  property="gioiTinh"  value="1" styleClass="col-sm-2"></html:radio>
                                <div class="col-sm-2">Nam</div>
                                <div class="col-sm-2"></div>
                                <html:radio property="gioiTinh" value="0" styleClass="col-sm-1"></html:radio>
                                 <div class="col-sm-2">Nữ</div>
                            </div>
                        </div>
                        
                        <div class="row form-group">
                            <label class="col-sm-12">Số điện thoại(*)</label>
                            <div class="col-sm-12">
                                <html:text  property="sDT" style="margin-bottom: 0px;" styleClass="form-control" ></html:text>
                            </div>
                            <div class="col-sm-12">
                            	<font color="red"><html:errors property="msSDT"/></font>
                            </div>
                            <label class="control-label col-md-4" for="email"><font color="green"></font></label>
                        </div>
                        
                        <div class="row form-group">
                            <label class="col-sm-12">Email(*)</label>
                            <div class="col-sm-12">
                                <input type="email" name="email" style="margin-bottom: 0px;" class="form-control" />
                            </div>
                            <div class="col-sm-12">
                           		 <font color="red"><html:errors property="msEmail"/></font>
                            </div>
                            <label class="control-label col-sm-12" for="email"><font color="green"></font></label>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-12">
                            	<div class="col-sm-6">
                                    <html:submit styleClass= "btn btn-primary" property="submit" value="Submit" />
                                </div>
                                <div class="col-sm-6">
                                    <html:button styleClass="btn btn-primary"   property="submit" value="Hủy" onclick="window.location = 'showTrangChu.do'" ></html:button>
                            	</div>
                            </div>
                        </div>
                    </html:form>
            </div>
            <div class="col-sm-6">
            	<div class="col-sm-12" style="margin-top:20px;margin-bottom:20px">
	            	<p style="font-style: italic;"><i>Xin chào quý khách, để có thể thực hiện việc đặt hàng online, quý khách phải đăng ký tài khoản, vui lòng điền vào đầy đủ các ô ở phía tay phải, những ô có dấu (*) là bắt buộc. Sau khi điền hoàn tất, vui lòng nhấn nút <font color="red">Submit</font> để gửi yêu cầu đăng ký</i></p>
	            </div>
	            <div class="col-sm-12">
	                <img style="border:3px solid #B40303;border-radius:6px;" src="images/logo2.jpg" width="100%" height="500px"/>
	            </div>
	            
            </div>
			</div>
        </div>
    </div>

	<script src="//cdn.jsdelivr.net/webshim/1.14.5/polyfiller.js">
	</script> 
	<script>
		webshims.setOptions('forms-ext', {
		types : 'date'
			});
		webshims.polyfill('forms forms-ext');
</script>
<%@include file="footer.html"%>