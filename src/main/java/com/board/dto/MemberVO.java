package com.board.dto;

import java.sql.Timestamp;

public class MemberVO {
	private Long m_code;
	private String id;
	private String password;
	private Timestamp indate;
	private int grade;
	public Long getM_code() {
		return m_code;
	}
	public void setM_code(Long m_code) {
		this.m_code = m_code;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Timestamp getIndate() {
		return indate;
	}
	public void setIndate(Timestamp indate) {
		this.indate = indate;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	
}
