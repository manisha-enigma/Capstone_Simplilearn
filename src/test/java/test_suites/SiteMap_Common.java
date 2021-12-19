package test_suites;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.*;

public class SiteMap_Common extends Base {

	@Test(priority = 0)
	public void validateHomePage() throws InterruptedException {
		HomePage HP = new HomePage();
		HP.isHomePage();
		   Assert.assertTrue(HP.getHomePageTitle().contains("Medicare - Home"));
		   String pageTitle = HP.getHomePageTitle();
		   System.out.println(pageTitle);
		 
		Thread.sleep(3000);

	}

	@Test(priority = 1)
	public void validateContactPage() throws InterruptedException {
		ContactPage CP = new ContactPage();
		CP.isContactPage();
		 //Verify home page
		   Assert.assertTrue(CP.getContactPageTitle().contains("Medicare - Contact"));
		   Thread.sleep(1000);
		   
		   String pageTitle = CP.getContactPageTitle();
		   System.out.println(pageTitle);
		   Thread.sleep(2000);
		
	}

	@Test(priority = 2)
	public void validateAboutPage() throws InterruptedException {
		AboutPage AP = new AboutPage();
		AP.isAboutPage();
		Assert.assertTrue(AP.getAboutPageTitle().contains("Medicare - About Us"));
		   Thread.sleep(500);
		   
		   String pageTitle = AP.getAboutPageTitle();
		   System.out.println(pageTitle);
		Thread.sleep(500);
	}

	@Test(priority = 3)
	public void validateViewProducts() throws InterruptedException {
		ViewProductsPage VPP = new ViewProductsPage();
		VPP.isViewAllProductPage();
		 
		   Assert.assertTrue(VPP.getProductsPageTitle().contains("Medicare - All Products"));
		   Thread.sleep(500);
		   String pageTitle = VPP.getProductsPageTitle();
		   System.out.println(pageTitle);
		Thread.sleep(500);
	}

	@Test(priority = 4)
	public void validate_Categories_AntipyreticsViewProducts() throws InterruptedException {
		ViewProductsPage VPP = new ViewProductsPage();
		VPP.isAntipyretics();
		Thread.sleep(500);
	}

	@Test(priority = 5)
	public void validate_Categories_AnalgesicsViewProducts() throws InterruptedException {
		ViewProductsPage VPP = new ViewProductsPage();
		VPP.isAnalgesics();
		Thread.sleep(500);
	}

	@Test(priority = 6)
	public void validate_Categories_AntibioticsViewProducts() throws InterruptedException {
		ViewProductsPage VPP = new ViewProductsPage();
		VPP.isAntibiotics();
		Thread.sleep(500);
	}

	@Test(priority = 7)
	public void validateSignupPage() throws InterruptedException {
		SignUpPage SP = new SignUpPage();
		SP.isSignUpPage();
		Assert.assertTrue(SP.getSignUpPageTitle().contains("Medicare - Membership"));
		   Thread.sleep(500);
		   
		   String pageTitle = SP.getSignUpPageTitle();
		   System.out.println(pageTitle);
		   Thread.sleep(2000);
		Thread.sleep(500);
	}

	@Test(priority = 8)
	public void validateLoginPage() throws InterruptedException {
		LogInPage LP = new LogInPage();
		LP.isLoginPage();
		 Assert.assertTrue(LP.getLoginPageTitle().contains("Medicare - Login"));
		   Thread.sleep(500);
		   String pageTitle = LP.getLoginPageTitle();
		   System.out.println(pageTitle);
		   Thread.sleep(500);
	
	}

}
