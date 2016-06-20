package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.PhanHoi;
import model.bo.PhanHoiBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.PhanHoiForm;

public class PhanHoiAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		PhanHoiForm phanHoiForm = (PhanHoiForm) form;
		PhanHoi phanHoi = new PhanHoi();
		phanHoi.setMaDonHang(phanHoiForm.getMaDonHang());
		phanHoi.setThaiDoNhanVien(phanHoiForm.getThaiDoNhanVien());
		phanHoi.setChatLuongSanPham(phanHoiForm.getChatLuongSanPham());
		phanHoi.setDoHaiLong(phanHoiForm.getDoHaiLong());
		phanHoi.setNoiDungKhac(phanHoiForm.getNoiDungKhac());
		PhanHoiBO phanHoiBO = new PhanHoiBO();
		phanHoiBO.themPhanHoi(phanHoi);
		
		return mapping.findForward("dskh");
	}
}
