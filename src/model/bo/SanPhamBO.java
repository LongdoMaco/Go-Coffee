package model.bo;

import java.sql.SQLException;
import java.util.ArrayList;

import model.bean.GioHangTam;
import model.bean.ListSanPham;
import model.bean.LoaiSanPham;
import model.bean.SanPham;
import model.dao.SanPhamDAO;

public class SanPhamBO {
	SanPhamDAO spdao = new SanPhamDAO();

	// moi lam day ne
	public ArrayList<model.bean.SanPham> layGioHang(String chuoi) {
		// TODO Auto-generated method stub
		return spdao.layGioHang(chuoi);
	}
	public void updateSP(SanPham sanPham) {
		
		spdao.updateSP(sanPham);
	}

	public ArrayList<GioHangTam> layThongtin() {
		// TODO Auto-generated method stub
		return spdao.layThongtin();
	}

	public ArrayList<GioHangTam> getThongTinGioHang(int[] maSanPham,
			int[] soLuong, int i) throws SQLException {
		return spdao.getThongTinGioHang(maSanPham, soLuong, i);
	}

	public GioHangTam layTongTienGioHang(int[] maSanPham, int[] soLuong, int i)
			throws SQLException {
		// TODO Auto-generated method stub
		return spdao.layTongTienGioHang(maSanPham, soLuong, i);
	}

	public SanPham getSP(int maSanPham) {
		// TODO Auto-generated method stub
		return spdao.getSanPham(maSanPham);
	}

	public ArrayList<SanPham> layThongTinSP() {
		// TODO Auto-generated method stub
		return spdao.getListSanPham();
	}

	public ArrayList<GioHangTam> getThongTinGioHang2(int masanpham) {
		// TODO Auto-generated method stub
		return spdao.getThongTinGioHang2(masanpham);
	}
	public void insertSanPham(SanPham sp) {
		spdao.insertSanPham(sp);
		
	}
	public ArrayList<SanPham> layThongTinSP1(String maloai) {
		// TODO Auto-generated method stub
		return spdao.layThongTinSP1(maloai);
	}

	public ArrayList<LoaiSanPham> getListMaLoai() {

		return spdao.getListMaLoai();
	}
	public void deleteSanPham(int masp) {
		spdao.deleteSanPham(masp);
	}
}
