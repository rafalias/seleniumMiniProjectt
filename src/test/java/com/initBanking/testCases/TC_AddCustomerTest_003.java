package com.initBanking.testCases;

import java.io.IOException;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.initBanking.pageObject.AddcustomerPage;
import com.initBanking.pageObject.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username provided");
		lp.setPassword(password);
		logger.info("password provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddcustomerPage addcust= new AddcustomerPage(driver) ;
		addcust.ClickAddBewCustomer();
		
		logger.info("providing customer details.............");
		
		addcust.custName("rafidah");
		addcust.custGender("female");
		addcust.custDOB("09", "13", "1992");
		Thread.sleep(3000);
		addcust.custAdd("OrchardVille");
		addcust.custCity("Bayan Lepas");
		addcust.custState("Penang");
		addcust.custPin("11900");		
		addcust.custMobile("0133504315");
		
		//generate unique email id and number(generate random data dynamically)
		String email = randomstring()+"@gmail.com";
		addcust.custEmail(email);
		addcust.custPwd("anraraa");
		addcust.custSubmit();
		
		Thread.sleep(3000);
		
		logger.info("validation .............");
		boolean res = driver.getPageSource().contains("Customer Register Successfully!!!");
		
		if(res == true)
		{
			Assert.assertTrue(true);
		}
		else
		{
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
		
	}
	
}
