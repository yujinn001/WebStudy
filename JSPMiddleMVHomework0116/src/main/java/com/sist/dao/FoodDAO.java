package com.sist.dao;
import java.util.*; 
import java.sql.*;
import javax.naming.*;
import javax.sql.*;

import com.sist.vo.FoodLocationVO;

public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	 public void getConnection()
	 {
		 // 탐색기 형식 => 탐색기 열기 => c드라이버 성
		 try {
		   Context init=new InitialContext();
		   Context c= (Context)init.lookup("java://comp/env");
		   DataSource ds=(DataSource)c.lookup("jdbc/oracle");
		   conn = ds.getConnection();
		 } catch(Exception ex){}
		   
	 }
	 public void disConnection()
	 {
		 try
		 {
			if(ps!= null)ps.close();
			if(conn!=null)conn.close();
		 }catch(Exception ex) {}
	 }
	 // 서울 명소 => 20개 목록 출력
	 public ArrayList<FoodLocationVO>  seoullocationListData(int page)
	 {
		 ArrayList<FoodLocationVO> list = new  ArrayList<FoodLocationVO>();
		 try {
			 getConnection();
			 String sql ="SELECT fno, name, poster, num "
			 		+ "FROM (SELECT fno, name, poster,rownum as num "
			 		+ "FROM(SELECT fno, name, poster "
			 		+ "FROM food_location ORDER BY fno ASC)) "
			 		+ "WHERE num BETWEEN 1 AND 20";
			 ps=conn.prepareStatement(sql);
			 
			 
			 ResultSet rs = ps.executeQuery();
			 while(rs.next())
			 {
				 FoodLocationVO vo = new FoodLocationVO();
				 vo.setFno(rs.getInt(1));
				 vo.setName(rs.getString(2));
				 String poster =rs.getString(3);
				 poster=poster.substring(0,poster.indexOf("^")).replace("#","&");
				 
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
}
