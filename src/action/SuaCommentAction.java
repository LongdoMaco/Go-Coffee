package action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.Comment;
import model.bo.CommentBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import form.CommentForm;

public class SuaCommentAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		CommentForm commentForm = (CommentForm) form;
		String submit = commentForm.getSubmit();
		System.out.println("Submit commnet: "+submit);
		int maBaiViet = commentForm.getMaBaiViet();
		int idComment = commentForm.getIdComment();
		
		if ("".equals(submit)){
			CommentBO bo = new CommentBO();
			Comment comment = null;
			comment = bo.getComment(idComment, maBaiViet);

			commentForm.setNoiDungComment(comment.getNoiDung());
			commentForm.setThoiGian(comment.getThoiGian());
			commentForm.setUserName(comment.getUserName());
			
			return mapping.findForward("gosuacomment");
		} else {
			String noiDungComment = commentForm.getNoiDungComment().trim();
			
			ActionErrors ae = new ActionErrors();
			if ("".equals(noiDungComment)){
				ae.add("noidung_Error", new ActionMessage("error.noidung.trong"));
				saveErrors(request, ae);
				
				CommentBO bo = new CommentBO();
				Comment comment = null;
				comment = bo.getComment(idComment, maBaiViet);

				commentForm.setNoiDungComment(comment.getNoiDung());
				commentForm.setThoiGian(comment.getThoiGian());
				commentForm.setUserName(comment.getUserName());
				commentForm.setMaBaiViet(maBaiViet);
				commentForm.setIdComment(idComment);
				
				return mapping.findForward("suathatbai");
			} else {
				if (noiDungComment.length()>=3000){
					ae.add("noidung_Error", new ActionMessage("error.noidung.dai"));
					saveErrors(request, ae);
					
					CommentBO bo = new CommentBO();
					Comment comment = null;
					comment = bo.getComment(idComment, maBaiViet);

					commentForm.setNoiDungComment(noiDungComment);
					commentForm.setThoiGian(comment.getThoiGian());
					commentForm.setUserName(comment.getUserName());
					commentForm.setMaBaiViet(maBaiViet);
					commentForm.setIdComment(idComment);
					
					return mapping.findForward("suathatbai");
				}
			}
			
			Date date = new Date();
			SimpleDateFormat sim = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss");
			String thoiGian = sim.format(date);
			
			System.out.println("dang sua comment......");
			CommentBO bo = new CommentBO();
			if (bo.editComment(idComment, noiDungComment, thoiGian)){
				commentForm.setSubmit("");
				return mapping.findForward("suathanhcong");
			}
		}	
		commentForm.setSubmit("");
		return mapping.findForward("suathanhcong");
	}
}
