package action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.ChiTietDonHang;
import model.bean.DanhSachSanPham;
import model.bean.DonHang;
import model.bean.TongTien;
import model.bo.DonHangBO;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import form.ChiTietDonHangForm;

public class SuaDonHangAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ChiTietDonHangForm ChiTietDonHangForm = (ChiTietDonHangForm) form;
		DonHangBO DonHangBO= new DonHangBO();
		//
		
		int madonhang= ChiTietDonHangForm.getMadonhang();
		String diachi= ChiTietDonHangForm.getDiachigiaohang();
		String ghichu=ChiTietDonHangForm.getGhichu();
		int soluong = ChiTietDonHangForm.getSoluong();
		System.out.println("Ma don hang"+madonhang);
		
		String submit=ChiTietDonHangForm.getSubmit();
		System.out.println("SUbmit +"+submit+diachi+ghichu+soluong);
		
			//Lay danh sach chi tiet don hang
			ArrayList<ChiTietDonHang> listchitietdonhang;
			listchitietdonhang= DonHangBO.layChiTietDH(madonhang);
			ChiTietDonHangForm.setListchitietdonhang(listchitietdonhang);
			//Lay danh sach san pham
			ArrayList<DanhSachSanPham> listdanhsachsanpham;
			listdanhsachsanpham= DonHangBO.layDanhSachSP(madonhang);
			ChiTietDonHangForm.setListdanhsachsanpham(listdanhsachsanpham);
			//Tinh tong gia thanh
			ArrayList<TongTien> listtonggiathanh;
			listtonggiathanh= DonHangBO.layTongGiaThanh(madonhang);
			ChiTietDonHangForm.setListtonggiathanh(listtonggiathanh);
			return mapping.findForward("sua");
			
		//}
		
	}
}
