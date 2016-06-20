package form;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class CommentForm extends ActionForm{
	private int idComment;
	private int maBaiViet;
	private String thoiGian;
	private String noiDungComment;
	private String userName;
	private String submit="";
	public int getIdComment() {
		return idComment;
	}
	public void setIdComment(int idComment) {
		this.idComment = idComment;
	}
	public int getMaBaiViet() {
		return maBaiViet;
	}
	public void setMaBaiViet(int maBaiViet) {
		this.maBaiViet = maBaiViet;
	}
	public String getThoiGian() {
		return thoiGian;
	}
	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}
	public String getNoiDungComment() {
		return noiDungComment;
	}
	public void setNoiDungComment(String noiDungComment) {
		this.noiDungComment = noiDungComment;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getSubmit() {
		return submit;
	}
	public void setSubmit(String submit) {
		this.submit = submit;
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
