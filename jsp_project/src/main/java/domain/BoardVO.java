package domain;

public class BoardVO {
	/*
create table board(
bno int not null auto_increment,
title varchar(100) not null,
writer varchar(20) not null,
regdate datetime default now(),
content text,
readcount int default 0,
Primary key(bno));

	 */
	
	private int bno;
	private String title;
	private String writer;
	private String regdate;
	private String content;
	private int readcount;
	
	public BoardVO() {}

	// register
	public BoardVO(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}

	// list
	public BoardVO(int bno, String title, String writer, String regdate, int readcount) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.regdate = regdate;
		this.readcount = readcount;
	}

	// detail
	public BoardVO(int bno, String title, String writer, String regdate, String content, int readcount) {
		super();
		this.bno = bno;
		this.title = title;
		this.writer = writer;
		this.regdate = regdate;
		this.content = content;
		this.readcount = readcount;
	}

	// update
	public BoardVO(int bno, String title, String content) {
		super();
		this.bno = bno;
		this.title = title;
		this.content = content;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getReadcount() {
		return readcount;
	}

	public void setReadcount(int readcount) {
		this.readcount = readcount;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", writer=" + writer + ", regdate=" + regdate + ", content="
				+ content + ", readcount=" + readcount + "]";
	}
	
	
	
}
