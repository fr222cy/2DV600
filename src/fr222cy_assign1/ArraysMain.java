/**
 * 
 */
package fr222cy_assign1;

import java.util.Arrays;

/**
 * @author Filip Rydberg
 *
 */
public class ArraysMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] unsortedArray = {4,5,6,2,3,1};
		int[] testArray = {1,2,3,4,5};
		int[] testArray2 = {2,2,2,3,7};
		int[] seqArr = {1,2,3,3,4,5,6};
		int[] subSeq = {4,5,6};
		int[] subSeq2 = {2,4,6};
		int testNum = 3;
		int replaceNumber = 4;
		Arrays1 a = new Arrays1();
					
	System.out.println("Method: int sum(int[])");
	System.out.println("Data sent:" + Arrays.toString(testArray));
	System.out.println("Response:"+ a.sum(testArray));
	System.out.println("------");
		
	System.out.println("Method: String toString(int[])");
	System.out.println("Data sent:" + Arrays.toString(testArray));
	System.out.println("Response:"+ a.toString(testArray));
	System.out.println("------");
	
	System.out.println("Method: int[] addN(int[], int)");
	System.out.println("Data sent:" + Arrays.toString(testArray) + "|"+ testNum);
	System.out.println("(String)Response:"+ Arrays.toString(a.addN(testArray, testNum)));
	System.out.println("------");
	
	System.out.println("Method: int[] reverse(int[])");
	System.out.println("Data sent:" + Arrays.toString(testArray) );
	System.out.println("(String)Response:"+ Arrays.toString(a.reverse(testArray)));
	System.out.println("------");
		
	System.out.println("Method: int[] replaceAll(int[],int,int)");
	System.out.println("Data sent:" + Arrays.toString(testArray) + "|"+ replaceNumber +"|"+ testNum );
	System.out.print("Print:"); a.replaceAll(testArray,replaceNumber,testNum);
	System.out.println("------");
	
	System.out.println("Method: int[] sort(int[])");
	System.out.println("Data sent:" + Arrays.toString(unsortedArray));
	System.out.println("(String)Response:"+Arrays.toString(a.sort(unsortedArray)));
	System.out.println("------");
	
	System.out.println("Method: boolean hasSubsequence(int[],int[])");
	System.out.println("Test1:Data sent:" + Arrays.toString(seqArr) + "|"+Arrays.toString(subSeq));
	System.out.println("Response:"+a.hasSubsequence(seqArr, subSeq));
	System.out.println("---");
	System.out.println("Test2 :Data sent:" + Arrays.toString(seqArr) + "|"+Arrays.toString(subSeq2));
	System.out.println("Response:"+a.hasSubsequence(seqArr, subSeq2));
	System.out.println("------");
	
	System.out.println("Method: int[] absDif(int[],int[])");
	System.out.println("Data sent:" + Arrays.toString(testArray) + "|"+Arrays.toString(testArray2));
	System.out.println("Response:"+Arrays.toString(a.absDif(testArray, testArray2)));
	System.out.println("---");
	
	}
	

}
