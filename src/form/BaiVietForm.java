package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.BaiViet;
import model.bean.LoaiBaiViet;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

public class BaiVietForm extends ActionForm {
	private int maBaiViet;
	private String tieuDeBaiViet="";
	private String maLoaiBaiViet;
	private String userName;
	private String noiDungBaiViet="";
	private String thoiGian;
	private ArrayList<BaiViet> listBaiViet;
	private ArrayList<LoaiBaiViet> listLoaiBaiViet;
	private ArrayList<BaiViet> listBaiVietMoi;
	private String submit="";
	private int quyenHan;
	private String userDangNhap;
	private FormFile image;
	private String hinhAnh="";
	private String dieuKien="";
	
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public int getMaBaiViet() {
		return maBaiViet;
	}
	public void setMaBaiViet(int maBaiViet) {
		this.maBaiViet = maBaiViet;
	}
	public String getTieuDeBaiViet() {
		return tieuDeBaiViet;
	}
	public void setTieuDeBaiViet(String tieuDeBaiViet) {
		this.tieuDeBaiViet = tieuDeBaiViet;
	}
	public String getMaLoaiBaiViet() {
		return maLoaiBaiViet;
	}
	public void setMaLoaiBaiViet(String maLoaiBaiViet) {
		this.maLoaiBaiViet = maLoaiBaiViet;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName.trim();
	}
	public String getNoiDungBaiViet() {
		return noiDungBaiViet;
	}
	public void setNoiDungBaiViet(String noiDungBaiViet) {
		this.noiDungBaiViet = noiDungBaiViet;
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	public ArrayList<BaiViet> getListBaiViet() {
		return listBaiViet;
	}
	public void setListBaiViet(ArrayList<BaiViet> listBaiViet) {
		this.listBaiViet = listBaiViet;
	}
	
	public ArrayList<LoaiBaiViet> getListLoaiBaiViet() {
		return listLoaiBaiViet;
	}
	public void setListLoaiBaiViet(ArrayList<LoaiBaiViet> listLoaiBaiViet) {
		this.listLoaiBaiViet = listLoaiBaiViet;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
	}
	public int getQuyenHan() {
		return quyenHan;
	}
	public void setQuyenHan(int quyenHan) {
		this.quyenHan = quyenHan;
	}
	public String getUserDangNhap() {
		return userDangNhap;
	}
	public void setUserDangNhap(String userDangNhap) {
		this.userDangNhap = userDangNhap.trim();
	}
	public FormFile getImage() {
		return image;
	}
	public void setImage(FormFile image) {
		this.image = image;
	}
	public ArrayList<BaiViet> getListBaiVietMoi() {
		return listBaiVietMoi;
	}
	public void setListBaiVietMoi(ArrayList<BaiViet> listBaiVietMoi) {
		this.listBaiVietMoi = listBaiVietMoi;
	}
	public String getDieuKien() {
		return dieuKien;
	}
	public void setDieuKien(String dieuKien) {
		this.dieuKien = dieuKien;
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
