package model.bean;

import java.util.ArrayList;

public class ListPhanHoi {
	ArrayList<PhanHoi> listPhanHoi;
	private Login login;
	private int soTrang;
	private int page;
	public ArrayList<PhanHoi> getListPhanHoi() {
		return listPhanHoi;
	}
	public void setListPhanHoi(ArrayList<PhanHoi> listPhanHoi) {
		this.listPhanHoi = listPhanHoi;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	
}
