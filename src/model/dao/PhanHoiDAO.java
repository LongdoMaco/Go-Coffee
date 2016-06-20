package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.KhachHang;
import model.bean.PhanHoi;

public class PhanHoiDAO {
	Connection cn;

	void connect() {
		try {
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			String Url = "jdbc:odbc:GoCoffee";
			cn = DriverManager.getConnection(Url, "sa", "12345678");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<PhanHoi> getListPH() {
		connect();
		String sqlQuery = "SELECT * FROM PhanHoi";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(sqlQuery);
			ArrayList<PhanHoi> list = new ArrayList<PhanHoi>();
			PhanHoi ph;
			while (rs.next()) {
				ph = new PhanHoi();
				ph.setMaDonHang(rs.getString(2));
				ph.setThaiDoNhanVien(rs.getInt(3));
				ph.setChatLuongSanPham(rs.getInt(4));
				ph.setDoHaiLong(rs.getInt(5));
				ph.setNoiDungKhac(rs.getString(6));
				ph.setThoiGianPH(rs.getString(7));

				list.add(ph);
			}
			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}

	public void themPhanHoi(PhanHoi phanHoi) {
		connect();
		String sqlQuery = "INSERT INTO PhanHoi(MaDonHang,ThaiDoNV,ChatLuongSP,DoHaiLong,Khac,ThoiGianPH) VALUES('"
				+ phanHoi.getMaDonHang()
				+ "','"
				+ phanHoi.getThaiDoNhanVien()
				+ "','"
				+ phanHoi.getChatLuongSanPham()
				+ "','"
				+ phanHoi.getDoHaiLong()
				+ "','"
				+ phanHoi.getNoiDungKhac()
				+ "','" + phanHoi.getThoiGianPH() + "')";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(sqlQuery);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		}
	}

	public boolean checkDH(String maDonHang,String username) {
		connect();
		String sqlQuery = "SELECT MaDonHang FROM DonHang WHERE MaDonHang = '"+maDonHang+"' AND Username = '"+username+"'";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(sqlQuery);
			if(rs.next()){
				return true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return false;
		}
		return false;
	}

}
