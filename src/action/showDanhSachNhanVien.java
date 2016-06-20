package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.KhachHang;
import model.bean.ListKhachHang;
import model.bo.KhachHangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.taglibs.standard.lang.jpath.adapter.Convert;

import form.KhachHangForm;
import form.ListKhachHangForm;
import form.LoginForm;

public class showDanhSachNhanVien extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		
		ListKhachHangForm listKhachHangForm = (ListKhachHangForm) form;
		
		HttpSession session = request.getSession();
		LoginForm loginForm = (LoginForm)session.getAttribute("loginForm");
		if(loginForm != null ){
			if( loginForm.getQuyenHan() != 1){
				return mapping.findForward("home");
			}
		}else{
			return mapping.findForward("home");
		}
		
		KhachHangBO khachHangBO = new KhachHangBO();
		String a = "";
		a = listKhachHangForm.getSearch();
		int page = 0;
		if(listKhachHangForm.getPage() == 0){
			page = 1;
		}else{
			page = listKhachHangForm.getPage();
		}
		
		if("".equals(a) || a == null){
			ListKhachHang arr = khachHangBO.getListKhachHang(2,page);
			listKhachHangForm.setListKH(arr.getListKH());
			listKhachHangForm.setPage(arr.getPage());
			listKhachHangForm.setSotrang(arr.getSotrang());
			return mapping.findForward("dsnv");
		}else{
			System.out.println(a);
			ListKhachHang arr = khachHangBO.getListKhachHang(2,a,page);
			listKhachHangForm.setListKH(arr.getListKH());
			listKhachHangForm.setPage(arr.getPage());
			listKhachHangForm.setSotrang(arr.getSotrang());
			return mapping.findForward("dsnv");
		}
	}
}
