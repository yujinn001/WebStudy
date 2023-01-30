package com.sist.dao;
import java.util.*;

import com.sist.vo.NoticeVO;

import java.sql.*;

public class NoticeDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	// 1. footer에 저장
	public List<NoticeVO> noticeTop5()
	{
		List<NoticeVO> list =new ArrayList<NoticeVO>();
		try {
			conn=CreateConnection.getConnection();
			String sql="select no, name, subject,to_char(regdate,'YYYY-MM-DD HH24:MI:SS') "
					+ "from (select no, name, subject, regdate "
					+ "from project_notice order by hit desc) "
					+ "where rownum<=5"; // Top-N (인기순위)
			ps =conn.prepareStatement(sql);
			ResultSet rs =ps.executeQuery();
			while(rs.next())
			{
				NoticeVO vo = new NoticeVO();
				vo.setNo(rs.getInt(1));
				vo.setName(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setDbday(rs.getString(4));
				list.add(vo);
			}
			rs.close();	
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally
		{
			CreateConnection.disConnection(conn, ps);
		}
		return list;
		
	}
}
