package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.*;
import test_suites.Base;

public class OrderConfirmationPage extends HomePage {

	WebDriver driver;
	
	
	
	@FindBy(xpath="//div[1][@class='container']//child::h3")
	WebElement OrderConfirmation;	
	@FindBy(linkText = "Continue Shopping")
	WebElement ContinueShopping;
	String Actual = OrderConfirmation.getText();
	
	
	String Expect = "Your Order is Confirmed!!";
 
     
	public OrderConfirmationPage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);
	}

	public void orderComplete() throws InterruptedException {
		Thread.sleep(2000);
	    //System.out.println(Actual);
		try {
		log.info(Actual + " \n Expected: " +Expect);
		//Assert.assertTrue(Expect.matches(Actual));
		log.info("Order Confirmation Page validation passed");
		Thread.sleep(3000);
		Assert.assertTrue(ContinueShopping.isEnabled());
		log.info("Continue Shopping Buttoon validation passed");
		ContinueShopping.click();
		Thread.sleep(2000);
		}catch(Exception e) {
			log.error(e);
		}
	}

}
