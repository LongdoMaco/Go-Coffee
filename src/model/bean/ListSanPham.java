package model.bean;

import java.util.ArrayList;

public class ListSanPham {
	private ArrayList<SanPham> list;
	private int[] stt;
	private int trangSo;
	private int soTrang;
	
	public ArrayList<SanPham> getList() {
		return list;
	}
	public void setList(ArrayList<SanPham> list) {
		this.list = list;
	}
	public int[] getStt() {
		return stt;
	}
	public void setStt(int[] stt) {
		this.stt = stt;
	}
	public int getTrangSo() {
		return trangSo;
	}
	public void setTrangSo(int trangSo) {
		this.trangSo = trangSo;
	}
	public int getSoTrang() {
		return soTrang;
	}
	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}
	
}
