package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) 
	{
		ArrayList<RateDomainModel> alRates = _RateDAL.getAllRates();
		
		double rate = 0.0;
			for (RateDomainModel r : alRates) {
				if (GivenCreditScore >= r.getiMinCreditScore()) {
					rate = r.getdInterestRate();
				}
			
			if (rate < 0.0) {
				try {
					throw new RateException(r);
				} catch (RateException e) {
					e.printStackTrace();
				}
			}
			}
				
		
		//			obviously this should be changed to return the determined rate
		return rate;
		
		
	}
	
	
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
