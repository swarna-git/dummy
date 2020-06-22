package FinalProject.ZFinalProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sunde\\OneDrive\\Desktop\\Selenium_workspace\\ZFinalProject\\src\\main\\java\\utilities\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> l=driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[2]"));
		for(int i=0;i<l.size();i++)
		{
			System.out.println(l.get(i).getText());
		}
			
		System.out.println("***************************************88");
		List<WebElement> l1=driver.findElements(By.xpath("//table[@id='product']/tbody/tr[4]/td"));
		for(WebElement l2:l1)
		{
			System.out.println(l2.getText());
		}
		System.out.println(driver.findElement(By.xpath("//table[@id='product']/tbody/tr[3]")).getText());
		List<WebElement> l3=driver.findElements(By.xpath("//table[@id='product']/tbody/tr/td[3]"));
		int sum=0;
		for(int j=0;j<l3.size();j++)
		{
			String s=l3.get(j).getText();
			sum=sum+Integer.parseInt(s);
		}
		System.out.println(sum);
		
		
		
		
		
		
		
		
	}

}
