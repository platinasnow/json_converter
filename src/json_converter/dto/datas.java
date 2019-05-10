package json_converter.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class datas {

	private Integer board_idx;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	private Date reg_date;
	private String hphone;
	private Integer cust_seq;

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

	public String getHphone() {
		return hphone;
	}

	public void setHphone(String hphone) {
		this.hphone = hphone;
	}

	public Integer getCust_seq() {
		return cust_seq;
	}

	public void setCust_seq(Integer cust_seq) {
		this.cust_seq = cust_seq;
	}

}
