package testCasePack;

import org.testng.annotations.Test;

import Utils.LoggerUtils;
import designPattern.HomePage;
import designPattern.LoginPage;

public class TC002_UserVerify extends BaseScenarios{
	public LoginPage loginPage;
	public HomePage homepage;
	
	public TC002_UserVerify() {
		super();
	}

	@Test
	public void UserVerify()
	{
		//System.out.println(driver);
		LoggerUtils.log.info("=======Starting User Sanity test========");
		try{
		loginPage = new LoginPage(driver);
		homepage=new HomePage(driver);
		loginPage.Login("Admin","admin");
		homepage.moveToUsers();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
