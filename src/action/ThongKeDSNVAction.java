package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.ListThongKe;
import model.bean.ThongKe;
import model.bo.ThongKeBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ListThongKeForm;
import form.LoginForm;

public class ThongKeDSNVAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ListThongKeForm listThongKeForm = (ListThongKeForm)form;
		
		HttpSession session = request.getSession();
		LoginForm loginForm = (LoginForm)session.getAttribute("loginForm");
		if(loginForm != null ){
			if( loginForm.getQuyenHan() != 1){
				return mapping.findForward("home");
			}
		}else{
			return mapping.findForward("home");
		}
		
		if(listThongKeForm.getThangHienTai() == null){
			Date date = new Date();
			SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
			String thoiGian = sim.format(date);
			System.out.println(thoiGian);
			listThongKeForm.setThangHienTai(thoiGian);
		}
		System.out.println(listThongKeForm.getThangHienTai());
		ArrayList<ThongKe> listtk = new ArrayList<ThongKe>();
		ThongKeBO tkbo = new ThongKeBO();
		ListThongKe tkChung= new ListThongKe();
		tkChung = tkbo.getTK();// lay thong ke chung
		listThongKeForm.setSoLuongDonHang(tkChung.getSoLuongDonHang());
		listThongKeForm.setSoLuongSanPhamBanDuoc(tkChung.getSoLuongSanPhamBanDuoc());
		listThongKeForm.setTongChiPhi(tkChung.getTongChiPhi());
		int loaitk = listThongKeForm.getLoaiThongKe();
		if(loaitk == 2){
			listtk = tkbo.getTKDSNV(listThongKeForm.getThangHienTai());
			listThongKeForm.setList(listtk);
		}else if(loaitk == 3){
			listtk = tkbo.getTKKH(listThongKeForm.getThangHienTai());
			listThongKeForm.setList(listtk);
		}else{
			listtk = tkbo.getTKTheoThang(listThongKeForm.getThangHienTai());
			listThongKeForm.setList(listtk);
		}
		return mapping.findForward("tkdsnv");
	}

}
