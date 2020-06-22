package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignInTestPage {
	
	private WebDriver driver;

	public SignInTestPage(WebDriver driver)
	{
		this.driver=driver;
		if (!driver.getTitle().equals("Coderanch, a friendly place for programming greenhorns!")) {
		      throw new IllegalStateException("This is not Home Page of logged in user," +
		            " current page is: " + driver.getCurrentUrl());
		    }
	}
	private By signUp=By.cssSelector("button#signup-button");
	private By Username=By.xpath("//input[@name='username']");
	private By Password=By.xpath("//input[@name='password']");
	private By loginButton=By.xpath("//div[@class='loginBtnSec']/button");
	
	
	public WebElement signUP()
	{
		return driver.findElement(signUp);
	}
	public WebElement Username()
	{
		return driver.findElement(Username);
	}
	public WebElement Password()
	{
		return driver.findElement(Password);
	}
	public menuPage loginButton()
	{
		 driver.findElement(loginButton).click();
		 menuPage menu=new menuPage(driver);
		 return menu;
		 
	}

	
	
}
