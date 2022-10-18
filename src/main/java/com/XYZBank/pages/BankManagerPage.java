package com.XYZBank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BankManagerPage {
	
	WebDriver driver;
	
	
	public BankManagerPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	//WebElments - BankManager Page
		@FindBy(xpath="//*[@ng-click='addCust()']")
		WebElement openCustsectionBtn;
		
		@FindBy(xpath="//*[@ng-click='openAccount()']")
		WebElement openAccountBtn;
		
		@FindBy(xpath="//*[@ng-click='showCust()']")
		WebElement customersBtn;
		
		

		//WebElments - BankManager - Add Customer Page
				@FindBy(xpath="//*[@ng-model='fName']")
				WebElement fName;
				
				@FindBy(xpath="//*[@ng-model='lName']")
				WebElement lName;
				
				@FindBy(xpath="//*[@ng-model='postCd']")
				WebElement postCode;
				
				@FindBy(xpath="//*[text()='Add Customer']")
				WebElement addCustomer;
		
		
		
		
		
		//Bank Manager Page
		public void addACusotmerBtn()
		{
			openCustsectionBtn.click();
			
			
		}
		
		public void clickOpenAccountBtn()
		{
			openAccountBtn.click();
			
			
		}
		
		
		public void clickCustomersBtn()
		{
			customersBtn.click();
			
			
		}
		
		
		//Add Customer
		public void addCustomer(String fname, String lname, String pCode)
		{
			fName.sendKeys(fname);
			lName.sendKeys(lname);
			postCode.sendKeys(pCode);
			addCustomer.click();
			
		}
	
	
	

}
