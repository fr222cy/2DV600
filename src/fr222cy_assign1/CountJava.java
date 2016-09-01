/**
 * 
 */
package fr222cy_assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * @author Filip Rydberg
 *
 */
public class CountJava {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		printFileLinesFromRootPath(args[0]);
		
	}
	
	static void printFileLinesFromRootPath(String path) throws FileNotFoundException{
		
		File rootPath = new File(path);
		File[] listOfFiles = rootPath.listFiles();
		int numberOfJavaFiles = 0;
		
		if(listOfFiles != null){
			try{
				for ( File file : listOfFiles ) {
		            if ( file.isDirectory() ) {
		            	printFileLinesFromRootPath( file.getAbsolutePath() );
		            }
		            else if(file.getName().toLowerCase().endsWith(".java")){
		            	numberOfJavaFiles++;
		                System.out.print( numberOfJavaFiles + ". " + file.getName());
		                Scanner scanner = new Scanner(file);
		                int numberOfLinesInJavaFile = 0;
		                while(scanner.hasNextLine()){
		                	numberOfLinesInJavaFile++;
		                	scanner.nextLine();
		                }
		                
		                System.out.println("| Lines:"+numberOfLinesInJavaFile);
		                scanner.close();
		            }
		        }
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}
}
