package Beans;

public class Passage {

	int siteID;
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
	int passageID;
	String text;
	float passageRating;
}
