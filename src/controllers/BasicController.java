package controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import Beans.Passage;
import Beans.Site;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.DBConnector;
import db.DBEditor;
import db.DBGetter;


/*
 * 
 * Controllers will be doing all of the computational work. Controllers may call
 * methods in other class files, access data from the client and server and 
 * perform any calculations needed. They always return a string that describes
 * the path of the .jsp file that the user will be forwarded to
 * 
 * 
 */
public class BasicController {

	
	/*
	 * This is a basic controller example method. 
	 * This method will get the name from the form that the user submitted,
	 *   make it all uppercase, and then give it back to the client.
	 * It will also create a timestamp of when the request was processed.
	 */
	public static String nameForm(HttpServletRequest request) {
		
		//We can access our form information using the getParameter() method
		//In the file home.jsp, we named the text input "myName".
		String name = request.getParameter("myName");
		
		//Make the name all uppercase
		String upperName = name.toUpperCase();
		
		//We can sent information to the jsp file using the setAttribute() method
		//We will call the name "helloName"
		request.setAttribute("helloName", upperName);
		
		
		//We can also set attributes to be things other than strings
		request.setAttribute("processTime", new Date());
		
		//These values will be accessed in the sayHello.jsp file
		
		//Always return the path to the jsp file we want to take the user to
		return "hello/sayHello.jsp";
	}

	public static String colorForm(HttpServletRequest request) {
		String hexColor = request.getParameter("color");
		
		request.setAttribute("bgColor", "#"+hexColor);
		
		System.out.println(hexColor);
		
		
		
		return "home.jsp";
	}

	public static String getsite(HttpServletRequest request) {
		String url = request.getParameter("url");
		url = url.trim();
		
		System.out.println("site: " + url);
		
		Site site = DBGetter.getSite(url);
		
		if (site == null) {
			return "home.jsp";
		}
		
		request.setAttribute("siteinfo", site);
		
		return "dashboard.jsp";
	}

	public static String newPassage(HttpServletRequest request) throws SQLException {
		String passage_str = request.getParameter("passage");
		String url = request.getParameter("url").trim();
		
		Site site = DBGetter.getSite(url);
		if (site == null) {
			site = Site.newSite(url);
			DBEditor.addNewSite(site);
			site = DBGetter.getSite(url);
		}
		
		Passage passage = Passage.newPassage(site.getSiteID(), passage_str);
		
		DBEditor.addNewPassage(passage);
		
		//Refresh the site
		site = DBGetter.getSite(url);
		
		request.setAttribute("siteinfo", site);
		
		return "dashboard.jsp";
	}
	
}
