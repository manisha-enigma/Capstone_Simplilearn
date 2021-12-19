package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import test_suites.Base;

public class AboutPage extends HomePage {

	WebDriver driver;

	public AboutPage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);
	}

	public void isAboutPage() throws InterruptedException {
		About.click();
		Thread.sleep(1000);
		try {
		Assert.assertEquals("About Us", AboutDescription.getText());
		log.info("About page validation passed");
		}
		catch(Exception e) {
			log.error(e);
		}
	}
	// Get the title of About Page	
		public String getAboutPageTitle() {
			return driver.getTitle();
}
}
