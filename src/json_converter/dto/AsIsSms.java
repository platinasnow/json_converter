package json_converter.dto;

public class AsIsSms {
	private String hphone;
	private String sale_man_cd;
	private String cust_seq;
	private String board_idx;
	// @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
	private String reg_date;

	public String getHphone() {
		return hphone;
	}

	public void setHphone(String hphone) {
		this.hphone = hphone;
	}

	public String getSale_man_cd() {
		return sale_man_cd;
	}

	public void setSale_man_cd(String sale_man_cd) {
		this.sale_man_cd = sale_man_cd;
	}

	public String getCust_seq() {
		return cust_seq;
	}

	public void setCust_seq(String cust_seq) {
		this.cust_seq = cust_seq;
	}

	public String getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(String board_idx) {
		this.board_idx = board_idx;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		return "AsIsSms [hphone=" + hphone + ", sale_man_cd=" + sale_man_cd + ", cust_seq=" + cust_seq + ", board_idx="
				+ board_idx + ", reg_date=" + reg_date + "]";
	}

}
