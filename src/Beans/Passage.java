package Beans;

import java.util.ArrayList;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class Passage {
	ArrayList<Citation> citations;
	int siteID;
	int passageID;
	String text;
	float passageRating;
	
	public Passage() {
		citations = null;
		siteID = 0;
		passageID = 0;
		text = "";
		passageRating = 0.0f;
	}
	
	public static Passage newPassage(int siteID, String text) {
		Passage p = new Passage();
		p.setSiteID(siteID);
		p.setText(text);
		return p;
	}
	
	
	
	public ArrayList<Citation> getCitations() {
		return citations;
	}
	public void setCitations(ArrayList<Citation> citations) {
		this.citations = citations;
	}

	public int getSiteID() {
		return siteID;
	}
	public void setSiteID(int siteID) {
		this.siteID = siteID;
	}
	public int getPassageID() {
		return passageID;
	}
	public void setPassageID(int passageID) {
		this.passageID = passageID;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public float getPassageRating() {
		return passageRating;
	}
	public void setPassageRating(float passageRating) {
		this.passageRating = passageRating;
	}
	
	
	protected JsonObject getJsonObject() {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("text", text);
		job.add("passageRating", passageRating);
		
		JsonArrayBuilder cites = Json.createArrayBuilder();
		for (Citation cite : citations) {
			cites.add(cite.getJsonObject());
		}
		job.add("citations", cites);
		
		return job.build();
	}
}
