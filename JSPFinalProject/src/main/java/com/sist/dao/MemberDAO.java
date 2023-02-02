package com.sist.dao;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sist.vo.MemberVO;
import com.sist.vo.ZipcodeVO;

import java.sql.*;

public class MemberDAO {
   private Connection conn;
   private PreparedStatement ps;
   
   // 1. 회원가입
   /*
       이름       널?       유형            
   -------- -------- ------------- 
   ID       NOT NULL VARCHAR2(20)  
   PWD      NOT NULL VARCHAR2(10)  
   NAME     NOT NULL VARCHAR2(34)  
   SEX               VARCHAR2(6)   
   BIRTHDAY NOT NULL VARCHAR2(15)  
   EMAIL             VARCHAR2(50)  
   POST     NOT NULL VARCHAR2(7)   
   ADDR1    NOT NULL VARCHAR2(200) 
   ADDR2             VARCHAR2(200) 
   PHONE    NOT NULL VARCHAR2(20)  
   CONTENT           CLOB          
   ADMIN             CHAR(1)       
   RGDATE            DATE
 */
   // 1. ID 중복체크///////////////////////////////////////////////////////////////
   public int memberIdCheck(String id) {
      int count = 0;
      try {
         conn = CreateConnection.getConnection();
         String sql = "SELECT COUNT(*) FROM project_member "
               +"WHERE id=?";
         ps = conn.prepareStatement(sql);
         ps.setString(1, id);
         ResultSet rs = ps.executeQuery();
         rs.next();
         count = rs.getInt(1); 
         rs.close();
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         CreateConnection.disConnection(conn, ps);
         
      }
      return count;
   }
   // 2. 우편번호 검색///////////////////////////////////////////////////////////////
   public List<ZipcodeVO> memberPostFind(String dong){
      List<ZipcodeVO> list = new ArrayList<ZipcodeVO>();
      try {
         conn = CreateConnection.getConnection();
         String sql = "SELECT zipcode, sido, gugun, dong, NVL(bunji,' ') "
               +"FROM zipcode "
               +"WHERE dong LIKE '%'||?||'%'";
         ps = conn.prepareStatement(sql);
         ps.setString(1, dong);
         ResultSet rs = ps.executeQuery();
         while(rs.next()) {
            ZipcodeVO vo = new ZipcodeVO();
            vo.setZipcode(rs.getString(1));
            vo.setSido (rs.getString(2));
            vo.setGugun(rs.getString(3));
            vo.setDong(rs.getString(4));
            vo.setBunji(rs.getString(5));
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
   
   public int memberPostCount(String dong) { // 검색결과가 있는지 없는지 확인
      int count = 0;
      try {
         conn = CreateConnection.getConnection();
         String sql = "SELECT COUNT(*) "
               +"FROM zipcode "
               +"WHERE dong LIKE '%'||?||'%'";
         ps = conn.prepareStatement(sql);
         ps.setString(1, dong);
         ResultSet rs = ps.executeQuery();
         rs.next();
         count = rs.getInt(1);
         rs.close();
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         CreateConnection.disConnection(conn, ps);
      }
      return count;
   }
   
   // 3. Email검색///////////////////////////////////////////////////////////////
   public int memberEmailCheck(String email) {
      int count = 0;
      try {
         conn = CreateConnection.getConnection();
         String sql = "SELECT COUNT(*) FROM project_member "
               +"where email = ?";
         ps = conn.prepareStatement(sql);
         ps.setString(1, email);
         ResultSet rs = ps.executeQuery();
         rs.next();
         count = rs.getInt(1); 
         rs.close();
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         CreateConnection.disConnection(conn, ps);
         
      }
      return count;
   
   }
   // 4. 전화번호 검색///////////////////////////////////////////////////////////////
   public int memberPhoneCheck(String phone) {
      int count = 0;
      try {
         conn = CreateConnection.getConnection();
         String sql = "SELECT COUNT(*) FROM project_member "
               +"where phone = ?";
         ps = conn.prepareStatement(sql);
         ps.setString(1, phone);
         ResultSet rs = ps.executeQuery();
         rs.next();
         count = rs.getInt(1); 
         rs.close();
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         CreateConnection.disConnection(conn, ps);
         
      }
      return count;
   }
   // 회원가입
   public void memberInsert(MemberVO vo) {
      try {
         conn = CreateConnection.getConnection();
         String sql = "INSERT INTO project_member VALUES(?,?,?,?,?,?,?,?,?,?,?,'n',SYSDATE)";
         ps = conn.prepareStatement(sql);
         ps.setString(1, vo.getId());
         ps.setString(2, vo.getPwd());
         ps.setString(3, vo.getName());
         ps.setString(4, vo.getSex());
         ps.setString(5, vo.getBirthday());
         ps.setString(6, vo.getEmail());
         ps.setString(7, vo.getPost());
         ps.setString(8, vo.getAddr1());
         ps.setString(9, vo.getAddr2());
         ps.setString(10, vo.getPhone());
         ps.setString(11, vo.getContent());
         ps.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         CreateConnection.disConnection(conn, ps);
      }
   }
   // 2. 로그인
   public MemberVO memberLogin(String id, String pwd) {
      MemberVO vo = new MemberVO();
      try {
         conn = CreateConnection.getConnection();
         String sql = "select count(*) from project_member "
               +"where id=?";
         ps = conn.prepareStatement(sql);
         ps.setString(1, id);
         ResultSet rs = ps.executeQuery();
         rs.next();
         int count = rs.getInt(1);
         rs.close();
         //----------------------------------ID존재여부 확인
         if(count==0) {
            vo.setMsg("NOID");
         }else { // 아이디 존재
            sql = "select id, pwd, name, admin from project_member "
                  +"WHERE id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            rs = ps.executeQuery();
            rs.next();
            String db_id = rs.getString(1);
            String db_pwd = rs.getString(2);
            String db_name = rs.getString(3);
            String db_admin = rs.getString(4);
            
            rs.close();
            
            if(db_pwd.equals(pwd)) { // 로그인 된 상태
               vo.setMsg("OK");
               vo.setId(db_id);
               vo.setName(db_name);
               vo.setAdmin(db_admin);
            }else { // 비번 틀린 상태
               vo.setMsg("NOPWD");
            }
            
         }
         
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         CreateConnection.disConnection(conn, ps);
      }
      return vo;
   }
   
   
   // 3. 회원수정 /////////////////////////////////////////////////////////
   public MemberVO memberJoinUpdateData(String id) {
      MemberVO vo = new MemberVO();
      try {
         conn = CreateConnection.getConnection();
         String sql = "select id, name, sex, birthday, email, post, addr1, addr2, phone, content "
               +"from project_member "
               +"where id=?";
         ps = conn.prepareStatement(sql);
         ps.setString(1, id);
         
         ResultSet rs = ps.executeQuery();
         rs.next();
         vo.setId(rs.getString(1));
         vo.setName(rs.getString(2));
         vo.setSex(rs.getString(3));
         vo.setBirthday(rs.getString(4));
         vo.setEmail(rs.getString(5));
         vo.setPost(rs.getString(6));
         vo.setAddr1(rs.getString(7));
         vo.setAddr2(rs.getString(8));
         vo.setPhone(rs.getString(9));
         vo.setContent(rs.getString(10));
         rs.close();
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         CreateConnection.disConnection(conn, ps);
      }
      
      return vo;
   }
   
   // 실제 회원수정 //
   public boolean memberJoinUpdate(MemberVO vo)
   {
      boolean bCheck=false;
      try
      {
         conn=CreateConnection.getConnection();
         String sql="SELECT pwd FROM project_member "
               +"WHERE id=?";
         ps=conn.prepareStatement(sql);
         ps.setString(1, vo.getId());
         ResultSet rs=ps.executeQuery();
         rs.next();
         String db_pwd=rs.getString(1);
         rs.close();
         
         if(db_pwd.equals(vo.getPwd()))
         {
            bCheck=true;
            sql="UPDATE project_member SET "
                  +"name=?,sex=?,email=?,phone=?,content=?,birthday=?,"
                  +"post=?,addr1=?,addr2=? "
                  +"WHERE id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1, vo.getName());
            ps.setString(2, vo.getSex());
            ps.setString(3, vo.getEmail());
            ps.setString(4, vo.getPhone());
            ps.setString(5, vo.getContent());
            ps.setString(6, vo.getBirthday());
            ps.setString(7, vo.getPost());
            ps.setString(8, vo.getAddr1());
            ps.setString(9, vo.getAddr2());
            ps.setString(10, vo.getId());
            
            ps.executeUpdate();
         }
      }catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         CreateConnection.disConnection(conn, ps);
      }
      return bCheck;
   }


   
   
   
   // 4. ID 찾기 (전화번호)/////////////////////////////////////////////////////////
   public String memberIdfind(String tel) {
      String result="";
      try {
         conn = CreateConnection.getConnection();
         String sql = "select count(*) from project_member "
               +"where phone=?";
         ps = conn.prepareStatement(sql);
         ps.setString(1, tel);
         ResultSet rs = ps.executeQuery();
         rs.next();
         int count = rs.getInt(1);
         rs.close();
         
         if(count == 0) {
            result="NO";
         }else {
            sql = "SELECT RPAD(substr(id,1,1),LENGTH(id), '*') from project_member "
                  +"where phone=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, tel);
            rs=ps.executeQuery();
            rs.next();
            result = rs.getString(1);
            rs.close();
            
         }
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         CreateConnection.disConnection(conn, ps);
      }
      return result;
      
   }
   // 아이디 찾기=> 이메일
   public String memberEmailfind(String email) {
      String result="";
      try {
         conn = CreateConnection.getConnection();
         String sql = "select count(*) from project_member "
               +"where email=?";
         ps = conn.prepareStatement(sql);
         ps.setString(1, email);
         ResultSet rs = ps.executeQuery();
         rs.next();
         int count = rs.getInt(1);
         rs.close();
         
         if(count == 0) {
            result="NO";
         }else {
            sql = "SELECT RPAD(substr(id,1,1),LENGTH(id), '*') from project_member "
                  +"where email=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            rs=ps.executeQuery();
            rs.next();
            result = rs.getString(1);
            rs.close();
            
         }
      } catch (Exception e) {
         e.printStackTrace();
      }finally {
         CreateConnection.disConnection(conn, ps);
      }
      return result;
      
   }
   // 5. PWD 찾기 =>  /////////////////////////////////////////////////////////
   // 6. 회원탈퇴 /////////////////////////////////////////////////////////
   public boolean memberJoinDelete(String id,String pwd)
   {
      boolean bCheck=false;
      try
      {
         conn=CreateConnection.getConnection();
         String sql="SELECT pwd FROM project_member "
               +"WHERE id=?";
         ps=conn.prepareStatement(sql);
         ps.setString(1, id);
         ResultSet rs=ps.executeQuery();
         rs.next();
         String db_pwd=rs.getString(1);
         rs.close();
         
         if(db_pwd.equals(pwd))
         {
            bCheck=true;
            sql="DELETE FROM project_member "
                  +"WHERE id=?";
            ps=conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();
         }
      }catch(Exception ex)
      {
         ex.printStackTrace();
      }
      finally
      {
         CreateConnection.disConnection(conn, ps);
      }
      return bCheck;
   }



}