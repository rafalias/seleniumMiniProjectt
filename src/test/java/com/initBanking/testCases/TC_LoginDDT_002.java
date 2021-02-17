package com.initBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.initBanking.pageObject.LoginPage;
import com.initBanking.utilities.XLUtils;

public class TC_LoginDDT_002 extends BaseClass
{//test method
//data provider method

	@Test(dataProvider="LoginData")

	public void loginDDT(String user, String pwd)
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);	
		lp.clickSubmit();
		
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()
	{
		try {
		driver.switchTo().alert();
		return true;
		}
		catch (NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name="LoginData")
	String [][] getData() throws IOException
	{
		String path = System.getProperty("user.dir")+"/src/test/java/com/initBanking/testData/logData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int cocount= XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][]= new String [rownum][cocount];
		
		for(int i=1; i<=rownum; i++) {
			for(int j=0; j<cocount; j++) {
				
				logindata[i-1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			
			}			
		}
		return logindata;
	}
}
