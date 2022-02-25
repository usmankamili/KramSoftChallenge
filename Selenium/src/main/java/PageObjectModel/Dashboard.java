package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Assignment.Selenium.Driver;

public class Dashboard extends Driver{
	
	public void clickYourAccount()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".user-email span"))).click();
	}
	
	public void clickEditProfile()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//a[text()='Edit Profile']"))).click();
	}
	
	public String getName()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//tr[1]//td[2]"))).getText();
	}
	
	public String getEmail()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//tr[3]//td[2]"))).getText();
	}
	
	public String getjobTitle()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//tr[4]//td[2]"))).getText();
	}
	
	public String getNmlsId()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//tr[5]//td[2]"))).getText();
	}
	
	public String getdirectPhoneNumber()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//tr[6]//td[2]"))).getText();
	}
	
	public String getMobileNumber()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//tr[7]//td[2]"))).getText();
	}
	
	public String getOfficeAddress()
	{
		WebDriverWait wait = new WebDriverWait(driver, 90);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//tr[8]//td[2]"))).getText();
	}
	
	
}
