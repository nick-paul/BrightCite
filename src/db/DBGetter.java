package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Beans.Citation;
import Beans.Passage;
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
		Site site=new Site();
		try {
			site.setURL(rs.getString("url"));
			site.setSiteID(rs.getInt("siteID"));
			site.setSiteRating(rs.getFloat("siteRanking"));
			site.setPassanges(null);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return site;
	}
	protected static Passage getPassageBean(ResultSet rs)
	{
		Passage passage=new Passage();
		try {
			passage.setSiteID(rs.getInt("siteID"));
			passage.setPassageID(rs.getInt("passageID"));
			passage.setPassageRating(rs.getFloat("PassageRanking"));
			passage.setCitations(null);
			passage.setText(rs.getString("passageText"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(passage);		
	}
	protected static Citation getCitationBean(ResultSet rs)
	{
		Citation cite=new Citation();
		try {
			cite.setCitationID(rs.getInt("citationID"));
			cite.setFlagCount(rs.getInt("flagCount"));
			cite.setPassageID(rs.getInt("passageID"));
			cite.setPassageIntegrity(rs.getInt("passageIntegrity"));
			cite.setSource(rs.getString("source"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return(cite);
	}
	
	public static ArrayList<Passage> getAllPassages(int siteID) {
		ArrayList<Passage> passage = new ArrayList<Passage>();
		try {
			PreparedStatement ps = DBConnector.getConnection().prepareStatement(
					"SELECT * FROM passage where siteID =?;");
			ps.setInt(1,siteID );
			ResultSet rs = ps.executeQuery();
			
			
			while(rs.next()) {
				Passage p=getPassageBean(rs);
				p.setCitations(getAllCitations(p.getPassageID()));
				passage.add(p);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return passage;
	}
	public static ArrayList<Citation> getAllCitations(int passageID)
	{
		ArrayList<Citation> citations=new ArrayList<Citation>();
		try {
			PreparedStatement ps =DBConnector.getConnection().prepareStatement(
					"SELECT * FROM citation WHERE passageID = ?");
			ps.setInt(1,passageID);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				citations.add(getCitationBean(rs));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return citations;
	}
	public static Site getSite(String URL)
	{
		Site site=new Site();
		PreparedStatement ps;
		try {
			ps = DBConnector.getConnection().prepareStatement(
					"SELECT * FROM site WHERE url = ?");
			ps.setString(1,URL);
			ResultSet rs=ps.executeQuery();
			if (!rs.next()) {
				System.out.println("No rows");
				return null;
			}
			site=getSiteBean(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		site.setPassanges(getAllPassages(site.getSiteID()));
		return(site);
	}
}
