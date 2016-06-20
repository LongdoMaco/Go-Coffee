package model.bean;


public class Login {
	private String userName;
	private String password;
	private int quyenHan;
	
	public int getQuyenhan() {
		return quyenHan;
	}
	public void setQuyenhan(int quyenhan) {
		this.quyenHan = quyenhan;
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
}
