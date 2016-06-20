package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.ChiTietDonHang;
import model.bean.DanhSachSanPham;
import model.bean.DonHang;
import model.bean.TongTien;
import model.dao.DonHangDAO;

public class DonHangBO {
	
	DonHangDAO DonHangDAO= new DonHangDAO();
	public ArrayList<DonHang> xemDanhSachDonHang(String username,int quyen) {
		// TODO Auto-generated method stub
		return DonHangDAO.xemDanhSachDonHang(username,quyen);
	}
	public ArrayList<ChiTietDonHang> layChiTietDH(int madonhang) {
		// TODO Auto-generated method stub
		return DonHangDAO.layChiTietDH(madonhang);
	}
	public ArrayList<DanhSachSanPham> layDanhSachSP(int madonhang) {
		// TODO Auto-generated method stub
		return DonHangDAO.layDanhSachSP(madonhang);
	}
	public void huyDatHang(int madonhang, String magiaohang) {
		DonHangDAO.huyDatHang(madonhang,magiaohang);
		
	}
	public model.bean.DonHang layQuyen(int madonhang) {
		// TODO Auto-generated method stub
		return DonHangDAO.layQuyen(madonhang);
	}
	public void suaDonHang(int madonhang, String ghichu, String diachi,
			int soluong) {
		DonHangDAO.suaDonHang(madonhang,ghichu,diachi,soluong);
		
	}
	public void xacnhanGiaoHang(int madonhang, String thoigiangiaohang) {
		DonHangDAO.xacnhanGiaoHang(madonhang,thoigiangiaohang);
		
	}
	public model.bean.DonHang layQuyenMoi(String username) {
		return DonHangDAO.layQuyenMoi(username);
	}
	public ArrayList<TongTien> layTongGiaThanh(int madonhang) {
				return DonHangDAO.layTongGiaThanh(madonhang);
	}
	public ArrayList<model.bean.ChiTietDonHang> layDanhSachDonHang(int quyenmoi) {
		// TODO Auto-generated method stub
		return DonHangDAO.layDanhSachDonHang(quyenmoi);
	}
	public ArrayList<model.bean.ChiTietDonHang> layDanhSachDonHangTK(
			int quyenmoi, String timkiem) {
		return DonHangDAO.layDanhSachDonHangTK(quyenmoi,timkiem);
	}
	public ArrayList<model.bean.ChiTietDonHang> layDanhSachTrangThaiTK(
			int quyenmoi, String timkiem) {
		// TODO Auto-generated method stub
		return DonHangDAO.layDanhSachTrangThaiTK(quyenmoi,timkiem);
	}
	public void xoaDonHang(int madonhang) {
		DonHangDAO.xoaDonHang(madonhang);
		
	}
	public ArrayList<ChiTietDonHang> layDanhSachNgayDonHangTK(int quyenmoi,
			String timkiem, String thang, String nam) {
		// TODO Auto-generated method stub
		return DonHangDAO.layDanhSachNgayDonHangTK(quyenmoi,timkiem,thang,nam);
	}
	//Them don hang cua dai ca hieu
	public void themDonHangDCH(String username, String thoigiandat,
			String username2, String diachigiaohang, String ghichu,
			String matrangthai) {
		DonHangDAO.themDonHangDCH(username,thoigiandat,username2,diachigiaohang,ghichu,matrangthai);
		
	}
	public int layMaDonHangDCH(String username, String thoigiandat) throws SQLException {
		return DonHangDAO.layMaDonHangDCH(username,thoigiandat);
	}
	public void themChiTietDonHang(int[] maSanPham, int[] soLuong, int madonhang, int i) throws SQLException {
		DonHangDAO.themChiTietDonHang(maSanPham,soLuong,madonhang,i);
		
	}
	
	

}
