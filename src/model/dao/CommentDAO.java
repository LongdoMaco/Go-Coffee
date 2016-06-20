package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.bean.BaiViet;
import model.bean.Comment;

public class CommentDAO {

	public ArrayList<Comment> getListComment(int maBaiViet) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		ArrayList<Comment> arrCom = new ArrayList<Comment>();
		Comment comment = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String sql = " Select c.IDComment,c.MaBaiViet, c.ThoiGian, c.NoiDung, c.Username, u.HinhDaiDien From Comment c Inner Join ThongTinUser u ON c.Username = u.Username Where c.MaBaiViet =?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, maBaiViet);
			rs = preparedStatement.executeQuery();
			
			while(rs.next()){
				comment = new Comment(rs.getInt(1), maBaiViet, rs.getString(3), rs.getString(4), rs.getString(5).trim());
				String path = "images\\avatar\\"+rs.getString(6);
				comment.setHinhDaiDien(path);
				arrCom.add(comment);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("Size list Comment: "+arrCom.size());
			ConnectionDB.closeConnection(rs);
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
		}
		
		return arrCom;
	}

	public boolean addComment(int maBaiViet, String thoiGian,
			String noiDungComment, String userName) {
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String sql = "Insert into Comment(MaBaiViet, ThoiGian, NoiDung, Username) Values (?,?,?,?)";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, maBaiViet);
			preparedStatement.setString(2, thoiGian);
			preparedStatement.setString(3, noiDungComment);
			preparedStatement.setString(4, userName.trim());
			
			preparedStatement.executeUpdate();
			System.out.println("Insert comment thanh cong");
			
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
			return false;
		} finally {
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
		}
		
	}

	public boolean xoaComment(int idComment) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String sql = "Delete From Comment Where IDComment=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, idComment);
			
			preparedStatement.executeUpdate();
			
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
			return true;
		}
	}
	
	public boolean xoaAllComment(int maBaiViet) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String sql = "Delete From Comment Where MaBaiViet=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, maBaiViet);
			
			preparedStatement.executeUpdate();
			
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
			return true;
		}
	}


	public Comment getComment(int idComment, int maBaiViet) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet=null;
		Comment comment=null;
		try {
			connection = ConnectionDB.getConnection();
			String sql = "Select * From Comment Where MaBaiViet=? And IDComment=? ";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, maBaiViet);
			preparedStatement.setInt(2, idComment);
			
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()){
				comment = new Comment(idComment, maBaiViet, resultSet.getString(3), resultSet.getString(4).trim(), resultSet.getString(5).trim());
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			ConnectionDB.closeConnection(resultSet);
			ConnectionDB.closeConnection(connection);
			ConnectionDB.closeConnection(preparedStatement);
			return comment;
		}
	}

	public boolean editComment(int idComment, String noiDungComment,
			String thoiGian) {

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String sql = "UPDATE Comment SET NoiDung=?, ThoiGian=? WHERE IDComment=?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, noiDungComment);
			preparedStatement.setString(2, thoiGian);
			preparedStatement.setInt(3, idComment);
			
			preparedStatement.executeUpdate();
			
			System.out.println("Sua comment thanh cong...");
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
