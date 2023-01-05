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
			String sql ="SELECT fno, name, poster, rownum "
					+ "FROM project_food "
					+ "WHERE rownum <=20";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				FoodVO vo=new FoodVO();
	            vo.setFno(rs.getInt(1));
	            vo.setName(rs.getString(2));
	            String poster=rs.getString(3);
	            poster=poster.substring(0,poster.indexOf("^"));
	            poster=poster.replace("#","&");
	            vo.setPoster(poster);
	            list.add(vo);			
			}
			rs.close();
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
	public FoodVO foodDetailData() // 맛집 한개일 때는 VO, 여러개일경우 ArrayList
	{
		FoodVO vo = new FoodVO();
		try {
			getConnection();
			String sql ="SELECT fno, name, score, tel, type, address, time, parking, price, poster, menu, "
					+ "good, soso, bad "
					+ "FROM project_food "
					+ "WHERE fno =3187";
			ps=conn.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			rs.next();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setScore(rs.getDouble(3));
				vo.setTel(rs.getString(4));
				vo.setType(rs.getString(5));
				vo.setAddress(rs.getString(6));
				vo.setTime(rs.getString(7));
				vo.setParking(rs.getString(8));
				vo.setPrice(rs.getString(9));
				vo.setPoster(rs.getString(10));
				vo.setMenu(rs.getString(11));
				vo.setGood(rs.getInt(12));
				vo.setSoso(rs.getInt(13));
				vo.setBad(rs.getInt(14));
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return vo;
	}
}






























