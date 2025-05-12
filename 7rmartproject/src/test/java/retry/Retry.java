package retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {
	int counter = 0;
	int retryLimit = 2;
	
	public boolean retry(ITestResult result) {

		if(counter < retryLimit) //0,1 -two times we can run retry
		{
			counter++;
			return true;
		}
		return false;
	}

}
