package codewars;

import static org.junit.Assert.*;

import org.junit.*;

public class SumSeriesTest {

	@Test
	public void testSeriesSum() {
		//fail("Not yet implemented");
		SumSeries testObj = new SumSeries();
		String ans;
		ans = testObj.SeriesSum(0);
		assertEquals("0.00", ans);
		ans = testObj.SeriesSum(1);
		assertEquals("1.00", ans);
		ans = testObj.SeriesSum(2);
		assertEquals("1.25", ans);
	}

}
