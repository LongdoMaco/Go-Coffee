package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.KhachHangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.KhachHangForm;

public class XoaThongTinAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KhachHangForm khachHangForm = (KhachHangForm) form;
		String user = khachHangForm.getUserName();
		int quyen = khachHangForm.getQuyenhan();
		KhachHangBO khachHangBO = new KhachHangBO();
		khachHangBO.deleteKH(user);
		if (quyen == 2) {
			return mapping.findForward("dsnv");
		} else {
			return mapping.findForward("dskh");
		}
	}
}
