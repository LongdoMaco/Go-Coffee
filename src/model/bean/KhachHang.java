package model.bean;

import java.util.ArrayList;

import org.apache.struts.action.ActionForm;

public class KhachHang extends ActionForm{
	private String userName;
	private String password;
	private String tenKhachHang;
	private String diaChi;
	private String sDT;
	private String ngaySinh;
	private int gioiTinh;
	private int quyenhan;
	private String email;
	private String hinhAnh;
	private int block;
	private int mucDoSua;
	private ArrayList<KhachHang> list;
	
	public ArrayList<KhachHang> getList() {
		return list;
	}
	public void setList(ArrayList<KhachHang> list) {
		this.list = list;
	}
	public int getMucDoSua() {
		return mucDoSua;
	}
	public void setMucDoSua(int mucDoSua) {
		this.mucDoSua = mucDoSua;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getQuyenhan() {
		return quyenhan;
	}
	public void setQuyenhan(int quyenhan) {
		this.quyenhan = quyenhan;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
	}
	
}
