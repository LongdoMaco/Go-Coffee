package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.bean.KhachHang;

public class loginDAO {

	Connection cn;

	void connect() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String Url = "jdbc:odbc:GoCoffee";
			cn = DriverManager.getConnection(Url, "sa", "123456789");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public KhachHang checklogin(String username, String password) {
		connect();
		String str = "SELECT Username, QuyenHan FROM ThongTinUser WHERE Username = '" + username
				+ "' AND Password = '" + password + "' AND Block <> 1";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(str);
			if (rs.next()) {
				KhachHang kh = new KhachHang();
				kh.setUserName(rs.getString(1));
				kh.setQuyenhan(rs.getInt(2));
				return kh;
			}
			return null;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}

}
