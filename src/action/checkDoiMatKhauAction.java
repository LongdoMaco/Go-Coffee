package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.KhachHangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;
import common.Validations;
import form.KhachHangForm;

public class checkDoiMatKhauAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
			KhachHangForm khachHangForm = (KhachHangForm) form;
			String username=khachHangForm.getUserName();
			String password=khachHangForm.getPassword();
			String newpassword=khachHangForm.getMatKhauMoi();
			
			KhachHangBO khachHangBO = new KhachHangBO();
			if("Submit".equals(khachHangForm.getSubmit())){	
				ActionErrors actionErrors = new ActionErrors();
				
				if (StringProcess.notVaild(khachHangForm.getUserName())) {
					actionErrors.add("msUser", new ActionMessage(
							"error.tenDangNhap.null"));
				}
				
				if (StringProcess.notVaild(khachHangForm.getPassword())) {
					actionErrors.add("msPass", new ActionMessage(
							"error.matKhau.null"));
				}
				if (StringProcess.notVaild(khachHangForm.getMatKhauMoi())) {
					actionErrors.add("msNewPass", new ActionMessage(
							"error.matKhau.null"));
				}
				if (StringProcess.notVaild(khachHangForm.getXacNhanMatKhau())) {
					actionErrors.add("msXanNhanMK", new ActionMessage(
							"error.matKhau.null"));
				}
				
				// check max length
				
				
				if (!Validations.validateMaxLength(khachHangForm.getMatKhauMoi(), 20)) {
					actionErrors.add("msNewPass", new ActionMessage(
							"error.matKhau.quadai"));
				}
				

				// check min length
				
				
				if (Validations.validateMinLength(khachHangForm.getMatKhauMoi(), 6)) {
					actionErrors.add("msNewPass", new ActionMessage(
							"error.matKhau.quangan"));
				}
				
				// check others
				
				
				if (!Validations.checkConfirmMK(khachHangForm.getMatKhauMoi(),
						khachHangForm.getXacNhanMatKhau())) {
					actionErrors.add("msRePass", new ActionMessage(
							"error.xacNhanMatKhau.notEqual"));
				}
				
				
				

				

				
				saveErrors(request, actionErrors);
				if (actionErrors.size() > 0) {
					return mapping.findForward("thatbai");
				}// nhan nut Xac nhan o trang Them sinh vien

				khachHangForm.setSubmit("");
			if(khachHangBO.checkUser(username,password))//em check vai nay ton tai
			{
				khachHangBO.doiMatKhau(username,password,newpassword);
				return mapping.findForward("doimatkhauthanhcong");
			}else return mapping.findForward("thatbai");
			
			}
			else 											//chuyen sang doimatkhau
				return mapping.findForward("thatbai");
					
			
	}
}
