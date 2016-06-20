package action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
import form.LoginForm;

public class CheckDangKyAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		System.out.println("aeljhrfwerfhw4j3hf2u4rfw3e");
		KhachHangForm khachHangForm = (KhachHangForm) form;
		
		

		if ("Submit".equals(khachHangForm.getSubmit())) {
			ActionErrors actionErrors = new ActionErrors();
			// check null
			if (StringProcess.notVaild(khachHangForm.getUserName())) {
				actionErrors.add("msUser", new ActionMessage(
						"error.tenDangNhap.null"));
			}
			if (StringProcess.notVaild(khachHangForm.getTenKhachHang())) {
				actionErrors.add("msName", new ActionMessage(
						"error.tenNguoiDung.null"));
			}
			if (StringProcess.notVaild(khachHangForm.getPassword())) {
				actionErrors.add("msPass", new ActionMessage(
						"error.matKhau.null"));
			}
			if (StringProcess.isEmptyString(khachHangForm.getNgaySinh())) {
				actionErrors.add("msDate", new ActionMessage(
						"error.ngaySinh.format"));
			}
			if (StringProcess.notVaild(khachHangForm.getDiaChi())) {
				actionErrors.add("msDiaChi", new ActionMessage(
						"error.diaChi.null"));
			}
			if (StringProcess.notVaild(khachHangForm.getsDT())) {
				actionErrors.add("msSDT", new ActionMessage(
						"error.soDienThoai.null"));
			}
			if (StringProcess.notVaild(khachHangForm.getEmail())) {
				actionErrors.add("msEmail", new ActionMessage(
						"error.email.null"));
			}

			// check max length
			if (!Validations.validateMaxLength(khachHangForm.getUserName(), 30)) {
				actionErrors.add("msUser", new ActionMessage(
						"error.tenDangNhap.quadai"));
			}
			if (!Validations.validateMaxLength(khachHangForm.getTenKhachHang(),
					30)) {
				actionErrors.add("msName", new ActionMessage(
						"error.tenNguoiDung.quadai"));
			}
			if (!Validations.validateMaxLength(khachHangForm.getPassword(), 20)) {
				actionErrors.add("msPass", new ActionMessage(
						"error.matKhau.quadai"));
			}
			if (!Validations.validateMaxLength(khachHangForm.getDiaChi(), 50)) {
				actionErrors.add("msDiaChi", new ActionMessage(
						"error.diaChi.quadai"));
			}
			if (!Validations.validateMaxLength(khachHangForm.getsDT(), 12)) {
				actionErrors.add("msSDT", new ActionMessage(
						"eror.sDT.quadai"));
			}
			if (!Validations.validateMaxLength(khachHangForm.getEmail(), 50)) {
				actionErrors.add("msEmail", new ActionMessage(
						"error.email.quadai"));
			}

			// check min length
			if (Validations.validateMinLength(khachHangForm.getUserName(), 6)) {
				actionErrors.add("msUser", new ActionMessage(
						"error.tenDangNhap.quangan"));
			}
			if (Validations.validateMinLength(khachHangForm.getTenKhachHang(),
					6)) {
				actionErrors.add("msName", new ActionMessage(
						"error.tenNguoiDung.quangan"));
			}
			if (Validations.validateMinLength(khachHangForm.getPassword(), 6)) {
				actionErrors.add("msPass", new ActionMessage(
						"error.matKhau.quangan"));
			}
			if (Validations.validateMinLength(khachHangForm.getDiaChi(), 10)) {
				actionErrors.add("msDiaChi", new ActionMessage(
						"error.diaChi.quangan"));
			}
			if (Validations.validateMinLength(khachHangForm.getsDT(), 9)) {
				actionErrors.add("msSDT",
						new ActionMessage("error.sDT.quangan"));
			}
			if (Validations.validateMinLength(khachHangForm.getEmail(), 6)) {
				actionErrors.add("msEmail", new ActionMessage(
						"error.email.quangan"));
			}
			// check others
			if (!StringProcess.notVaildNumber2(khachHangForm.getTenKhachHang())) {
				actionErrors.add("msName", new ActionMessage(
						"error.tenNguoiDung.chuaso"));
			}

			if (!StringProcess.isSpace(khachHangForm.getPassword())) {
				actionErrors.add("msPass", new ActionMessage(
						"error.matKhau.space"));
			}
			
			if (Validations.validateDate(khachHangForm.getNgaySinh())) {
				actionErrors.add("msDate", new ActionMessage(
						"error.email.ngaysinh"));
			}
			
			

			if (StringProcess.notVaildNumber(khachHangForm.getsDT())) {
				actionErrors.add("msSDT", new ActionMessage(
						"error.soDienThoai.saidinhdang"));
			}

			if (!Validations.checkEmail(khachHangForm.getEmail())) {
				actionErrors.add("msEmail", new ActionMessage(
						"error.soDienThoai.saidinhdang"));
			}

			saveErrors(request, actionErrors);
			if (actionErrors.size() > 0) {
				return mapping.findForward("thatbai");
		}// nhan nut Xac nhan o trang Them sinh vien

			khachHangForm.setSubmit("");

			String username = khachHangForm.getUserName();
			String tenKhachHang = khachHangForm.getTenKhachHang();
			String password = khachHangForm.getPassword();
			String diaChi = khachHangForm.getDiaChi();
			String ngaySinh = khachHangForm.getNgaySinh();
			int gioiTinh = khachHangForm.getGioiTinh();
			String sDT = khachHangForm.getsDT();
			String email = khachHangForm.getEmail();
			KhachHangBO khachHangBO = new KhachHangBO();

			khachHangBO.dangKy(username, tenKhachHang, password, diaChi,
					ngaySinh, gioiTinh, sDT, email);
			return mapping.findForward("dangkythanhcong");
		} else { // chuyen sang trang đăng ký
			LoginForm loginForm = new LoginForm();
			HttpSession session = request.getSession();
			loginForm = (LoginForm) session.getAttribute("loginForm");
			if(loginForm != null){
				session.invalidate();
			}
			return mapping.findForward("thatbai");
		}
	}
}
