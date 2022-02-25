package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Assignment.Selenium.Driver;

public class Login extends Driver{
	

	public void fillEmail(String email)
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='mail']"))).sendKeys(email);
	}
	
	public void fillPassword(String password)
	{
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(password);
	}
	
	public void ClickLogin()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#apply-now-login-button"))).click();
	}
	
}
