package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import test_suites.Base;

public class ContactPage extends HomePage {

	WebDriver driver;

	@FindBy(xpath = "//li[@id='contact']")
	WebElement Contact;
	@FindBy(xpath = "//div[@class='row']//h1")
	WebElement Description;
	@FindBy(tagName = "title")
	private WebElement homeTitle;
	
	public ContactPage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);
	}

	public void isContactPage() throws InterruptedException {
		Contact.click();
		Thread.sleep(1000);
		try {
		Assert.assertEquals("Contact Us", Description.getText());
		log.info("Contact Us page test passed");
		} catch(Exception e) {
			log.error(e);
		}
	}
	// Get the title of Contact Page	
	public String getContactPageTitle() {
		return driver.getTitle();
	}	
}
