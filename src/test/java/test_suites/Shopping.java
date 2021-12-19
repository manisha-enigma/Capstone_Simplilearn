package test_suites;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.*;

public class Shopping extends Base {

	@Test(priority = 0 , enabled=true)
	@Parameters({ "ivusername", "password" })
	public void InValidUserLoginCheck(String ivusername,String password) throws InterruptedException {
		LogInPage LP = new LogInPage();
		Thread.sleep(2000);
		LP.InValidUserLog(URL, ivusername, password);
	}
	
	@Test(priority = 1, enabled=true)
	@Parameters({ "username", "epassword" })
	public void InValidPasswordLogin_Check1(String username, String epassword) throws InterruptedException {
		LogInPage LP = new LogInPage();
		Thread.sleep(2000);
		LP.InValidPassLog(URL, username, epassword);
	}
	@Test(priority = 2, enabled = true)
	@Parameters({ "username", "inpassword" })
	public void InvalidPassword_Check2(String username, String inpassword) throws InterruptedException {
		LogInPage LP1 = new LogInPage();
		Thread.sleep(2000);
		LP1.InValidPassLog1(URL, username, inpassword);
	}
	
	@Test(priority = 3, enabled = true)
	@Parameters({ "username", "password" })
	public void ValidUserLoginCheck(String username, String password) throws InterruptedException {
		LogInPage LP = new LogInPage();
		Thread.sleep(2000);
		LP.ValidUserLog(URL, username, password);
	}

	
	@Test(priority = 3, enabled = true)
	public void ViewProductList() throws InterruptedException {
		ViewProductsPage VPP = new ViewProductsPage();
		Thread.sleep(2000);
		VPP.ProductList();
	}

	@Test(priority = 3, enabled = true)
	public void ViewProductList_DropDownCheck() throws InterruptedException {
		ViewProductsPage DD = new ViewProductsPage();
		Thread.sleep(2000);
		DD.ShowEntriesDropDown();
	}
	@Test(priority = 4, enabled = true)
	public void SearchBox_Check() throws InterruptedException {
		ViewProductsPage S1 = new ViewProductsPage();
		Thread.sleep(2000);
		S1.searchBox();
	}
		
	@Test(priority = 5, enabled = true)
	@Parameters({"med1", "med2"})
	public void MedAddCart(String med1, String med2) throws InterruptedException {
		AddProducttoCart AC = new AddProducttoCart();
		Thread.sleep(2000);
		AC.AddMedicine(med1, med2);
	}
	
	@Test(priority = 6, enabled = true)
	@Parameters({"med1", "med2"})
	public void checkCart(String med1, String med2) throws InterruptedException {
		CartPage CP = new CartPage();
		Thread.sleep(2000);
		CP.checkCart(med1, med2);
	}
	
	@Test(priority = 7, enabled = true)
	public void selectShipping() throws InterruptedException {
		ShippingPage SP = new ShippingPage();
		Thread.sleep(2000);
		SP.shippingPage();
	}
	
	
	@Test(priority = 7, enabled = true)
	public void orderConfirm() throws InterruptedException {
		OrderConfirmationPage OCP = new OrderConfirmationPage();
		Thread.sleep(2000);
		OCP.orderComplete();
	}
	
	@Test(priority = 8, enabled = true)
	public void userLogOutClick() throws InterruptedException {
		LogOutPage LO = new LogOutPage();
		Thread.sleep(2000);
		LO.logOut();
	}
   @Test(priority = 9, enabled = true)
	public void register_SignUpNewUser() throws InterruptedException {
		SignUpPage Rg = new SignUpPage();
		Thread.sleep(2000);
		Rg.register_SignUp();
	
	}
	
}
