package com.sist.common;
import java.sql.*;

public class CreateConneciton {
	private final String URL="jdbc:oracle:thim:@localhost:1521.XE";
	
	public  CreateConneciton()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception ex) {}
	}
	public Connection getConnection()
	{
		Connection conn=null;
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
		return conn;		
	}
	

	public void disConnection(PreparedStatement ps, Connection conn)
	{
		try {
			if(conn!=null) conn.close();
			if(ps!=null) ps.close();
		}catch(Exception ex) {}
	}
}























