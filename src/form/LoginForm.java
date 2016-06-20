package form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import common.StringProcess;

public class LoginForm extends ActionForm{
	private String userName;
	private String password;
	private int quyenHan;
	private String submit;
	private int soluong;
	private int maSanPham;
	
	
	
	public int getQuyenHan() {
		return quyenHan;
	}
	public void setQuyenHan(int quyenHan) {
		this.quyenHan = quyenHan;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getMaSanPham() {
		return maSanPham;
	}
	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {
		ActionErrors actionError = new ActionErrors();
		if(StringProcess.notVaild(userName)){
			actionError.add("usernameError",new ActionMessage("error.tenDangNhap"));
		}
		if(StringProcess.notVaild(password)){
			actionError.add("passwordError",new ActionMessage("error.matKhau"));
		}
		return actionError;
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
