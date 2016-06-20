package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BaiViet;
import model.bo.BaiVietBO;
import model.bo.LoaiBaiVietBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiVietForm;
import form.LoginForm;

public class ShowQuanLyBaiViet extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		LoginForm loginForm = null;
		String userDangNhap=null;
		int quyenHan=0;
		
		HttpSession httpSession = request.getSession();
		loginForm = (LoginForm) httpSession.getAttribute("loginForm");
		
		if (loginForm!=null){
			userDangNhap = loginForm.getUserName();
			quyenHan = loginForm.getQuyenHan();
		} else {
			userDangNhap = "";
		}
		
		System.out.println("User dang nhap: "+userDangNhap);
		
		BaiVietForm bvForm = (BaiVietForm) form;
		String dieuKien = bvForm.getDieuKien();
		System.out.println("Dieu kien: "+dieuKien);
		BaiVietBO bo = new BaiVietBO();
		
		ArrayList<BaiViet> listBaiViet=null;
		ArrayList<BaiViet> listBaiVietMoi = null;
		
		if (!"".equals(dieuKien)){
			System.out.println("Dieu kien sau if: "+dieuKien);
			listBaiViet = bo.getListBaiViet(dieuKien);
			bo.changeFormat(listBaiViet);
			listBaiVietMoi = getNew(listBaiViet);
		} else {
			System.out.println("Dieu kien sau if: "+dieuKien);
			listBaiViet = bo.getListBaiViet();
			bo.changeFormat(listBaiViet);
			listBaiVietMoi = getNew(listBaiViet);
		}
		
		
		
		bvForm.setListBaiViet(listBaiViet);
		bvForm.setListBaiVietMoi(listBaiVietMoi);
		bvForm.setQuyenHan(quyenHan);
		bvForm.setUserDangNhap(userDangNhap);
		
		return mapping.findForward("goQLBV");
	}
	
	private ArrayList<BaiViet> getNew(ArrayList<BaiViet> listBaiViet){
		ArrayList<BaiViet> listBaiVietMoi = new ArrayList<BaiViet>();
		int length = listBaiViet.size();
		BaiViet bv = null;
		
		if (length>=5){
			for (int i = 0; i < 5; i++) {
				bv = listBaiViet.get(i);
				listBaiVietMoi.add(bv);
			}
		}else {
			for (int i = 0; i < length; i++) {
				bv = listBaiViet.get(i);
				listBaiVietMoi.add(bv);
			}
		}
		return listBaiVietMoi;
	}
}
