package com.XYZBank.testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.XYZBank.pages.BankManagerPage;
import com.XYZBank.pages.HomePage;
import com.XYZBank.testbase.TestBase;

public class HomePageTest extends TestBase {
	
	
	@Test(enabled=true)
	public void bank() throws InterruptedException
	{
		openBrowser();
		HomePage homepage = new HomePage(driver);
		
		Thread.sleep(3000);
		BankManagerPage bankManagerPage =  homepage.clickBankManagerLoginBtn();
		
		

	}

}
