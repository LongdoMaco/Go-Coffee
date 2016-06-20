package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.Login;
import model.bean.PhanHoi;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ListPhanHoiForm extends ActionForm{
	ArrayList<PhanHoi> listPhanHoi;
	private Login login;
	private int soTrang;
	private int page;
	
	
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
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	public ArrayList<PhanHoi> getListPhanHoi() {
		return listPhanHoi;
	}

	public void setListPhanHoi(ArrayList<PhanHoi> listPhanHoi) {
		this.listPhanHoi = listPhanHoi;
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
