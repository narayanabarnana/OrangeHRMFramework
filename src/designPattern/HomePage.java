package designPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import ImplementedClassLib.*;
public class HomePage {

	@FindBy(xpath="//*[text()='Admin']")
	public WebElement adminLink;
	
	@FindBy(xpath="//*[text()='PIM']")
	public WebElement pimLink;
	
	@FindBy(xpath="//*[text()='Leave']")
	public WebElement leaveLink;

	@FindBy(xpath="//*[text()='Time']")
	public WebElement timeLink;
	
	@FindBy(xpath="//*[text()='Recruitement']")
	public WebElement recruitmentLink;
	
	@FindBy(xpath="//*[text()='Dashoard']")
	public WebElement dashboardLink;
	
	@FindBy(xpath="//*[text()='Directory']")
	public WebElement directoryLink;
	
	@FindBy(id="menu_admin_UserManagement")
	public WebElement userManagementLink;
	
	@FindBy(id="menu_admin_viewSystemUsers")
	public WebElement usersLink;
	
	@FindBy(xpath=".//*[@id='menu_admin_Job']")
	public WebElement jobLink;
	
	@FindBy(xpath=".//*[@id='menu_admin_viewJobTitleList']")
	public WebElement jobTitlesLink;
	
	@FindBy(xpath=".//*[@id='menu_admin_Configuration']")
	public WebElement configurationLink;
	
	@FindBy(xpath=".//*[@id='menu_admin_listMailConfiguration']")
	public WebElement emailconfigurationLink;
		
	private WebDriver driver;
	private ActionControl action;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		action=new ActionControl(driver);
	}
	
	private void moveToadminLink() throws Exception
	{
		Utils.WaitUtils.waitTillElementVisible(driver, 5l, adminLink);
		action.moveToElement(adminLink);
	}
	
	private void moveToUserManagementLink() throws Exception
	{
		Utils.WaitUtils.waitTillElementVisible(driver, 5l, userManagementLink);
		action.moveToElement(userManagementLink);
	}
	
	private void moveToJobLink() throws Exception
	{
		Utils.WaitUtils.waitTillElementVisible(driver, 5l, jobLink);
		action.moveToElement(jobLink);
	}
	
	private void configurationLink() throws Exception
	{
		Utils.WaitUtils.waitTillElementVisible(driver, 5l, configurationLink);
		action.moveToElement(configurationLink);
	}
	
	public void moveToUsers() throws Exception{
		moveToadminLink();
		moveToUserManagementLink();
		Utils.WaitUtils.waitTillElementVisible(driver, 5l, usersLink);
		action.moveToElementAndClick(usersLink);
		
	}
	
	public void moveToJobTitleList() throws Exception{
		
		moveToadminLink();
		moveToJobLink();
		Utils.WaitUtils.waitTillElementVisible(driver, 5l, jobTitlesLink);
		action.moveToElementAndClick(jobTitlesLink);

	}
	
	public void moveToEmailConfigLink() throws Exception{
		
		moveToadminLink();
		configurationLink();
		Utils.WaitUtils.waitTillElementVisible(driver, 5l, emailconfigurationLink);
		action.moveToElementAndClick(emailconfigurationLink);

	}
	
		
	
	
	
	

}
