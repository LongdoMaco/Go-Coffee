package model.bo;

import model.bean.KhachHang;
import model.dao.loginDAO;

public class loginBO {

	public KhachHang checklogin(String username, String password) {
		loginDAO login = new loginDAO();
		return login.checklogin(username,password);
	}

}
