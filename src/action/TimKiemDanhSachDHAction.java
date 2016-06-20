package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ChiTietDonHang;
import model.bo.DonHangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachDonHangForm;
import form.LoginForm;

public class TimKiemDanhSachDHAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DanhSachDonHangForm DanhSachDonHangForm = (DanhSachDonHangForm) form;
		
		DonHangBO DonHangBO= new DonHangBO();
		ChiTietDonHang ChiTietDonHang= new ChiTietDonHang();
		ArrayList<ChiTietDonHang> listchitietdonhang;
		//Lay chuoi tim kiem
		String timkiem = DanhSachDonHangForm.getSearch();
		//System.out.println("tim kiem"+timkiem);
		//Lay quyen và username
		HttpSession httpSession = request.getSession();
		LoginForm loginForm = (LoginForm) httpSession.getAttribute("loginForm");
		int quyenmoi=loginForm.getQuyenHan();
		String username = loginForm.getUserName();
		
		//Lay thong tin danh sach don hang
		listchitietdonhang= DonHangBO.layDanhSachDonHangTK(quyenmoi,timkiem);
		DanhSachDonHangForm.setListchitietdonhang(listchitietdonhang);
		return mapping.findForward("danhsach");
	}
}
