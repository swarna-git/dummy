package stepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.SignInTestPage;
import pageObjects.menuPage;
import resources.BaseClass;
import resources.DataDriven;

public class LoginStep  extends BaseClass{
	
	public WebDriver driver;
	SignInTestPage signInPage;
	menuPage menu;
	SoftAssert soft=new SoftAssert();
	boolean t;WebDriverWait wait;
		
	@Given("^chrome browser is initialized$")
	public void chrome_browser_is_initialized() throws Throwable {
		driver=	 initializeDriver();   
	}

	@Given("^User Navigates to the URL$")
	public void user_Navigates_to_the_URL() throws Throwable {
		driver.get(prop.getProperty("url2"));
	}

	@Given("^Clicks on Sign in link$")
	public void clicks_on_Sign_in_link() throws Throwable {
		signInPage=new SignInTestPage(driver);
		signInPage.signUP().click();
	}


	 @When("^user enters valid (.+) and valid (.+)$")
	    public void user_enters_valid_and_valid(String username, String password) throws Throwable {
	  signInPage.Username().sendKeys(username);
	signInPage.Password().sendKeys(password);
	menu=signInPage.loginButton();
		
	}

	@Then("^Verify the user is successfully logged in$")
	public void verify_the_user_is_successfully_logged_in() throws Throwable {
	t=menu.ProfileTab().isDisplayed();
	System.out.println(t);
	soft.assertTrue(t);
	soft.assertAll();
	    
	}
	@When("^user enters invalid username and invalid password$")
    public void user_enters_invalid_username_and_invalid_password() throws Throwable {
       		String[] ar=DataDriven.Data();
	   for(int i=0;i<ar.length;i++)
	   {
		   signInPage.Username().clear();
		   signInPage.Password().clear();
		   signInPage.Username().sendKeys(ar[i]);
		   signInPage.Password().sendKeys(ar[++i]);
		   menu=signInPage.loginButton();
	
		   
	   }
	   
	}
	@Then("^Verify if the appropriate error message is displayed$")
	public void verify_if_the_appropriate_error_message_is_displayed() throws Throwable {
		 
		wait=new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.errorMsg")));
		   System.out.println(driver.findElement(By.cssSelector("div.errorMsg")).isDisplayed());
		    t=driver.findElement(By.cssSelector("div.errorMsg")).isDisplayed();
		    soft.assertTrue(t);
			   soft.assertAll();
			
	    
	}
	@Then("^Close the browser$")
	public void close_the_browser() throws Throwable {
		driver.close();
	}

	
}
