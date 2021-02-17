package com.initBanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.initBanking.utilities.ReadConfig;

public class BaseClass {
	//common variables
	ReadConfig readconfig = new ReadConfig();
	public String BaseURL = readconfig.getApplicationURL();
	public String username = readconfig.getUsername();
	public String password= readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{		
		logger = Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		
		if(br.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver = new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
		}
		driver.get(BaseURL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+"\\Screenshots\\"+tname+".png");
		FileUtils.copyFile(source, target);
		System.out.println("ScreenShot Taken");
	}
	
	public String randomstring()
	{
		String generateString = RandomStringUtils.randomAlphabetic(8);
		return(generateString);
	}
	
	public static String randomNum()
	{
		String generateNum = RandomStringUtils.randomNumeric(4);
		return(generateNum);
	}
	

}


