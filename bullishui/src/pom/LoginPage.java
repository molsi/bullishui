package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	private static final String loginId = "username";
	private static final String passwordId = "password";
	private static final String buttonXpath = "//button";
	private static final String failureUsernameXpath = "//div[contains(text(), 'Your username is invalid!')]";
	private static final String failurePasswordXpath = "//div[contains(text(), 'Your password is invalid!')]";
	private WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterUsernameAndPassword(String username, String password) {
		WebElement loginText = driver.findElement(By.id(loginId));
		loginText.sendKeys(username);

		WebElement passwordText = driver.findElement(By.id(passwordId));
		passwordText.sendKeys(password);
	}
	
	public void clickLogin() {
		WebElement submitBtn = driver.findElement(By.xpath(buttonXpath));
		submitBtn.click();
	}
	
	public WebElement getFailureTextUsername() {
		WebElement failureText = driver.findElement(By.xpath(failureUsernameXpath));
		return failureText;
	}
	
	public WebElement getFailureTextPassword() {
		WebElement failureText = driver.findElement(By.xpath(failurePasswordXpath));
		return failureText;
	}
}