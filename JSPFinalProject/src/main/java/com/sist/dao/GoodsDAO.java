package com.sist.dao;
import java.util.*;

import com.sist.vo.GoodsVO;

import java.sql.*;
public class GoodsDAO {
	private Connection conn;
	private PreparedStatement ps;
	
	// 기능
	// 1. 전체 출력
	public ArrayList<GoodsVO> goodsAllListData(int page)
	{
		ArrayList<GoodsVO> list = new ArrayList<GoodsVO>();
		try
		{
			conn=CreateConnection.getConnection();
			String sql ="select no, goods_name,goods_poster, num "
					+ "from (select no, goods_name,goods_poster, rownum as num "
					+ "from (select /*+ index_asc(goods_all ga_no_opk)*/ no, goods_name,goods_poster "
					+ "from goods_all)) "
					+ "where num between ? and ?";
			ps=conn.prepareStatement(sql);
			int rowSize =20;
			int start= (rowSize*page) -(rowSize-1);
			int end =(rowSize*page);
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				GoodsVO vo = new GoodsVO();
				vo.setNo(rs.getInt(1));
				vo.setGoods_name(rs.getString(2));
				vo.setGoods_poster(rs.getString(3));
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
	public int goodsAllTotalPage()
	{
		int total =0;
		try
		{
			conn=CreateConnection.getConnection();
			String sql="select ceil(count(*)/20.0) from goods_all";
			ps=conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
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
	// 2. 특가
	// 3. 베스트
	// 4. 신상품
}
