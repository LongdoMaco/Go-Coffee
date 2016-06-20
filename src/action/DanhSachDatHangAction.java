package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.DonHang;
import model.bo.DonHangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.DanhSachDatHangForm;
import form.LoginForm;
import form.SanPhamForm;

public class DanhSachDatHangAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		DanhSachDatHangForm DanhSachDatHangForm = (DanhSachDatHangForm) form;
		DonHang DonHang= new DonHang();
		DonHangBO DonHangBO= new DonHangBO();
		
		String submit=DanhSachDatHangForm.getSubmit();
		
		///
		HttpSession httpSession = request.getSession();
		LoginForm loginForm = (LoginForm) httpSession.getAttribute("loginForm");
		int quyenmoi=loginForm.getQuyenHan();
		String username = loginForm.getUserName();
		//
		System.out.println("summit+++"+submit);
		//DonHang = DonHangBO.layQuyenMoi(username);
		//int quyenmoi=DonHang.getQuyenhan();
		int madonhang=DanhSachDatHangForm.getMadonhang();
		String ghichu= DanhSachDatHangForm.getGhichu();
		String diachi=DanhSachDatHangForm.getDiachigiaohang();
		int soluong=DanhSachDatHangForm.getSoluong();
		ArrayList<DonHang> listdonhang;
		
		
		
		//System.out.println("moi vao"+user);
		if("submit".equals(submit)){
			System.out.println("aaaaa"+ghichu+diachi+soluong);
			DonHangBO.suaDonHang(madonhang,ghichu,diachi,soluong);
			
			
			listdonhang=DonHangBO.xemDanhSachDonHang(username,quyenmoi);
			DanhSachDatHangForm.setListdonhang(listdonhang);
			return mapping.findForward("danhsach");
			//
		}
		else if("Huy".equals(submit)){
			System.out.println("da qua duoc roi ha ha");
			listdonhang=DonHangBO.xemDanhSachDonHang(username,quyenmoi);
			DanhSachDatHangForm.setListdonhang(listdonhang);
			return mapping.findForward("danhsach");
		}
		else{
			listdonhang=DonHangBO.xemDanhSachDonHang(username,quyenmoi);
			DanhSachDatHangForm.setListdonhang(listdonhang);
			return mapping.findForward("danhsach");
		}
		
	}
}
