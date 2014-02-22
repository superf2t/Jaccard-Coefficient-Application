import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class ParserClass {

	ArrayList<String> documents = new ArrayList<String>();
	
	/**
	 * Reference for text for reading in from textfile
	 * http://www.roseindia.net/java/beginners/java-read-file-line-by-line.shtml
	 */
	public ParserClass(String Folder)
	{
		File myDirectory = new File(Folder);

		if (myDirectory.isDirectory())
		{

		File[] s = myDirectory.listFiles();
		
		try{
			for (int i =0; i< s.length; i++)
			{
				File f = s[i];
				FileInputStream fstream;
				
					fstream = new FileInputStream(Folder +"/"+ f.getName());
				
			  
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  String fullDocument = "";
			  while ((strLine = br.readLine()) != null)   {
			  fullDocument = fullDocument+ strLine ; 
			  }
			  in.close();
			  
			  documents.add(fullDocument);
			  fullDocument ="";
			}
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }
		}
		else
		{
			System.out.println("INVALID FILE");
		}
	}
	
	public ArrayList<String> getDocuments()
	{
		return documents;
	}
	


}
