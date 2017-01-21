package Beans;

import java.util.ArrayList;

public class RankUtilities {

public static final float noReviews=Float.MAX_VALUE;

	public float evaluatePassage(ArrayList<Citation> citations) {
		float Rating;
		if (citations.size()!=0){
			Rating=0;
			for(Citation cite:citations)
			{
				Rating+=((1/(cite.getFlagCount()+1))*cite.getPassageIntegrity());	
			}
		}
		else{
		Rating=noReviews;
		}
		return Rating;	
	}
	public float evaluateSite(ArrayList<Passage> passages)
	{
		float Rating=0;
		for(Passage passage:passages)
		{
			Rating+=passage.getPassageRating();
		}
		Rating/=passages.size();
		return(Rating);
	}
}
