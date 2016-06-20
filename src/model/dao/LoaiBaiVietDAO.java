package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.bean.LoaiBaiViet;

public class LoaiBaiVietDAO {

	public ArrayList<LoaiBaiViet> getListLoaiBaiViet() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		ArrayList<LoaiBaiViet> arrLBV = new ArrayList<LoaiBaiViet>();
		LoaiBaiViet loaiBaiViet = null;
		
		try {
			connection = ConnectionDB.getConnection();
			String sql = "Select * from LoaiBaiViet";
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()){
				loaiBaiViet = new LoaiBaiViet(resultSet.getString(1), resultSet.getString(2));
				arrLBV.add(loaiBaiViet);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			System.out.println("Size Loai Bai Viet: "+arrLBV.size());
			ConnectionDB.closeConnection(resultSet);
			ConnectionDB.closeConnection(preparedStatement);
			ConnectionDB.closeConnection(connection);
		}
		
		
		return arrLBV;
	}

}
