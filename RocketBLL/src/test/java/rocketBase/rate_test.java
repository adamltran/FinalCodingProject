package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	//		Check to see if a known credit score returns a known interest rate
	
	//		Check to see if a RateException is thrown if there are no rates for a given
	//		credit score
	@Test
	public void getrateTest() throws RateException {
		assertEquals(RateBLL.getRate(800),3.5,1);
	}
	
	@Test (expected = RateException.class)
	public void getRateExceptionTest() throws RateException {
		RateBLL.getRate(10000);
	}

}
