package model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.bean.ChiTietDonHang;
import model.bean.DanhSachSanPham;
import model.bean.DonHang;
import model.bean.SanPham;
import model.bean.TongTien;

public class DonHangDAO {
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

	public ArrayList<DonHang> xemDanhSachDonHang(String username, int quyen) {
		connect();
		String SQLQuery;
		if (quyen == 1) {
			SQLQuery = "select ChiTietDonHang.MaDonHang,ThoiGianDat ,Diachi,DonHang.ThoiGianGiao,SUM(ChiTietDonHang.SoLuong*ChiTietDonHang.GiaBan)as ThanhTien,TenTrangThai,DonHang.MaTrangThai,Username from DonHang INNER JOIN TrangThaiGiaoHang ON DonHang.MaTrangThai=TrangThaiGiaoHang.MaTrangThai INNER JOIN ChiTietDonHang ON DonHang.MaDonHang=ChiTietDonHang.MaDonHang group by ChiTietDonHang.MaDonHang,ThoiGianDat,Diachi,TenTrangThai,DonHang.MaTrangThai,Username,DonHang.ThoiGianGiao ";
		} else {
			SQLQuery = "select ChiTietDonHang.MaDonHang,ThoiGianDat ,Diachi,DonHang.ThoiGianGiao,SUM(ChiTietDonHang.SoLuong*ChiTietDonHang.GiaBan)as ThanhTien,TenTrangThai,DonHang.MaTrangThai,Username from DonHang INNER JOIN TrangThaiGiaoHang ON DonHang.MaTrangThai=TrangThaiGiaoHang.MaTrangThai INNER JOIN ChiTietDonHang ON DonHang.MaDonHang=ChiTietDonHang.MaDonHang Where Username='"
					+ username
					+ "' group by ChiTietDonHang.MaDonHang,ThoiGianDat,Diachi,TenTrangThai,DonHang.MaTrangThai,Username,DonHang.ThoiGianGiao";
		}

		Statement stCmd;
		ArrayList<DonHang> list = new ArrayList<DonHang>();
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);

			DonHang sp;
			while (rs.next()) {
				sp = new DonHang();
				sp.setMadonhang(rs.getInt("MaDonHang"));
				sp.setThoigiandat(rs.getString("ThoiGianDat"));
				sp.setDiachi(rs.getString("Diachi"));
				sp.setThoigiangiao(rs.getString("ThoiGianGiao"));
				sp.setThanhtien(rs.getInt("ThanhTien"));
				sp.setTentrangthai(rs.getString("TenTrangThai"));
				sp.setMatrangthai(rs.getString("MaTrangThai"));
				sp.setUsername(rs.getString("Username"));
				list.add(sp);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

	public ArrayList<ChiTietDonHang> layChiTietDH(int madonhang) {
		connect();
		// System.out.println(username+"asdhsajdhjakshd");
		String SQLQuery = "select MaDonHang,HoTen, SDT,DonHang.Diachi,ThoiGianDat,TenTrangThai,GhiChu,DonHang.Username from DonHang inner join ThongTinUser on DonHang.Username=ThongTinUser.Username inner join TrangThaiGiaoHang on DonHang.MaTrangThai=TrangThaiGiaoHang.MaTrangThai where MaDonHang='"
				+ madonhang + "'";
		Statement stCmd;
		ArrayList<ChiTietDonHang> list = new ArrayList<ChiTietDonHang>();
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);

			ChiTietDonHang sp;
			while (rs.next()) {
				sp = new ChiTietDonHang();
				sp.setMadonhang(rs.getInt("MaDonHang"));
				sp.setTenkhachhang(rs.getString("HoTen"));
				sp.setSodienthoai(rs.getString("SDT"));
				sp.setDiachigiaohang(rs.getString("Diachi"));
				sp.setThoigiandat(rs.getString("ThoiGianDat"));
				sp.setTrangthai(rs.getString("TenTrangThai"));
				sp.setGhichu(rs.getString("GhiChu"));
				// sp.setUsername(rs.getString("Username"));
				list.add(sp);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

	public ArrayList<DanhSachSanPham> layDanhSachSP(int madonhang) {
		connect();

		String SQLQuery = "select SANPHAM.MaSanPham,TenSanPham,ChiTietDonHang.GiaBan,SoLuong, SUM(SANPHAM.GiaBan*SoLuong) as TongTien, DonHang.Username from ChiTietDonHang inner join SANPHAM on ChiTietDonHang.MaSanPham=SANPHAM.MaSanPham inner join DonHang on ChiTietDonHang.MaDonHang=DonHang.MaDonHang where DonHang.MaDonHang ='"
				+ madonhang
				+ "' group by ChiTietDonHang.GiaBan,SANPHAM.MaSanPham,TenSanPham,SoLuong,DonHang.Username";
		// select SANPHAM.MaSanPham,TenSanPham,SANPHAM.GiaBan,SoLuong,
		// SUM(SANPHAM.GiaBan*SoLuong) as TongTien, DonHang.Username from
		// ChiTietDonHang inner join SANPHAM on
		// ChiTietDonHang.MaSanPham=SANPHAM.MaSanPham inner join DonHang on
		// ChiTietDonHang.MaDonHang=DonHang.MaDonHang where DonHang.MaDonHang
		// ='"+ madonhang + "' group by
		// SANPHAM.GiaBan,SANPHAM.MaSanPham,TenSanPham,SoLuong,DonHang.Username
		Statement stCmd;
		ArrayList<DanhSachSanPham> list = new ArrayList<DanhSachSanPham>();
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);

			DanhSachSanPham sp;
			while (rs.next()) {
				sp = new DanhSachSanPham();
				sp.setMasanpham(rs.getInt("MaSanPham"));
				sp.setTensanpham(rs.getString("TenSanPham"));
				sp.setGiaban(rs.getInt("GiaBan"));
				sp.setSoluong(rs.getInt("SoLuong"));
				// sp.setTongtien(rs.getInt("TongTien"));
				sp.setUsername(rs.getString("Username"));
				list.add(sp);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

	public void huyDatHang(int madonhang, String magiaohang) {
		connect();
		// System.out.println(sanPham.getMaSanPham()+";"+sanPham.getTenSanPham()+";"+sanPham.getGiaBan()+";"+sanPham.getGioiThieu());
		String SQLQuery = "UPDATE [dbo].[DonHang] SET [MaTrangThai] = '"
				+ magiaohang + "' where MaDonHang='" + madonhang + "'";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(SQLQuery);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public DonHang layQuyen(int madonhang) {
		connect();

		String SQLQuery = "select QuyenHan, DonHang.Username from DonHang inner join ThongTinUser on DonHang.Username=ThongTinUser.Username where MaDonHang='"
				+ madonhang + "'";
		// select SANPHAM.MaSanPham,TenSanPham,SANPHAM.GiaBan,SoLuong,
		// SUM(SANPHAM.GiaBan*SoLuong) as TongTien from ChiTietDonHang inner
		// join SANPHAM on ChiTietDonHang.MaSanPham=SANPHAM.MaSanPham Where
		// SANPHAM.MaSanPham=(select MaSanPham from DonHang inner join
		// ChiTietDonHang on DonHang.MaDonHang=ChiTietDonHang.MaDonHang where
		// DonHang.MaDonHang ='"+ madonhang + "') group by
		// SANPHAM.GiaBan,SANPHAM.MaSanPham,TenSanPham,SoLuong
		Statement stCmd;
		DonHang sp = new DonHang();
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);

			while (rs.next()) {
				sp.setQuyenhan(rs.getInt("QuyenHan"));
				sp.setUsername(rs.getString("Username"));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return sp;
	}

	public void suaDonHang(int madonhang, String ghichu, String diachi,
			int soluong) {
		connect();
		System.out.println("sua don hang");
		String SQLQuery = "UPDATE [dbo].[DonHang] SET [Diachi] = '" + diachi
				+ "',[GhiChu]='" + ghichu + "' where MaDonHang='" + madonhang
				+ "'";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(SQLQuery);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		// Sua chi tiet don hang
		String SQLQuery1 = "UPDATE [dbo].[ChiTietDonHang] SET [SoLuong] = '"
				+ soluong + "' where MaDonHang='" + madonhang + "'";
		Statement stCmd1;
		try {
			stCmd1 = cn.createStatement();
			stCmd1.executeUpdate(SQLQuery1);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}

	}

	public void xacnhanGiaoHang(int madonhang, String thoigiangiaohang) {
		connect();
		// System.out.println(sanPham.getMaSanPham()+";"+sanPham.getTenSanPham()+";"+sanPham.getGiaBan()+";"+sanPham.getGioiThieu());
		String SQLQuery = "UPDATE [dbo].[DonHang] SET [MaTrangThai] = 'TT02', ThoiGianGiao='"
				+ thoigiangiaohang + "' where MaDonHang='" + madonhang + "'";
		Statement stCmd;
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(SQLQuery);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public DonHang layQuyenMoi(String username) {
		connect();

		String SQLQuery = "select QuyenHan, MaDonHang from ThongTinUser inner join DonHang on ThongTinUser.Username= DonHang.Username where ThongTinUser.Username='"
				+ username + "'";
		// select SANPHAM.MaSanPham,TenSanPham,SANPHAM.GiaBan,SoLuong,
		// SUM(SANPHAM.GiaBan*SoLuong) as TongTien from ChiTietDonHang inner
		// join SANPHAM on ChiTietDonHa""ng.MaSanPham=SANPHAM.MaSanPham Where
		// SANPHAM.MaSanPham=(select MaSanPham from DonHang inner join
		// ChiTietDonHang on DonHang.MaDonHang=ChiTietDonHang.MaDonHang where
		// DonHang.MaDonHang ='"+ madonhang + "') group by
		// SANPHAM.GiaBan,SANPHAM.MaSanPham,TenSanPham,SoLuong
		Statement stCmd;
		DonHang sp = new DonHang();
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);

			while (rs.next()) {
				sp.setQuyenhan(rs.getInt("QuyenHan"));
				// sp.setUsername(rs.getString("Username"));
				sp.setMadonhang(rs.getInt("MaDonHang"));

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return sp;
	}

	public ArrayList<TongTien> layTongGiaThanh(int madonhang) {
		connect();

		String SQLQuery = "select ChiTietDonHang.MaDonHang,MaTrangThai, SUM(GiaBan*SoLuong) as TongGiaThanh from ChiTietDonHang inner join DonHang on ChiTietDonHang.MaDonHang=DonHang.MaDonHang where DonHang.MaDonHang='"
				+ madonhang
				+ "' group by ChiTietDonHang.MaDonHang,MaTrangThai ";
		Statement stCmd;
		ArrayList<TongTien> list = new ArrayList<TongTien>();
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);

			TongTien sp;
			while (rs.next()) {
				sp = new TongTien();
				sp.setMasanpham(rs.getInt("MaDonHang"));
				sp.setMatrangthai(rs.getString("MaTrangThai"));
				sp.setTonggiathanh(rs.getInt("TongGiaThanh"));
				list.add(sp);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

	public ArrayList<ChiTietDonHang> layDanhSachDonHang(int quyenmoi) {
		connect();
		String SQLQuery;
		System.out.println("quyen cua tau" + quyenmoi);
		if (quyenmoi == 1 || quyenmoi == 2) {
			System.out.println("da vao day roi ^^");
			SQLQuery = "select DonHang.MaDonHang,HoTen,DonHang.Diachi,SDT,ThoiGianDat,TenTrangThai from DonHang inner join TrangThaiGiaoHang on DonHang.MaTrangThai= TrangThaiGiaoHang.MaTrangThai inner join ThongTinUser on DonHang.Username=ThongTinUser.Username ";
		} else {
			return null;
		}

		Statement stCmd;
		ArrayList<ChiTietDonHang> list = new ArrayList<ChiTietDonHang>();
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);

			ChiTietDonHang sp;
			while (rs.next()) {
				sp = new ChiTietDonHang();
				sp.setMadonhang(rs.getInt("MaDonHang"));
				sp.setTenkhachhang(rs.getString("HoTen"));
				sp.setDiachigiaohang(rs.getString("DiaChi"));
				sp.setSodienthoai(rs.getString("SDT"));
				sp.setThoigiandat(rs.getString("ThoiGianDat"));
				sp.setTrangthai(rs.getString("TenTrangThai"));
				list.add(sp);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

	public ArrayList<ChiTietDonHang> layDanhSachDonHangTK(int quyenmoi,
			String timkiem) {
		connect();
		String SQLQuery;
		System.out.println("quyen cua tau" + quyenmoi);
		if (quyenmoi == 1 || quyenmoi == 2) {
			System.out.println("da vao day roi ^^" + timkiem);
			SQLQuery = "select DonHang.MaDonHang,HoTen,DonHang.Diachi,SDT,ThoiGianDat,TenTrangThai from DonHang inner join TrangThaiGiaoHang on DonHang.MaTrangThai= TrangThaiGiaoHang.MaTrangThai inner join ThongTinUser on DonHang.Username=ThongTinUser.Username where HoTen like '%"
					+ timkiem + "%' ";
		} else {
			return null;
		}

		Statement stCmd;
		ArrayList<ChiTietDonHang> list = new ArrayList<ChiTietDonHang>();
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);

			ChiTietDonHang sp;
			while (rs.next()) {
				sp = new ChiTietDonHang();
				sp.setMadonhang(rs.getInt("MaDonHang"));
				sp.setTenkhachhang(rs.getString("HoTen"));
				sp.setDiachigiaohang(rs.getString("DiaChi"));
				sp.setSodienthoai(rs.getString("SDT"));
				sp.setThoigiandat(rs.getString("ThoiGianDat"));
				sp.setTrangthai(rs.getString("TenTrangThai"));
				list.add(sp);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

	public ArrayList<ChiTietDonHang> layDanhSachTrangThaiTK(int quyenmoi,
			String timkiem) {
		connect();
		String SQLQuery;
		System.out.println("quyen cua tau" + quyenmoi);
		if (quyenmoi == 1 || quyenmoi == 2) {
			System.out.println("da vao day roi ^^");
			SQLQuery = "select DonHang.MaDonHang,HoTen,DonHang.Diachi,SDT,ThoiGianDat,TenTrangThai from DonHang inner join TrangThaiGiaoHang on DonHang.MaTrangThai= TrangThaiGiaoHang.MaTrangThai inner join ThongTinUser on DonHang.Username=ThongTinUser.Username where DonHang.MaTrangThai like '%"
					+ timkiem + "%' ";
		} else {
			return null;
		}

		Statement stCmd;
		ArrayList<ChiTietDonHang> list = new ArrayList<ChiTietDonHang>();
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);

			ChiTietDonHang sp;
			while (rs.next()) {
				sp = new ChiTietDonHang();
				sp.setMadonhang(rs.getInt("MaDonHang"));
				sp.setTenkhachhang(rs.getString("HoTen"));
				sp.setDiachigiaohang(rs.getString("DiaChi"));
				sp.setSodienthoai(rs.getString("SDT"));
				sp.setThoigiandat(rs.getString("ThoiGianDat"));
				sp.setTrangthai(rs.getString("TenTrangThai"));
				list.add(sp);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

	public void xoaDonHang(int madonhang) {
		connect();
		// System.out.println(sanPham.getMaSanPham()+";"+sanPham.getTenSanPham()+";"+sanPham.getGiaBan()+";"+sanPham.getGioiThieu());
		String SQLQuery = "Delete FROM ChiTietDonHang where MaDonHang='"
				+ madonhang + "'";
		String SQLQuery1 = "Delete FROM DonHang where MaDonHang='" + madonhang
				+ "'";

		Statement stCmd;
		Statement stCmd1;
		try {
			stCmd = cn.createStatement();
			stCmd1 = cn.createStatement();
			stCmd.executeUpdate(SQLQuery);
			stCmd1.executeUpdate(SQLQuery1);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	public ArrayList<ChiTietDonHang> layDanhSachNgayDonHangTK(int quyenmoi,
			String timkiem, String thang, String nam) {
		connect();
		String SQLQuery;
		System.out.println("quyen cua tau" + quyenmoi);
		if (quyenmoi == 1 || quyenmoi == 2) {
			System.out.println("da vao day roi ^^");
			SQLQuery = "select DonHang.MaDonHang,HoTen,DonHang.Diachi,SDT,ThoiGianDat,TenTrangThai from DonHang inner join TrangThaiGiaoHang on DonHang.MaTrangThai= TrangThaiGiaoHang.MaTrangThai inner join ThongTinUser on DonHang.Username=ThongTinUser.Username where day(ThoiGianDat) = '"+timkiem+"'  AND MONTH(ThoiGianDat) = '"+thang+"' AND YEAR(ThoiGianDat)='"+nam+"'";
		} else {
			return null;
		}

		Statement stCmd;
		ArrayList<ChiTietDonHang> list = new ArrayList<ChiTietDonHang>();
		try {
			stCmd = cn.createStatement();
			ResultSet rs = null;
			rs = stCmd.executeQuery(SQLQuery);

			ChiTietDonHang sp;
			while (rs.next()) {
				sp = new ChiTietDonHang();
				sp.setMadonhang(rs.getInt("MaDonHang"));
				sp.setTenkhachhang(rs.getString("HoTen"));
				sp.setDiachigiaohang(rs.getString("DiaChi"));
				sp.setSodienthoai(rs.getString("SDT"));
				sp.setThoigiandat(rs.getString("ThoiGianDat"));
				sp.setTrangthai(rs.getString("TenTrangThai"));
				list.add(sp);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return list;
	}

	public void themDonHangDCH(String username, String thoigiandat,
			String username2, String diachigiaohang, String ghichu,
			String matrangthai) {
		connect();
		// System.out.println(sanPham.getMaSanPham()+";"+sanPham.getTenSanPham()+";"+sanPham.getGiaBan()+";"+sanPham.getGioiThieu());
		String SQLQuery = String
				.format(
						"INSERT INTO DonHang(Username,ThoiGianDat,UsernameGH,Diachi,GhiChu,MaTrangThai) "
								+ " VALUES ( '%s','%s','%s',N'%s',N'%s','%s')",
						username, thoigiandat, username2, diachigiaohang,
						ghichu, matrangthai);
		Statement stCmd;
		System.out.println("them thanh cong");
		try {
			stCmd = cn.createStatement();
			stCmd.executeUpdate(SQLQuery);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	public int layMaDonHangDCH(String username, String thoigiandat)
			throws SQLException {
		connect();
		int madonhang;
		String SQLQuery;
		// System.out.println("quyen cua tau" + quyenmoi);

		System.out.println("da vao Lay MA DOn Hang DCH");
		SQLQuery = "select MaDonHang from DonHang where Username='" + username
				+ "' and ThoiGianDat='" + thoigiandat + "'";
		Statement stCmd;
		stCmd = cn.createStatement();
		ResultSet rs = null;
		rs = stCmd.executeQuery(SQLQuery);
		rs.next();
		madonhang = rs.getInt("MaDonHang");
		System.out.println("ma don Hang da duoc lay ra" + madonhang);
		return madonhang;

	}

	// Them chi tiet don Hang cua dai ca hieu
	public void themChiTietDonHang(int[] maSanPham, int[] soLuong,
			int madonhang, int i) throws SQLException {
		connect();
		System.out.println("so thu tu" + i);
		int giaban = 0;
		for (int j = 0; j < i; j++) {
			System.out.println("vao them chi tiet don hang");
			String SQLQuery1 = "select GiaBan from SANPHAM where MaSanPham ='"
					+ maSanPham[j] + "' ";
			Statement stCmd1;

			stCmd1 = cn.createStatement();
			ResultSet rs1 = null;

			System.out.println("vao roi sao ko duoc");
			rs1 = stCmd1.executeQuery(SQLQuery1);
			rs1.next();
			giaban = rs1.getInt("GiaBan");
			System.out.println("Gia ban cua san pham" + giaban);

			String SQLQuery = String.format(
					"INSERT INTO ChiTietDonHang(MaDonHang,MaSanPham,SoLuong,GiaBan) "
							+ " VALUES ( '%s','%s','%s','%s')", madonhang,
					maSanPham[j], soLuong[j], giaban);
			Statement stCmd;
			System.out.println("them thanh cong");
			try {
				stCmd = cn.createStatement();
				stCmd.executeUpdate(SQLQuery);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		// System.out.println(sanPham.getMaSanPham()+";"+sanPham.getTenSanPham()+";"+sanPham.getGiaBan()+";"+sanPham.getGioiThieu());

	}

}
