package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.KhachHangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.KhachHangForm;
import form.LoginForm;

public class BlockThongTinAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KhachHangForm khachHangForm = (KhachHangForm) form;
		
		HttpSession session = request.getSession();
		LoginForm loginForm = (LoginForm)session.getAttribute("loginForm");
		if(loginForm != null ){
			if( loginForm.getQuyenHan() != 1){
				return mapping.findForward("home");
			}
		}else{
			return mapping.findForward("home");
		}
		
		String user = khachHangForm.getUserName();
		int block = khachHangForm.getBlock();
		int quyen = khachHangForm.getQuyenhan();
		System.out.println("block " + block+ ": quyen:"+quyen);
		if (block == 1) {
			KhachHangBO khachHangBO = new KhachHangBO();
			khachHangBO.unblockKH(user);
		} else {
			KhachHangBO khachHangBO = new KhachHangBO();
			khachHangBO.blockKH(user);
		}
		if (quyen == 2) {
			return mapping.findForward("dsnv");
		}else{
			return mapping.findForward("dskh");
		}
	}
}
