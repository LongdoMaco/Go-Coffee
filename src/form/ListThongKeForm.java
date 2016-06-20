package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.Login;
import model.bean.ThongKe;

public class ListThongKeForm extends ActionForm{
	private ArrayList<ThongKe> list;
	private int soLuongDonHang;
	private int soLuongSanPhamBanDuoc;
	private long tongChiPhi;
	private int loaiThongKe;
	private String thangHienTai;
	private Login login;
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	
	
	public String getThangHienTai() {
		return thangHienTai;
	}
	public void setThangHienTai(String thangHienTai) {
		this.thangHienTai = thangHienTai;
	}
	public int getLoaiThongKe() {
		return loaiThongKe;
	}
	public void setLoaiThongKe(int loaiThongKe) {
		this.loaiThongKe = loaiThongKe;
	}
	public ArrayList<ThongKe> getList() {
		return list;
	}
	public void setList(ArrayList<ThongKe> list) {
		this.list = list;
	}
	public int getSoLuongDonHang() {
		return soLuongDonHang;
	}
	public void setSoLuongDonHang(int soLuongDonHang) {
		this.soLuongDonHang = soLuongDonHang;
	}
	public int getSoLuongSanPhamBanDuoc() {
		return soLuongSanPhamBanDuoc;
	}
	public void setSoLuongSanPhamBanDuoc(int soLuongSanPhamBanDuoc) {
		this.soLuongSanPhamBanDuoc = soLuongSanPhamBanDuoc;
	}
	public long getTongChiPhi() {
		return tongChiPhi;
	}
	public void setTongChiPhi(long tongChiPhi) {
		this.tongChiPhi = tongChiPhi;
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
