/*
Write a function:

class Solution { public int solution(int[] A); }

that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

Given A = [1, 2, 3], the function should return 4.

Given A = [−1, −3], the function should return 1.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..100,000];
each element of array A is an integer within the range [−1,000,000..1,000,000].
*/

package mypackage;

import java.util.Arrays;
import java.lang.Math;

public class SmallestIntinArray {
	
	
	public int Solution(int[] A) {
		
		System.out.println("Array is");
		for(int x:A) {
			System.out.print(x + " ");
		}
		System.out.println();
		
		//find the smallest value in array
		int min = A[0];
		for(int i=1; i<A.length; i++) {
			if(min > A[i]) {
				min = A[i];
			}
		}
		
		//find the max value in array
		int max = A[0];
		for(int i=1; i<A.length; i++) {
			if(max < A[i]) {
				max = A[i];
			}
		}
		
		int candidate = min + 1;
		
		//matchFlag is true when value of candidate matches
		//a value in the given array. Used to exit the
		//while loop.
		boolean matchFlag = false;
		
		/*
		 * The while loop runs multiple passes on the array.
		 * At each pass, the inner for loop checks if candidate
		 * exists in the array. If it does, then it increments
		 * candidate and goes for the next pass. The number of 
		 * passes is determined by value of candidate - the 
		 * while loop runs at least till candidate equals max
		 * value in array. In case of an array like {1,2,3}, the 
		 * while loop's last loop runs when candidate=3, and the 
		 * for loop finds this value in the array, and increments
		 * candidate. So we end up with answer being one larger than
		 * the max value in the array.
		 * */
		while(candidate <= max ) {
			for(int i=0; i<A.length; i++) {
				if(candidate == A[i]) {
					candidate++;
					matchFlag = true;
					
				} else {
					matchFlag = false;	
				}
			}
			//exit while loop
			if(!matchFlag) {
				break;
			}
		}
		
		//to ensure that candidate is always positive minimum
		if(candidate <= 0) {
			candidate = 1;
		}
		
		return candidate;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestIntinArray obj = new SmallestIntinArray();
		//int[] A = {-1,-3};
		//int[] A = {1,2,3};
		//int[] A = {1, 3, 6, 4, 1, 2};
		//int[] A = {-13, -8, 0};
		//int[] A = {-13, 2, 0};
		//int[] A = {-13,13,0};
		int[] A = {-13,1,0};
		int ans = obj.Solution(A);
		System.out.println("Minimum positive integer not in array: " + ans);
	}

}
