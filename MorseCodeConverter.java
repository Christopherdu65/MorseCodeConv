import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.Scanner;

 //A class that has several methods to convert morsecode to english and vice versa
public class MorseCodeConverter {
	//creating and initialize an object of type MorseCodeTree
	MorseCodeTree m = new MorseCodeTree();
	
	
	/**
	 * @return a string with all the data in the tree in LNR order with an space in between them
	 */
	public String printTree() {
		String temp = "";
		ArrayList<String> result = m.toArrayList();
		//System.out.print(result.size());
		for(int i = 0; i < result.size(); i++) {
			temp+= result.get(i) + " ";
		}
		return temp;
	}
	
	/**
	 * Converts Morse code into English
	 * @param code the string to be return in english
	 * @return the string in english
	 */
	public String convertToEnglish(String code) {
		String result = "";
		String [] temp = code.split(" ");
		for(int i =0; i < temp.length; i++) {
			if(temp[i].equals("/")) {
				result+= " ";
			}
			else {
				result += m.fetch(temp[i]);
			}
		}
		return result;
		}
	
	/**
	 * @param codeFile the file containing the text to convert in english
	 * @return the string in english
	 * @throws java.io.FileNotFoundException
	 */
	public String convertToEnglish(File codeFile)
            throws java.io.FileNotFoundException{
		String temp = "";
	
		try{
			Scanner scan = new Scanner(codeFile);
			while(scan.hasNextLine()){
				temp+=scan.nextLine(); 
			}
			}catch(FileNotFoundException e) {
				System.out.println("File is not found");
			}
		//System.out.println(temp);
		return convertToEnglish(temp);
	}
}

