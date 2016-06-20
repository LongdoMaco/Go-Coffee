package model.bean;

import java.util.ArrayList;

import org.apache.struts.upload.FormFile;

public class SanPham {
	private int maSanPham;
	private String tenSanPham;
	private int giaBan;
	private String tenLoai;
	private String maLoaiSP;
	private String gioiThieu;
	private String donViTinh;
	private FormFile image;
	private String hinhAnh;
	private ArrayList<LoaiSanPham> listMaLoai;
	
	
	public ArrayList<LoaiSanPham> getListMaLoai() {
		return listMaLoai;
	}
	public void setListMaLoai(ArrayList<LoaiSanPham> listMaLoai) {
		this.listMaLoai = listMaLoai;
	}
	public String getMaLoaiSP() {
		return maLoaiSP;
	}
	public void setMaLoaiSP(String maLoaiSP) {
		this.maLoaiSP = maLoaiSP;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public FormFile getImage() {
		return image;
	}
	public void setImage(FormFile image) {
		this.image = image;
	}
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
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
	
	
}
