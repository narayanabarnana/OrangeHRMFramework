package ImplementedClassLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import interfaceLib.IActions;

public class ActionControl implements IActions{
	
	WebDriver driver;
	
	public ActionControl(WebDriver driver) {
		this.driver = driver;
	}
	
	private Actions getActions() throws Exception{
		Actions action = new Actions(driver);
		
		return action;
	}

	@Override
	public void dragAndDrop(WebElement srcEle, WebElement tarEle) throws Exception {
		getActions().dragAndDrop(srcEle, tarEle).build().perform();
		
	}

	@Override
	public void moveToElement(WebElement element) throws Exception {
		getActions().moveToElement(element).build().perform();
		
	}

	@Override
	public void rightClick(WebElement element) throws Exception {
		getActions().contextClick().build().perform();
		
	}

	@Override
	public void doubleClick(WebElement element) throws Exception {
		getActions().doubleClick().build().perform();
		
	}

	@Override
	public void moveToElementAndClick(WebElement element) throws Exception {
		getActions().moveToElement(element).click().build().perform();
		
	}

}
