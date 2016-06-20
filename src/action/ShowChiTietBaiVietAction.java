package action;

import java.util.ArrayList;

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

public class ShowChiTietBaiVietAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession httpSession = request.getSession();
		LoginForm loginForm = (LoginForm) httpSession.getAttribute("loginForm");
		
		ChiTietBaiVietForm chiTietBaiVietForm = (ChiTietBaiVietForm) form;
		int maBaiViet = chiTietBaiVietForm.getMaBaiViet();
		
		BaiVietBO baiVietBO = new BaiVietBO();
		BaiViet baiViet = baiVietBO.getBaiViet(maBaiViet);
		
		CommentBO commentBO = new CommentBO();
		ArrayList<Comment> listComment;
		listComment = commentBO.getListComment(maBaiViet);
		
		chiTietBaiVietForm.setMaBaiViet(baiViet.getMaBaiViet());
		chiTietBaiVietForm.setTieuDeBaiViet(baiViet.getTieuDeBaiViet());
		chiTietBaiVietForm.setMaLoaiBaiViet(baiViet.getMaLoaiBaiViet());
		chiTietBaiVietForm.setTenLoaiBaiViet(baiViet.getTenLoaiBaiViet());
		chiTietBaiVietForm.setUserName(baiViet.getUserName());
		chiTietBaiVietForm.setNoiDungBaiViet(baiViet.getNoiDungBaiViet());
		chiTietBaiVietForm.setThoiGian(baiViet.getThoiGian());
		chiTietBaiVietForm.setListComment(listComment);
		
		if (loginForm==null){
			chiTietBaiVietForm.setQuyenHan(0);
			chiTietBaiVietForm.setUserDangNhap("");
		}else {
			chiTietBaiVietForm.setQuyenHan(loginForm.getQuyenHan());
			chiTietBaiVietForm.setUserDangNhap(loginForm.getUserName());
		}
		
		
		chiTietBaiVietForm.setHinhAnh(baiViet.getHinhAnh());
		
		return mapping.findForward("show");
	}
}
