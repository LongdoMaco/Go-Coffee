package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ListPhanHoi;
import model.bean.PhanHoi;
import model.bo.PhanHoiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ListPhanHoiForm;
import form.LoginForm;

public class XemPhanHoiAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ListPhanHoiForm listPhanHoiForm = (ListPhanHoiForm)form;
		
		HttpSession session = request.getSession();
		LoginForm loginForm = (LoginForm)session.getAttribute("loginForm");
		if(loginForm != null ){
			if( loginForm.getQuyenHan() != 1){
				return mapping.findForward("home");
			}
		}else{
			return mapping.findForward("home");
		}
		int page = listPhanHoiForm.getPage();
		PhanHoiBO phanHoiBO = new PhanHoiBO();
		ListPhanHoi listPhanHoi = phanHoiBO.getlistPH(page);
		listPhanHoiForm.setListPhanHoi(listPhanHoi.getListPhanHoi());
		listPhanHoiForm.setSoTrang(listPhanHoi.getSoTrang());
		listPhanHoiForm.setPage(listPhanHoi.getSoTrang());
		if(listPhanHoi != null){
			return mapping.findForward("dsph");
		}
		else{
			System.out.println("loi tai xemphanhoiaction");
			return mapping.findForward("home");
		}
	}
}