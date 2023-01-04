package com.sist.dao;
import java.util.*;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

public class foodDAO {
	private Connection conn;
	private PreparedStatement ps;
	// DBCP => 웹에서만 사용이 가능 (Connection 생성 => 톰캣에서 생성
	// Connec tion의 갯수를 관리할 수 있기 때문에 쉽게 다운로드가 되지 않는다
	// JDBC =DBCP =ORM (Mybatis, JPA)
	public void getConnection() // 미리 만들어진 Connection 객체를 가지고 온다
	{
		try
		{
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void disConnection() // 재사용을 위해서 반환해준다
	{
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
