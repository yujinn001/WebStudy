package com.sist.dao;

public class DeptVO {
	private int deptno;
	private String danme, loc;
	private DeptVO dvo = new DeptVO(); // 조인을 사용할 경
	
	public DeptVO getDvo() {
		return dvo;
	}
	public void setDvo(DeptVO dvo) {
		this.dvo = dvo;
	}
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDanme() {
		return danme;
	}
	public void setDanme(String danme) {
		this.danme = danme;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	

}
