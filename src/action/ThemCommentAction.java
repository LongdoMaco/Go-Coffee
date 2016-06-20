package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BaiViet;
import model.bean.Comment;
import model.bo.BaiVietBO;
import model.bo.CommentBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ChiTietBaiVietForm;
import form.LoginForm;

public class ThemCommentAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ChiTietBaiVietForm chiTietBaiVietForm = (ChiTietBaiVietForm) form;
		int maBaiViet = chiTietBaiVietForm.getMaBaiViet();
		String noiDungComment = chiTietBaiVietForm.getNoiDungComment();
		
		HttpSession httpSession = request.getSession();
		LoginForm loginForm = (LoginForm) httpSession.getAttribute("loginForm");
		String userName = null;
		
		if (loginForm==null){
			userName = "";
		}else {
			userName = loginForm.getUserName();
		}
		
		
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
		String thoiGian = sim.format(date);
		
		System.out.println("Noi dung commnet cua bai viet: "+maBaiViet+" la: "+noiDungComment);
		
		CommentBO bo = new CommentBO();
		if(bo.addComment(maBaiViet, thoiGian ,noiDungComment, userName)){

			chiTietBaiVietForm.setMaBaiViet(maBaiViet);
			
			return mapping.findForward("thanhcong");
		}
		
		return mapping.findForward("thanhcong");
	}
	
}
