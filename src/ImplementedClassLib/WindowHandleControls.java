package ImplementedClassLib;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import interfaceLib.IWindowHandle;

public class WindowHandleControls implements IWindowHandle{
	
	WebDriver driver;
	
	public WindowHandleControls(WebDriver driver){
		this.driver = driver;
	}

	@Override
	public void switchToChildWindow() throws Exception {
		
		String childWindow;
		
		childWindow = getWindowHandles().toArray()[1].toString();
		
		switchToWindow(childWindow);
	}

	@Override
	public void switchToParentWindow() throws Exception {
		String parentWindow = getWindowHandle();
		
		switchToWindow(parentWindow);
	}
	
	private void switchToWindow(String windowHandle){
		driver.switchTo().window(windowHandle);
	}

	@Override
	public String getWindowHandle() throws Exception {
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}

	@Override
	public Set<String> getWindowHandles() throws Exception {
		Set<String> childWindow = driver.getWindowHandles();
		return childWindow;
	}

}
