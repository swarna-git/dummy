package tests;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import resources.BaseClass;

public class AddItemsTest extends BaseClass{
	public WebDriver driver;
	
	@BeforeClass
	public void init() throws IOException
	{
		driver=initializeDriver();
		
	}
	
	@Test(dataProvider="getData")
	public void addToCart(String[] Veg)
	{
		driver.get(prop.getProperty("url1"));
		List<String> list =new ArrayList<String>(Arrays.asList(Veg));
		List<WebElement> VegList =driver.findElements(By.xpath("//h4[@class='product-name']"));
		int j=0;
		for(int i=0;i<VegList.size();i++)
		{
			String[] VegName=VegList.get(i).getText().split("-");
			
			String Name=VegName[0].trim();
			System.out.println(Name);
			if(list.contains(Name))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product']/div[3]/button")).get(i).click();
				
			}
			if(j==Veg.length)
			{
				break;
			}
			
		}	
		
	}
	@Test
	public void cart() throws InterruptedException
	{
		driver.findElement(By.xpath("//a[@class='cart-icon']/img")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
	}

	@DataProvider
	public String[] getData()
	{
	String[] Veg = {"Brocolli","Cauliflower","Beetroot"};
	return Veg;
	}
	
@Test
@Parameters("promo")
public void checkOut(String promo)
	{
		WebDriverWait wait =new WebDriverWait(driver,20);
		SoftAssert softAssert=new SoftAssert();
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys(promo);
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		String text=driver.findElement(By.cssSelector("span.promoInfo")).getText();
		softAssert.assertTrue(text.equals("Invalid code ..!"));
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		WebElement element=driver.findElement(By.xpath("//div[@class='wrapperTwo']/div/select"));
		Select s =new Select(element);
		s.selectByValue("Afghanistan");
		driver.findElement(By.cssSelector("input[type='checkbox']")).click();
		driver.findElement(By.cssSelector("div[class='wrapperTwo'] button")).click();
		WebElement thank =driver.findElement(By.linkText("Home"));
		softAssert.assertTrue(thank.isDisplayed());
		softAssert.assertAll();
	}
		
	@AfterClass
	public void exit()
	{
	driver.close();
		
	}
}
