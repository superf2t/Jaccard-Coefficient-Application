import java.util.ArrayList;


public class Shingle {
	
	ArrayList<String> shingleHolder;
	int trackingNum;
	
	public Shingle(String w1, String w2, String w3)
	{
		shingleHolder = new ArrayList<String>();
		shingleHolder.add(w1);
		shingleHolder.add(w2);
		shingleHolder.add(w3);
	}
	
	public ArrayList<String> getShingles()
	{
		return shingleHolder;
	}
	
	public void setTrackingNum(int i)
	{
		trackingNum = i;
	}

}
