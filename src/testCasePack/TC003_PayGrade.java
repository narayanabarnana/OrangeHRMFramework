package testCasePack;

import org.testng.Assert;
import org.testng.annotations.Test;

import Utils.LoggerUtils;
import designPattern.HomePage;
import designPattern.JobTitlesPage;
import designPattern.LoginPage;

public class TC003_PayGrade extends BaseScenarios{
	
	public LoginPage loginPage;
	public HomePage homepage;
	public JobTitlesPage jobTitlePage;
		
	public TC003_PayGrade() {
		super();
	}
	
	
	@Test
	public void UserVerify()
	{
		LoggerUtils.log.info("=======Starting Payment Grade Sanity test========");
		try{
		loginPage = new LoginPage(driver);
		homepage=new HomePage(driver);
		jobTitlePage=new JobTitlesPage(driver);
		
		loginPage.Login("Admin","admin");
		homepage.moveToJobTitleList();
		jobTitlePage.newJobTitle("Agni ZAX12","Sr. QA Analyst", "/Users//agnibhaghosh//Downloads//ANAMITRA//444376.doc","nothing new");
		boolean result=jobTitlePage.verifyNewlyCreatedJobTitle("Agni @!$%#");
		Assert.assertTrue(result);
		
		LoggerUtils.log.info("=======Finished Payment Grade Sanity test========");

		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
