package com.sist.dao;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import com.sist.vo.MemberVO;
import com.sist.vo.ZipcodeVO;

import java.security.interfaces.RSAKey;
import java.sql.*;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	// 1. 회원 가입
	// 1-1) ID 중복 체크
	public int memberIdCheck(String id)
	{
		int count=0;
		try {
			conn=CreateConnection.getConnection();
			String sql="select count(*) from project_member "
					+ "where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs= ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			rs.close();
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			CreateConnection.disConnection(conn, ps);
		}
		return count;
	}
	// 1-2) 우편번호 검색
	public List<ZipcodeVO> memberPostFind(String dong)
	   {
		   List<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
		   try
		   {
			   conn=CreateConnection.getConnection();
			   String sql="SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') "
					     +"FROM zipcode "
					     +"WHERE dong LIKE '%'||?||'%'";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, dong);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   ZipcodeVO vo=new ZipcodeVO();
				   vo.setZipcode(rs.getString(1));
				   vo.setSido(rs.getString(2));
				   vo.setGugun(rs.getString(3));
				   vo.setDong(rs.getString(4));
				   vo.setBunji(rs.getString(5));
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
	   public int memberPostCount(String dong)
	   {
		   int count=0;
		   try
		   {
			   conn=CreateConnection.getConnection();
			   String sql="SELECT COUNT(*) "
					     +"FROM zipcode "
					     +"WHERE dong LIKE '%'||?||'%'";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, dong);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   count=rs.getInt(1);
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   CreateConnection.disConnection(conn, ps);
		   }
		   return count;
	   }
	// 1-3) Email 검색
	public int memberEmailCheck(String email)
	{
		int count=0;
		try {
			conn=CreateConnection.getConnection();
			String sql="select count(*) from project_member "
					+ "where email=?";
					
			ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs= ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			rs.close();
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			CreateConnection.disConnection(conn, ps);
		}
		return count;
	}
	// 1-4) 전화번호 검색
	public int memberPhoneCheck(String phone)
	{
		int count=0;
		try {
			conn=CreateConnection.getConnection();
			String sql="select count(*) from project_member "
					+ "where phone=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, phone);
			ResultSet rs= ps.executeQuery();
			rs.next();
			count=rs.getInt(1);
			rs.close();
					
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			CreateConnection.disConnection(conn, ps);
		}
		return count;
	}
	// 1. 회원 가입
	public void memberInsert(MemberVO vo)
	{
		try 
		{
			conn=CreateConnection.getConnection();
			// 'n' => user계정이여서 
			String sql="insert into project_member values(?,?,?,?,?,?,?,?,?,?,?,'n',sysdate)";
			ps=conn.prepareStatement(sql);
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
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			CreateConnection.disConnection(conn, ps);
			
		}
	}
	// 2. 로그인
	public MemberVO memberLogin(String id, String pwd)
	{
		MemberVO vo =new MemberVO();
		try
		{
			conn=CreateConnection.getConnection();
			String sql="select count(*) from project_member "
					+ "where id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			int count =rs.getInt(1);
			rs.close();
			///////////////////////////////// ID 존재 여부 확인
			
			if(count==0)
			{
				vo.setMsg("NOID");
			}
			else // ID존재
			{
				sql="select id, pwd,name, admin from project_member "
						+ "where id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				rs.next();
				String db_id =rs.getString(1);
				String db_pwd=rs.getString(2);
				String db_name =rs.getString(3);
				String db_admin=rs.getString(4);
				rs.close();
				
				if(db_pwd.equals(pwd))// 로그인
				{
					vo.setMsg("OK");
					vo.setId(db_id);
					vo.setName(db_name);
					vo.setAdmin(db_admin);
					
				}
				else // 비밀번호가 틀린 상태
				{
					vo.setMsg("NOPWD");
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			CreateConnection.disConnection(conn, ps);
		}
		
		return vo;
	}
	// 3. 회원 수정
	// 4. ID 찾기
	// 5. PWD 찾기
	// 6. 회원 탈퇴
}



























