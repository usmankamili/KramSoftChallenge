package PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Assignment.Selenium.Driver;

public class EditProfile extends Driver {

	public void fillFirstName(String firstname) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		WebElement firstName = driver.findElement(By.id("firstName"));
		firstName.clear();
		firstName.sendKeys(firstname);
	}

	public void fillLastName(String lastname) {
		WebElement lastName = driver.findElement(By.id("lastName"));
		lastName.clear();
		lastName.sendKeys(lastname);
	}

	public void fillMobilePhone(String mobile) {
		driver.findElement(By.id("mobilePhone")).sendKeys(mobile);
	}

	public void fillJobTitle(String jobTitleName) {
		driver.findElement(By.id("jobTitle")).sendKeys(jobTitleName);
	}

	public void fillnmlsId(String nmls) {
		driver.findElement(By.id("nmlsId")).sendKeys(nmls);
	}

	public void filldirectPhone(String directPhoneNo) {
		WebElement phn = driver.findElement(By.id("directPhone"));
		phn.clear();
		phn.sendKeys(directPhoneNo);
	}

	public void fillofficeAddress(String offAdd) {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("officeAddress")));
		driver.findElement(By.name("officeAddress")).sendKeys(offAdd);
	}

	public void clickSaveButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 90);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("save-profile-btn")));
		Thread.sleep(3000);
		driver.findElement(By.id("save-profile-btn")).click();
	}
}
