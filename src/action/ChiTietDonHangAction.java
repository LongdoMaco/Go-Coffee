package action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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

public class ChiTietDonHangAction extends Action {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		ChiTietDonHangForm ChiTietDonHangForm = (ChiTietDonHangForm) form;
		int madonhang= ChiTietDonHangForm.getMadonhang();
		String huygiaohang=ChiTietDonHangForm.getSubmit();
		System.out.println("Ma don hang"+madonhang+"Huy giao hang"+ huygiaohang);
		String magiaohang;
		DonHangBO DonHangBO= new DonHangBO();
		//Huy giao hang
		if("Huy Giao Hang".equals(huygiaohang)){
			System.out.println("dai ca hieu ");
			magiaohang="TT04";
			DonHang DonHang = DonHangBO.layQuyen(madonhang);
			int quyen= DonHang.getQuyenhan();
			String username= DonHang.getUsername();
			//Ham huy
			DonHangBO.huyDatHang(madonhang,magiaohang);
			//Lay danh sach chi tiet don hang
			ArrayList<ChiTietDonHang> listchitietdonhang;
			listchitietdonhang= DonHangBO.layChiTietDH(madonhang);
			ChiTietDonHangForm.setListchitietdonhang(listchitietdonhang);
			//Lay danh sach san pham
			ArrayList<DanhSachSanPham> listdanhsachsanpham;
			listdanhsachsanpham= DonHangBO.layDanhSachSP(madonhang);
			ChiTietDonHangForm.setListdanhsachsanpham(listdanhsachsanpham);
			//int tongtien=DonHangBO.tongTien(madonhang);
			//ChiTietDonHangForm.setTongtien(tongtien);
			ArrayList<TongTien> listtonggiathanh;
			listtonggiathanh= DonHangBO.layTongGiaThanh(madonhang);
			ChiTietDonHangForm.setListtonggiathanh(listtonggiathanh);
			return mapping.findForward("chitiet");
			//Tinh tong gia thanh
			
			
		}
		//Xac nhan Giao Hang
		else if("Xac Nhan Da Giao".equals(huygiaohang)){
			DonHang DonHang = DonHangBO.layQuyen(madonhang);
			magiaohang="TT02";
			int quyen= DonHang.getQuyenhan();
			
			String username= DonHang.getUsername();
			//Lay thoi gian giao hang
			
			//Lay gio he thong
	        Date thoiGian = new Date();
	 
	        //Khai bao dinh dang ngay thang
	        SimpleDateFormat dinhDangThoiGian = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	 
	        //parse ngay thang sang dinh dang va chuyen thanh string.
	        String thoigiangiaohang = dinhDangThoiGian.format(thoiGian.getTime());
			//Ham xac nhan giao hang
			DonHangBO.xacnhanGiaoHang(madonhang,thoigiangiaohang);
			//Lay danh sach chi tiet don hang
			ArrayList<ChiTietDonHang> listchitietdonhang;
			listchitietdonhang= DonHangBO.layChiTietDH(madonhang);
			ChiTietDonHangForm.setListchitietdonhang(listchitietdonhang);
			//Lay danh sach san pham
			ArrayList<DanhSachSanPham> listdanhsachsanpham;
			listdanhsachsanpham= DonHangBO.layDanhSachSP(madonhang);
			ChiTietDonHangForm.setListdanhsachsanpham(listdanhsachsanpham);
			//int tongtien=DonHangBO.tongTien(madonhang);
			//ChiTietDonHangForm.setTongtien(tongtien);
			
			
			//Tinh tong gia thanh
			ArrayList<TongTien> listtonggiathanh;
			listtonggiathanh= DonHangBO.layTongGiaThanh(madonhang);
			ChiTietDonHangForm.setListtonggiathanh(listtonggiathanh);
			return mapping.findForward("chitiet");
		}
		else{
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
			return mapping.findForward("chitiet");
		}
		
	}
}
