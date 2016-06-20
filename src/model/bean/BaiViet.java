package model.bean;

public class BaiViet {
	private int maBaiViet;
	private String tieuDeBaiViet;
	private String maLoaiBaiViet;
	private String tenLoaiBaiViet;
	private String userName;
	private String noiDungBaiViet;
	private String thoiGian;
	private String hinhAnh;
	
	public BaiViet() {
		// TODO Auto-generated constructor stub
	}
	
	public BaiViet(int maBaiViet, String tieuDeBaiViet, String maLoaiBaiViet,
			String userName, String noiDungBaiViet, String thoiGian) {
		super();
		this.maBaiViet = maBaiViet;
		this.tieuDeBaiViet = tieuDeBaiViet;
		this.maLoaiBaiViet = maLoaiBaiViet;
		this.userName = userName;
		this.noiDungBaiViet = noiDungBaiViet;
		this.thoiGian = thoiGian;
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

	public String getTenLoaiBaiViet() {
		return tenLoaiBaiViet;
	}

	public void setTenLoaiBaiViet(String tenLoaiBaiViet) {
		this.tenLoaiBaiViet = tenLoaiBaiViet;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
}
