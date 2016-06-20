package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import net.sourceforge.jtds.jdbc.DateTime;

import model.bean.ListThongKe;
import model.bean.SanPham;
import model.bean.ThongKe;

public class ThongKeDAO {
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

	public ListThongKe getTKChung() {
		connect();
		Statement stm;
		String query1 = "SELECT Count(MaDonHang) FROM DonHang WHERE MaTrangThai = 'TT02'";
		String query2 = "SELECT SUM(SoLuong),Sum(GiaBan*SoLuong)"
				+ " FROM DonHang JOIN ChiTietDonHang ON DonHang.MaDonHang = ChiTietDonHang.MaDonHang "
				+ " WHERE DonHang.MaTrangThai = 'TT02'";
		try {
			stm = cn.createStatement();
			ResultSet rs1 = null;

			rs1 = stm.executeQuery(query1);
			rs1.next();
			ListThongKe listtk = new ListThongKe();
			listtk.setSoLuongDonHang(rs1.getInt(1));
			ResultSet rs2 = null;
			rs2 = stm.executeQuery(query2);
			rs2.next();
			listtk.setSoLuongSanPhamBanDuoc(rs2.getInt(1));
			listtk.setTongChiPhi(rs2.getLong(2));

			return listtk;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<ThongKe> getTKTheoThang(String month) {
		connect();
		Statement stm;
		String query = "SELECT SANPHAM.MaSanPham, TenSanPham,SUM(SoLuong) as Soluong, SUM(ChiTietDonHang.GiaBan * SoLuong) as tonggia "
				+ "FROM DonHang JOIN ChiTietDonHang ON DonHang.MaDonHang = ChiTietDonHang.MaDonHang "
				+ "JOIN SANPHAM ON ChiTietDonHang.MaSanPham = SANPHAM.MaSanPham "
				+ "WHERE MaTrangThai = 'TT02' AND MONTH(ThoiGianGiao) = "
				+ month.substring(5, 7)
				+ " AND YEAR(ThoiGianGiao)= "
				+ month.substring(0, 4)
				+ " GROUP BY TenSanPham,SANPHAM.MaSanPham "
				+ " ORDER BY COUNT(SANPHAM.MaSanPham) DESC";
		try {
			System.out.println(query);
			stm = cn.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(query);
			ThongKe tk;
			ArrayList<ThongKe> lsttk = new ArrayList<ThongKe>();
			while (rs.next()) {
				tk = new ThongKe();
				tk.setMaSanPham(rs.getString(1));
				System.out.println("Ma SanPham " + tk.getMaSanPham());
				tk.setTenSanPham(rs.getString(2));
				tk.setSoLuongBan(rs.getInt(3));
				tk.setTongTienBanDuoc(rs.getLong(4));
				lsttk.add(tk);
			}
			return lsttk;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<ThongKe> getTKKHTheoDonHang(String month) {

		connect();
		Statement stm;
		String query = "select ht , us, count(dh), SUM(sun) "
				+ "FROM ("
				+ "SELECT TOP 10 HoTen as ht,ThongTinUser.Username as us,ChiTietDonHang.MaDonHang as dh,SUM(SoLuong*GiaBan) as sun "
				+ "FROM DonHang join ChiTietDonHang on DonHang.MaDonHang = ChiTietDonHang.MaDonHang "
				+ "join ThongTinUser on ThongTinUser.Username = DonHang.Username "
				+ "WHERE MONTH(ThoiGianGiao) = "
				+ month.substring(5, 7)
				+ " "
				+ "AND YEAR(ThoiGianGiao)= "
				+ month.substring(0, 4)
				+ " "
				+ "Group by HoTen,ThongTinUser.Username,ChiTietDonHang.MaDonHang "
				+ "ORDER BY Count(DonHang.MaDonHang) DESC ) as tam "
				+ "group by ht ,us";
		try {
			System.out.println(query);
			ThongKe tk;
			ArrayList<ThongKe> lsttk = new ArrayList<ThongKe>();
			stm = cn.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(query);
			while (rs.next()) {
				tk = new ThongKe();
				tk.setTenKhachHang(rs.getString(1));
				tk.setUsername(rs.getString(2));
				System.out.println("username:" + tk.getUsername());
				tk.setSoDonHangDaGiao(rs.getInt(3));
				tk.setTongTienDaThanhToan(rs.getLong(4));
				lsttk.add(tk);
			}
			return lsttk;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public ArrayList<ThongKe> getTKNVTheoDonHang(String thangtk) {
		connect();
		Statement stm;

		String query = "SELECT ten,us,count(dh),sum(sotien)"
				+ " FROM (SELECT TOP 10 HoTen as ten,ThongTinUser.Username as us,DonHang.MaDonHang as dh ,SUM(SoLuong*GiaBan) sotien "
				+ "FROM DonHang join ChiTietDonHang on DonHang.MaDonHang = ChiTietDonHang.MaDonHang "
				+ "join ThongTinUser on ThongTinUser.Username = DonHang.UsernameGH "
				+ "WHERE Month(ThoiGianGiao) = "
				+ thangtk.substring(5, 7)
				+ " AND year(ThoiGianGiao) = "
				+ thangtk.substring(0, 4)
				+ " "
				+ " Group by DonHang.MaDonHang,HoTen,ThongTinUser.Username "
				+ " ORDER BY SUM(SoLuong*GiaBan) DESC) as TAM "
				+ " Group by ten,us ";

		try {
			System.out.println(query);
			ThongKe tk;
			ArrayList<ThongKe> lsttk = new ArrayList<ThongKe>();
			stm = cn.createStatement();
			ResultSet rs = null;
			rs = stm.executeQuery(query);
			while (rs.next()) {
				tk = new ThongKe();
				tk.setTenNhanVien(rs.getString(1));
				tk.setUsername(rs.getString(2));
				System.out.println(tk.getUsername());
				tk.setSoDonHangDaGiao(rs.getInt(3));
				tk.setTongTienBanDuoc(rs.getLong(4));
				lsttk.add(tk);
			}
			return lsttk;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;

		}
	}
}
