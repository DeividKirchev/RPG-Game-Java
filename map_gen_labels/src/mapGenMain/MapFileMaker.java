package mapGenMain;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
//import java.util.Scanner;
public class MapFileMaker {
	//Scanner scan = new Scanner();
	FileWriter fWrite;
	final static String filePath = System.getProperty("user.dir");
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
	
	public MapFileMaker(String MapName) throws IOException
	{
		CreateMap(MapName);
		fWrite = new FileWriter(filePath+"\\"+MapName+".txt",false);
	}
	public void writeMap(String map) throws IOException
	{
		fWrite.write(map);
		fWrite.close();
	}
	
}
