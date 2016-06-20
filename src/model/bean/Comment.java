package model.bean;

public class Comment {
	private int idComment;
	private int maBaiViet;
	private String thoiGian;
	private String noiDung;
	private String userName;
	private String hinhDaiDien="";
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(int idComment, int maBaiViet, String thoiGian,
			String noiDung, String userName) {
		super();
		this.idComment = idComment;
		this.maBaiViet = maBaiViet;
		this.thoiGian = thoiGian;
		this.noiDung = noiDung;
		this.userName = userName;
	}

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

	public String getNoiDung() {
		return noiDung;
	}

	public void setNoiDung(String noiDung) {
		this.noiDung = noiDung;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName.trim();
	}

	public String getHinhDaiDien() {
		return hinhDaiDien;
	}

	public void setHinhDaiDien(String hinhDaiDien) {
		this.hinhDaiDien = hinhDaiDien;
	}
	
	
}
