package ListenerPackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import ImplementedClassLib.TakeScreenshot;


public class Listener implements ITestListener{
static String timeStamp;
static String ScreenShotpath;
public TakeScreenshot screenshot;
 
	public void onFinish(ITestContext arg0) {
		System.out.println("On Finish");
		Reporter.log("Test is finished:" + arg0.getName());
		
	}

	public void onStart(ITestContext arg0) {
		//this.driver=super.driver;
	
		System.out.println("On Start");
	

		//timeStamp=commonUtils.getTimeStamp();
		
		//ScreenShotpath=configProperty.getProperty("ScreenShotpath");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {			
			//String timeStamp=commonUtils.getTimeStamp();
			//String ScreenShotpath=configProperty.getProperty("ScreenShotpath");
			
		//ITestResult failResult=result;
		
		if(ITestResult.FAILURE==result.getStatus())
		{
		try 
		{
			//screenshot.captureAndSaveScreenshotforFailure(ScreenShotpath, timeStamp, failResult);
			
				} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
	}
}
	
			

	public void onTestSkipped(ITestResult arg0) {
		Reporter.log("Test is skipped:" + arg0.getMethod().getMethodName());
		
	}

	public void onTestStart(ITestResult arg0) {
		
	}

	public void onTestSuccess(ITestResult result) {

	
	if(ITestResult.SUCCESS==result.getStatus())
	{
	try 
	{
		//screenshot.captureAndSaveScreenshotAnytime(ScreenShotpath, timeStamp);
		} 
	catch (Exception e)
	{
		e.printStackTrace();
	} 
	}
		
}
}