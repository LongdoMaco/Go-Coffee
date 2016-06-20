package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.SanPham;
import model.bo.SanPhamBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.LoginForm;
import form.SanPhamForm;

public class showSanPhamAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		SanPhamForm sanPhamForm = (SanPhamForm) form;
		LoginForm loginForm = new LoginForm();
		HttpSession session = request.getSession();
		loginForm = (LoginForm)session.getAttribute("loginForm");
		if(loginForm != null){
			sanPhamForm.setQuyenHan(loginForm.getQuyenHan());
		}
		
		int maSanPham = sanPhamForm.getMaSanPham();
		System.out.println(maSanPham);
		SanPhamBO spbo = new SanPhamBO();
		SanPham sp  = spbo.getSP(maSanPham);
		sanPhamForm.setMaSanPham(sp.getMaSanPham());
		sanPhamForm.setTenSanPham(sp.getTenSanPham());
		sanPhamForm.setGiaBan(sp.getGiaBan());
		sanPhamForm.setTenLoai(sp.getTenLoai());
		sanPhamForm.setHinhAnh(sp.getHinhAnh());
		
		return mapping.findForward("chitietsp");
	}
}
