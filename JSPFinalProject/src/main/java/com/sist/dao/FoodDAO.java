package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;

// DAO => Model =>(DispatcherServlet) JSP
public class FoodDAO {
	private Connection conn;
	private PreparedStatement ps; 
	
	// 기능
	// 1. 카테고리 읽기
	public ArrayList<CategoryVO> foodCategoryData()
	{
		ArrayList<CategoryVO> list = new ArrayList<CategoryVO>();
		try
		{
			conn=CreateConnection.getConnection();
			String sql ="SELECT /*+ index_asc(project_category pc_cno_pk) */cno, title,subject,poster "
					+ "from project_category";
			ps =conn.prepareStatement(sql);
			ResultSet rs= ps.executeQuery();
			while(rs.next())
			{
				CategoryVO vo = new CategoryVO();
				vo.setCno(rs.getInt(1));
				vo.setTitle(rs.getString(2));
				vo.setSubject(rs.getString(3));
				vo.setPoster(rs.getString(4));
				
				list.add(vo);
			}
			rs.close();
		}catch(Exception ex)
		{
			
		}
		finally
		{
			CreateConnection.disConnection(conn, ps);
		}
		return list;
	}
}
