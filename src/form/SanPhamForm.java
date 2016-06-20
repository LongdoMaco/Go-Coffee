package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.LoaiSanPham;
import model.bean.Login;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class SanPhamForm extends ActionForm{
	private int maSanPham;
	private String tenSanPham;
	private int giaBan;
	private String donViTinh;
	private String gioiThieu;
	private String submit;
	private String search;
	private int quyenHan = 0;
	private String tenLoai;
	private String maLoaiSP;
	private int soLuong;
	private FormFile image;
	private ArrayList<LoaiSanPham> listMaLoai;
	private String hinhAnh;
	
	
	public String getMaLoaiSP() {
		return maLoaiSP;
	}
	public void setMaLoaiSP(String maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public FormFile getImage() {
		return image;
	}
	public void setImage(FormFile image) {
		this.image = image;
	}
	public ArrayList<LoaiSanPham> getListMaLoai() {
		return listMaLoai;
	}
	public void setListMaLoai(ArrayList<LoaiSanPham> listMaLoai) {
		this.listMaLoai = listMaLoai;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public int getQuyenHan() {
		return quyenHan;
	}
	public void setQuyenHan(int quyenHan) {
		this.quyenHan = quyenHan;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getGioiThieu() {
		return gioiThieu;
	}
	public void setGioiThieu(String gioiThieu) {
		this.gioiThieu = gioiThieu;
	}
	public int getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}
	public String getTenSanPham() {
		return tenSanPham;
	}
	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}
	public int getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
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
