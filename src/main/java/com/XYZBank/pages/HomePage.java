package com.XYZBank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	//WebElments - HomePage
	@FindBy(xpath="//*[@ng-click='home()']")
	WebElement homeBtn;
	
	@FindBy(xpath="//*[@ng-click='customer()']")
	WebElement custLoginBtn;
	
	@FindBy(xpath="//*[@ng-click='manager()']")
	WebElement bankMngLoginBtn;
	
	
	
	
	public BankManagerPage clickBankManagerLoginBtn()
	{
		bankMngLoginBtn.click();
		
		return new BankManagerPage(driver);
	}
	
	
	
	public CustomerPage clickCusomterLoginBtn()
	{
		custLoginBtn.click();
		return new CustomerPage();
	}
	
	
	public void clickHomeBtn()
	{
		homeBtn.click();
	}
	
	

	
	
}
