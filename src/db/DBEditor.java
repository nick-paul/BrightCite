package db;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import Beans.Citation;
import Beans.Passage;
import Beans.Site;

public class DBEditor {

	public static void addNewCitation(Citation citation) throws SQLException {
		Connection conn = DBConnector.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO citation VALUES(0,?,?,?,0)"
				);
		
		ps.setInt(0, citation.getPassageID());
		ps.setString(1, citation.getSource());
		ps.setInt(2, citation.getPassageIntegrity());
		
		ps.execute();
	}
	
	public static void addNewPassage(Passage passage) throws SQLException {
		Connection conn = DBConnector.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO passage VALUES(0,?,?,?)"
				);
		
		ps.setInt(0, passage.getSiteID());
		ps.setString(1, passage.getText());
		ps.setFloat(2, passage.getPassageRating());
		
		ps.execute();
	}
	
	public static void addNewSite(Site site) throws SQLException {
		Connection conn = DBConnector.getConnection();
		PreparedStatement ps = conn.prepareStatement(
				"INSERT INTO site VALUES(0,?,?)"
				);
		
		ps.setString(0, site.getURL());
		ps.setFloat(1, site.getSiteRating());
		
		ps.execute();
	}
	
}
