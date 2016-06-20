package model.bo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import model.bean.ListPhanHoi;
import model.bean.PhanHoi;
import model.dao.PhanHoiDAO;

public class PhanHoiBO {
	PhanHoiDAO phanHoiDAO = new PhanHoiDAO();

	public ListPhanHoi getlistPH(int page) {
		ArrayList<PhanHoi> list = phanHoiDAO.getListPH();
		ArrayList<PhanHoi> list2 = new ArrayList<PhanHoi>();
		int maxpage = list.size() / 10;
		if (list.size() % 10 != 0) {
			maxpage++;
		}
		if (page > maxpage || page <=0) {
			page = 1;
		}
		int start = (page - 1) * 10 + 1;
		int end = start + 9;
		if (end > list.size()) {
			end = list.size();
		}
		if (list.size() != 0) {
			for (int i = start; i <= end; i++) {
				list2.add(list.get(i - 1));
			}
		}
		ListPhanHoi listph = new ListPhanHoi();
		listph.setListPhanHoi(list2);
		listph.setSoTrang(maxpage);
		listph.setPage(page);
		return listph;
	}

	public void themPhanHoi(PhanHoi phanHoi) {
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String thoiGian = sim.format(date);
		phanHoi.setThoiGianPH(thoiGian);
		phanHoiDAO.themPhanHoi(phanHoi);
	}

	public boolean checkDH(String maDonHang, String username) {
		return phanHoiDAO.checkDH(maDonHang, username);
	}

}
