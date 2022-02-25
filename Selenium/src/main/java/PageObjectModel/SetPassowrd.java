package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Assignment.Selenium.Driver;

public class SetPassowrd extends Driver{
	

	public void FillPassword(String enterPassword)
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys(enterPassword);
	}
	
	public void FillConfirmPassword(String enterPassword)
	{
		driver.findElement(By.name("password2")).sendKeys(enterPassword);
	}
	
	public void ClickSetPassword()
	{
		driver.findElement(By.id("termsSubmit")).click();
	}
	
}
