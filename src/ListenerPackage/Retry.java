package ListenerPackage;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import Utils.LoggerUtils;

public class Retry implements IRetryAnalyzer {
	//public static final Logger log = Logger.getLogger(Retry.class.getName());
	private int retryCount = 0;
	private int maxRetryCount = 3;
	
	public boolean retry(ITestResult result) {
		if (!result.isSuccess()){
		if (retryCount < maxRetryCount) {
			LoggerUtils.log.info("Retrying test " + result.getName() + " with status " + getResultStatusName(result.getStatus()) + " for the " + (retryCount + 1) + " time(s).");
			retryCount++;
			return true;
		}
		//return false;
	}
		return false;
	}
	public String getResultStatusName(int status) {
		String resultName = null;
		if (status == 1)
			resultName = "SUCCESS";
		if (status == 2)
			resultName = "FAILURE";
		if (status == 3)
			resultName = "SKIP";
		return resultName;
	}
	
	
	
}
