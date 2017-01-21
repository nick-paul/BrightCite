package Beans;

import java.util.ArrayList;

public class Site {
	int siteID;
	String URL;
	float siteRating;
	ArrayList<Passage> passanges;
	
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
	
}
