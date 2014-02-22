import java.util.ArrayList;
import java.util.StringTokenizer;


public class ShingleMaker {
	
	ArrayList<ArrayList<Shingle>> ShingleList;
	
	public ShingleMaker(ArrayList<String> arr)
	{
		ShingleList = new ArrayList<ArrayList<Shingle>>();
		
		for (int i = 0 ; i < arr.size();i++)
		{
			boolean first = true;
			ArrayList<Shingle> shingleArray = new ArrayList<Shingle>();
			
			//Make shingles!!!
			
			String s = arr.get(i);
			s=s.toUpperCase();
			
			StringTokenizer st = new StringTokenizer(s);
			
			String w1 = "";
			String w2 = "";
			String w3 = "";
			
			while (st.hasMoreTokens())
			{
				if (first == true)
				{
					 w1 = st.nextToken();
					 w2 = st.nextToken();
					 w3 = st.nextToken();	
					first = false;
				}
				else
				{
					w1 = w2;
					w2 = w3;
					w3 = st.nextToken();
					
				}
				
				Shingle shin = new Shingle(w1,w2,w3);
				if (!(shingleArray.contains(shin)))
				{
				shingleArray.add(shin);
				}
				
			
			}
			
			ShingleList.add(shingleArray);
			
			
		}
	}
	
	public ArrayList<ArrayList<Shingle>> getShingleList()
	{
		return ShingleList;
	}

}
