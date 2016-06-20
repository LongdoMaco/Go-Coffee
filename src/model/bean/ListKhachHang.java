package model.bean;

import java.util.ArrayList;

public class ListKhachHang {
	ArrayList<KhachHang> listKH;
	private String search ;
	private int page;
	private int sotrang;
	private Login login;
	public ArrayList<KhachHang> getListKH() {
		return listKH;
	}
	public void setListKH(ArrayList<KhachHang> listKH) {
		this.listKH = listKH;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getSotrang() {
		return sotrang;
	}
	public void setSotrang(int sotrang) {
		this.sotrang = sotrang;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
}
