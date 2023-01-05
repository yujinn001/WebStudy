package com.sist.dao;
import java.util.*;
import java.sql.*;

public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public EmpDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception ex) {}
	}
	
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch (Exception ex) {}
	}
	
	public void disConnection()
	{
		try {
			if(conn!=null) conn.close();
			if(ps!=null) ps.close();
		}catch(Exception ex) {}
	}
	
	// 전체 목록  
	public ArrayList<EmpVO> empListData()
	{
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try
		{
			getConnection();
			String sql ="SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno "
					+ "From emp";
			ps =conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEnam(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setMgr(rs.getInt(4));
				vo.setHiredate(rs.getDate(5));
				vo.setSal(rs.getInt(6));
				vo.setComm(rs.getInt(7));
				vo.setDeptno(rs.getInt(8));
				
				list.add(vo);
			}
		    rs.close();	
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	// 조인
	public ArrayList<EmpVO> empJoinData()
	{
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try
		{
			getConnection();
			String sql ="SELECT empno, ename, job, mgr, hiredate, sal, comm, deptno "
					+ "From emp "
					+ "WHERE emp.deptno =dept.deptno";
			ps =conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				EmpVO vo = new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEnam(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setMgr(rs.getInt(4));
				vo.setHiredate(rs.getDate(5));
				vo.setSal(rs.getInt(6));
				vo.setComm(rs.getInt(7));
				vo.setDeptno(rs.getInt(8));
				vo.getDvo().setDanme(rs.getString(9));
				vo.getDvo().setLoc(rs.getString(10));
				list.add(vo);
			}
		    rs.close();	
		}catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
}




























