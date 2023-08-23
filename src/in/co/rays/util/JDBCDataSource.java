package in.co.rays.util;


import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public  final class JDBCDataSource {

	private static JDBCDataSource jds=null;
	
	private ComboPooledDataSource ds=null;
	
	private JDBCDataSource() {
		
		try {
			ds = new ComboPooledDataSource();
			
			ds.setDriverClass("com.mysql.cj.jdbc.Driver");
			ds.setJdbcUrl("jdbc:mysql://localhost:3306/advance_java");
			ds.setUser("root");
			ds.setPassword("root");
			ds.setInitialPoolSize(5);
			ds.setAcquireIncrement(5);
			ds.setMaxPoolSize(50);
		}catch(PropertyVetoException e) {
			e.printStackTrace();
			
		}
		
		}
	public static JDBCDataSource getInstance() {
		if(jds==null) {
			jds=new JDBCDataSource();
		}
		return jds;
	}
	public static Connection getConnection() {
		try {
			return getInstance().ds.getConnection();
		}
		catch(SQLException e) {
			
		
		return null;
		}
		}
	public static void closeConnection(
			Connection conn,Statement stmt,ResultSet rs)
	{
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			if(conn!=null)conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	public static void closeConnection(
	Connection conn,Statement stmt) {
		closeConnection(conn,stmt,null);
	}
			 public static void closeConnection(Connection conn, Statement stmt, Object object) {
				 closeConnection(conn,null,null);
			 }
					 
	}
	