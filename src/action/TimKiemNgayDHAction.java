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

public class TimKiemNgayDHAction extends Action {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DanhSachDonHangForm DanhSachDonHangForm = (DanhSachDonHangForm) form;
		
		DonHangBO DonHangBO= new DonHangBO();
		ChiTietDonHang ChiTietDonHang= new ChiTietDonHang();
		ArrayList<ChiTietDonHang> listchitietdonhang;
		//Lay chuoi tim kiem
		String timkiem = DanhSachDonHangForm.getNgaythang();
		System.out.println("tim kiem"+timkiem);
		String nam = timkiem.substring(0, 4);
		String thang = timkiem.substring(5,7);
		String ngay=timkiem.substring(8, 10);
		System.out.println("Ngay "+ngay+"Thang "+ thang+"Nam "+nam);
		//Lay quyen v� username
		HttpSession httpSession = request.getSession();
		LoginForm loginForm = (LoginForm) httpSession.getAttribute("loginForm");
		int quyenmoi=loginForm.getQuyenHan();
		String username = loginForm.getUserName();
		
		//Lay thong tin danh sach don hang
		listchitietdonhang= DonHangBO.layDanhSachNgayDonHangTK(quyenmoi,ngay,thang,nam);
		DanhSachDonHangForm.setListchitietdonhang(listchitietdonhang);
		return mapping.findForward("danhsach");
	}
}
