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

public class SmallestIntinArray {
	
	/*
	 * Utility function to sort the array. I am using
	 * bubble sort for ease of coding
	 * */
	public int[] Sort(int[] a) {
		boolean swap=false;
		int[] array = a;
		int temp;
		
		do {
			swap=false;
			for(int i=0; i<array.length-1; i++) {
				if(array[i] > array[i+1]) {
					temp=array[i+1];
					array[i+1] = array[i];
					array[i] = temp;
					swap = true;
				}	
			}
		}while(swap==true);
		
		return array;
	}
	
	public int Solution(int[] A) {
		//make a copy of array
		int[] a = A;
		
		//sort the array copy in ascending order
		a = Sort(a);
		
		//ans starts with min value in array
		int ans = a[0];
		
		for(int i = 0; i < a.length; i++) {
			//we are only concerned with a positive
			//outcome, so final ans has to be 
			//positive anyway
			if(a[i] <= 0) {
				ans = 0;
			}
			if(ans == a[i]) {
				ans++;
			}
		}
		
		//to ensure that ans is minimum positive
		if(ans == 0) {
			ans++;
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SmallestIntinArray obj = new SmallestIntinArray();
		//TEST CASES
		//int[] A = {-1,-3};	PASS
		//int[] A = {1,2,3};	PASS
		//int[] A = {1, 3, 6, 4, 1, 2};	PASS
		//int[] A = {-13, -8, 0};	PASS
		//int[] A = {-13, 2, 0};	PASS
		//int[] A = {-13,13,0};	PASS
		int[] A = {-13,1,0}; //PASS
		
		int ans = obj.Solution(A);
		System.out.println("Minimum positive integer not in array: " + ans);
	}

}
