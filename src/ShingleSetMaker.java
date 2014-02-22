import java.util.ArrayList;


public class ShingleSetMaker {
	
	ArrayList<ShingleFile> shingleFileList;
	
	public ShingleSetMaker(ArrayList<ArrayList<Shingle>> arr)
	{
		shingleFileList = new ArrayList<ShingleFile>();
		
		for (int i = 0 ; i < arr.size(); i++)
		{
			for(int j = 0 ; j < arr.get(i).size(); j++)
			{
				Shingle holder = arr.get(i).get(j);
				
				int containsMethod = contains(holder);
				
				
				if (containsMethod >= 0)
				{
					shingleFileList.get(containsMethod).addDocument(i);
					holder.setTrackingNum(shingleFileList.get(containsMethod).trackingnum);
				}
				else
				{
					shingleFileList.add(new ShingleFile(holder,i, shingleFileList.size()));
				}
				
				}
		}
	}
	
	public int contains (Shingle s)
	{
		for (int i = 0 ; i < shingleFileList.size(); i++)
		{
			String w1 = shingleFileList.get(i).s.shingleHolder.get(0);
			String w2 = shingleFileList.get(i).s.shingleHolder.get(1);
			String w3 = shingleFileList.get(i).s.shingleHolder.get(2);
			
			if ((w1.equals(s.shingleHolder.get(0))) && (w2.equals(s.shingleHolder.get(1)))
					&& (w3.equals(s.shingleHolder.get(2))))
			{
				return i;
			}
		}
		
		return -10;
	}
	
	public ArrayList<ShingleFile> getshinglefilelist()
	{
		return shingleFileList;
	}

}
