package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.DonHang;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class DanhSachDatHangForm extends ActionForm{
	private int madonhang;
	private String userName;
	private String huy;
	private String submit;
	private String ghichu;
	private int soluong;
	private String diachigiaohang;
	private String search;
	
	
	private ArrayList<DonHang> listdonhang1;
	
	
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getGhichu() {
		return ghichu;
	}
	public void setGhichu(String ghichu) {
		this.ghichu = ghichu;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public String getDiachigiaohang() {
		return diachigiaohang;
	}
	public void setDiachigiaohang(String diachigiaohang) {
		this.diachigiaohang = diachigiaohang;
	}
	public String getHuy() {
		return huy;
	}
	public void setHuy(String huy) {
		this.huy = huy;
	}
	public int getMadonhang() {
		return madonhang;
	}
	public void setMadonhang(int madonhang) {
		this.madonhang = madonhang;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public ArrayList<DonHang> getListdonhang() {
		return listdonhang1;
	}
	public void setListdonhang(ArrayList<DonHang> listdonhang) {
		this.listdonhang1 = listdonhang;
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
