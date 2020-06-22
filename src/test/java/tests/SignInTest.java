package tests;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pageObjects.SignInTestPage;
import pageObjects.menuPage;
import resources.BaseClass;
import resources.DataDriven;

public class SignInTest extends BaseClass{

	public WebDriver driver;
	SignInTestPage signInPage;
	menuPage menu;
	SoftAssert soft=new SoftAssert();
	boolean t;
	
	@BeforeClass
	public void init() throws IOException
	{
		driver=initializeDriver();
		
	}
	@Test
	public void login() throws IOException
	{		
		String[] ar=DataDriven.Data();
		for(int i=0;i<ar.length;i++)
		{
		driver.get(prop.getProperty("url2"));
		System.out.println(driver.getTitle());
		SignInTestPage signInPage=new SignInTestPage(driver);
		signInPage.signUP().click();
		signInPage.Username().sendKeys(ar[i]);
		signInPage.Password().sendKeys(ar[++i]);
	   menu=signInPage.loginButton();
	   WebDriverWait wait=new WebDriverWait(driver,30);
	   wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.errorMsg")));
	   System.out.println(driver.findElement(By.cssSelector("div.errorMsg")).isDisplayed());
	    t=driver.findElement(By.cssSelector("div.errorMsg")).isDisplayed();
	    soft.assertTrue(t);
		   soft.assertAll();
		
		}
		 
	}
	
	@Test(enabled=false)
	public void menu() throws InterruptedException
	{
		Select s =new Select(menu.select());
		s.selectByIndex(1);
		menu.AuthorLink().click();
		String num=menu.numOfPosts().getText();
		soft.assertFalse(num.equals("39,975"));
		soft.assertAll();
	}
	
	@AfterClass
	public void exit()
	{
		driver.close();
	}
	
	 
}
