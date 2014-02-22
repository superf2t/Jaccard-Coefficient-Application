import java.util.ArrayList;


public class ShingleFile {
	
	Shingle s;
	ArrayList<Integer> docs;
	int trackingnum;
	
	public ShingleFile(Shingle shin, int docNum, int trackingNum)
	{
		s = shin;
		docs = new ArrayList<Integer>();
		docs.add(docNum);
		trackingnum = trackingNum;
		s.setTrackingNum(trackingNum);
	}
	
	public void addDocument(int num)
	{
		docs.add(num);
	}

}
