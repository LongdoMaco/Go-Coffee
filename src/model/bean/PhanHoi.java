package model.bean;

import net.sourceforge.jtds.jdbc.DateTime;

public class PhanHoi {
	private String userName;
	private String maDonHang;
	private String thoiGianPH;
	private int thaiDoNhanVien;
	private int chatLuongSanPham;
	private int doHaiLong;
	private String noiDungKhac;
	
	
	public String getThoiGianPH() {
		return thoiGianPH;
	}
	public void setThoiGianPH(String thoiGianPH) {
		this.thoiGianPH = thoiGianPH;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMaDonHang() {
		return maDonHang;
	}
	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}
	public int getThaiDoNhanVien() {
		return thaiDoNhanVien;
	}
	public void setThaiDoNhanVien(int thaiDoNhanVien) {
		this.thaiDoNhanVien = thaiDoNhanVien;
	}
	public int getChatLuongSanPham() {
		return chatLuongSanPham;
	}
	public void setChatLuongSanPham(int chatLuongSanPham) {
		this.chatLuongSanPham = chatLuongSanPham;
	}
	public int getDoHaiLong() {
		return doHaiLong;
	}
	public void setDoHaiLong(int doHaiLong) {
		this.doHaiLong = doHaiLong;
	}
	public String getNoiDungKhac() {
		return noiDungKhac;
	}
	public void setNoiDungKhac(String noiDungKhac) {
		this.noiDungKhac = noiDungKhac;
	}
	
}
