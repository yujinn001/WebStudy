package com.sist.db;
import java.util.*;
import java.sql.*;
import com.sist.common.*; // db

public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private CreateConneciton c= new CreateConneciton();
	
	public void getConnection()
	{
		conn=c.getConnection();
	}
	public void disConnection()
	{
		c.disConnection(ps, conn);
	}
	public void empData()
	{
		try
		{
			getConnection();
			String sql ="SELECT ename FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1));
			}
			rs.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			disConnection();
		}
	}
	public static void main(String[] args) {
		EmpDAO dao =new EmpDAO();
		dao.empData();
	}
}
