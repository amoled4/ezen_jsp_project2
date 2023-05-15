package domain;

public class MemberVO {

	/*
create table member(
mid varchar(20) not null,
mpw varchar(20) not null,
mname varchar(20) not null,
mphone int,
memail varchar(45) not null, 
regdate datetime default now(),
last_login datetime default null,
Primary key(mid)
);

	 */
	
	
	private String mid;
	private String mpw;
	private String mname;
	private String mphone;
	private String memail;
	private String regdate;
	private String last_login;
	private String mgrant;
	
	public MemberVO() {}

	
	public MemberVO(String mid) {
		this.mid = mid;
	}
	
	// login
	// 아이디, 비밀번호
	public MemberVO(String mid, String mpw) {
		this.mid = mid;
		this.mpw = mpw;
	}


	// join
	// 아이디, 비밀번호, 이름, 전화번호, 이메일 
	public MemberVO(String mid, String mpw, String mname, String mphone, String memail) {
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mphone = mphone;
		this.memail = memail;
	}


	// list
	// 아이디, 이메일
	public MemberVO(String mid, String memail, String regdate) {
		this.mid = mid;
		this.memail = memail;
		this.regdate = regdate;
	}

	// edit
	public MemberVO(String mid, String mpw, String mphone, String memail) {
		super();
		this.mid = mid;
		this.mpw = mpw;
		this.mphone = mphone;
		this.memail = memail;
	}
	
	// modify
	// 전부
	public MemberVO(String mid, String mpw, String mname, String mphone, String memail, String regdate,
			String last_login) {
		this.mid = mid;
		this.mpw = mpw;
		this.mname = mname;
		this.mphone = mphone;
		this.memail = memail;
		this.regdate = regdate;
		this.last_login = last_login;
	}
	
	
	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getMpw() {
		return mpw;
	}


	public void setMpw(String mpw) {
		this.mpw = mpw;
	}


	public String getMname() {
		return mname;
	}


	public void setMname(String mname) {
		this.mname = mname;
	}


	public String getMphone() {
		return mphone;
	}


	public void setMphone(String mphone) {
		this.mphone = mphone;
	}


	public String getMemail() {
		return memail;
	}


	public void setMemail(String memail) {
		this.memail = memail;
	}


	public String getRegdate() {
		return regdate;
	}


	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}


	public String getLast_login() {
		return last_login;
	}


	public void setLast_login(String last_login) {
		this.last_login = last_login;
	}

	


	public String getMgrant() {
		return mgrant;
	}


	public void setMgrant(String mgrant) {
		this.mgrant = mgrant;
	}


	@Override
	public String toString() {
		return "MemberVO [mid=" + mid + ", mpw=" + mpw + ", mname=" + mname + ", mphone=" + mphone + ", memail="
				+ memail + ", regdate=" + regdate + ", last_login=" + last_login + ", mgrant=" + mgrant + "]";
	}




	
	
	
	
	
	
}
