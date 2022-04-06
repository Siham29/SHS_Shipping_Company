
public class Customer {
	
	private int cid; 
	private int cphone_num;
	private String cname;
	private String caddress;
	private String cemail;
	
    public Customer () {
    	
    }
	public Customer(int cid,String cname, int cphone_num,String caddress,String cemail)
	{
		super();
		this.cid = cid;
		this.cname = cname;
		this.cphone_num = cphone_num;
		this.caddress = caddress;
		this.cemail = cemail;
		
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getCphone_num() {
		return cphone_num;
	}

	public void setCphone_num(int cphone_num) {
		this.cphone_num = cphone_num;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCaddress() {
		return caddress;
	}

	public void setCaddress(String caddress) {
		this.caddress = caddress;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	
	
}
