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

public class HuyGiaoHangAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String magiaohang;
		DonHang DonHang= new DonHang();
		DanhSachDatHangForm DanhSachDatHangForm = (DanhSachDatHangForm) form;
		
		HttpSession httpSession = request.getSession();
		LoginForm loginForm = (LoginForm) httpSession.getAttribute("loginForm");
		
		String username = loginForm.getUserName();
		int quyen=loginForm.getQuyenHan();
		System.out.println("Tau la dai ca o day"+username+"quyen"+quyen);
		//int madonhang = DanhSachDatHangForm.getMadonhang();
		//String username= DanhSachDatHangForm.getUserName();
		int madonhang = DanhSachDatHangForm.getMadonhang();
		ArrayList<DonHang> listdonhang;
		DonHangBO DonHangBO= new DonHangBO();
		//Lay quyen han, Username
		
		
		//Ham huy
		if(quyen==3){
			magiaohang="TT03";
		}
		else{
			magiaohang="TT04";
		}
		DonHangBO.huyDatHang(madonhang,magiaohang);
		//Ham show
		listdonhang=DonHangBO.xemDanhSachDonHang(username,quyen);
		DanhSachDatHangForm.setListdonhang(listdonhang);
		//System.out.println("quyen han "+ quyen +username);
		
		//DonHangBO.huyDatHang(madonhang);
		//DanhSachDatHangForm.setListdonhang(listdonhang);
		return mapping.findForward("huy");
	}
}
