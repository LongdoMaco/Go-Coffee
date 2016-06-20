package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import model.bean.GioHangTam;

public class GioHangTamForm extends ActionForm {
	private int tongthanhtien;
	private int maSanPham;
	
	public int getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(int maSanPham) {
		this.maSanPham = maSanPham;
	}

	public int getTongthanhtien() {
		return tongthanhtien;
	}

	public void setTongthanhtien(int tongthanhtien) {
		this.tongthanhtien = tongthanhtien;
	}

	private ArrayList<GioHangTam> listGH;

	public ArrayList<GioHangTam> getListGH() {
		return listGH;
	}

	public void setListGH(ArrayList<GioHangTam> listGH) {
		this.listGH = listGH;
	}
	public void reset(ActionMapping mapping,HttpServletRequest request){
		try {
			request.setCharacterEncoding("UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.reset(mapping, request);
	}
}
