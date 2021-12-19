package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import test_suites.Base;

public class LogInPage extends HomePage {
	@FindBy(xpath = "//*[@id='username']")
	WebElement UserName;
	@FindBy(xpath = "//*[@id='password']")
	WebElement Password;
	@FindBy(xpath = "//*[@id='loginForm']/div[3]/div/input[2]")
	WebElement ClickLogin;
	@FindBy(xpath = "//a[@id='dropdownMenu1']")
	WebElement CurrentUser;
	@FindBy(xpath = "//*[@id='logout']/a")
	WebElement LogOut;
	@FindBy(xpath = "//*[@id='username-error']")
	WebElement UError;
	@FindBy(xpath = "//*[@id='password-error']")
	WebElement PError;
	@FindBy(xpath = "//*[@class='alert alert-danger fade in']")
	WebElement PError1;
	@FindBy(xpath = "//*[@id='dropdownMenu1']/text()")
	WebElement AdminUser;
	


	String eu = "tu tu";
	SoftAssert softAssert = new SoftAssert();

	public LogInPage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);

	}

	public void isLoginPage() throws InterruptedException {
		driver.navigate().back();
		Thread.sleep(1000);
		Login.click();
		Thread.sleep(1000);
		try {
		Assert.assertEquals("Login", LoginDescription.getText());
		log.info("Login page validation passed");
		}catch(Exception e) {
			log.error(e);
		}
	}
	// Get the title of Login Page
		public String getLoginPageTitle() {
			return driver.getTitle();
		}

	public void ValidUserLog(String URL, String uname, String pass) throws InterruptedException {
		driver.get(URL);
		Thread.sleep(1000);
		Login.click();
		Thread.sleep(1000);
		UserName.sendKeys(uname);
		Password.sendKeys(pass);
		ClickLogin.click();
		Thread.sleep(1000);
		try {
		Assert.assertEquals(eu, CurrentUser.getText());
		log.info("Login Successful for " +uname);
		}catch(Exception e) {
			log.error(e);
		}
	}
	
	public void ValidAdminUserLog(String auname, String apass) throws InterruptedException {
		Thread.sleep(1000);
		driver.navigate().to("http://localhost:8080/medicare/login");
		Thread.sleep(1000);
		UserName.sendKeys(auname);
		Password.sendKeys(apass);
		ClickLogin.click();
		Thread.sleep(1000);
	}

	public void InValidUserLog(String URL, String uname, String pass) throws InterruptedException {
		driver.get(URL);
		Thread.sleep(1000);
		Login.click();
		Thread.sleep(1000);
		UserName.sendKeys(uname);
		Password.sendKeys(pass);
		Thread.sleep(1000);
		try {
		log.warn("Error Message on the Login Page ---> " + UError.getText());
		softAssert.assertEquals("Please enter a valid email address!", UError.getText());
		log.info("Invalid user message validation passed");
		softAssert.assertAll();
		}catch(Exception e) {
			log.error(e);
		}
	}
	
	public void InValidPassLog(String URL, String uname, String pass) throws InterruptedException {
		driver.get(URL);
		Thread.sleep(1000);
		Login.click();
		Thread.sleep(1000);
		UserName.sendKeys(uname);
		Password.sendKeys(pass);
		ClickLogin.click();
		Thread.sleep(1000);
		try {
		log.warn("Error Message on the Login Page ---> " + PError.getText());
		softAssert.assertEquals("Please enter your password!", PError.getText());
		log.info("Login with proper username and password validation passed");
		softAssert.assertAll();
		}catch(Exception e) {
			log.error(e);
		}
	}

	public void InValidPassLog1(String URL, String uname, String pass) throws InterruptedException {
		driver.get(URL);
		Thread.sleep(1000);
		Login.click();
		Thread.sleep(1000);
		UserName.sendKeys(uname);
		Password.sendKeys(pass);
		ClickLogin.click();
		Thread.sleep(1000);
		try {
		log.warn("Error Message on the Login Page ---> " + PError1.getText());
		softAssert.assertEquals("Username and Password is invalid!", PError.getText());
		log.info("Login with proper username and password validation passed");
		softAssert.assertAll();
		}catch(Exception e) {
			log.error(e);
		}
	}
}
