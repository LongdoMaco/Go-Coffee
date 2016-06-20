package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.ChiTietDonHang;
import model.bean.DanhSachSanPham;
import model.bean.DonHang;
import model.bean.TongTien;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ChiTietDonHangForm extends ActionForm {
	private int madonhang;
	private int masanpham;
	private int tongtien;
	private String submit;
	private String ghichu;
	private int soluong;
	private String username;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	//private String matrangthai;
	private String diachigiaohang;
	private ArrayList<DonHang> listdonhang;
	private ArrayList<ChiTietDonHang> listchitietdonhang;
	private ArrayList<DanhSachSanPham> listdanhsachsanpham;
	private ArrayList<TongTien> listtonggiathanh;
	
	
	public ArrayList<TongTien> getListtonggiathanh() {
		return listtonggiathanh;
	}
	public void setListtonggiathanh(ArrayList<TongTien> listtonggiathanh) {
		this.listtonggiathanh = listtonggiathanh;
	}
	public ArrayList<DonHang> getListdonhang() {
		return listdonhang;
	}
	public void setListdonhang(ArrayList<DonHang> listdonhang) {
		this.listdonhang = listdonhang;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getDiachigiaohang() {
		return diachigiaohang;
	}
	public void setDiachigiaohang(String diachigiaohang) {
		this.diachigiaohang = diachigiaohang;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public int getTongtien() {
		return tongtien;
	}
	public void setTongtien(int tongtien) {
		this.tongtien = tongtien;
	}
	public int getMadonhang() {
		return madonhang;
	}
	public void setMadonhang(int madonhang) {
		this.madonhang = madonhang;
	}
	public int getMasanpham() {
		return masanpham;
	}
	public void setMasanpham(int masanpham) {
		this.masanpham = masanpham;
	}
	public ArrayList<ChiTietDonHang> getListchitietdonhang() {
		return listchitietdonhang;
	}
	public void setListchitietdonhang(ArrayList<ChiTietDonHang> listchitietdonhang) {
		this.listchitietdonhang = listchitietdonhang;
	}
	public ArrayList<DanhSachSanPham> getListdanhsachsanpham() {
		return listdanhsachsanpham;
	}
	public void setListdanhsachsanpham(
			ArrayList<DanhSachSanPham> listdanhsachsanpham) {
		this.listdanhsachsanpham = listdanhsachsanpham;
	}
	public void reset(ActionMapping mapping,HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.reset(mapping, request);
	}
	
}
