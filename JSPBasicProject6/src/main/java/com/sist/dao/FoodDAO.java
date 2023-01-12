package com.sist.dao;
import java.util.*;

import javax.naming.*;
import javax.sql.DataSource;

import com.sist.vo.FoodVO;

import java.sql.*;

public class FoodDAO {
	   //연결 객체 => 미리 생성된 객체의 주소를 가지고 온다
	   private Connection conn;
	   //오라클과 송수신 (SQL 전송 == 결과값 얻기)
	   private PreparedStatement ps;
	   // DBCP ==> 요청 시마다 생성(connection이 많이 생성) OR 미리 연결된 객체를 사용(반환)
	   private static FoodDAO dao; //싱글턴 패턴 (사용자마다 1개의 DAO만 사용이 가능하게 만든다)
	 
	 
	   // POOL안에서 Connection 주소를 얻어 온다
	   public void getConnection()
	   {
	      try
	      {
	         //POOL 안에 접근 (JNDI) => 이름으로 디렉토리를 만들고 있다
	         Context init=new InitialContext(); //탐색기 연다
	         // 루트 경로 이용
	         Context c=(Context)init.lookup("java://comp/env"); //c드라이브에 접근
	         //Connection 객체를 얻어온다
	         DataSource ds=(DataSource)c.lookup("jdbc/oracle");//해당 파일 찾기
	         //주소
	         conn=ds.getConnection();
	      }catch(Exception ex) {}
	  
	   }
	   // Connection 사용이 종료 => 반환
	   public void disConnetion()
	   {
	      try
	      {
	         if(ps!=null) ps.close();
	         if(conn!=null) conn.close();
	         //닫고 => 다시 재사용을 할 수 있게 반환
	      }catch(Exception ex) {}
	   }
	   //3. 기능	
	   public ArrayList<FoodVO> foodFindData(String addr, int page)
	   {
		   ArrayList<FoodVO> list = new ArrayList<FoodVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT fno, name,poster,num  "
			   		+ "FROM (SELECT fno,name,poster,rownum as num "
			   		+ "FROM (SELECT fno, name, poster "
			   		+ "FROM food_location WHERE address LIKE'%'||?||'%' ORDER BY fno ASC)) "
			   		+ "WHERE num BETWEEN ? AND ?";
			   
			   ps=conn.prepareStatement(sql);
			   int rowSize =20;
			   int start =(rowSize*page)-(rowSize-1);
			   int end =rowSize*page;
			   
			   ps.setString(1, addr);
			   ps.setInt(2, start);
			   ps.setInt(3, end);
			   
			   ResultSet rs =ps.executeQuery();
			   while(rs.next())
			   {
				   FoodVO  vo = new FoodVO();
				   vo.setFno(rs.getInt(1));
				   vo.setName(rs.getString(2));
				   String poster=rs.getString(3);
				   poster=poster.substring(0,poster.indexOf("^")).replace("#", "&");
				   
				   vo.setPoster(poster);
				   
				   list.add(vo);						   
			   }
			   rs.close();
			   
			   
		   }catch (Exception e) {
			 e.printStackTrace();
		   }
		   finally
		   {
			   disConnetion();
		   }
		   return list;
	   }
	   // 총페이지
	   public int foodFindTotalPage(String addr)
	   {
		   int totalpage=0;
		   try {
			   getConnection();
			   String sql ="SELECT CEIL(COUNT(*)/20.0) FROM food_location "
			   		+ "WHERE address LIKE '%'||?||'%' ";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, addr);
			   ResultSet rs =ps.executeQuery();
			   rs.next();
			   totalpage = rs.getInt(1);
			   rs.close();
			   
		   }catch (Exception e) {
			 e.printStackTrace();
		   }
		   finally
		   {
			   disConnetion();
		   }
		   return totalpage;
	   }
	   public int foodFindCount(String addr)
	   {
		   int totalpage=0;
		   try {
			   getConnection();
			   String sql ="SELECT COUNT(*) FROM food_location "
			   		+ "WHERE address LIKE '%'||?||'%' ";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, addr);
			   ResultSet rs =ps.executeQuery();
			   rs.next();
			   totalpage = rs.getInt(1);
			   rs.close();
			   
		   }catch (Exception e) {
			 e.printStackTrace();
		   }
		   finally
		   {
			   disConnetion();
		   }
		   return totalpage;
	   }
	// 상세보기
			public FoodVO foodDetailData(int fno)
			{
				FoodVO vo = new FoodVO();
				try
				{
					getConnection();
					String sql ="SELECT fno, name, score,poster,tel,type,time,parking,menu,price,address "
							+ "FROM food_location "
							+ "WHERE fno =? ";
					ps=conn.prepareStatement(sql);
					ps.setInt(1, fno);
					ResultSet rs=ps.executeQuery();
					rs.next();
					vo.setFno(rs.getInt(1));
					vo.setName(rs.getString(2));
					vo.setScore(rs.getDouble(3));
					vo.setPoster(rs.getString(4));
					vo.setTel(rs.getString(5));
					vo.setType(rs.getString(6));
					vo.setTime(rs.getString(7));
					vo.setParking(rs.getString(8));
					vo.setMenu(rs.getString(9));
					vo.setPrice(rs.getString(10));
					vo.setAddress(rs.getString(11));
					
					rs.close();
				}catch(Exception ex)
				{
					ex.printStackTrace();
				}
				finally
				{
					disConnetion();
				}
				return vo;
			}
}

















































