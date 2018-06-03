package Utils;

import java.io.File;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import ImplementedClassLib.WebElementControl;

public class CommnUtilsWork {
	private WebElementControl elementControl;
	private String targetColumnValue;
	public static boolean valIsPresent;

	public CommnUtilsWork() {
		elementControl=new WebElementControl();
	}

	

	public String dynamicTableValueSearch(WebElement searchGrid,String usernametoSearch,WebElement targetBox ) throws Exception
	{
		List<WebElement> rows_table=searchGrid.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		for (int row=0; row<rows_count; row++){ 
		{	
				List<WebElement> columns_table=rows_table.get(row).findElements(By.tagName("td"));
				int columns_count = columns_table.size();

				for (int column=0; column<columns_count; column++){ 
				{
					//String elementToSearch=columns_table.get(column).getText(); 
					String elementToSearch=elementControl.getText(columns_table.get(column));
					if (elementToSearch.equals(usernametoSearch))
					{
						
						String targetColumnValue=elementControl.getText(targetBox);
						//System.out.println("Status of "+usernametoSearch+":  "+ targetColumnValue);
						return targetColumnValue;

					}
				}
			}
		}
	 
	}
		return targetColumnValue;
	}
	
	
	public boolean singleValueSearch(WebElement searchGrid,String textToSearch) throws Exception
	{
		List<WebElement> rows_table=searchGrid.findElements(By.tagName("tr"));
		int rows_count = rows_table.size();
		for (int row=0; row<rows_count; row++){ 
				List<WebElement> columns_table=rows_table.get(row).findElements(By.tagName("td"));
				int columns_count = columns_table.size();
				
				
				for (int column=0; column<columns_count; column++){ 
					//String elementToSearch=columns_table.get(column).getText(); 
					String elementToSearch=elementControl.getText(columns_table.get(column));

					if (elementToSearch.equals(textToSearch))
						{
						
						valIsPresent=true;
						break;
						
						}	
					else{
						valIsPresent=false;
					}
				  }	
				
				if(valIsPresent==true){
					break;
				}
								
			}
		return valIsPresent;
	}
	
	/*
	
	public static void captureScreenshot(WebDriver driver,String screenshotName) throws Exception
	{
	TakesScreenshot ts=(TakesScreenshot)driver;
	 
	File source=ts.getScreenshotAs(OutputType.FILE);
	 
	FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
	 
	System.out.println("Screenshot taken");
	} */
	
	
	public String getTimeStamp() 
	{
		Date d = new Date();
        Timestamp t = new Timestamp(d.getTime());
        String timeStamp = t.toString();
        timeStamp = timeStamp.replace(' ', '_');
        timeStamp = timeStamp.replace(':', '_');
        return timeStamp;
	}
	
	public void getresult(ITestResult result,ExtentTest test) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(LogStatus.PASS, result.getName() + " test is pass");
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, result.getName() + " test is skipped and skip reason is:-" + result.getThrowable());
		} else if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.ERROR, result.getName() + " test is failed" + result.getThrowable());
			//String screen = captureScreen("");
			//test.log(LogStatus.FAIL, test.addScreenCapture(screen));
		} else if (result.getStatus() == ITestResult.STARTED) {
			test.log(LogStatus.INFO, result.getName() + " test is started");
		}
	}
	
	}

