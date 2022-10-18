package com.XYZBank.testcase;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.XYZBank.datareader.DataProviders;
import com.XYZBank.pages.BankManagerPage;
import com.XYZBank.pages.HomePage;
import com.XYZBank.testbase.TestBase;

public class BankManagerPageTest extends TestBase {
	
	
	@Test(enabled=true, dataProviderClass=DataProviders.class,dataProvider="CommonDataProvider")
	public void addACustomer(String fname, String Lname, String Pcode) throws InterruptedException
	{
		openBrowser();
        HomePage homepage = new HomePage(driver);
		
		Thread.sleep(3000);
		BankManagerPage bankManagerPage =  homepage.clickBankManagerLoginBtn();
		
		Thread.sleep(3000);
		bankManagerPage.addACusotmerBtn();
		
		Thread.sleep(3000);
		bankManagerPage.addCustomer(fname,Lname, Pcode );
		Alert alert = driver.switchTo().alert();
		
		String expectedMessage = "Customer added successfully with customer id ";
		
		String actualMessage  = alert.getText();
		
		String str[] = actualMessage.split(":");
		
		Assert.assertEquals(str[0], expectedMessage);
		alert.accept();
		
	}
	

}
