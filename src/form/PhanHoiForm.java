package form;



import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.bean.Login;
import net.sourceforge.jtds.jdbc.DateTime;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class PhanHoiForm extends ActionForm{
	private String userName;
	private String maDonHang;
	private String thoiGianPH;
	private int thaiDoNhanVien;
	private int chatLuongSanPham;
	private int doHaiLong;
	private String noiDungKhac;
	private Login login;
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	public String getThoiGianPH() {
		return thoiGianPH;
	}
	public void setThoiGianPH(String thoiGianPH) {
		this.thoiGianPH = thoiGianPH;
	}
	public int getThaiDoNhanVien() {
		return thaiDoNhanVien;
	}
	public void setThaiDoNhanVien(int thaiDoNhanVien) {
		this.thaiDoNhanVien = thaiDoNhanVien;
	}
	public int getChatLuongSanPham() {
		return chatLuongSanPham;
	}
	public void setChatLuongSanPham(int chatLuongSanPham) {
		this.chatLuongSanPham = chatLuongSanPham;
	}
	public int getDoHaiLong() {
		return doHaiLong;
	}
	public void setDoHaiLong(int doHaiLong) {
		this.doHaiLong = doHaiLong;
	}
	public String getNoiDungKhac() {
		return noiDungKhac;
	}
	public void setNoiDungKhac(String noiDungKhac) {
		this.noiDungKhac = noiDungKhac;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMaDonHang() {
		return maDonHang;
	}
	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
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
