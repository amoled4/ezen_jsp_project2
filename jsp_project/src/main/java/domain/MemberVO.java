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
	
	public MemberVO() {}

	
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


	
	
	
	
	
	
}