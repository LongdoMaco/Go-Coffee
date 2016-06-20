package model.bean;

public class LoaiBaiViet {
	private String maLoaiBaiViet;
	private String tenLoaiBaiViet;
	
	public LoaiBaiViet() {
		// TODO Auto-generated constructor stub
	}

	public LoaiBaiViet(String maLoaiBaiViet, String tenLoaiBaiViet) {
		super();
		this.maLoaiBaiViet = maLoaiBaiViet;
		this.tenLoaiBaiViet = tenLoaiBaiViet;
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
	
	
}
