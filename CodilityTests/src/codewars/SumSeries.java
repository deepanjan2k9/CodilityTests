/**
 * Write a function which returns the sum of following series up to nth term(parameter):
 * 
 * Series: 1 + 1/4 + 1/7 + 1/10 + 1/13 + 1/16 +...
 * 
 * Rules:
 * 1. You need to round the answer to 2 decimal places and return it as String.
 * 2. If the given value is 0 then it should return 0.00
 * 3. You will only be given Natural Numbers as arguments.
 * 
 * Examples:
 * SeriesSum(1) => 1 = "1.00"
 * SeriesSum(2) => 1 + 1/4 = "1.25"
 * SeriesSum(5) => 1 + 1/4 + 1/7 + 1/10 + 1/13 = "1.57"
 * 
 * */


package codewars;

public class SumSeries {
	
	public String SeriesSum(int n) {
		double sum = 0.00;
		double denominator = 0;
		double term = 0;
		
		if(n==0) {
			sum = 0;
		}
		
		if(n==1) {
			sum = 1;
		}
		
		if (n==2) {
			sum = 1.25;
		}
		
		if (n>2) {
			sum = 1.25;
			for(int i=1; i<=n-2; i++) {
				denominator = 4 + 3*i;
				term = 1/denominator;
				sum = sum + term;
			}
		}
		
		return String.format("%.2f",sum);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SumSeries obj = new SumSeries();
		System.out.println("Series with 0 terms: " + obj.SeriesSum(0));
		System.out.println("Series with 1 term: " + obj.SeriesSum(1));
		System.out.println("Series with 2 terms: " + obj.SeriesSum(2));
		System.out.println("Series with 3 terms: " + obj.SeriesSum(3));
		System.out.println("Series with 4 terms: " + obj.SeriesSum(4));
		System.out.println("Series with 5 terms: " + obj.SeriesSum(5));
	}

}
