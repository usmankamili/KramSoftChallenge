package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Assignment.Selenium.Driver;

public class Registration extends Driver{
	

	public void FillFirstName(String firstname)
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName"))).sendKeys(firstname);
	}
	
	public void FillLastName(String lastname)
	{
		driver.findElement(By.id("lastName")).sendKeys(lastname);
	}
	
	public void FillPhone(String phoneNo)
	{
		driver.findElement(By.id("phone")).sendKeys(phoneNo);
	}
	
	public void FillEmail(String email)
	{
		driver.findElement(By.id("mail")).sendKeys(email);
	}
	
	public void FillCompany(String companyName)
	{
		driver.findElement(By.id("company")).sendKeys(companyName);
	}
	
	public void TickAcceptLicense()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver; 
		js.executeScript("document.querySelector('.checkboxItem label',':before').click();");
	//	driver.findElement(By.cssSelector(".checkboxItem")).click();
	}
	
	public void ClickSignUp()
	{
		driver.findElement(By.id("apply-now-register-button")).click();
	}
	
	public String SuccessfulReg()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".apply-now-forgot-password-header")));
		return driver.findElement(By.cssSelector(".apply-now-forgot-password-header")).getText();
	}
}
