package com.sist.dao;
import java.util.*;

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
   //1.1목록
   //1.1_1 총페이지
   //1.2상세

}