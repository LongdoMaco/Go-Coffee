package model.bo;

import java.util.ArrayList;
import java.util.Date;

import model.bean.ListThongKe;
import model.bean.ThongKe;
import model.dao.ThongKeDAO;

public class ThongKeBO {
	ThongKeDAO tkdao = new ThongKeDAO();
	public ArrayList<ThongKe> getTKTheoThang(String month) {
		ArrayList<ThongKe> list = tkdao.getTKTheoThang(month);
		return list;
	}

	public ListThongKe getTK() {
		return tkdao.getTKChung();
		
	}

	public ArrayList<ThongKe> getTKDSNV(String thang) {
		
		return tkdao.getTKNVTheoDonHang(thang);
	}
	public ArrayList<ThongKe> getTKKH(String thang) {
		
		return tkdao.getTKKHTheoDonHang(thang);
	}

}
