package model.bo;

import java.util.ArrayList;

import model.bean.BaiViet;
import model.bean.LoaiBaiViet;
import model.dao.LoaiBaiVietDAO;

public class LoaiBaiVietBO {
	LoaiBaiVietDAO dao;
	public LoaiBaiVietBO() {
		dao = new LoaiBaiVietDAO();
	}
	public void changeMaLoaiBaiViet(ArrayList<BaiViet> listBaiViet) {
		ArrayList<LoaiBaiViet> listLoaiBaiViet = null;
		listLoaiBaiViet = dao.getListLoaiBaiViet();
		
		int sizeListBV = listBaiViet.size();
		int sizeListLBV = listLoaiBaiViet.size();
		
		for (BaiViet bv : listBaiViet){
			for (LoaiBaiViet lbv : listLoaiBaiViet){
				if (lbv.getMaLoaiBaiViet().trim().equals(bv.getMaLoaiBaiViet().trim())){
					bv.setTenLoaiBaiViet(lbv.getTenLoaiBaiViet());
					break;
				}
			}
		}
	}
	public ArrayList<LoaiBaiViet> getListLoaiBaiViet() {
		// TODO Auto-generated method stub
		return dao.getListLoaiBaiViet();
	}
	
	
	
	
}
