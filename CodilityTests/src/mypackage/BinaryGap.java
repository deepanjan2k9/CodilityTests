/*
A binary gap within a positive integer N is any maximal sequence of consecutive zeros that is surrounded
by ones at both ends in the binary representation of N.

For example, number 9 has binary representation 1001 and contains a binary gap of length 2. 
The number 529 has binary representation 1000010001 and contains two binary gaps: one of length 4 and one of length 3. 
The number 20 has binary representation 10100 and contains one binary gap of length 1. 
The number 15 has binary representation 1111 and has no binary gaps. 
The number 32 has binary representation 100000 and has no binary gaps.

Write a function:

class Solution { public int solution(int N); }

that, given a positive integer N, returns the length of its longest binary gap. 
The function should return 0 if N doesn't contain a binary gap.

For example, given N = 1041 the function should return 5, because N has binary representation 10000010001 and so its longest binary gap is of length 5. 
Given N = 32 the function should return 0, because N has binary representation '100000' and thus no binary gaps.

Write an efficient algorithm for the following assumptions:

N is an integer within the range [1..2,147,483,647].

*/


package mypackage;

import java.util.ArrayList;

public class BinaryGap {
	int binaryGap;
	//to keep track of encountered one's
	boolean flag;
	
	//to keep track of 0's in binary gaps
	int zeroCounter;
	
	//Constructor
	public BinaryGap() {
		this.binaryGap = 0;
		flag = false;
		zeroCounter = 0;
	}
	
	//getters and setters
	public int getBinaryGap() {
		return binaryGap;
	}
	public void setBinaryGap(int binaryGap) {
		this.binaryGap = binaryGap;
	}
	
	
	/**
	 * Helper method to convert integer to binary string format.
	 * Runs in O(log n) average case.
	 * */
	public String toBinary(int N) {
		return Integer.toBinaryString(N);
	}
	
	
	/**
	 * Create an integer array that stores the binary form
	 * taken from string binary form. Return this integer array 
	 * to Solution()
	 * */
	public int[] Preprocess(String bits) {
		int len = bits.length();
		int[] a = new int[len];
		
		for(int i=0; i<len; i++) {
			a[i] = Integer.parseInt(String.valueOf(bits.charAt(i)));
		}
		//stdout for debugging purposes
		System.out.println("\nArray a in Preprocess: ");
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		
		return a;
	}
	
	/**
	 * Method to calculate binary gap. 
	 * 
	 * */
	public int Solution(int N) {
		int[] binaryInt = Preprocess(Integer.toBinaryString(N));
		int len = binaryInt.length;
		
		//ArrayList to store the number of consecutive 0's in between two 1's
		ArrayList<Integer> binaryGaps = new ArrayList<>();
		
		//loop starts from the end to account for trailing 0's
		for(int i=len-1; i>=0; i--) {
			if(binaryInt[i] == 1) {
				/*
				 * flag is true in case the loop has already encountered at least one 1
				 * by this time, in which case when it encounters 1 again at this iteration,
				 * it will reset zeroCounter, because flag stays true throughout, beginning the
				 * first time loop encounters a 1. The value of zeroCounter at this point will
				 * be stored in an ArrayList binaryGaps to store different values of binary
				 * gaps.
				 * 
				 * flag is false when the loop has not encountered a 1 before, and this is 
				 * the first time it is encountering, at which point flag is set to true.  
				 * 
				 * 
				 * The flag thus helps us determine if 0's encountered at the current iteration
				 * should be counted towards binary gap. When loop encounters a 0 and the flag is 
				 * false, then 1 has not been encountered before, meaning the current 0 is a 
				 * trailing zero and should not be counted towards binary gap. 
				 * */
				if(flag) {
					binaryGaps.add(zeroCounter);
					//reset zeroCounter
					zeroCounter = 0;
				}else {
					flag = true;
				}
				
			}
			if(binaryInt[i] == 0) {
				if(flag) {
					zeroCounter++;
				}else {
					//do nothing
				}
			}
		}
		
		//find out the max value in the ArrayList
		int maxBinaryGap = 0;
		for(int i=0; i<binaryGaps.size(); i++) {
			//
			if(maxBinaryGap < binaryGaps.get(i)) {
				maxBinaryGap = binaryGaps.get(i);
			}	
		}
		
		return maxBinaryGap;	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//N is the integer to be converted to binary
		/*
		 * NOTE: The integer to string binary does not show 0's at the beginning
		 * Test cases:
		 * N=114 (1110010), expected=2, result=2; PASS
		 * N=1 (1), expected=0, result=0; 		PASS
		 * N=10000 (10011100010000), expected=3, result=3; PASS
		 * N=39 (100111), expected=2, result=2; PASS
		 * N=57 (111001), expected=2, result=2; PASS
		 * N=2147483647 (1111111111111111111111111111111), expected=0, result=0; PASS
		 * */
		int N=1024;
		BinaryGap bg = new BinaryGap();
		System.out.println("\nMax binary gap: " + bg.Solution(N));
	}

}
