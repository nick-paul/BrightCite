package Beans;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

public class Citation {
	int citationID;
	int passageID;
	String source;
	int passageIntegrity;
	int flagCount;
	
	
	public Citation() {
		this.citationID = 0;
		this.passageID = 0;
		this.source = "";
		this.passageIntegrity = 0;
		this.flagCount = -1;
	}
	
	public static Citation newCitation(String source, int passageID) {
		Citation c = new Citation();
		c.setSource(source);
		c.setPassageID(passageID);
		return c;
	}
	
	
public int getCitationID() {
	return citationID;
}
public void setCitationID(int citationID) {
	this.citationID = citationID;
}
public int getPassageID() {
	return passageID;
}
public void setPassageID(int passageID) {
	this.passageID = passageID;
}
public String getSource() {
	return source;
}
public void setSource(String source) {
	this.source = source;
}
public int getPassageIntegrity() {
	return passageIntegrity;
}
public void setPassageIntegrity(int passageIntegrity) {
	this.passageIntegrity = passageIntegrity;
}
public int getFlagCount() {
	return flagCount;
}
public void setFlagCount(int flagCount) {
	this.flagCount = flagCount;
}




	protected JsonObject getJsonObject() {
		JsonObjectBuilder job = Json.createObjectBuilder();
		job.add("source", source);
		job.add("passageIntegrity", passageIntegrity);
		job.add("flagCount", flagCount);
		return job.build();
	}

}
