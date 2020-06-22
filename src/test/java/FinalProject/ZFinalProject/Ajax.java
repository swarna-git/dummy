package FinalProject.ZFinalProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ajax {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\sunde\\OneDrive\\Desktop\\Selenium_workspace\\ZFinalProject\\src\\main\\java\\utilities\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	driver.findElement(By.id("autocomplete")).sendKeys("ind");
	Thread.sleep(3000);
	System.out.println(driver.findElement(By.xpath("//ul[@id='ui-id-1']")).getAttribute("value"));
	System.out.println(driver.findElement(By.id("autocomplete")).getText());
	
		
		
	}

}
