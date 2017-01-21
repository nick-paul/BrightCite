package Beans;

public class Citation {
	int citationID;
public int getCitationID() {
	return citationID;
}
public void setCitationID(int citationID) {
	this.citationID = citationID;
}
int passageID;
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
String source;
int passageIntegrity;
int flagCount;
}
