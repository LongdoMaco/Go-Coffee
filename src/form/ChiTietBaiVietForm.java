package form;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import model.bean.BaiViet;
import model.bean.Comment;
import model.bean.LoaiBaiViet;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

public class ChiTietBaiVietForm extends ActionForm {
	private int maBaiViet;
	private String tieuDeBaiViet;
	private String maLoaiBaiViet;
	private String tenLoaiBaiViet;
	private String userName;
	private String noiDungBaiViet;
	private String thoiGian;
	private ArrayList<Comment> listComment;
	private String noiDungComment;
	private String themComment;
	private String suaComment;
	private String xoaComment;
	private int quyenHan;
	private String userDangNhap;
	private String hinhAnh="";
	
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
	public String getTenLoaiBaiViet() {
		return tenLoaiBaiViet;
	}
	public void setTenLoaiBaiViet(String tenLoaiBaiViet) {
		this.tenLoaiBaiViet = tenLoaiBaiViet;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public ArrayList<Comment> getListComment() {
		return listComment;
	}
	public void setListComment(ArrayList<Comment> listComment) {
		this.listComment = listComment;
	}
	public String getNoiDungComment() {
		return noiDungComment;
	}
	public void setNoiDungComment(String noiDungComment) {
		this.noiDungComment = noiDungComment;
	}
	public String getThemComment() {
		return themComment;
	}
	public void setThemComment(String themComment) {
		this.themComment = themComment;
	}
	public String getSuaComment() {
		return suaComment;
	}
	public void setSuaComment(String suaComment) {
		this.suaComment = suaComment;
	}
	public String getXoaComment() {
		return xoaComment;
	}
	public void setXoaComment(String xoaComment) {
		this.xoaComment = xoaComment;
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
		this.userDangNhap = userDangNhap;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
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
