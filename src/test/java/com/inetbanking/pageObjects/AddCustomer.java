package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomer {

	WebDriver driver;
	
	public AddCustomer(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	WebElement newcustomer;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement name;
	
	@FindBy(xpath="//input[@name='rad1']")
	WebElement gender;
	
	@FindBy(id="dob")
	WebElement txtdob;
	
	@FindBy(name="addr")
	WebElement txtaddress;
	
	@FindBy(name="city")
	WebElement txtcity;
	
	@FindBy(name="state")
	WebElement txtstate;
	
	@FindBy(name="pinno")
	WebElement txtpinno;
	
	@FindBy(name="telephoneno")
	WebElement txttelephoneno;
	
	@FindBy(name="emailid")
	WebElement txtemailid;
	
	@FindBy(name="sub")
	WebElement btnSubmit;
	
	@FindBy(name="password")
	WebElement txtpassword;


	public void getlink()
	{
		newcustomer.click();
	}
	
	public void getname(String ename)
	{
		name.sendKeys(ename);	
	}
	
	public void getgender(String egender)
	{
		gender.sendKeys(egender);	
	}
	
	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
		
	}

	public void custaddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}

	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}

	public void custpinno(String cpinno) {
		txtpinno.sendKeys(String.valueOf(cpinno));
	}

	public void custtelephoneno(String ctelephoneno) {
		txttelephoneno.sendKeys(ctelephoneno);
	}

	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}

public void custpassword(String cpassword) {
	txtpassword.sendKeys(cpassword);
	}

	public void custsubmit() {
		btnSubmit.click();
	}
	


}