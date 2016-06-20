package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.SanPhamBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.KhachHangForm;
import form.LoginForm;
import form.SanPhamForm;

public class XoaSanPhamAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		SanPhamForm sanPhamForm = (SanPhamForm) form;
		HttpSession session = request.getSession();

		LoginForm loginForm = new LoginForm();
		loginForm = (LoginForm) session.getAttribute("loginForm");
		if (sanPhamForm == null || loginForm == null) {
			ActionErrors er = new ActionErrors();
			er.add("loikhixoa", new ActionMessage("error.errordelete"));
			return mapping.findForward("home");
		}
		if (loginForm.getQuyenHan() != 1) {
			ActionErrors er = new ActionErrors();
			er.add("loikhixoa", new ActionMessage("error.errordelete2"));
			return mapping.findForward("home");
		}
		int masp = sanPhamForm.getMaSanPham();
		SanPhamBO spbo = new SanPhamBO();
		spbo.deleteSanPham(masp);
		return mapping.findForward("home");

	}
}
