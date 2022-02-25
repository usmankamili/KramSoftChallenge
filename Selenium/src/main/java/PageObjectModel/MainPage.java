package PageObjectModel;

import org.openqa.selenium.By;

import Assignment.Selenium.Driver;

public class MainPage extends Driver{
	
	public void clickTryItOutButton()
	{
		driver.findElement(By.xpath(".//span[text()='try it out']")).click();
	}

	public void clickLoginButton()
	{
		driver.findElement(By.xpath(".//span[text()='Log In']")).click();
	}

}
