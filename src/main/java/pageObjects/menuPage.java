package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class menuPage {

	private WebDriver driver;

	public menuPage(WebDriver driver)
	
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@id='dashboardView']")
	WebElement select;
	
	@FindBy(xpath="//a[contains(@href,'Jeanne-Boyarsky')]")
	WebElement AuthorLink;
	
	@FindBy(css="span.statNum")
	WebElement numOfPosts;
	
	@FindBy(xpath="//a[contains(text(),'My Profile')]")
	WebElement ProfileTab;
	
	public WebElement select()
	{
		return select;
	}
	public WebElement ProfileTab()
	{
		return ProfileTab;
	}

	public WebElement AuthorLink()
	{
		return AuthorLink;
	}
	public WebElement numOfPosts()
	{
		return numOfPosts;
	}
	
	
}
