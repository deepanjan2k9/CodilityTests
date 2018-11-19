/**
 * Array rotation. Goal is to rotate an array A K times towards the right.
 * */


package mypackage;

public class ArrayRotation {

	public int[] solution(int[] A, int K) {
		int n = A.length;
		for(int j=1; j<=K; j++) {
			int last = A[n-1];
			for(int i=1; i<n; i++) {
				A[n-i] = A[n-1-i];
			}
			A[0] = last; 
		}
		return A;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayRotation obj = new ArrayRotation();
		int[] A = new int[] {3,8,9,7,6};
		int[] ans = obj.solution(A, 3);
		
		System.out.println("Ans: ");
		for(int i=0; i<A.length; i++) {
			System.out.print(" " + A[i]);
		}
	}

}
