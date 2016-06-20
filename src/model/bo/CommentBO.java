package model.bo;

import java.util.ArrayList;

import model.bean.Comment;
import model.dao.CommentDAO;

public class CommentBO {
	CommentDAO dao;
	
	public CommentBO() {
		dao = new CommentDAO();
	}

	public ArrayList<Comment> getListComment(int maBaiViet) {
		ArrayList<Comment> listComment = dao.getListComment(maBaiViet);
		for(Comment com : listComment){
			com.setThoiGian(com.getThoiGian().substring(0, 19));
		}
		return listComment;
	}

	public boolean addComment(int maBaiViet, String thoiGian,
			String noiDungComment, String userName) {
		return dao.addComment(maBaiViet, thoiGian ,noiDungComment, userName);
	}

	public boolean xoaComment(int idComment) {
		// TODO Auto-generated method stub
		return dao.xoaComment(idComment);
	}

	public boolean xoaAllCommnet(int maBaiViet) {
		// TODO Auto-generated method stub
		return dao.xoaAllComment(maBaiViet);
	}

	public Comment getComment(int idComment, int maBaiViet) {
		// TODO Auto-generated method stub
		return dao.getComment(idComment, maBaiViet);
	}

	public boolean editComment(int idComment, String noiDungComment,
			String thoiGian) {
		// TODO Auto-generated method stub
		return dao.editComment(idComment, noiDungComment, thoiGian);
	}
}
