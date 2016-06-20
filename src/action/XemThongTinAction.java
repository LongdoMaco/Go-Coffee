package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.KhachHang;
import model.bo.KhachHangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.KhachHangForm;

public class XemThongTinAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		KhachHangForm khachHangForm = (KhachHangForm)form;
		String Username = khachHangForm.getUserName(); 
		System.out.println(Username);
		KhachHang kh = new KhachHang();
		KhachHangBO khbo = new KhachHangBO();
		kh = khbo.getKH(Username);
		
		khachHangForm.setUserName(kh.getUserName());
		System.out.println(kh.getUserName());
		khachHangForm.setTenKhachHang(kh.getTenKhachHang());
		khachHangForm.setsDT(kh.getsDT());
		khachHangForm.setDiaChi(kh.getDiaChi());
		khachHangForm.setGioiTinh(kh.getGioiTinh());
		khachHangForm.setEmail(kh.getEmail());
		khachHangForm.setNgaySinh(kh.getNgaySinh());
		khachHangForm.setQuyenhan(kh.getQuyenhan());
		System.out.println(kh.getQuyenhan());
		khachHangForm.setBlock(kh.getBlock());
		khachHangForm.setHinhAnh(kh.getHinhAnh());
		System.out.println(kh.getHinhAnh());
		return mapping.findForward("xemtt");

	}
}
