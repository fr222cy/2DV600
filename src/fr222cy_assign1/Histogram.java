/**
 * 
 */
package fr222cy_assign1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author Filip Rydberg
 *
 */
public class Histogram {


	public static void main(String[] args) throws FileNotFoundException {
			
		List<Integer> sortedList = getSortedNumbers(getIntListFromFile(args[0]));	
		drawHistogram(sortedList,args[0]);
	}

	static List<Integer> getIntListFromFile(String path) throws FileNotFoundException{
		try{
			Scanner scanner = new Scanner(new File(path));
			
			List<Integer> list = new ArrayList<Integer>();
			
			while(true){
				if(scanner.hasNext()){
					if(scanner.hasNextInt()){
						list.add(scanner.nextInt());
					}
					else{
						break;
					}
				}
				else{
					break;
				}
			}
			return list;
			
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}
	/*
	 * Creates a new list with all values assigned a number between 0-10. 
	 * If a number is between 1-10 it will be assigned value 0 in the list.
	 * 11-20 has the value 1 and so on...
	 * Then it sorts the list and returns it.
	 */
	static List<Integer> getSortedNumbers(List<Integer> list){
		
		List<Integer> hList = new ArrayList<Integer>();
		
		for ( int val : list){
			
			for(int i = 0; i < 11; i++){
				if(val <= (i+1)*10  && val >=  1+(i*10)){
					hList.add(i);
					break;
				}
				else if(val <= (i+1)*10  && val >= 200){
					hList.add(i);
					break;
				}
			}
		}
		
		Collections.sort(hList);
		return hList;
	}	
	
	/*
	 * Retrieves the sorted list and prints out the Histogram.
	 * Ex. list content = {0,0,0,1,2}
	 * Prints:
	 * 1-10 ***
	 * 11-20 *
	 * 21-30 *
	 * ...
	 */
	static void drawHistogram(List<Integer> hList, String path){
		
		System.out.println("Reading from file: " + path);
		int interval_1_100 = 0;
		int interval_101_200 = 0;
		System.out.println("Histogram");
		for(int i = 0; i < 11 ; i++){
			
			if(i < 10){
				System.out.print( 1+(i*10)+" - "+(i+1)*10 + "|");
				for(int val : hList){
					
					if(val == i){
						interval_1_100++;
						System.out.print("*");
					}
				}
				System.out.println();
			}
			else{
				System.out.print( 1+(i*10)+" - "+ 200 + "|");		
				
				for(int val : hList){
					
					if(val == i){
						interval_101_200++;
						System.out.print("*");
					}
				}
				System.out.println();
			}	
		}
		System.out.println("Numbers in interval 1-100: " + interval_1_100);
		System.out.println("Numbers in interval 101-200: " + interval_101_200);
	}
			
}
