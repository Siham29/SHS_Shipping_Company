
public class Service {
	
	private int sid; 
	
	private int cid;
	private int eid;
	
	public Service(int sid,int cid,int eid) {
		
		super();
		this.sid = sid;
		this.cid = cid;
		this.eid= eid;
	}
public Service(int sid) {
		
		super();
		this.sid = sid;
		
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}
	

}
