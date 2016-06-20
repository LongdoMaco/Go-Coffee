package model.bo;

import java.util.ArrayList;

import model.bean.BaiViet;
import model.dao.BaiVietDAO;

public class BaiVietBO {
	BaiVietDAO dao;
	public BaiVietBO() {
		dao = new BaiVietDAO();
	}
	public ArrayList<BaiViet> getListBaiViet() {
		// TODO Auto-generated method stub
		return dao.getListBaiViet();
	}
	
	public ArrayList<BaiViet> getListBaiViet(String dieuKien) {
		// TODO Auto-generated method stub
		return dao.getListBaiViet(dieuKien);
	}
	
	public void changeFormat(ArrayList<BaiViet> listBaiViet) {
		LoaiBaiVietBO lbvBO = new LoaiBaiVietBO();
		lbvBO.changeMaLoaiBaiViet(listBaiViet);
		
		for (BaiViet bv : listBaiViet){
			String noiDungBaiViet = bv.getNoiDungBaiViet();
			
			int sizeNoiDungBaiViet = noiDungBaiViet.length();
			int sizeKiTu = 200;
			if (sizeNoiDungBaiViet>=sizeKiTu){
				StringBuffer strBuf = new StringBuffer(noiDungBaiViet.substring(0, sizeKiTu));
				strBuf.append(" ...");
				bv.setNoiDungBaiViet(strBuf.toString().trim());
			}
		}
		
		
	}
	public boolean themBaiViet(String tieuDeBaiViet, String maLoaiBaiViet,
			String userName, String noiDungBaiViet, String thoiGian, String filenameNew) {
		// TODO Auto-generated method stub
		return (dao.themBaiViet(tieuDeBaiViet, maLoaiBaiViet, userName, noiDungBaiViet, thoiGian, filenameNew));
	}
	public BaiViet getBaiViet(int maBaiViet) {
		BaiViet baiViet = dao.getBaiViet(maBaiViet);
		baiViet.setThoiGian(baiViet.getThoiGian().substring(0,19));
		return baiViet;
	}
	public boolean xoaBaiViet(int maBaiViet) {
		CommentBO commentBO = new CommentBO();
		if (commentBO.xoaAllCommnet(maBaiViet)){
			if (dao.xoaBaiViet(maBaiViet)){
				return true;
			}else return false;
		}else return false;
	}
	public boolean editBaiViet(int maBaiViet, String tieuDeBaiViet,
			String maLoaiBaiViet, String userName, String noiDungBaiViet,
			String thoiGian, String hinhAnh) {
		return dao.editBaiViet(maBaiViet, tieuDeBaiViet, maLoaiBaiViet,userName, noiDungBaiViet, thoiGian,hinhAnh);
	}

	

}
