package designPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ImplementedClassLib.*;
import Utils.LoggerUtils;


public class LoginPage {

	//@CacheLookup
	@FindBy(xpath=".//*[@id='txtUsername']")
	private WebElement username;
	
	//@CacheLookup
	@FindBy(xpath=".//*[@id='txtPassword']")
	private WebElement password;
	
	@CacheLookup
	@FindBy(xpath=".//*[@id='btnLogin']")
	private WebElement loginBtn;
	
	@FindBy(xpath=".//*[@id='welcome']")
	private WebElement welcomeText;
	
	private WebElementControl elementControl;
	public TextboxControl textboxControl;
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) throws Exception {

		this.driver=driver;
		textboxControl=new TextboxControl();
		elementControl=new WebElementControl();
		PageFactory.initElements(driver, this);

	}
	
	
	public void Login(String usrnme,String pswd) throws Exception{
	
		textboxControl.setText(username, usrnme);
		textboxControl.setText(password, pswd);

		elementControl.click(loginBtn);
		LoggerUtils.log.info("Clicked on login button ");

	}
	
	public String getWelComeText() throws Exception{
		
		Utils.WaitUtils.waitTillElementVisible(driver, 5l, welcomeText);
		String actualText=elementControl.getText(welcomeText);
		return actualText;
	}
	
	
}
