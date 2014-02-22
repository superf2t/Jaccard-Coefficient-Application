import java.util.ArrayList;


public class SketchMaker {
	
	ArrayList<ArrayList<Shingle>> sketches;

	public SketchMaker (ArrayList<ArrayList<Shingle>> shingles, ArrayList<ShingleFile> fullShingles, 
			ArrayList<Integer> a, ArrayList<Integer> b )
	{
		
		sketches = new ArrayList<ArrayList<Shingle>>();
		
		for (int i = 0 ; i < shingles.size(); i++)
		{
			ArrayList<Shingle> s = new ArrayList<Shingle>();
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			ArrayList<Integer> values = new ArrayList<Integer>();
			int count = 0;
			for (int j = 0 ; j < shingles.get(i).size(); j++)
			{
				int label = shingles.get(i).get(j).trackingNum;
				
				//System.out.println(a.get(count) + " , " + b.get(count));
				
				int value = ((a.get(count)*label) + b.get(count)) % 23788;
				
				
				indexes.add(j);
				values.add(value);
				
				count++;
				
				if (count == 25)
				{
					count = 0;
				}
				
			}
			
			for (int k = 0; k <25; k++)
			{
				int min = values.get(0);
				int index = 0;
				
				for (int t = 0 ; t < values.size(); t++)
				{
					if (values.get(t) < min)
					{
						min = values.get(t);
						index = t;
					}
				}
				
			int label = shingles.get(i).get(indexes.get(index)).trackingNum;
		//	System.out.println(label+": "+min +" , " +shingles.get(i).get(indexes.get(index)).shingleHolder.get(0));
				
				s.add(shingles.get(i).get(indexes.get(index)));
				indexes.remove(index);
				values.remove(index);
			}
			//System.out.println();
			
			sketches.add(s);
		}
	}
	
	public ArrayList<ArrayList<Shingle>> getSketches()
	{
		return sketches;
	}
}
