package FinalProject.ZFinalProject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WindowsFramesActions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sunde\\OneDrive\\Desktop\\Selenium_workspace\\ZFinalProject\\src\\main\\java\\utilities\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://jqueryui.com/resizable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		Actions a =new Actions(driver);
		a.clickAndHold(driver.findElement(By.xpath("//div[@id='resizable']/div[3]"))).moveByOffset(50,50).release(driver.findElement(By.xpath("//div[@id='resizable']/div[3]"))).build().perform();
	
		
		
		
		
	}

}
