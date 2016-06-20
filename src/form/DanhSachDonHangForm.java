package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.ChiTietDonHang;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class DanhSachDonHangForm extends ActionForm {
	private int madonhang;
	private String search;
	private int trangthaitk;
	private String ngaythang;
	private ArrayList<ChiTietDonHang> listchitietdonhang;
	
	public String getNgaythang() {
		return ngaythang;
	}
	public void setNgaythang(String ngaythang) {
		this.ngaythang = ngaythang;
	}
	public int getTrangthaitk() {
		return trangthaitk;
	}
	public void setTrangthaitk(int trangthaitk) {
		this.trangthaitk = trangthaitk;
	}
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	public int getMadonhang() {
		return madonhang;
	}
	public void setMadonhang(int madonhang) {
		this.madonhang = madonhang;
	}
	public ArrayList<ChiTietDonHang> getListchitietdonhang() {
		return listchitietdonhang;
	}
	public void setListchitietdonhang(ArrayList<ChiTietDonHang> listchitietdonhang) {
		this.listchitietdonhang = listchitietdonhang;
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
