package Assignment.Selenium;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Helper.FakeEmailHelper;
import Helper.SeleniumHelper;
import Model.Profile;
import PageObjectModel.Dashboard;
import PageObjectModel.EditProfile;
import PageObjectModel.Login;
import PageObjectModel.MainPage;
import PageObjectModel.Registration;
import PageObjectModel.SetPassowrd;

public class Demo {
	WebDriver chromeDriver;
	MainPage mainPage = new MainPage();
	Registration registrationPage = new Registration();
	SetPassowrd setPasswordPage = new SetPassowrd();
	Dashboard dashboardPage = new Dashboard();
	Login loginPage = new Login();
	EditProfile editProfile = new EditProfile();	
	String emailId;
	String passsword;
	
	@BeforeMethod
	public void setup()
	{
		Driver driver = new Driver();
		driver.intializeDriver();
		chromeDriver = Driver.driver;
	}
	
	@AfterMethod
	public void tearDown()
	{
		chromeDriver.quit();
	}
	
	@Test(priority=1)
	public void testRegistration() {
		emailId =  FakeEmailHelper.GetFakeEmail();		
		chromeDriver.get("https://floify.com/");
		mainPage.clickTryItOutButton();
		SeleniumHelper.switchToLastWindow(chromeDriver);
		registrationPage.FillFirstName(SeleniumHelper.getRandomString());
		registrationPage.FillLastName(SeleniumHelper.getRandomString());
		registrationPage.FillEmail(emailId);
		registrationPage.FillPhone("64494949494");
		registrationPage.FillCompany(SeleniumHelper.getRandomString());
		registrationPage.TickAcceptLicense();
		registrationPage.ClickSignUp();
		String actual = registrationPage.SuccessfulReg();
		assertEquals(actual, "Thank You for Joining Floify");
		String url =  FakeEmailHelper.getVerifyAccountLink();
		chromeDriver.get(url);
		passsword = SeleniumHelper.getRandomPassword();
		setPasswordPage.FillPassword(passsword);
		setPasswordPage.FillConfirmPassword(passsword);
		setPasswordPage.ClickSetPassword();
		assertEquals(chromeDriver.getCurrentUrl() , "https://app.floify.com/");
	}
	
	@Test(priority=2 , dependsOnMethods = { "testRegistration" })
	public void testLogin() {
		chromeDriver.get("https://floify.com/");
		mainPage.clickLoginButton();
		SeleniumHelper.switchToLastWindow(chromeDriver);
		loginPage.fillEmail(emailId);
		loginPage.fillPassword(passsword);
		loginPage.ClickLogin();
		assertEquals(chromeDriver.getCurrentUrl() , "https://app.floify.com/");
	}
	
	
	@Test(priority=3, dependsOnMethods = { "testLogin" })
	public void testProfileModifications() throws InterruptedException {
		Profile profile = new Profile();
		profile.setFirstName(SeleniumHelper.getRandomString());
		profile.setLastName(SeleniumHelper.getRandomString());
		profile.setJobTitle(SeleniumHelper.getRandomString());
		profile.setAddress(SeleniumHelper.getRandomString());
		profile.setNmlsId("12345");
		profile.setDirectPhNo("8528528520");
		profile.setMobileNo("45522727421");
		
		chromeDriver.get("https://floify.com/");
		mainPage.clickLoginButton();
		SeleniumHelper.switchToLastWindow(chromeDriver);
		chromeDriver.navigate().refresh();
		loginPage.fillEmail(emailId);
		loginPage.fillPassword(passsword);
		loginPage.ClickLogin();
		dashboardPage.clickYourAccount();
		dashboardPage.clickEditProfile();
		editProfile.fillFirstName(profile.getFirstName());
		editProfile.fillJobTitle(profile.getJobTitle());
		editProfile.filldirectPhone(profile.getDirectPhNo());
		editProfile.fillnmlsId(profile.getNmlsId());	
		editProfile.fillMobilePhone(profile.getMobileNo());		
		editProfile.fillofficeAddress(profile.getAddress());
		editProfile.fillLastName(profile.getLastName());
		editProfile.clickSaveButton();
		chromeDriver.navigate().refresh();
		assertEquals(dashboardPage.getName() , profile.getFirstName() + " " + profile.getLastName());
		assertEquals(dashboardPage.getEmail() , emailId);
		assertEquals(dashboardPage.getdirectPhoneNumber() , profile.getDirectPhNo());
		assertEquals(dashboardPage.getjobTitle() , profile.getJobTitle());
		assertEquals(dashboardPage.getMobileNumber() , profile.getMobileNo());
		assertEquals(dashboardPage.getNmlsId() , profile.getNmlsId());
		assertEquals(dashboardPage.getOfficeAddress() , profile.getAddress());
	}
	
	

}
