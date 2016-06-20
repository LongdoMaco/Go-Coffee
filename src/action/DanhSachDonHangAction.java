package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ChiTietDonHang;
import model.bean.DonHang;
import model.bean.GioHang;
import model.bo.DonHangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachDatHangForm;
import form.DanhSachDonHangForm;
import form.LoginForm;

public class DanhSachDonHangAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DanhSachDonHangForm DanhSachDonHangForm = (DanhSachDonHangForm) form;
		DonHangBO DonHangBO= new DonHangBO();
		ChiTietDonHang ChiTietDonHang= new ChiTietDonHang();
		ArrayList<ChiTietDonHang> listchitietdonhang;
		//Lay quyen và username
		HttpSession httpSession = request.getSession();
		LoginForm loginForm = (LoginForm) httpSession.getAttribute("loginForm");
		int quyenmoi=loginForm.getQuyenHan();
		String username = loginForm.getUserName();
		 
		
		//Thu nghiem gio hang
		
		//Lay thong tin danh sach don hang
		listchitietdonhang= DonHangBO.layDanhSachDonHang(quyenmoi);
		DanhSachDonHangForm.setListchitietdonhang(listchitietdonhang);
		return mapping.findForward("danhsach");
	}
}
