package com.sist.dao;
import java.util.*;

import com.sist.vo.FoodVO;
import com.sist.vo.SeoulVO;

import java.sql.*;
public class SeoulDAO {
   private Connection conn;
   private PreparedStatement ps;
   
   //기능
   public ArrayList<SeoulVO> seoulListData(int page,int type)
   {
      ArrayList<SeoulVO> list=new ArrayList<SeoulVO>();
      String[] table= {"","location","nature","shop","hotel","guest"};
      try
      {
         conn=CreateConnection.getConnection();
         String sql="SELECT no,title,poster,num "
               +"FROM (SELECT no,title,poster,rownum as num "
               +"FROM (SELECT no,title,poster "
               +"FROM seoul_"+table[type]+" ORDER BY no ASC)) "
               +"WHERE num BETWEEN ? AND ?";
         ps=conn.prepareStatement(sql);
         int rowSize=20;
         int start=(rowSize*page)-(rowSize-1);
         int end=rowSize*page;
         ps.setInt(1, start);
         ps.setInt(2, end);
         
         ResultSet rs=ps.executeQuery();
         while(rs.next())
         {
            SeoulVO vo=new SeoulVO();
            vo.setNo(rs.getInt(1));
            vo.setTitle(rs.getString(2));
            vo.setPoster(rs.getString(3));
            
            list.add(vo);
         }
         rs.close();
      }catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         CreateConnection.disConnection(conn, ps);
      }
      return list;
   }
   
   public int seoulTotalPage(int type)
   {
      int total=0;
      try
      {
         conn=CreateConnection.getConnection();
         String[] table= {"","location","nature","shop","hotel","guest"};
         String sql="SELECT CEIL(COUNT(*)/20.0) FROM seoul_"+table[type];
         ps=conn.prepareStatement(sql);
         ResultSet rs=ps.executeQuery();
         rs.next();
         total=rs.getInt(1);
         rs.close();
      }catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         CreateConnection.disConnection(conn, ps);
      }
      return total;
   }
  
   //1.2상세
   public SeoulVO seoulDetail(int no)
   {
	   SeoulVO vo = new SeoulVO();
	   try
	   {
		   conn=CreateConnection.getConnection();
		   String sql="update seoul_location set "
		   		+ "hit =hit+1 "
		   		+ "where no =?";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, no);
		   ps.executeUpdate();
		   
		   sql="select no, title, poster, msg,address "
		   		+ "from seoul_location "
		   		+ "where no =?";
		   ps=conn.prepareStatement(sql);
		   ps.setInt(1, no);
		   ResultSet rs =ps.executeQuery();
		   rs.next();
		   vo.setNo(rs.getInt(1));
		   vo.setTitle(rs.getString(2));
		   vo.setPoster(rs.getString(3));
		   vo.setMsg(rs.getString(4));
		   vo.setAddress(rs.getString(5));
		   rs.close();
				   
	   }catch (Exception e) {
		   e.printStackTrace();
	   }
	   finally
	   {
		   CreateConnection.disConnection(conn, ps);
	   }
	   return vo;
   }
   // 인근 맛집 읽기
   public List<FoodVO>  seoulFoodFind(String addr)
   {
	   List<FoodVO> list=new ArrayList<FoodVO>();
	      try
	      {
	         conn=CreateConnection.getConnection();
	         String sql="SELECT fno,poster,name,type "
	               +"FROM food_location "
	               +"WHERE address LIKE '%'||?||'%' AND rownum<=12";
	         ps=conn.prepareStatement(sql);
	         ps.setString(1, addr);
	         ResultSet rs=ps.executeQuery();
	         while(rs.next())
	         {
	            FoodVO vo=new FoodVO();
	            vo.setFno(rs.getInt(1));
	            String poster=rs.getString(2);
	            poster=poster.substring(0,poster.indexOf("^")); // 포스터 5개씩 
	            vo.setPoster(poster);
	            vo.setName(rs.getString(3));
	            vo.setType(rs.getString(4));
	            list.add(vo);
	         }
	         
	      }catch(Exception ex)
	      {
	         ex.printStackTrace();
	      }
	      finally
	      {
	         CreateConnection.disConnection(conn, ps);
	      }
	      return list;
	   }

}

















