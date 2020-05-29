package com.board.dto;

import java.sql.Timestamp;

public class BoardVO {
	private int b_code;
	private String b_title;
	private String b_content;
	private int b_hit;
	private String b_writer;
	private Timestamp b_indate;
	private int b_like;
	private BoardKind b_kind;
	
	
	public int getB_code() {
		return b_code;
	}
	public void setB_code(int b_code) {
		this.b_code = b_code;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public int getB_hit() {
		return b_hit;
	}
	public void setB_hit(int b_hit) {
		this.b_hit = b_hit;
	}
	public String getB_writer() {
		return b_writer;
	}
	public void setB_writer(String b_writer) {
		this.b_writer = b_writer;
	}
	public Timestamp getB_indate() {
		return b_indate;
	}
	public void setB_indate(Timestamp b_indate) {
		this.b_indate = b_indate;
	}
	public int getB_like() {
		return b_like;
	}
	public void setB_like(int b_like) {
		this.b_like = b_like;
	}
	public BoardKind getB_kind() {
		return b_kind;
	}
	public void setB_kind(BoardKind b_kind) {
		this.b_kind = b_kind;
	}
	
	
}
