package json_converter.dto;

public class cust {
	private String hphone;
	private int cust_seq;

	public String getHphone() {
		return hphone;
	}

	public void setHphone(String hphone) {
		this.hphone = hphone;
	}

	public int getCust_seq() {
		return cust_seq;
	}

	public void setCust_seq(int cust_seq) {
		this.cust_seq = cust_seq;
	}

	@Override
	public String toString() {
		return "cust [hphone=" + hphone + ", cust_seq=" + cust_seq + "]";
	}

}
