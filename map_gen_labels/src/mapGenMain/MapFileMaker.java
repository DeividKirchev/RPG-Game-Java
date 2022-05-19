package mapGenMain;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
//import java.util.Scanner;
public class MapFileMaker {
	//Scanner scan = new Scanner();
	FileWriter fWrite;
	final static String filePath = "C:\\Users\\Student\\eclipse-workspace\\Deivd Kirchev\\map_gen_labels\\src\\";
	public void CreateFile(String FileName)
	{
		try {
			File myObj = new File(filePath+FileName);
			
			if (myObj.createNewFile())
			{
			System.out.println("File created: " + myObj.getName());
			   } 
			
			     } 
		    catch (IOException e) 
		    {
			e.printStackTrace();
			}
		
	}
	
	public void CreateMap(String MapName)
	{
		CreateFile(MapName+".txt");
	}
	
	public MapFileMaker(String Map, String MapName) throws IOException
	{
		CreateMap(MapName);
		fWrite = new FileWriter(filePath+MapName+".txt",false);
		fWrite.write(Map);
		fWrite.close();
	}
	
}
