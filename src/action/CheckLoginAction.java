package action;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.KhachHang;
import model.bo.loginBO;
import model.bean.GioHang;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.LoginForm;

public class CheckLoginAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println("check login action");
		LoginForm loginForm = (LoginForm)form;
		HttpSession session = request.getSession();
		LoginForm loginForm2 = new LoginForm();
		loginForm2 = (LoginForm)session.getAttribute("loginForm");
		if(loginForm2 == null){
			System.out.println("thang loginForm la null");
		}else{
			System.out.println("thang loginForm ko la null");
		}
		String username = loginForm.getUserName();
		String password = loginForm.getPassword();
		
		loginBO loginbo = new loginBO();
		GioHang GioHang= new GioHang();
		
		System.out.println("hello");
		System.out.println(username+"    "+password);
		
		KhachHang kh = new KhachHang();
		kh = loginbo.checklogin(username, password);
		
		if("Them Vao Gio Hang".equals(loginForm.getSubmit())){
			
			if(loginForm2 == null){
				return mapping.findForward("thatBai");
			}
			String submit= loginForm.getSubmit();
			int soluong= loginForm.getSoluong();
			int masanpham= loginForm.getMaSanPham();
			System.out.println("vao day choi"+submit+"So luong"+soluong+"Ma san pham"+masanpham );
			ArrayList<GioHang> orders;
			session = request.getSession();
			if (session.getAttribute("Orders") != null) {
	            orders = (ArrayList<GioHang>) (session.getAttribute("Orders"));
	        }
			else
			{
				orders = new ArrayList<GioHang>();
			}
			boolean check=true;;
			for(int i = 0 ; i< orders.size();i++)
			{
				if(masanpham == orders.get(i).getMasanpham())
				{
					orders.get(i).setSoluong(orders.get(i).getSoluong()+soluong);
					check = false;
					break;
				}
			}
			if(check)
			{
				GioHang.setMasanpham(masanpham);
				GioHang.setSoluong(soluong);
				orders.add(GioHang);
			}
	        session.setAttribute("Orders", orders);
		}
		else if("Xoa Gio Hang".equals(loginForm.getSubmit())){
			 session = request.getSession();
			
			session.removeAttribute("Orders");
		}
		if(kh != null){
			loginForm.setUserName(kh.getUserName());
			loginForm.setQuyenHan(kh.getQuyenhan());
			return mapping.findForward("thanhCong");
		}else {
			session.removeAttribute("loginForm");
			
		}
		ActionErrors er = new ActionErrors();
		er.add("dangNhapError",new ActionMessage("error.login"));
		saveErrors(request, er);
		return mapping.findForward("thatBai");
	}
}
