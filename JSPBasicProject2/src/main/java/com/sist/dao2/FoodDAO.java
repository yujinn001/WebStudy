package com.sist.dao2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public FoodDAO()
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
	// 기능 설정
	public ArrayList<CategoryVO> categoryData()
	{
		ArrayList<CategoryVO> list = new ArrayList<CategoryVO>();
		try 
		{
			getConnection();
			// 정렬은 ORDER BY를 쓰지말고 INDEX를 사용해서 쓴다
			String sql ="SELECY /*+INDEX_ASC(project_cateogory px_cno_pk)*/cno, title, subject,poster "
					+ "FROM project_category ";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) 
			{
				CategoryVO vo = new CategoryVO();
				 vo.setCno(rs.getInt(1));
				 vo.setTitle(rs.getString(2));
				 vo.setSubject(rs.getString(3));
				 vo.setPoster(rs.getString(4));
				 
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
	public ArrayList<FoodVO> foodListData()
	{
		ArrayList<FoodVO> list = new ArrayList<FoodVO>();
		try
		{
			getConnection();
			String sql ="";
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	
}






























