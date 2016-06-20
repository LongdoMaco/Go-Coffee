package model.bo;

import java.util.ArrayList;

import model.bean.KhachHang;
import model.bean.ListKhachHang;
import model.dao.KhachHangDAO;

public class KhachHangBO {
	KhachHangDAO khachHangDAO = new KhachHangDAO();
	public void insertKhachHang(KhachHang khachHang) {
		khachHangDAO.insertKhachHang(khachHang);
	}
	public ListKhachHang getListKhachHang(int lvl, int page) {
		ArrayList<KhachHang> list = khachHangDAO.getListKhachHang(lvl);
		ArrayList<KhachHang> list2 =  new ArrayList<KhachHang>();
		int maxpage = list.size() / 10;
		if(list.size()%10 != 0){maxpage ++;}
		if(page > maxpage) {page = 1;}
		
		int start = (page - 1) *10 + 1;
		int end = start +9;
		if(end >list.size()){
			end = list.size();
		}
		for(int i=start;i<=end;i++){
			list2.add(list.get(i-1));
		}
		ListKhachHang listkh = new ListKhachHang();
		listkh.setListKH(list2);
		listkh.setSotrang(maxpage);
		listkh.setPage(page);
		return listkh;
	}
	public boolean checkUser(String username, String password) {
		// TODO Auto-generated method stub
		return khachHangDAO.checkUser(username,password);
	}
	
	public Boolean updateTT(KhachHang khachHang) {
		return khachHangDAO.updateTT(khachHang);
	}
	public KhachHang getKH(String username) {
		return khachHangDAO.getKhachHang(username);
	}
	public ListKhachHang getListKhachHang(int dt, String search, int page) {
		ArrayList<KhachHang> list = khachHangDAO.getListKhachHang(dt,search);
		ArrayList<KhachHang> list2 =  new ArrayList<KhachHang>();
		int maxpage = list.size() / 10;
		if(list.size()%10 != 0){maxpage ++;}
		if(page > maxpage) {page = 1;}
		
		int start = (page - 1) *10 + 1;
		int end = start + 9;
		if(end >list.size()){
			end = list.size();
		}
		for(int i=start;i<=end;i++){
			list2.add(list.get(i-1));
		}
		ListKhachHang listkh = new ListKhachHang();
		listkh.setListKH(list2);
		listkh.setSotrang(maxpage);
		listkh.setPage(page);
		return listkh;
	}
	public void deleteKH(String user) {
		khachHangDAO.deleteKH(user);
	}
	public void blockKH(String user) {
		khachHangDAO.blockKH(user);
	}
	public void unblockKH(String user) {
		khachHangDAO.unblockKH(user);
		
	}
	public void dangKy(String username, String tenKhachHang, String password,
			String diaChi, String ngaySinh, int gioiTinh, String sDT, String email) {
			khachHangDAO.dangKy(username, tenKhachHang, password, diaChi, ngaySinh, gioiTinh
					, sDT, email);
		
	}
	public void doiMatKhau(String password, String newpassword, String newpassword2) {
		khachHangDAO.doiMatKhau(password,password,newpassword);
		
	}
	
}
