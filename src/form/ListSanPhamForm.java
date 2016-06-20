package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.Login;
import model.bean.SanPham;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ListSanPhamForm extends ActionForm {
	ArrayList<SanPham> list;
	int trangSo;
	int soTrang;
	int[] stt;
	private String search;
	private String page;
	private int maSanPham;
	private String phanloai;
	private int quyenHan;
	private Login login;
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public int getQuyenHan() {
		return quyenHan;
	}

	public void setQuyenHan(int quyenHan) {
		this.quyenHan = quyenHan;

	}

	public String getPhanloai() {
		return phanloai;
	}

	public void setPhanloai(String phanloai) {
		this.phanloai = phanloai;
	}

	public int getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public int[] getStt() {
		return stt;
	}

	public void setStt(int[] stt) {
		this.stt = stt;
	}

	public int getSoTrang() {
		return soTrang;
	}

	public void setSoTrang(int soTrang) {
		this.soTrang = soTrang;
	}

	public int getTrangSo() {
		return trangSo;
	}

	public void setTrangSo(int trangSo) {
		this.trangSo = trangSo;
	}

	public ArrayList<SanPham> getList() {
		return list;
	}

	public void setList(ArrayList<SanPham> list) {
		this.list = list;
	}
	public void reset(ActionMapping mapping,HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.reset(mapping, request);
	}
}
