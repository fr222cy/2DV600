/**
 * 
 */
package fr222cy_assign1;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author Filip Rydberg
 *
 */
public class Arrays1 {

	public int sum(int[] arr){
		int sum = 0;
		for(int num: arr){
			sum+=num;
		}
		return sum;
	}
	public String toString(int[] arr){
		
		String numberString = "Numbers in array: ";
		for(int num: arr){
			numberString +="|"+num;
		}
		return numberString;
		
	}
	public int[] addN(int[] arr, int n){
		
		for(int i = 0; i<arr.length; i++){
			arr[i] += n;
		}
		return arr;
		
	}
	public int[] reverse(int[] arr){
		int[] newArr = new int[arr.length];
		for(int i=0; i < arr.length; i++){
			
			newArr[i] = arr[arr.length - (i+1)];
		}
		return newArr;
	}
	public void replaceAll(int[] arr,int old,int nw){
		
		for(int i= 0; i<arr.length;i++){
			if(arr[i] == old){
				arr[i] = nw;
			}
			
		}
		System.out.println(Arrays.toString(arr));
	}
	
	public int[] sort(int[] arr){
		
		int[] sortedArray = arr.clone();
		Arrays.sort(sortedArray);
		
		return sortedArray;
	}
	
	//Probably not a good solution, but it works. 
	public boolean hasSubsequence(int[] arr, int[] sub) {
		int index = 0;
		int[] compareArr = new int[sub.length];
		
		for(int i = 0; i < arr.length; i++){
							
				if(arr[i] == sub[index]){
								
					for(int y = i; y < arr.length; y++){
						
						if(arr[y] == sub[index]){
							compareArr[index] = arr[y];
							index++;
						}
						else{	
							break;
						}
						
						if(index == sub.length){
							break;
						}						
					}
				}
						
			if(Arrays.equals(compareArr, sub)){
				break;
			}
			else{
				index = 0;
			}
		}		
				
		return Arrays.equals(compareArr, sub);		
	}
	
	public int[] absDif(int[] arr1,int[] arr2){
		int[] diffArray = new int[arr1.length];
		if(arr1.length == arr2.length){
			for(int i = 0; i < arr1.length; i++){
				diffArray[i] = Math.abs(arr1[i] - arr2[i]);
			}
			return diffArray;
		}
		else{
			System.out.print("The two arrays must be the same size!");
			return null;
		}
		
	}

}
