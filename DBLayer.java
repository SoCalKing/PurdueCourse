import java.security.DrbgParameters.Reseed;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBLayer {
	private Connection conn = null;
	private String jdbcURL;
	public DBLayer() {
		jdbcURL =
				"jdbc:sqlserver://LAPTOP-D3JARR3N\\SQLEXPRESS.Northwind;"
				+ "database=Northwind;"
				+ "encrypt=false;"
				+ "trustServerCertificate=false;"
				+ "loginTimeout=10;";
		
		
		
	}
	public DBLayer(String connection) {
		jdbcURL = connection;
		
	}
	
	public String getCustomerCount() {
		String count = null;
		
		try {
				
				conn = DriverManager.getConnection(jdbcURL);
				
				if(conn != null) {
					String countQuery = "SELECT COUNT(*) AS COUNT FROM Customers;";
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(countQuery);
					
					while(rs.next()) {
						
						count = rs.getString("COUNT");		
					}
					
					
				}
			
			
		}catch (SQLException ex) {
			ex.printStackTrace();	
		}finally 	{
			try {
					if(conn != null && !conn.isClosed()) {
							conn.close();
						
					}
				
			}catch(SQLException ex) {
				ex.printStackTrace();
					
			}
		}
		return count;
				
	}
	public String getCustomerNames() {
			String result = "";
			
			try {
				
					conn = DriverManager.getConnection(jdbcURL);
					
					if(conn !=null) {
					String countQuery = "Select ContactName from Customers;";	
					Statement stmt = conn.createStatement();
					ResultSet rs = stmt.executeQuery(countQuery);
					
					while (rs.next()) {
						result += rs.getString("ContactName")+"\n";
						
						}
					}
				
			}catch		(SQLException ex) {
						ex.printStackTrace();
							
			}finally {
					try {
							if(conn != null && !conn.isClosed()){
									conn.close();
								
							}
					}catch(SQLException ex) {
							ex.printStackTrace();
					}
			}
			return result;
		}			
}

