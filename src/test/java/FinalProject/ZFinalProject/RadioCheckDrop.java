package FinalProject.ZFinalProject;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RadioCheckDrop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sunde\\OneDrive\\Desktop\\Selenium_workspace\\ZFinalProject\\src\\main\\java\\utilities\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.findElement(By.id("autocomplete")).click();
		driver.findElement(By.id("autocomplete")).sendKeys("ind");
		String s = driver.findElement(By.id("autocomplete")).getAttribute("value");

		while (!s.equals("Indonesia")) {
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
			s = driver.findElement(By.id("autocomplete")).getAttribute("value");
		}

		driver.findElement(By.id("autocomplete")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("autocomplete")).clear();
		driver.findElement(By.id("autocomplete")).sendKeys(Keys.SHIFT);

	}

}
