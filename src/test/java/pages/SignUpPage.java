package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import test_suites.Base;

public class SignUpPage extends HomePage {
	@FindBy(xpath = "//a[text()='Register Here']")
	WebElement register;
	@FindBy(xpath = "//*[@id='firstName']")
	WebElement firstname;
	@FindBy(xpath = "//*[@id='lastName']")
	WebElement lastname;
	@FindBy(xpath = "//*[@id='email']")
	WebElement email;
	@FindBy(xpath = "//*[@id='contactNumber']")
	WebElement contactNum;
	@FindBy(xpath = "//*[@id='password']")
	WebElement password;
	@FindBy(xpath = "//*[@id='confirmPassword']")
	WebElement confirmPassword;
	@FindBy(xpath = "//*[@name='_eventId_billing']")
	WebElement submit;
	
	@FindBy(xpath = "//*[@id='addressLineOne']")
	WebElement Address1;
	@FindBy(xpath = "//*[@id='addressLineTwo']")
	WebElement Address2;
	@FindBy(xpath = "//*[@id='city']")
	WebElement city;
	@FindBy(xpath = "//*[@id='postalCode']")
	WebElement postalcode;
	@FindBy(xpath = "//*[@id='state']")
	WebElement state;
	@FindBy(xpath = "//*[@id='country']")
	WebElement country;
	@FindBy(xpath = "//*[@name='_eventId_confirm']")
	WebElement confirm;
	@FindBy(xpath = "//*[@class='btn btn-lg btn-primary']")
	WebElement confirm1;
	
	WebDriver driver;

	public SignUpPage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);
	}

	public void isSignUpPage() throws InterruptedException {
		SignUp.click();
		Thread.sleep(1000);
		try {
		Assert.assertEquals("Sign Up - Personal", SignUpDescription.getText());
		log.info("Sign Up - Personal page validation passed");
		}catch(Exception e) {
			log.error(e);
		}
	}
	// Get the title of Login Page
		public String getSignUpPageTitle() {
			return driver.getTitle();
		}
		public void register_SignUp() throws InterruptedException {
			Thread.sleep(1000);
			driver.navigate().to("http://localhost:8080/medicare/login");
			Thread.sleep(1000);
			register.click();
			Thread.sleep(2000);
			log.info("Naviagated to Sign Up - Page");
			firstname.sendKeys("tuwq2w11");
			Thread.sleep(1000);
			lastname.sendKeys("tuwwq211");
			Thread.sleep(1000);
			email.sendKeys("testwwq13@gmail.com");
			Thread.sleep(1000);
			contactNum.sendKeys("17234152");
			Thread.sleep(1000);
			password.sendKeys("T12ew34516");
			Thread.sleep(1000);
			confirmPassword.sendKeys("T12ew34516");
			Thread.sleep(1000);
			submit.click();
			Thread.sleep(2000);
			
			Address1.sendKeys("Toeenw2");
			Thread.sleep(1000);
			Address2.sendKeys("Toeenw13");
			Thread.sleep(1000);
			city.sendKeys("Citeew12");
			Thread.sleep(1000);
			postalcode.sendKeys("86344");
			Thread.sleep(1000);
			state.sendKeys("Staeewe11");
			Thread.sleep(1000);
			country.sendKeys("Counewye11");
			Thread.sleep(1000);
			confirm.click();
			Thread.sleep(2000);
			confirm1.click();
			Thread.sleep(2000);
		}
		
		}

