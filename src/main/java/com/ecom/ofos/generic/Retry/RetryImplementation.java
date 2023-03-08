package com.ecom.ofos.generic.Retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer {
	int count=0;

	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		int maxcount=3;
		if(1<maxcount)
		{
			count++;
			return true;
		}
		return false;
	}
	
	

}
