
import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.ResultSet;

public abstract class JDBCDAO {
	private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	private final String DB_URL = "jdbc:mysql://localhost/nbg";
	
	private final String USER = "root";
	private final String PASS = "password";
	
	private Connection openConn() {
		Connection conn = null;
		
		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Esablishing database connection...");
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	private void closeConn(Connection conn, Statement stmt) {
		try {
			if (stmt !=null)
				stmt.close();
		}
		catch (SQLException se) {
			
		}
		
		try {
			if (conn != null)
				conn.close();
		}
		catch (SQLException se) {
			se.printStackTrace();
		}
		System.out.println("Database connection closed.");
	}
	
	protected ResultSet query(String query) {
		Connection conn = openConn();
		
		Statement stmt = null;
		ResultSet results = null;
		
		System.out.println("Reading data...");
		
		try {
		stmt = conn.createStatement();
		results = stmt.executeQuery(query);
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		//closeConn(conn, stmt);
		return results;
	}
	
	protected void update(String query) {
		Connection conn = openConn();
		
		Statement stmt = null;
		
		System.out.println("Updating data...");
		
		try {
		stmt = conn.createStatement();
		stmt.executeUpdate(query);
		}
		catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		closeConn(conn, stmt);
	}
}

