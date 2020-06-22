package FinalProject.ZFinalProject;

import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Browsers {

	public static void main(String[] args)
	{
		Scanner s=new Scanner(System.in);
		String d=s.next();
		if(d.equals("chrome"))
		{		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\sunde\\OneDrive\\Desktop\\Selenium_workspace\\"
				+ "ZFinalProject\\src\\main\\java\\utilities\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.get("http://www.google.com");
		}
		else if(d.equals("ie"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\sunde\\OneDrive\\Desktop\\Selenium_workspace\\ZFinalProject\\src\\main\\java\\utilities\\"
					+ "MicrosoftWebDriver.exe");
		WebDriver driver=new EdgeDriver();
		driver.get("https://www.google.com");
				
		}
		else
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\sunde\\OneDrive\\Desktop\\Selenium_workspace\\ZFinalProject\\src\\main\\java\\utilities\\"
					+ "geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://www.google.com");
	}
}
