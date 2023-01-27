package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;
public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	// 톰캣에 의해 미리 생성된 Connection을 가지고 온다
	public void getConnection()
	{
		try
		{
			Context init= new InitialContext(); //POOL
			Context c=(Context)init.lookup("java://comp/env");
			DataSource ds=(DataSource)c.lookup("jdbc/oracle");
			conn=ds.getConnection();
		}catch(Exception ex) {}
	}
	// Connection을 사용 후에 반환 (Connection 관리 영역 : POOL)
	public void disConnection()
	{
		try
		{
			if(ps!=null)ps.close();
			if(conn!=null)conn.close();
		}catch(Exception ex) {}
	}
	
	// 1. 목록 => 페이징 (JavaScript) => 자바스크립트 <===> 자바 연동 => Ajax, axios(Vue, React)
	public List<FoodVO> foodListData(int page)
	{
		List<FoodVO> list =new ArrayList<FoodVO>();
		try {
			getConnection();
			String sql="SELECT fno, name, poster, num"
					+ " from (SELECT fno, name, poster, rownum as num "
					+ "from (SELECT /*+ index_asc(food_location fl_fno_pk)*/ fno, name, poster "
					+ "from food_location)) "
					+ "where num between ? and ?";
			ps =conn.prepareStatement(sql);
			int rowSize=10;
			int start =(rowSize*page)-(rowSize-1);
			int end =rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				FoodVO vo = new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				String poster=rs.getString(3);
				poster=poster.substring(0,poster.indexOf("^"));
				poster=poster.replace("#", "&");
				vo.setPoster(poster);
				list.add(vo);
			}
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	// 검색 기능
	public List<FoodVO> foodFindData(String ss)
	{
		List<FoodVO> list =new ArrayList<FoodVO>();
		try {
			getConnection();
			String sql="select fno, name, poster, rownum "
					+ "from food_location "
					+ "where rownum <=21 and address like '%'||?||'%'";
			ps =conn.prepareStatement(sql);
			ps.setString(1, ss);
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				FoodVO vo = new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				String poster=rs.getString(3);
				poster=poster.substring(0,poster.indexOf("^"));
				poster=poster.replace("#", "&");
				vo.setPoster(poster);
				list.add(vo);
			}
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	// 상세보기
	public FoodVO foodDetailData(int fno)
	{
		FoodVO vo = new FoodVO();
		try
		{
			getConnection();
			String sql="select fno,name,score,poster, time, type, parking, menu,address, tel"
					+ " from food_location "
					+ "where fno=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, fno);
			
			ResultSet rs= ps.executeQuery();
			rs.next();
				vo.setFno(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setScore(rs.getDouble(3));
				vo.setPoster(rs.getString(4));
				vo.setTime(rs.getString(5));
				vo.setType(rs.getString(6));
				vo.setParking(rs.getString(7));
				vo.setMenu(rs.getString(8));
				vo.setAddress(rs.getString(9));
				vo.setTel(rs.getString(10));
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return vo;		
	}
	
	public int idCheck(String id)
	{
		int count =0;
		try {
			getConnection();
			String sql="select count(*) from jsp_member "
					+ "where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			rs.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			disConnection();
		}
		return count;
	}
}


























