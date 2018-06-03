package designPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ImplementedClassLib.DropdownControl;
import ImplementedClassLib.TextboxControl;
import ImplementedClassLib.WebElementControl;
import Utils.CommnUtilsWork;

public class UsersPage {

	@FindBy(xpath=".//*[@id='btnAdd']")
	WebElement addUserLink;
	
	@FindBy(xpath=".//*[@id='btnDelete']")
	WebElement deleteUserLink;
	
	@FindBy(xpath=".//*[@id='searchSystemUser_userName']")
	WebElement userNameTextbox;
	
	@FindBy(xpath=".//*[@id='searchSystemUser_userType']")
	WebElement userRoleDropdown;
	
	@FindBy(xpath=".//*[@id='searchSystemUser_employeeName_empName']")
	WebElement employeeNameTextbox;
	
	@FindBy(xpath=".//*[@id='searchSystemUser_status']")
	WebElement statusDropdown;
	
	@FindBy(xpath=".//*[@id='searchBtn']")
	WebElement searchBtn;
	
	@FindBy(xpath="//*[@id='resultTable']/tbody")
	WebElement searchGrid;
	
	@FindBy(xpath=".//*[@id='resultTable']/tbody//td[5]")
	WebElement statusBox;
	
	private WebDriver driver;
	private DropdownControl dropdown;
	public TextboxControl textboxControl;
	private WebElementControl elementControl;
	CommnUtilsWork tablework;
	
	public UsersPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		dropdown=new DropdownControl();
		textboxControl=new TextboxControl();
		elementControl=new WebElementControl();
		tablework=new CommnUtilsWork();

	}
	
	
	public void SearchUser(String username,String roleValue,String empName,String status) throws Exception
	{
		Utils.WaitUtils.waitTillElementVisible(driver, 5l, userNameTextbox);
		textboxControl.setText(userNameTextbox, username);
		dropdown.selectViaVisibleText(userRoleDropdown, roleValue);
		textboxControl.setText(employeeNameTextbox, empName);
		dropdown.selectViaVisibleText(statusDropdown, status);
		Utils.WaitUtils.waitTillElementVisible(driver, 5l, searchBtn);
		elementControl.click(searchBtn);

	}
	
	public void getSearchedUserDetails(String usernametoSearch) throws Exception
	{
		Utils.WaitUtils.waitTillElementVisible(driver, 5l, addUserLink);

		String result= tablework.dynamicTableValueSearch(searchGrid, usernametoSearch, statusBox);
		System.out.println("Status of "+usernametoSearch+":  "+ result);
		
	}
	
	public void addUserNav() throws Exception
	{
		elementControl.click(addUserLink);
		System.out.println("Navigating to Add User page");
	}
}	
		
	
	
	
	


