package json_converter.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class SmsType2 {

	private String sale_man_cd;
	private Integer board_idx;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date reg_date;
	private List<cust> cust;

	public String getSale_man_cd() {
		return sale_man_cd;
	}

	public void setSale_man_cd(String sale_man_cd) {
		this.sale_man_cd = sale_man_cd;
	}

	public Integer getBoard_idx() {
		return board_idx;
	}

	public void setBoard_idx(Integer board_idx) {
		this.board_idx = board_idx;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public List<cust> getCust() {
		return cust;
	}

	public void setCust(List<cust> cust) {
		this.cust = cust;
	}

	@Override
	public String toString() {
		return "SmsType2 [sale_man_cd=" + sale_man_cd + ", board_idx=" + board_idx + ", reg_date=" + reg_date
				+ ", cust=" + cust + "]";
	}

}
