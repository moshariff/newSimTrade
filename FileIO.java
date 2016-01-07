package test;

import java.io.*;

public class FileIO 
{

	public static void main(String[] args)throws IOException
	{
		File file = new File("D:/anush/NewFile.txt");
		//creates a new file
		file.createNewFile();
		//creates a file writer object
		FileWriter writer = new FileWriter(file);
		//Writes content to file
		writer.write(" 2\t 3\n 6\t 2\n");
		writer.flush();
		writer.close();
		
		//creates a file reader object
		FileReader fread = new FileReader(file);
		char[] r = new char[50];
		fread.read(r);
		for(char c : r)
			System.out.print(c);
		fread.close();
		
	}

}
