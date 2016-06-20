package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.CommentBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.CommentForm;

public class XoaCommentAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		CommentForm commentForm = (CommentForm) form;
		int maBaiViet = commentForm.getMaBaiViet();
		int idComment = commentForm.getIdComment();
		System.out.println("XOA: mabai viet: "+maBaiViet + " | idComment: "+idComment);
		
		CommentBO bo = new CommentBO();
		if (bo.xoaComment(idComment)){
			
		}
		
		return mapping.findForward("xoathanhcong");
	}
}
