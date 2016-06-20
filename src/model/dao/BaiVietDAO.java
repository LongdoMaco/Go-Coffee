package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.bean.BaiViet;

public class BaiVietDAO {

	public ArrayList<BaiViet> getListBaiViet() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<BaiViet> arrBV = new ArrayList<BaiViet>();
		BaiViet bv = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String sql = "Select * from BaiViet Order by MaBaiViet Desc";
			preparedStatement = connection.prepareStatement(sql);
			rs = preparedStatement.executeQuery();
			while (rs.next()){
				bv = new BaiViet(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4).trim(), rs.getString(5), rs.getString(6).substring(0, 10));
				bv.setHinhAnh(rs.getString(7));
				arrBV.add(bv);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("Size list Bai Viet: "+arrBV.size());
			ConnectionDB.closeConnection(rs);
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
		}
		
		return arrBV;
	}
	
	
	public ArrayList<BaiViet> getListBaiViet(String dieuKien) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<BaiViet> arrBV = new ArrayList<BaiViet>();
		BaiViet bv = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String sql = "Select * from BaiViet WHERE MaLoaiBaiViet=? Order by MaBaiViet Desc";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, dieuKien);
			rs = preparedStatement.executeQuery();
			while (rs.next()){
				bv = new BaiViet(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4).trim(), rs.getString(5), rs.getString(6).substring(0, 10));
				bv.setHinhAnh(rs.getString(7));
				arrBV.add(bv);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("Size list Bai Viet: "+arrBV.size());
			ConnectionDB.closeConnection(rs);
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
		}
		
		return arrBV;
	}

	public boolean themBaiViet(String tieuDeBaiViet, String maLoaiBaiViet,
			String userName, String noiDungBaiViet, String thoiGian, String hinhAnh) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String sql = "Insert into BaiViet(TieuDeBaiViet, MaLoaiBaiViet, UserName, NoiDungBaiViet, ThoiGian, HinhAnh) values (?,?,?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, tieuDeBaiViet);
			preparedStatement.setString(2, maLoaiBaiViet);
			preparedStatement.setString(3, userName.trim());
			preparedStatement.setString(4, noiDungBaiViet);
			preparedStatement.setString(5, thoiGian);
			preparedStatement.setString(6, hinhAnh);
			
			preparedStatement.executeUpdate();
			
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
			
			System.out.println("Them bai viet thanh cong");
			
			return true;

		} catch (Exception e) {
			e.printStackTrace();
			
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
			
			return false;
		}  finally {
			//System.out.println("Size list Bai Viet: "+arrBV.size());
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
		}
	}

	public BaiViet getBaiViet(int maBaiViet) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		BaiViet bv = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String sql = "Select bv.MaBaiViet, bv.TieuDeBaiViet, bv.MaLoaiBaiViet, bv.Username, bv.NoiDungBaiViet, bv.ThoiGian, lbv.TenLoaiBaiviet, bv.HinhAnh "
					+"From BaiViet bv " 
					+"INNER JOIN LoaiBaiViet lbv " 
					+"ON bv.MaLoaiBaiViet = lbv.MaLoaiBaiViet "
					+ "Where MaBaiViet=?" ;
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, maBaiViet);
			rs = preparedStatement.executeQuery();
			
			while (rs.next()){
				bv = new BaiViet(rs.getInt(1), rs.getString(2).trim(), rs.getString(3), rs.getString(4).trim(), rs.getString(5), rs.getString(6));
				bv.setTenLoaiBaiViet(rs.getString(7));
				bv.setHinhAnh(rs.getString(8));
			}

					
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(rs);
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
		}
		
		return bv;
	}

	public boolean xoaBaiViet(int maBaiViet) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String sql = "Delete From BaiViet Where MaBaiViet=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, maBaiViet);
			preparedStatement.executeUpdate();
			
			System.out.println("Xoa thanh cong");
			
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
			return false;
		}
	}

	public boolean editBaiViet(int maBaiViet, String tieuDeBaiViet,
			String maLoaiBaiViet, String userName, String noiDungBaiViet,
			String thoiGian , String hinhAnh) {
		Connection connection=null;
		PreparedStatement preparedStatement = null;
		System.out.println("hinh anh"+hinhAnh);
		try {
			connection = ConnectionDB.getConnection();
			String sql = "Update BaiViet "
					+ "SET TieuDeBaiViet=?, MaLoaiBaiViet=?, NoiDungBaiViet=?, ThoiGian=?, HinhAnh=? "
					+ "WHERE MaBaiViet=?";
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setString(1, tieuDeBaiViet);
			preparedStatement.setString(2, maLoaiBaiViet);
			preparedStatement.setString(3, noiDungBaiViet);
			preparedStatement.setString(4, thoiGian);
			preparedStatement.setString(5, hinhAnh);
			preparedStatement.setInt(6, maBaiViet);
			
			preparedStatement.executeUpdate();
			System.out.println("Update bai viet thanh cong....");
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
			return false;
		}
		
	}

	

}
