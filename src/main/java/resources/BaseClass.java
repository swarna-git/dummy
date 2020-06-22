package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		FileInputStream f = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\config.properties");
		prop = new Properties();
		prop.load(f);
		String browser = prop.getProperty("browser");
		//String browser=System.getProperty("browser");
		if (browser.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\sunde\\OneDrive\\Desktop\\Selenium_workspace\\"
					+ "ZFinalProject\\src\\main\\java\\utilities\\chromedriver.exe");
			ChromeOptions op = new ChromeOptions();
			if (browser.contains("headless"))
				op.addArguments("--headless");
			driver = new ChromeDriver(op);
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			return driver;
		} 
		
		else if (browser.contains("ie")) {
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\sunde\\OneDrive\\Desktop\\Selenium_workspace\\ZFinalProject\\src\\main\\java\\utilities\\"
							+ "MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			return driver;

		} else
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\sunde\\OneDrive\\Desktop\\Selenium_workspace\\ZFinalProject\\src\\main\\java\\utilities\\"
							+ "geckodriver.exe");
		driver = new FirefoxDriver();
		return driver;

	}

}
