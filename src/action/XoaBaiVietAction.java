package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.BaiVietBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.BaiVietForm;

public class XoaBaiVietAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		BaiVietForm baiVietForm = (BaiVietForm) form;
		int maBaiViet = baiVietForm.getMaBaiViet();
		
		BaiVietBO bo = new BaiVietBO();
		if (bo.xoaBaiViet(maBaiViet)){
			return mapping.findForward("xoathanhcong");
		}
		
		return mapping.findForward("xoathanhcong");
	}
}
