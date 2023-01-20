package com.sist.dao;

import java.util.*;

import com.sist.vo.FreeBoardVO;

import java.sql.*;
					 

							 
/*
    select , delete, update, insert
    인라인뷰 / 조인 / 서브쿼리 
    
					 
			   
							
							
							 
		 
				 
			  
		
									 
 */
public class FreeBoardDAO {
   private Connection conn;
   private PreparedStatement ps;
   
   // 목록 출력 ///////////////////////////////////////////////////
   ///////////////////////////////////////////////////
   public List<FreeBoardVO> BoardListData(int page){ // 스프링은 arraylist보단 list를 사용
  
      List<FreeBoardVO> list = new ArrayList<FreeBoardVO>();
      try {
   
         conn = CreateConnection.getConnection();
         String sql = "select no,subject,name,TO_CHAR(regdate,'YYYY-MM-DD'), hit,num "
               +"from (select no,subject,name,regdate, hit,rownum as num "
               +"from (select /*+INDEX_DESC(project_freeboard pf1_no_pk)*/ no,subject,name,regdate, hit "
               +"from project_freeboard)) "
               +"where num between ? and ?";
         ps = conn.prepareStatement(sql); // sql문장을 오라클로 전송 => 나중에 값을 채워서 실행
         int rowSize = 10;
         int start = (rowSize*page) - (rowSize-1);
         int end = rowSize*page;
         ps.setInt(1, start);
         ps.setInt(2, end);
         ResultSet rs = ps.executeQuery(); // 뭘 실행?
         while(rs.next()) {
	
            FreeBoardVO vo = new FreeBoardVO();
            vo.setNo(rs.getInt(1));
            vo.setSubject(rs.getString(2));
            vo.setName(rs.getString(3));
            vo.setDbday(rs.getString(4));
            vo.setHit(rs.getInt(5));
            
            list.add(vo);
         }
         rs.close();
               
      } catch (Exception e) {
   
         e.printStackTrace();
   
      }finally {
   
         CreateConnection.disConnection(conn, ps);
      }
      return list;
   }
   
   // 총 페이지 ///////////////////////////////////////////////////
   ///////////////////////////////////////////////////
   public int boardTotalPage() {
  
      int total=0;
      try {
   
         conn = CreateConnection.getConnection();
         String sql = "select ceil(count(*)/10.0) from project_freeboard";
         ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery();
         rs.next();
         total = rs.getInt(1);
         rs.close();
      } catch (Exception e) {
         // TODO: handle exception
         e.printStackTrace();
   
      }finally {
   
         CreateConnection.disConnection(conn, ps);
      }
      return total;
   }
   // 추가
   public void boardInsert(FreeBoardVO vo)
   {
	   try
	   {
		   conn=CreateConnection.getConnection();
		   String sql ="insert into project_freeboard(no,name,subject,content, pwd) "
		   		+ "values(pf_no_seq.nextval, ?,?,?,?) ";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, vo.getName());
		   ps.setString(2, vo.getSubject());
		   ps.setString(3, vo.getContent());
		   ps.setString(4, vo.getPwd());
		   // 실행 명령 => commit => excuteUpdate() => commit
		   ps.executeUpdate();
		   
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   CreateConnection.disConnection(conn, ps);
		   
	   }
   }
   // 상세보기
   public FreeBoardVO boardDetailData(int no)
   {
      FreeBoardVO vo=new FreeBoardVO();
      try
      {
         conn=CreateConnection.getConnection();
         String sql="UPDATE project_freeboard SET "
               +"hit=hit+1 "
               +"WHERE no=?";
         ps=conn.prepareStatement(sql);
         ps.setInt(1, no);
         ps.executeUpdate();
         ////////////////// 조회수 증가
         // 실제 게시물 번호에 해당되는 데이터를 가지고 온다 * => database에 출력 순서로 읽는다 
         sql="SELECT no,name,subject,content,TO_CHAR(regdate,'YYYY-MM-DD'),hit "
               +"FROM project_freeboard "
               +"WHERE no=?";
         ps=conn.prepareStatement(sql);
         ps.setInt(1, no); // 채우지 않으면 IN OUT 오류
         ResultSet rs=ps.executeQuery();
         rs.next();
         vo.setNo(rs.getInt(1));
         vo.setName(rs.getString(2));
         vo.setSubject(rs.getString(3));
         vo.setContent(rs.getString(4));
         vo.setDbday(rs.getString(5));
         vo.setHit(rs.getInt(6));
         rs.close();
      }catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         CreateConnection.disConnection(conn, ps);
      }
      return vo;
   }										  
   // 수정									  
   // 삭제
   // 검색 -> 다중검색
   // 댓글  => 프로시저
 
}





















