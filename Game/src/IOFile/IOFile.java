package IOFile;

import java.util.ArrayList;
import java.util.HashMap;



public class IOFile 
{
	private static HashMap<String, ArrayList<String>> files =  init();
	

	// Pre setting information
	private static HashMap<String, ArrayList<String>> init() 
	{
		HashMap<String, ArrayList<String>> files = new HashMap<>();
		files.put("src/StoreGame/CrewSelected/MemberOne.txt", arrayOf("0", "0", "0", "0", "false", "josh", "Pilot", "alive", ""));
		files.put("src/StoreGame/CrewSelected/MemberTwo.txt", arrayOf("0", "0", "0", "0", "false", "jono", "Pilot", "alive", ""));
		files.put("src/StoreGame/CrewSelected/MemberThree.txt", arrayOf("0", "0", "0", "0", "false", "jono", "Pilot", "alive", ""));
		files.put("src/StoreGame/CrewSelected/MemberFour.txt", arrayOf("0", "0", "0", "0", "false", "jono", "Pilot", "alive", ""));
		return files;
	}
	
	private static ArrayList<String> arrayOf(String... values) 
	{
		ArrayList<String> data = new ArrayList<>();
		for (String s: values) {
			data.add(s);
		}
		return data;
	}
	

	/**
	 * Writing list to a storage location in ram
	 * @param input of type list string
	 * @param fileName a storage distanation
	*/
    public void fileWrite(ArrayList<String> input, String fileName)
    {
    	files.put(fileName, input);
    }
	
	/**
	 * Reading a storage location in ram
	 * and returning the information
	 * @param input of type list string
	 * @param fileName a storage distanation
	*/
	public ArrayList<String> fileRead(String fileName)
	{		
		return files.get(fileName);
	}
}