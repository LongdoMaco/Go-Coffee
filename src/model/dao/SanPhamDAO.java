package model.dao;

import java.sql.*;
import java.util.ArrayList;

import model.bean.GioHangTam;
import model.bean.LoaiSanPham;
import model.bean.SanPham;

public class SanPhamDAO {
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

	public ArrayList<SanPham> getListSanPham() {
		connect();
		String SQLQuery = "SELECT * FROM SANPHAM";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);
			ArrayList<SanPham> list = new ArrayList<SanPham>();
			SanPham sp;
			while (rs.next()) {
				sp = new SanPham();
				sp.setMaSanPham(rs.getInt(1));
				sp.setTenSanPham(rs.getString(2));
				// sp.setDonViTinh(rs.getString(3));
				sp.setGiaBan(rs.getInt(3));
				sp.setHinhAnh(rs.getString(4));
				list.add(sp);
			}
			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}

	public SanPham getSanPham(int maSanPham) {
		connect();
		String SQLQuery = "SELECT MaSanPham,TenSanPham, GiaBan,TenLoai,HinhAnh FROM SANPHAM inner join LoaiSanPham on SANPHAM.MaLoai=LoaiSanPham.MaLoai WHERE SANPHAM.MaSanPham = '"
				+ maSanPham + "'";
		String SQLQuery2 = "SELECT * FROM LoaiSanPham";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);
			SanPham sp = new SanPham();
			rs.next();
			sp.setMaSanPham(rs.getInt(1));
			sp.setTenSanPham(rs.getString(2));
			sp.setGiaBan(rs.getInt(3));
			sp.setTenLoai(rs.getString(4));
			sp.setHinhAnh(rs.getString(5));

			ResultSet rs2 = null;
			rs2 = stCmd.executeQuery(SQLQuery2);
			LoaiSanPham loaisp;
			ArrayList<LoaiSanPham> listloaisp = new ArrayList<LoaiSanPham>();
			while (rs2.next()) {
				loaisp = new LoaiSanPham();
				loaisp.setMaLoaiSP(rs2.getString(1));
				loaisp.setTenLoai(rs2.getString(2));
				listloaisp.add(loaisp);
			}
			sp.setListMaLoai(listloaisp);
			return sp;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}

	public void updateSP(SanPham sanPham) {
		connect();
		
		String SQLQuery = "UPDATE SANPHAM SET TenSanPham = N'"
				+ sanPham.getTenSanPham() + "', GiaBan = '"
				+ sanPham.getGiaBan() + "', HinhAnh = N'"
				+ sanPham.getHinhAnh() + "', MaLoai = '"
				+ sanPham.getMaLoaiSP() + "' WHERE MaSanPham = '"
				+ sanPham.getMaSanPham() + "'";
		System.out.println(SQLQuery);
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(SQLQuery);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void deleteSanPham(String maSanPham) {
		connect();
		String SQLQuery = "DELETE FROM SANPHAM WHERE MaSanPham = '" + maSanPham
				+ "'";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(SQLQuery);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public ArrayList<SanPham> layGioHang(String chuoi) {
		connect();

		String SQLQuery = "select MaSanPham,TenSanPham,GiaBan from SANPHAM where MaSanPham ='1'";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);
			ArrayList<SanPham> list = new ArrayList<SanPham>();
			SanPham sp;
			System.out.println("dau ma vo roi ma");
			while (rs.next()) {
				sp = new SanPham();
				sp.setMaSanPham(rs.getInt("MaSanPham"));
				sp.setTenSanPham(rs.getString("TenSanPham"));
				sp.setGiaBan(rs.getInt("GiaBan"));
				list.add(sp);
			}
			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}

	public ArrayList<GioHangTam> layThongtin() {
		connect();
		String SQLQuery;
		SQLQuery = "select MaSanPham,TenSanPham,GiaBan from SANPHAM ";
		Statement stCmd;
		ArrayList<GioHangTam> list = new ArrayList<GioHangTam>();
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);

			GioHangTam sp;
			while (rs.next()) {
				sp = new GioHangTam();
				sp.setMasanpham(rs.getInt("MaSanPham"));
				sp.setTensanpham(rs.getString("TenSanPham"));
				sp.setGiaban(rs.getInt("GiaBan"));

				list.add(sp);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

	public ArrayList<GioHangTam> getThongTinGioHang(int[] maSanPham,
			int[] soLuong, int i) throws SQLException {
		connect();
		ArrayList<GioHangTam> list = new ArrayList<GioHangTam>();

		for (int j = 0; j < i; j++) {
			System.out.println("day la sdasa" + maSanPham[j]);
			String SQLQuery;
			SQLQuery = "select MaSanPham,TenSanPham,GiaBan from SANPHAM where MaSanPham ='"
					+ maSanPham[j] + "'";
			Statement stCmd;

			try {
				stCmd = cn.createStatement();
				ResultSet rs = null;
				rs = stCmd.executeQuery(SQLQuery);

				GioHangTam sp = null;
				while (rs.next()) {
					sp = new GioHangTam();
					sp.setMasanpham(rs.getInt("MaSanPham"));
					sp.setTensanpham(rs.getString("TenSanPham"));
					sp.setGiaban(rs.getInt("GiaBan"));
					sp.setSoluong(soLuong[j]);
					list.add(sp);
				}

				// list.add(sp);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
		return list;
	}

	public GioHangTam layTongTienGioHang(int[] maSanPham, int[] soLuong, int i)
			throws SQLException {
		int tong = 0;
		for (int j = 0; j < i; j++) {
			System.out.println("da vao tinh tong tien");
			String SQLQuery = "select GiaBan from SANPHAM where MaSanPham ='"
					+ maSanPham[j] + "'";
			Statement stCmd;
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);
			rs.next();
			// System.out.println("Gia ban"+ rs.getInt("GiaBan"));
			tong = tong + rs.getInt("GiaBan") * soLuong[j];
			System.out.println("Gia ban" + soLuong[j]);

		}

		System.out.println("tong thanh tien cua gio hang" + tong + "ssss");
		GioHangTam ght = new GioHangTam();
		ght.setTongthanhtien(tong);
		return ght;
	}

	public ArrayList<GioHangTam> getThongTinGioHang2(int masanpham) {
		connect();

		ArrayList<GioHangTam> list = new ArrayList<GioHangTam>();

		System.out.println("day la mua lien");
		String SQLQuery;
		SQLQuery = "select MaSanPham,TenSanPham,GiaBan from SANPHAM where MaSanPham ='"
				+ masanpham + "'";
		Statement stCmd;

		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);

			GioHangTam sp = null;
			while (rs.next()) {
				sp = new GioHangTam();
				sp.setMasanpham(rs.getInt("MaSanPham"));
				sp.setTensanpham(rs.getString("TenSanPham"));
				sp.setGiaban(rs.getInt("GiaBan"));
				sp.setSoluong(1);
				list.add(sp);
			}

			// list.add(sp);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		return list;
	}

	public ArrayList<SanPham> layThongTinSP1(String maloai) {
		connect();
		// connect();
		String SQLQuery = "SELECT * FROM SANPHAM where MaLoai='" + maloai + "'";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);
			ArrayList<SanPham> list = new ArrayList<SanPham>();
			SanPham sp;
			while (rs.next()) {
				sp = new SanPham();
				sp.setMaSanPham(rs.getInt(1));
				sp.setTenSanPham(rs.getString(2));
				// sp.setDonViTinh(rs.getString(3));
				sp.setGiaBan(rs.getInt(3));
				sp.setHinhAnh(rs.getString(4));
				list.add(sp);
			}
			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}

	public ArrayList<LoaiSanPham> getListMaLoai() {
		connect();
		String SQLQuery = "SELECT MaLoai,TenLoai FROM LoaiSanPham";
		Statement stCmd = null;
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);
			ArrayList<LoaiSanPham> list = new ArrayList<LoaiSanPham>();
			LoaiSanPham lSP;
			while (rs.next()) {
				lSP = new LoaiSanPham();
				lSP.setMaLoaiSP(rs.getString(1));
				lSP.setTenLoai(rs.getString(2));
				list.add(lSP);
			}
			return list;
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			return null;
		}
	}

	public void insertSanPham(SanPham sp) {
		connect();
		String SQLQuery = "INSERT INTO SANPHAM(TenSanPham,MaLoai,GiaBan,HinhAnh) VALUES(N'"
				+ sp.getTenSanPham()
				+ "','"
				+ sp.getMaLoaiSP()
				+ "','"
				+ sp.getGiaBan() + "','" + sp.getHinhAnh() + "')";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(SQLQuery);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public void deleteSanPham(int masp) {
		connect();
		String SQLQuery = "DELETE FROM SANPHAM WHERE MaSanPham = '" + masp +"'";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(SQLQuery);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
