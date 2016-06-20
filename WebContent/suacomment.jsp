<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>
<%@ taglib uri="http://struts.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/alert.css">
<script type="text/javascript" src="javascript/com/alert.js">
</script>
<script type="text/javascript" src="javascript/com/validateInput.js">
</script>

</head>
<body>
	<%@include file="/header.jsp" %>
	
	<!-- ..Body.. -->
	<div class="container" style="margin-top:120px; ">
			<!-- Noi dung o day ne........................ -->
			<div class="panel panel-default panelnth">
		  		<div class="panel-body">
		  		<center> <p style="font-family: serif; font-size: 40px">SỬA BÌNH LUẬN</p> </center>
		  		<html:form action="suacomment">
					<table>
						<tr>
							<td style="width: 100px; font-size: 15px"> Người Đăng: </td>
							<td>  
								<bean:write name="commentForm" property="userName"/>
							</td>
						</tr>
							
						<tr height="160px" style="text-align: justify;">
							<td style="width: 100px; font-size: 15px"> Nội dung: </td>
							<td>  
								<html:textarea styleId="Nội Dung Comment" name="commentForm" property="noiDungComment" cols="100" rows="5" styleClass="form-control"/>
								<div style="color: red;">
									<html:messages id="err_id_pass" property="noidung_Error">
									<bean:write name="err_id_pass"/>
									</html:messages>
								</div>
							</td>
						</tr>	
							
						<tr>
							<td style="width: 100px"> </td>
							<td>
								<div>
									<center>
										<div class="col-sm-3 rightnth">
											<html:submit property="submit" value="Sửa" onclick="return checkSuaBinhLuan('Nội Dung Comment', 3000)" styleClass="btn btn-primary "></html:submit>
										</div>
											<bean:define id="mbv" name="commentForm" property="maBaiViet"></bean:define>
											<bean:define id="mcm" name="commentForm" property="idComment"></bean:define>
											<html:hidden property="maBaiViet" value="${mbv}"/>
											<html:hidden property="idComment" value="${mcm}"/>
										<div class="col-sm-3 rightnth">
											<button value="Quay lại" class="btn btn-primary">Quay lại</button>
										</div>
									</center>
								</div>  
								
							</td>
						</tr>
						
					</table>
					</html:form>
				</div>
			</div>
	</div>	
</body>
</body>
</html>