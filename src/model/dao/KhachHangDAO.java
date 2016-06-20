package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.KhachHang;
import model.bean.SanPham;

public class KhachHangDAO {
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

	public void insertKhachHang(KhachHang khachHang) {
		connect();
		String SQLQuery = "INSERT INTO KHACHHANG(Username,HoTen,DiaChi,SoDienThoai,NgaySinh,GioiTinh) VALUES('"
				+ khachHang.getUserName()
				+ "','"
				+ khachHang.getTenKhachHang()
				+ "','"
				+ khachHang.getDiaChi()
				+ "','"
				+ khachHang.getsDT()
				+ "','"
				+ khachHang.getNgaySinh()
				+ "','"
				+ khachHang.getGioiTinh() + "')";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(SQLQuery);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}
	public void dangKy(String username, String tenKhachHang, String password,
			String diaChi, String ngaySinh, int gioiTinh, String sDT, String email) {
		connect();
		String SQLQuery = "INSERT INTO ThongTinUser VALUES('"+username+"',3,'"+tenKhachHang+"','"+diaChi+"','"+sDT+"','"+ngaySinh+"','"+gioiTinh+"',avatar_default.jpg,null,'"+email+"','"+password+"',null)";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(SQLQuery);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
		
	}
	public ArrayList<KhachHang> getListKhachHang(int lvl) {
		connect();
		String SQLQuery = "SELECT Username,SDT,DiaChi,GioiTinh,NgaySinh,Email,Block,HinhDaiDien,QuyenHan FROM ThongTinUser WHERE QuyenHan = "
				+ lvl + "";
		Statement stCmd;

		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);
			ArrayList<KhachHang> list = new ArrayList<KhachHang>();
			KhachHang sp;
			while (rs.next()) {
				sp = new KhachHang();
				sp.setUserName(rs.getString(1));
				sp.setsDT(rs.getString(2));
				sp.setDiaChi(rs.getString(3));
				System.out.println(sp.getDiaChi());
				sp.setGioiTinh(rs.getInt(4));
				sp.setNgaySinh(rs.getString(5));

				sp.setEmail(rs.getString(6));
				sp.setBlock(rs.getInt(7));
				sp.setHinhAnh(rs.getString(8));
				sp.setQuyenhan(rs.getInt(9));
				list.add(sp);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}

	public Boolean updateTT(KhachHang khachHang) {
		connect();
		String SQLQuery = "";
		switch (khachHang.getMucDoSua()) {
		case 1:
			SQLQuery = "UPDATE ThongTinUser SET HoTen = N'"
				+ khachHang.getTenKhachHang() + "', DiaChi = '"
				+ khachHang.getDiaChi() + "', GioiTinh = '"
				+ khachHang.getGioiTinh() + "', NgaySinh = '"
				+ khachHang.getNgaySinh() + "', SDT = '" 
				+ khachHang.getsDT()+ "', Email = '" 
				+ khachHang.getEmail() + "', Block = '"
				+ khachHang.getBlock() + "', HinhDaiDien = '"
				+ khachHang.getHinhAnh() + "', QuyenHan = '"
				+ khachHang.getQuyenhan() + "' WHERE Username = '"
				+ khachHang.getUserName() + "'";
			break;
		case 2:
			SQLQuery = "UPDATE ThongTinUser SET HoTen = N'"
				+ khachHang.getTenKhachHang() + "', DiaChi = '"
				+ khachHang.getDiaChi() + "', GioiTinh = '"
				+ khachHang.getGioiTinh() + "', NgaySinh = '"
				+ khachHang.getNgaySinh() + "', SDT = '" 
				+ khachHang.getsDT()+ "', Email = '" 
				+ khachHang.getEmail() + "', HinhDaiDien = '"
				+ khachHang.getHinhAnh() + "' WHERE Username = '"
				+ khachHang.getUserName() + "'";
			break;
		default:
			SQLQuery = "UPDATE ThongTinUser SET HoTen = N'"
				+ khachHang.getTenKhachHang() + "', DiaChi = '"
				+ khachHang.getDiaChi() + "', GioiTinh = '"
				+ khachHang.getGioiTinh() + "', NgaySinh = '"
				+ khachHang.getNgaySinh() + "', SDT = '" 
				+ khachHang.getsDT()+ "', Email = '" 
				+ khachHang.getEmail() + "',' WHERE Username = '"
				+ khachHang.getUserName() + "'";
			break;
		}
		Statement stCmd;
		System.out.println(SQLQuery);
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(SQLQuery);
			return true;
		} catch (SQLException e1) {
			e1.printStackTrace();
			return false;
		}
	}

	public KhachHang getKhachHang(String username) {
		connect();
		String SQLQuery = "SELECT * FROM ThongTinUser WHERE Username = '"
				+ username + "'";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);
			KhachHang kh = new KhachHang();
			while (rs.next()) {
				kh.setUserName(rs.getString(1));
				kh.setQuyenhan(rs.getInt(2));
				kh.setTenKhachHang(rs.getString(3));
				kh.setDiaChi(rs.getString(4));
				kh.setsDT(rs.getString(5));
				kh.setNgaySinh(rs.getString(6));
				kh.setGioiTinh(rs.getInt(7));
				kh.setHinhAnh(rs.getString(8));
				kh.setBlock(rs.getInt(9));
				kh.setEmail(rs.getString(10));
			}
			return kh;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}

	public ArrayList<KhachHang> getListKhachHang(int dt, String search) {
		connect();
		String SQLQuery = "SELECT Username, SDT, DiaChi, GioiTinh, NgaySinh, Email FROM ThongTinUser WHERE QuyenHan = '"
				+ dt
				+ "' AND (Username like '%"
				+ search
				+ "%' or SDT like '"
				+ search
				+ "' or DiaChi like '%"
				+ search
				+ "%'or NgaySinh like '%" + search + "%')";
		Statement stCmd;

		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);
			ArrayList<KhachHang> list = new ArrayList<KhachHang>();
			KhachHang sp;
			while (rs.next()) {
				sp = new KhachHang();
				sp.setUserName(rs.getString(1));
				sp.setsDT(rs.getString(2));
				sp.setDiaChi(rs.getString(3));
				sp.setGioiTinh(rs.getInt(4));
				sp.setNgaySinh(rs.getString(5));
				System.out.println(sp.getGioiTinh());
				sp.setEmail(rs.getString(6));
				list.add(sp);
			}

			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}

	public void deleteKH(String user) {
		connect();
		String SQLQuery = "DELETE FROM ThongTinUser WHERE Username = '" + user
				+ "' AND QuyenHan <> 1";
		String SQLQuery2 = "DELETE FROM BaiViet WHERE Username = '" + user
				+ "'";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(SQLQuery);
			stCmd.executeUpdate(SQLQuery2);
			
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void blockKH(String user) {
		connect();
		String SQLQuery = "UPDATE ThongTinUser SET Block = 1 WHERE Username = '"
				+ user + "' AND QuyenHan <> 1";
		Statement stCmd;
		System.out.println(SQLQuery);
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(SQLQuery);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void unblockKH(String user) {
		connect();
		String SQLQuery = "UPDATE ThongTinUser SET Block = 0 WHERE Username = '"
				+ user + "' AND QuyenHan <> 1";
		Statement stCmd;
		System.out.println(SQLQuery);
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(SQLQuery);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public boolean checkUser(String tenDangNhap, String matKhau) {
		connect();
		String sql=	"SELECT * FROM ThongTinUser WHERE Username = '"+tenDangNhap+"' AND Password = '"+matKhau+"'";
		ResultSet rs = null;
		try {
			Statement stmt = cn.createStatement();
			System.out.println(sql);
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public void doiMatKhau(String Username, String password, String newpassword) {
		connect();
		String SQLquery="UPDATE ThongTinUser SET Password = '"+newpassword+"' WHERE Password='"+password+"' AND Username='"+Username+"'";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(SQLquery);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}		
		
	}
}
