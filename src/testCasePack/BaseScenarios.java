package testCasePack;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import ImplementedClassLib.CommonDriver;
import ImplementedClassLib.TakeScreenshot;
import Utils.CommnUtilsWork;
import Utils.CommonConfig;
import designPattern.AddUserPage;
import designPattern.JobTitlesPage;
import designPattern.UsersPage;

public class BaseScenarios {
	
	public CommonDriver cmnDriver;
	
	public UsersPage userpage;
	public AddUserPage addUser;
	public JobTitlesPage jobTitle;
	
	public static WebDriver driver;
	public Properties configProperty;
	public CommnUtilsWork commonUtils;
	public TakeScreenshot screenshot;
	public ITestResult result;
	static String timeStamp;
	static String ScreenShotpath;
	static ITestResult failResult;
	public static ExtentReports extent;
	public static ExtentTest test;
	

	//public static final Logger log = Logger.getLogger(BaseScenarios.class.getName());

	
	public BaseScenarios() {
		try {	
			Calendar calendar = Calendar.getInstance();
		
			SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
			configProperty = CommonConfig.getProperty("//Users//agnibhaghosh//Downloads//GIT//src//Configuration//config.properties");		
		
			extent = new ExtentReports(configProperty.getProperty("extentReportFilepath")+ formater.format(calendar.getTime()) + ".html", false);
		
			extent.loadConfig(new File(configProperty.getProperty("extentConfig")));	

			cmnDriver = new CommonDriver(configProperty.getProperty("browserType"));
			
			ScreenShotpath=configProperty.getProperty("ScreenShotpath");

			driver = cmnDriver.getDriver();
		
			commonUtils=new CommnUtilsWork();
		
			screenshot=cmnDriver.getScreenshot();
			
			timeStamp=commonUtils.getTimeStamp();
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	
	
	@BeforeClass (alwaysRun=true)
	public void setup(){
		try {
			
			userpage=new UsersPage(driver);
			addUser=new AddUserPage(driver);
			jobTitle=new JobTitlesPage(driver);
			
			long pageLoadTimeout = Long.valueOf(configProperty.getProperty("pageLoadTimeout"));
			cmnDriver.setPageLoadTimeOut(pageLoadTimeout);
			
			long elementDetectionTimout = Long.valueOf(configProperty.getProperty("elementDetectionTimeout"));
			cmnDriver.setElementDetectionTimeout(elementDetectionTimout);
			
			String url=configProperty.getProperty("baseUrl");
			cmnDriver.invokeBrowser(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@BeforeMethod()
	public void beforeMethod(Method result) {
		
		test = extent.startTest(result.getName());
		test.log(LogStatus.INFO, result.getName() + " test Started");
	}

	@AfterMethod
	public void ScreenshotHandle(ITestResult result)
	{
		 failResult=result;	
	if(ITestResult.FAILURE==result.getStatus())
	{
	try 
	{
		screenshot.captureAndSaveScreenshotforFailure(ScreenShotpath, timeStamp, failResult);
		
			} 
	catch (Exception e)
	{
		e.printStackTrace();
	} 
		}
			}
	
	@AfterMethod
	public void afterMethod(ITestResult result) {
		commonUtils.getresult(result, test);
		test.log(LogStatus.PASS,"Test executed successfully");
		extent.endTest(test);
	}

	
	
	@AfterClass (alwaysRun=true)
	public void cleanup(){
		
		try {
			cmnDriver.closeAllBrowser();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@AfterSuite(alwaysRun=true)
	public void afterSuite()
	{
		extent.flush();
		extent.close();
	}
}