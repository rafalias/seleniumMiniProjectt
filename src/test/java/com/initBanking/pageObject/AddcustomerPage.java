package com.initBanking.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddcustomerPage {
	WebDriver ldriver;
	
	//Constructor
	public AddcustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//element
	@FindBy(how = How.XPATH, using="/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement InkAddNewCustomer;
	
	@FindBy(how = How.NAME, using="name")
	@CacheLookup
	WebElement CustomerName;
	
	@FindBy(how = How.NAME, using="rad1")
	@CacheLookup
	WebElement CustomerGender;
	
	@FindBy(how = How.NAME, using="dob")
	@CacheLookup
	WebElement CustomerDOB;
	
	@FindBy(how = How.NAME, using="addr")
	@CacheLookup
	WebElement CustomerAdd;
	
	@FindBy(how = How.NAME, using="city")
	@CacheLookup
	WebElement CustomerCity;
	
	@FindBy(how = How.NAME, using="state")
	@CacheLookup
	WebElement CustomerState;
	
	@FindBy(how = How.NAME, using="pinno")
	@CacheLookup
	WebElement CustomerPin;
	
	@FindBy(how = How.NAME, using="telephoneno")
	@CacheLookup
	WebElement CustomerMobile;
	
	@FindBy(how = How.NAME, using="emailid")
	@CacheLookup
	WebElement CustomerEmail;
	
	@FindBy(how = How.NAME, using="password")
	@CacheLookup
	WebElement CustomerPwd;
	
	@FindBy(how = How.NAME, using="sub")
	@CacheLookup
	WebElement CustomerSubmit;
	
	@FindBy(how = How.NAME, using="res")
	@CacheLookup
	WebElement CustomerReset;
	
	//action method
	public void ClickAddBewCustomer()
	{
		InkAddNewCustomer.click();
	}
	
	public void custName(String sname)
	{
		CustomerName.sendKeys(sname);
	}
	
	public void custGender(String cgender)
	{
		CustomerGender.click();
	}
	
	public void custDOB(String mm, String dd, String yy)
	{
		CustomerDOB.sendKeys(mm);
		CustomerDOB.sendKeys(dd);
		CustomerDOB.sendKeys(yy);
	}
	
	public void custAdd(String address)
	{
		CustomerAdd.sendKeys(address);
	}
	
	public void custCity(String City)
	{
		CustomerCity.sendKeys(City);
	}
	
	public void custState(String State)
	{
		CustomerState.sendKeys(State);
	}
	
	public void custPin(String pin)
	{
		CustomerPin.sendKeys(String.valueOf(pin));
	}
	
	public void custMobile(String mobile)
	{
		CustomerMobile.sendKeys(mobile);
	}
	
	public void custEmail(String email)
	{
		CustomerEmail.sendKeys(email);
	}
	
	public void custPwd(String pwd)
	{
		CustomerPwd.sendKeys(pwd);
	}
	
	public void custSubmit()
	{
		CustomerSubmit.click();
	}
	
}
