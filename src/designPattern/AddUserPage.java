package designPattern;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ImplementedClassLib.*;

public class AddUserPage {

	@FindBy(xpath=".//*[@id='UserHeading' and text()='Add User']")
	WebElement addUserheading;
	
	@FindBy(xpath=".//*[@id='systemUser_userType']")
	WebElement roleDropdown;
	
	@FindBy(xpath=".//*[@id='systemUser_employeeName_empName']")
	WebElement employeeNameTextBox;

	@FindBy(xpath=".//*[@id='systemUser_userName']")
	WebElement UserNameTextBox;
	
	@FindBy(xpath=".//*[@id='systemUser_status']")
	WebElement statusDropdown;
	
	@FindBy(xpath=".//*[@id='systemUser_password']")
	WebElement passwordTextBox;
	
	@FindBy(xpath=".//*[@id='systemUser_confirmPassword']")
	WebElement confirmPasswordTextBox;
	
	@FindBy(xpath=".//*[@id='btnSave']")
	WebElement saveButton;
	
	//@FindBy(xpath="//*[contains(text(),\"Saved\")]")
	//WebElement successText;
	
	WebDriver driver;
	TextboxControl textbox;
	DropdownControl dropdown;
	WebElementControl webElement;
	
	public AddUserPage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory.initElements(driver, this);
	textbox=new TextboxControl();
	dropdown=new DropdownControl();
	webElement=new WebElementControl();
	
	}
	
	public void addUserMethod(String userRole, String empName, String userName, String status, String password ) throws Exception
	{
		Utils.WaitUtils.waitTillElementVisible(driver, 10l, addUserheading);
		dropdown.selectViaVisibleText(roleDropdown, userRole);
		textbox.setText(employeeNameTextBox, empName);
		textbox.setText(UserNameTextBox,userName);
		dropdown.selectViaVisibleText(statusDropdown, status);
		textbox.setText(passwordTextBox, password);
		textbox.setText(confirmPasswordTextBox, password);
		webElement.click(saveButton);
		//Utils.WaitUtils.waitTillElementVisible(driver, 5l, successText);

	}
	
	
	
	
	

}
