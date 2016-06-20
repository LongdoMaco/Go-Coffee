package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.PhanHoiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LoginForm;
import form.PhanHoiForm;

public class showPhanHoiAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PhanHoiForm phanHoiForm = (PhanHoiForm) form;
		HttpSession session = request.getSession();
		LoginForm loginForm = (LoginForm) session.getAttribute("loginForm");
		if (loginForm != null) {
			String user = loginForm.getUserName();
			String maDonHang = phanHoiForm.getMaDonHang();

			PhanHoiBO phbo = new PhanHoiBO();
			if (phbo.checkDH(maDonHang, user)) {
				return mapping.findForward("ph");
			}
		}
		return mapping.findForward("home");
	}
}
