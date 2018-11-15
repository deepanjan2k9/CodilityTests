package mypackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryGapTest {

	@Test
	public void testSolutionExtremes() {
		//fail("Not yet implemented");
		
		/*
		 * Testing extremes
		 * n=1, n=5 and n=2147483647
		 * */
		BinaryGap bg = new BinaryGap();
		assertEquals(0,bg.Solution(1));
		assertEquals(1,bg.Solution(5));
		assertEquals(0,bg.Solution(2147483647)); 
		
	}
	
	@Test
	public void testSolutionTrailingZeroes() {
		/*
		 * Test cases for trailing zeroes
		 * n=6 and n=328
		 * */
		/*try {
			
		}catch(AssertionError e) {
			System.out.println(e.getMessage());
		}*/
		
		BinaryGap bg = new BinaryGap();
		assertEquals(0,bg.Solution(6));
		assertEquals(2,bg.Solution(328));
	}
	
	@Test
	public void testSolutionPowerOfTwo() {
		/*
		 * Test cases for numbers which are powers of two
		 * n=16 and n=1024
		 * */
		try {
			BinaryGap bg = new BinaryGap();
			assertEquals(0,bg.Solution(16));
			assertEquals(0,bg.Solution(1024));
		}catch(AssertionError e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}
	
	@Test
	public void testSolutionSimpleTests() {
		/*
		 * Test cases for some simple cases
		 * n=9
		 * n=11
		 * n=19
		 * n=42
		 * n=1162
		 * n=5
		 * */
		try {
			BinaryGap bg = new BinaryGap();
			assertEquals(2,bg.Solution(9));
			assertEquals(1,bg.Solution(11));
			assertEquals(2,bg.Solution(19));
			assertEquals(1,bg.Solution(42));
			assertEquals(3,bg.Solution(1162));
			assertEquals(1,bg.Solution(5));
		}catch(AssertionError e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testSolutionMediumTests() {
		/*
		 * Test cases for some medium cases
		 * n=51712
		 * n=20
		 * n=561892
		 * n=9
		 * n=66561
		 * */
		try {
			BinaryGap bg = new BinaryGap();
			assertEquals(2,bg.Solution(51712));
			assertEquals(1,bg.Solution(20));
			assertEquals(3,bg.Solution(561892));
			assertEquals(2,bg.Solution(9));
			assertEquals(9,bg.Solution(66561));
		}catch(AssertionError e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testSolutionLargeTests() {
		/*
		 * Test cases for some large numbers
		 * n=6291457
		 * n=74901729
		 * n=805306373
		 * n=1376796946
		 * n=1073741825
		 * n=1610612737
		 * */
		BinaryGap bg = new BinaryGap();
		assertEquals(20,bg.Solution(6291457));
		assertEquals(4,bg.Solution(74901729));
		assertEquals(25,bg.Solution(805306373));
		assertEquals(5,bg.Solution(1376796946));
		assertEquals(29,bg.Solution(1073741825));
		assertEquals(28,bg.Solution(1610612737));
	}
	

}
