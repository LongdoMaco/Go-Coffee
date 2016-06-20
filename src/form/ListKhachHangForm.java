package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.KhachHang;
import model.bean.Login;

public class ListKhachHangForm extends ActionForm {
	ArrayList<KhachHang> listKH;
	private String search = "" ;
	private int page = 1;
	private int soTrang = 1;
	private Login login;
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

	public int getSotrang() {
		return soTrang;
	}

	public void setSotrang(int sotrang) {
		this.soTrang = sotrang;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public ArrayList<KhachHang> getListKH() {
		return listKH;
	}

	public void setListKH(ArrayList<KhachHang> listKH) {
		this.listKH = listKH;
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
