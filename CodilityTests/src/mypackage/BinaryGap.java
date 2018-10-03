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


public class BinaryGap {
	int binaryGap;
	
	public int getBinaryGap() {
		return binaryGap;
	}
	
	public void setBinaryGap(int binaryGap) {
		this.binaryGap = binaryGap;
	}
	
	public BinaryGap() {
		this.binaryGap = 0;
	}
	
	/**
	 * Helper method to convert integer to binary string format.
	 * Runs in O(log n) average case.
	 * */
	public String toBinary(int N) {
		return Integer.toBinaryString(N);
	}
	
	public String preprocessBinary(String bits) {
		String bitsTemp = null;
		int bitsLength = bits.length();
		for(int i=bits.length()-1; i>=0; i--) {
			if (bits.charAt(i) == '0') {
				bitsLength--;
				bitsTemp = bits.substring(0, bitsLength);
			} else continue;
		}
		
		System.out.println("Preprocessed binary: " + bitsTemp);
		return bitsTemp;
	}
	
	/**
	 * Method to calculate binary gap. 
	 * Runs in O(n) for for-loop and O(log n) for 
	 * Integer.toBinaryString() by helper method,
	 * therefore a total of O(n) + O(log n), capping at O(n)
	 * */
	public int Solution(int N) {
		//convert integer to binary in string format
		String bits = toBinary(N);
		
		//preprocessing the binary to remove trailing 0's
		String bitsTemp = preprocessBinary(bits);
		
		System.out.println("Bits: " + bits);
		System.out.println("BitsTemp: " + bitsTemp);
		int[] binaryGapArray = new int[32];
		int oneCounter = 0;
		for(int i=0; i < bitsTemp.length(); i++) {
			if(bitsTemp.charAt(i) == '1') {
				oneCounter++;
			} else {
				binaryGapArray[oneCounter]++;
			}
		}
		
		
		//checking for the case when there is no 1 at the end
		//of the binary string, therefore no binary gap even
		//if there are 0's.
		if(oneCounter == 1|| oneCounter == 0) {
			return 0;
		}
		
		int max = binaryGapArray[0];
		for(int i=1; i<binaryGapArray.length; i++) {
			if(max < binaryGapArray[i]) {
				max = binaryGapArray[i];
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//N is the integer to be converted to binary
		int N=114;
		BinaryGap bg = new BinaryGap();
		System.out.println("Max binary gap: " + bg.Solution(N));
	}

}
