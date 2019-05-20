package IOFile;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class IOFile 
{
	// writing list data to file
    public void fileWrite(ArrayList<String> input, String fileName)
    {
        try {
        	BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        	
        	// converting list to string
        	for (String txtStr: input) {
        		writer.write(txtStr + ", ");
        	}
        	
    		writer.close();
    	} catch (IOException e1) {
    		e1.printStackTrace();
    	}
    }

    
	// Append data	
	public void fileAppend(ArrayList<String> input, String fileName)
	{
		try {
			File file = new File(fileName);
			FileWriter fileWrite = new FileWriter(file, true);
			BufferedWriter bufferWrite = new BufferedWriter(fileWrite);
			
        	// converting list to string
        	for (String txtStr: input) {
        		bufferWrite.write(txtStr + ", ");
        		bufferWrite.write(input + "\n");
        	}
        	
			
        	bufferWrite.close();
        	fileWrite.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	
	// Read file, return list from file
	public ArrayList<String> fileRead(String fileName)
	{
		 // Store text
		ArrayList<String> content = new ArrayList<String>(); 
		
		try {
			BufferedReader buffer = new BufferedReader(new FileReader(fileName));
		    StringBuilder strBuffer = new StringBuilder();
		    String readLine = buffer.readLine();

		    while (readLine != null) {
		    	strBuffer.append(readLine);
		    	readLine = buffer.readLine();  
		    }
			
		    String strText[] = strBuffer.toString().split(", ");  // stripping text
			
			for(String txtStriped:strText) 
				content.add(txtStriped);
			
		    buffer.close();	 
		}  catch (IOException e3) {
			e3.printStackTrace();
		}

		return content;
	}
}