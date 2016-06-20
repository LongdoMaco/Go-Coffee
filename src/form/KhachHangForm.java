package form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import model.bean.Login;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

public class KhachHangForm extends ActionForm{
	private String userName;
	private String password;
	private String tenKhachHang;
	private String diaChi;
	private String sDT;
	private String submit = "123";
	private String ngaySinh;
	private int gioiTinh;
	private String email;
	private String hinhAnh;
	private int block;
	private int quyenhan;
	private FormFile image;
	private int mucDoSua;
	private String matKhauMoi;
	private String xacNhanMatKhau;
	private Login login;
	
	
	public String getMatKhauMoi() {
		return matKhauMoi;
	}
	public void setMatKhauMoi(String matKhauMoi) {
		this.matKhauMoi = matKhauMoi;
	}
	public String getXacNhanMatKhau() {
		return xacNhanMatKhau;
	}
	public void setXacNhanMatKhau(String xacNhanMatKhau) {
		this.xacNhanMatKhau = xacNhanMatKhau;
	}
	public Login getLogin() {
		return login;
	}
	public void setLogin(Login login) {
		this.login = login;
	}
	
	// muc 1: admin sua cua ng khac
	// muc 2: khach hang sua cua khach hang do
	// muc 3: 
	
	public int getMucDoSua() {
		return mucDoSua;
	}
	
	public void setMucDoSua(int mucDoSua) {
		this.mucDoSua = mucDoSua;
	}
	public FormFile getImage() {
		return image;
	}
	public void setImage(FormFile image) {
		this.image = image;
	}
	public int getQuyenhan() {
		return quyenhan;
	}
	public void setQuyenhan(int quyenhan) {
		this.quyenhan = quyenhan;
	}
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(int gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getTenKhachHang() {
		return tenKhachHang;
	}
	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getsDT() {
		return sDT;
	}
	public void setsDT(String sDT) {
		this.sDT = sDT;
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
