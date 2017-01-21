package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Beans.Site;

/* Gets stuff from the database */
public class DBGetter {
	
	// Get a test string
	public static String getTestCity() throws SQLException {
		Connection conn = DBConnector.getConnection();
		PreparedStatement ps = conn.prepareStatement("select * from city limit 10");
		ResultSet rs = ps.executeQuery();

		String out = "";
		
		if (!rs.next()) {
			out = "no data";
		} else {
			out = rs.getString("Name");
		}			
		
		return out;
	}
	protected static Site getSiteBean(ResultSet rs)
	{
		//Site site=new Site();
		return null;
	}
	
}
