package model.bean;

import java.util.ArrayList;

public class ListThongKe {
	private ArrayList<ThongKe> list;
	private int soLuongDonHang;
	private int soLuongSanPhamBanDuoc;
	private long tongChiPhi;
	public ArrayList<ThongKe> getList() {
		return list;
	}
	public void setList(ArrayList<ThongKe> list) {
		this.list = list;
	}
	public int getSoLuongDonHang() {
		return soLuongDonHang;
	}
	public void setSoLuongDonHang(int soLuongDonHang) {
		this.soLuongDonHang = soLuongDonHang;
	}
	public int getSoLuongSanPhamBanDuoc() {
		return soLuongSanPhamBanDuoc;
	}
	public void setSoLuongSanPhamBanDuoc(int soLuongSanPhamBanDuoc) {
		this.soLuongSanPhamBanDuoc = soLuongSanPhamBanDuoc;
	}
	public long getTongChiPhi() {
		return tongChiPhi;
	}
	public void setTongChiPhi(long tongChiPhi) {
		this.tongChiPhi = tongChiPhi;
	}
}
