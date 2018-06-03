package testCasePack;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.LoggerUtils;
import designPattern.LoginPage;

public class TC001_LoginSanity extends BaseScenarios{
		public LoginPage loginPage;
		private WebDriver driver;
		
	public TC001_LoginSanity() {
		
		super();
		this.driver=super.driver;
		
	}

	@Test(enabled=true,dataProvider="getData",dataProviderClass=DataProviderClass.class)
	
	public void loginVerifyTextSanity(String username,String password,String a,String b,String c,String d,String g,String f){

		LoggerUtils.log.info("=======Starting Login Sanity test========");
		System.out.println(username+password+a+b+c+d+g+f);
		
		try{
			loginPage = new LoginPage(driver);
			loginPage.Login("Admin","admin");
			String expectedText="Welcome Admin";
			String actualText=loginPage.getWelComeText();
			screenshot.captureAndSaveScreenshotAnytime(ScreenShotpath, timeStamp);
			Assert.assertEquals(actualText, expectedText);
			//Assert.assertTrue(false);

			LoggerUtils.log.info("=======Finished Login Sanity test========");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	@Test(enabled=false)
	public void zabc()
	{
		Assert.assertTrue(false);
	}
	
	
	
}
