package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DonHang;
import model.bean.ListSanPham;
import model.bean.SanPham;
import model.bo.SanPhamBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ListSanPhamForm;
import form.SanPhamForm;

public class ShowTrangChuAction extends Action{
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ListSanPhamForm listSanPhamForm = (ListSanPhamForm) form;
		SanPhamBO spbo = new SanPhamBO();
		ArrayList<SanPham> listSP;
		String phanloai= listSanPhamForm.getPhanloai();
		String maloai;
		System.out.println("dau ma ma loai la chi?"+phanloai);
		if("1".equals(phanloai)){
			System.out.println("dai ca hieu pha loai"+phanloai);
			maloai="L01";
			listSP=spbo.layThongTinSP1(maloai);
			listSanPhamForm.setList(listSP);
			return mapping.findForward("home");
		}
		else if("2".equals(phanloai)){
			System.out.println("dai ca hieu pha loai 2"+phanloai);
			maloai="L02";
			listSP=spbo.layThongTinSP1(maloai);
			listSanPhamForm.setList(listSP);
			return mapping.findForward("home");
		}
		else if("3".equals(phanloai)){
			System.out.println("dai ca hieu pha loai 3"+phanloai);
			maloai="L03";
			listSP=spbo.layThongTinSP1(maloai);
			listSanPhamForm.setList(listSP);
			return mapping.findForward("home");
		}
		else{
			listSP=spbo.layThongTinSP();
			listSanPhamForm.setList(listSP);
		}
		
		
		return mapping.findForward("home");
	}
}
