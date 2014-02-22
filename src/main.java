import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ParserClass pc = new ParserClass("test");
		ArrayList<String> documents = pc.getDocuments();
		
		ShingleMaker sm = new ShingleMaker(documents);
		ArrayList<ArrayList<Shingle>> shinglelis = sm.getShingleList();	
		
		
		ShingleSetMaker ssm = new ShingleSetMaker(shinglelis);
		ArrayList<ShingleFile> shin = ssm.getshinglefilelist();
		
		ArrayList<Integer> intsas = new ArrayList<Integer>();
		while (intsas.size() < 25)
		{
			Random rand = new Random();
			int randomNum = rand.nextInt(23787 -1 + 1) +1;
			
			if (!(intsas.contains(randomNum)))
			{
				intsas.add(randomNum);
			}
		}
		
		ArrayList<Integer> intsbs = new ArrayList<Integer>();
		while (intsbs.size() < 25)
		{
			Random rand = new Random();
			int randomNum = rand.nextInt(23787  + 1) ;
			
			if (!(intsbs.contains(randomNum)))
			{
				intsbs.add(randomNum);
			}
		}
		
		
	SketchMaker sketcher = new SketchMaker(shinglelis, shin, intsas, intsbs);
	ArrayList<ArrayList<Shingle>> sketches = sketcher.getSketches(); 
	
/*	for (int i = 0 ; i <sketchessize(); i++)
	{
		for (int j = 0 ; j < sketches.get(i).size(); j++)
		{
			System.out.print
		}
	} */
	
	ArrayList<ArrayList<Double>> indexes = new ArrayList<ArrayList<Double>>();
	
	for (int i = 0; i < sketches.size(); i++)
	{
		ArrayList<Double> a = new ArrayList<Double>();
		indexes.add(i,a);
		ArrayList<ArrayList<Shingle>> newArraySketches = new ArrayList<ArrayList<Shingle>>(sketches);
		
		ArrayList<Shingle> curr = newArraySketches.get(i);	
		
		for (int j = 0 ; j < newArraySketches.size(); j++)
		{
			double similaries = ((similar(curr, newArraySketches.get(j))) / 25);
			
			if (similaries >= .5 && i != j)
			{
				System.out.println("Document "+ i+ " - Document "+ j+ " Jaccard coefficient: " + similaries);
			}
			
			if ( i <10)
			{
				indexes.get(i).add(j,similaries);
			}
		}
	}
	
		sortMeth(indexes);
		
	}
	
	public static void sortMeth(ArrayList<ArrayList<Double>> arr)
	{	
		System.out.println();
		for (int i = 0; i< 10 && i <arr.size() ; i++)
		{
			ArrayList<Double> d = arr.get(i);
			d.set(i, -100.0);
			Double max = Collections.max(d);
			int index =0;
			
			for (int j = 0; j < d.size(); j++)
			{
				if  (d.get(j) ==max)
				{
					d.set(j,0.0);
					index = j;
					break;
				}
			}
			
			double max2 = Collections.max(d);
			int index1 =0;
			
			for (int j = 0; j < d.size(); j++)
			{
				if  (d.get(j) ==max2 && j != index)
				{
					d.set(j,0.0);
					index1 = j;
					break;
				}
			}
			
			double max3 = Collections.max(d);
			int index2 =0;
			
			for (int j = 0; j < d.size(); j++)
			{
				if  (d.get(j) ==max3 && j != index1 && j != index2)
				{
					d.set(j,0.0);
					index2 = j;
					break;
				}
			}
			
			System.out.println("Document "+ i+" - Document "+ index+ ": "+ max+" Document "+ index1+ ": "+ max2 + 
					" Document "+ index2+ ": "+ max3);
		}
		
	}
		

	
	
	public static double similar(ArrayList<Shingle> arr1, ArrayList<Shingle> arr2)
	{
		double sim = 0;
		
		for(int i = 0 ; i < arr1.size(); i++)
		{
			for (int j = 0 ; j < arr2.size(); j++)
			{
				Shingle a1 = arr1.get(i);
				Shingle a2 = arr2.get(j);
				
				if (a1.shingleHolder.get(0).equals(a2.shingleHolder.get(0))
						&& a1.shingleHolder.get(1).equals(a2.shingleHolder.get(1))
						&& a1.shingleHolder.get(2).equals(a2.shingleHolder.get(2)))
				{
					sim++;
				}
			}
		}
		
		return sim;
	}
	

}
