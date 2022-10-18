package com.XYZBank.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.XYZBank.utility.Constants;
import com.XYZBank.utility.DriverFactory;

public class TestBase {
	
	
	public static WebDriver driver=null;
	Properties prop = new Properties();
	FileInputStream fin=null;
	
	
	@BeforeSuite
	public void setUpFramework()
	{
		
		DriverFactory.setConfigPropertyFile(System.getProperty("user.dir") +"\\src\\test\\resources\\properties\\config.properties");
		DriverFactory.setChromeDriverExePath(System.getProperty("user.dir") +"\\src\\test\\resources\\executables\\chromedriver.exe");
		DriverFactory.setGeckoDriverExePath(System.getProperty("user.dir") +"\\src\\test\\resources\\executables_drivers\\geckodriver.exe");
		
		try {
			fin = new FileInputStream(DriverFactory.getConfigPropertyFile());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			prop.load(fin);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void openBrowser()
	{
		
		
		if (Constants.REMOTE_STATUS) {
			DesiredCapabilities cap = null;

			if (Constants.CHROME_BROWSER.equals(prop.getProperty("browser"))) {
				cap = DesiredCapabilities.chrome();
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.ANY);
			} else if (Constants.CHROME_BROWSER.equals("firefox")) {
				cap = DesiredCapabilities.firefox();
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.ANY);
			}

			try {
				driver = new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if (prop.getProperty("browser").equals(Constants.CHROME_BROWSER))
		{
			System.setProperty("webdriver.chrome.driver",
				DriverFactory.getChromeDriverExePath());
			 driver = new ChromeDriver();
			
		}else if(prop.getProperty("browser").equals(Constants.FIREFOX_BROWSER))
		{
			System.setProperty("webdriver.gecko.driver",
					DriverFactory.getGeckoDriverExePath());
			 driver = new FirefoxDriver();
		}
		
		driver.get(prop.getProperty("testurl"));// open the URL in the browser

		driver.manage().window().maximize();// maximize the browser
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_TIME, TimeUnit.SECONDS);
		
	}
	
	
	
	@AfterSuite
	public void close()
	{
		driver.close();
	}

}
