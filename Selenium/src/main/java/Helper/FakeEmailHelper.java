package Helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FakeEmailHelper {
	
	static WebDriver secondarydriver;
	
	public static void invokeDriver()
	{
		WebDriverManager.chromedriver().setup();
		secondarydriver = new ChromeDriver();
	}
	
	public static String GetFakeEmail()
	{
		invokeDriver();
		secondarydriver.get("https://emailfake.com/");		
		String username =secondarydriver.findElement(By.id("userName")).getAttribute("value");
		String domain = secondarydriver.findElement(By.id("domainName2")).getAttribute("value");
		return username + "@" + domain;
	}
	
	public static String getVerifyAccountLink()
	{
		secondarydriver.navigate().refresh();
		String url =  secondarydriver.findElement(By.xpath(".//a[text()='verify your account now']")).getAttribute("href");
		secondarydriver.close();
		return url;
	}

}
