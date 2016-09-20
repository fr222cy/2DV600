package fr222cy_assign2.Exercise_5;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.util.Scanner;

public class IdentifyWordsMain {
	private static String _path = "";

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		try {
			_path = args[0];
			String wordString = fileToWordString(args[0]);
			writeToTextFile(wordString);
		} catch (Exception e) {
			System.err.println("Something went wrong");
			e.printStackTrace();
		}
		
	}
	
	private static String fileToWordString(String path) throws FileNotFoundException{
		
		Scanner scanner = new Scanner(new File(path));
		String content = "";
		String contentToBePrinted = "";
		while(scanner.hasNext()){			
			content += scanner.nextLine() + "\n";	
		}
		
		char[] chars = content.toCharArray();
		
		for(Character c : chars){
			if(Character.isLetter(c) || Character.isWhitespace(c)){
				contentToBePrinted += c;
			}
			
		}
		scanner.close();
		return contentToBePrinted;
	}
	
	private static void writeToTextFile(String wordString) throws IOException{
		File file = new File(_path);
		
		FileWriter writer = new FileWriter(file.getParentFile().getPath()+"/words.txt");
		writer.write(wordString);
		writer.close();
	}
	
	
	
	

}
