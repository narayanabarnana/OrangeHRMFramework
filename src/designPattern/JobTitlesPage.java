package designPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ImplementedClassLib.*;
import Utils.*;

public class JobTitlesPage {

	@FindBy(xpath=".//*[@id='btnAdd']")
	WebElement addButton;
	
	@FindBy(xpath=".//*[@id='btnDelete']")
	WebElement deleteBtn;
	
	@FindBy(id="resultTable")
	WebElement searchGrid;
	
	@FindBy(xpath=".//*[@id='jobTitle_jobTitle']")
	WebElement jobTitleBox;
	
	@FindBy(xpath=".//*[@id='jobTitle_jobDescription']")
	WebElement jobDescriptionBox;
	
	@FindBy(xpath=".//*[@id='jobTitle_jobSpec']")
	WebElement jobSpecificationUpload;
	
	@FindBy(xpath=".//*[@id='jobTitle_note']")
	WebElement noteBox;
	
	@FindBy(xpath=".//*[@id='btnSave']")
	WebElement saveButton;
	
	@FindBy(xpath="//*[contains(text(),\"Saved\")]")
	WebElement successText;
	
	CommnUtilsWork tableValueIsPresent;
	private WebElementControl elementControl;
	private TextboxControl textbox;
	private WebDriver driver;

	public JobTitlesPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		tableValueIsPresent=new CommnUtilsWork();
		elementControl=new WebElementControl();
		textbox=new TextboxControl();
		
	}
	
	/*public void addNewJobTitle(String textToSearch,String jobTitle, String jobDescription, String jobUpload, String note) throws Exception
	{
		boolean valCheck=tableValueIsPresent.singleValueSearch(searchGrid, textToSearch);
		if (valCheck=true)
		{
			System.out.println("Job Title : "+textToSearch+" is already present");
		}
		else
			newJobTitle(textToSearch,jobTitle, jobDescription, jobUpload, note);
	}*/
	public void newJobTitle(String jobTitle, String jobDescription, String jobUpload, String note) throws Exception
	{
		elementControl.click(addButton);
		Utils.WaitUtils.waitTillElementVisible(driver, 10l, jobTitleBox);
		textbox.setText(jobTitleBox, jobTitle);
		textbox.setText(jobDescriptionBox, jobDescription);
		textbox.setText(jobSpecificationUpload, jobUpload);
		textbox.setText(noteBox, note);
		elementControl.click(saveButton);
	}
	
	
	public boolean verifyNewlyCreatedJobTitle(String textToSearch) throws Exception
	{
		boolean valCheck=tableValueIsPresent.singleValueSearch(searchGrid, textToSearch);
		if (valCheck==true)
		{
			//System.out.println("New Job Title : "+textToSearch+" is created successfully");
			return true;
		}
		else
			//System.out.println("New Job Title : "+textToSearch+" is not created successfully");
			return false;
	
	}
	

}
