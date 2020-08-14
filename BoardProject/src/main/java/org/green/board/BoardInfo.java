package org.green.board;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoardInfo {
	private int b_id;
	private String b_title;
	private String b_content;
	private String b_date;
	
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (hh:mm)");
	public BoardInfo() {
	}
	public BoardInfo(String b_title, String b_content, Date date) {
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_date = sdf.format(date).toString();
	}
	public BoardInfo(int b_id, String b_title, String b_content, Date date) {
		super();
		this.b_id = b_id;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_date = sdf.format(date).toString();
	}
	public BoardInfo(int b_id, String b_title, String b_content, String date) {
		super();
		this.b_id = b_id;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_date = date;
	}
	public int getB_id() {
		return b_id;
	}

	public String getB_title() {
		return b_title;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_id(int b_id) {
		this.b_id = b_id;
	}

	public void setB_title(String b_title) {
		this.b_title = b_title;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public String getB_date() {
		return b_date;
	}

	public void setB_date(String date) {
		this.b_date = date;
	}

	@Override
	public String toString() {
		return "BoardInfo [b_id=" + b_id + ", b_title=" + b_title + ", b_content=" + b_content + ", date=" + b_date + "]";
	}
}
