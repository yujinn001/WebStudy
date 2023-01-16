package com.sist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.sist.vo.BoardVO;

public class BoardDAO {
	 private Connection conn; // 미리 연결됨 (톰캣)
	 private PreparedStatement ps; // 송수신
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
	 // 기능 => JSTL / EL
	 //1. 목록
	 public ArrayList<BoardVO> boardListData(int page)
	 {
		 ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		 try
		 {
			 getConnection();
			 String sql ="SELECT no, subject,name,TO_CHAR(regdate,'yyyy-MM-dd'),hit, group_tab,num "
			 		+ "FROM (SELECT no, subject,name,regdate,hit, group_tab,rownum as num "
			 		+ "FROM(SELECT no, subject,name,regdate,hit, group_tab "
			 		+ "FROM replyboard ORDER BY group_id DESC, group_step ASC)) "
			 		+ "WHERE num BETWEEN ? AND ? ";
			 ps=conn.prepareStatement(sql);
			 int rowSize =10;
			 int start =(rowSize*page)-(rowSize-1);
			 int end =rowSize*page;
			 ps.setInt(1, start);
			 ps.setInt(2, end);
			 
			 ResultSet rs= ps.executeQuery();
			 while(rs.next())
			 {
				 BoardVO vo = new BoardVO();
				 vo.setNo(rs.getInt(1));
				 vo.setSubject(rs.getString(2));
				 vo.setName(rs.getString(3));
				 vo.setDbday(rs.getString(4));
				 vo.setHit(rs.getInt(5));
				 vo.setGroup_tab(rs.getInt(6));
				 
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
	 public int boardRowCount()
	 {
		 int count = 0;
		 try
		 {
			 getConnection();
			 String sql ="SELECT COUNT(*) FROM replyBoard ";
			 ps=conn.prepareStatement(sql);
			 ResultSet rs= ps.executeQuery();
			 rs.next();
			 count =rs.getInt(1);
			 rs.close();
		 }catch(Exception ex)
		 {
			 ex.printStackTrace();
		 }
		 finally
		 {
			 disConnection();
		 }
		 return count;	 
     }
	 
	 //2. 새글
	 
	 //3. 상세보기
	 //4. 답변 ***** => SQL(4)
	 //5. 수정
	 //6. 삭제 => SQL(4)
}




































