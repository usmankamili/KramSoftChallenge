package Assignment.Selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	public static WebDriver driver; 
	public void intializeDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver cdriver  = new ChromeDriver();
		cdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cdriver.manage().window().maximize();
		driver = cdriver;
	}

}
