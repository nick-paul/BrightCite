package Beans;

import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class Site {
	int siteID;
	String URL;
	float siteRating;
	ArrayList<Passage> passanges;
	
	public Site() {
		this.siteID = 0;
		this.URL = "";
		this.siteRating = 0.0f;
		this.passanges = null;
	}
	
	public static Site newSite(String url) {
		Site s = new Site();
		s.setURL(url);
		return s;
	}
	
	public ArrayList<Passage> getPassanges() {
		return passanges;
	}
	public void setPassanges(ArrayList<Passage> passanges) {
		this.passanges = passanges;
	}
	public int getSiteID() {
		return siteID;
	}
	public void setSiteID(int siteID) {
		this.siteID = siteID;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String url) {
		URL = url;
	}
	public float getSiteRating() {
		return siteRating;
	}
	public void setSiteRating(float siteRating) {
		this.siteRating = siteRating;
	}
	
	
	
	protected JsonObject getJsonObject() {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("url", URL);
		job.add("siteRating", siteRating);
		
		JsonArrayBuilder psgsJson = Json.createArrayBuilder();
		for (Passage psg : passanges) {
			psgsJson.add(psg.getJsonObject());
		}
		job.add("passages", psgsJson);
		
		return job.build();
	}
	
	public String getJsonSring() {
		return getJsonObject().toString();
	}
	
}
