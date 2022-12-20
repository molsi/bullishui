package stepdefinitions;

import static org.junit.Assert.assertNotNull;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pom.LoginPage;
import pom.MainPage;
import pom.LoggedInPage;

public class StepDefinitions {
	private static final String URL = "http://the-internet.herokuapp.com";
	
	private static final String correctUsername = "tomsmith";
	private static final String correctPassword = "SuperSecretPassword!";
	
	private WebDriver driver;
	private MainPage mainPage;
	private LoginPage loginPage;
	private LoggedInPage loggedInPage;
	
	@Given("Open Chrome and launch the application")
	public void open_chrome_and_launch_the_application() throws Throwable {
		driver = new ChromeDriver();
		driver.get(URL);

		mainPage = new MainPage(driver);
		mainPage.clickOnFormAuthentication();
	}

	@When("Enter the right username and right password")
	public void enter_the_right_username_and_right_password() throws Throwable {
		loginPage = new LoginPage(driver);
		
		loginPage.enterUsernameAndPassword(correctUsername, correctPassword);
		
		loginPage.clickLogin();
	}

	@Then("Login works")
	public void login_works() throws Throwable {
		loggedInPage = new LoggedInPage(driver);
		
		WebElement successText = loggedInPage.getSuccessText();
		assertNotNull(successText);
		
		loggedInPage.clickLogout();
		
		driver.quit();
	}
	
	@When("Enter the username {string} and right password")
	public void enter_the_username_and_right_password(String username) throws Throwable {
		loginPage = new LoginPage(driver);
		loginPage.enterUsernameAndPassword(username, correctPassword);
		loginPage.clickLogin();
	}

	@Then("Login doesn't work because of invalid username")
	public void login_doesnt_work_because_of_invalid_username() throws Throwable {
		WebElement failureText = loginPage.getFailureTextUsername();
		assertNotNull(failureText);
		
		driver.quit();
	}	
	
	@When("Enter the right username and password {string}")
	public void enter_the_right_username_and_password(String password) throws Throwable {
		loginPage = new LoginPage(driver);
		loginPage.enterUsernameAndPassword(correctUsername, password);
		loginPage.clickLogin();
	}
	
	@Then("Login doesn't work because of invalid password")
	public void login_doesnt_work_because_of_invalid_password() throws Throwable {
		WebElement failureText = loginPage.getFailureTextPassword();
		assertNotNull(failureText);
		
		driver.quit();
	}	
	
	@When("Enter the username {string} and password {string}")
	public void enter_the_username_and_password(String username, String password) throws Throwable {		
		loginPage = new LoginPage(driver);
		loginPage.enterUsernameAndPassword(username, password);
		loginPage.clickLogin();
	}
}