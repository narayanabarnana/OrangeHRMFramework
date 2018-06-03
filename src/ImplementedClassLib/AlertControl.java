package ImplementedClassLib;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import interfaceLib.IAlert;

import Utils.WaitUtils;

public class AlertControl implements IAlert{
	WebDriver driver;
	
	public AlertControl(WebDriver driver) {
		this.driver = driver;
	}
	
	private Alert getAlert(){
		Alert alert = driver.switchTo().alert();
		
		return alert;
	}

	@Override
	public void acceptAlert() throws Exception {
		
		getAlert().accept();
		
	}

	@Override
	public void rejectAlert() throws Exception {
		getAlert().dismiss();
		
	}

	@Override
	public String getMessageFromAlert() throws Exception {
		String message = getAlert().getText();
		return message;
	}

	@Override
	public boolean isAlertPresent(long timeOutInSeconds) throws Exception {
		WaitUtils.waitTillAlertIsPresent(driver, timeOutInSeconds);
		return true;
	}

	

}
