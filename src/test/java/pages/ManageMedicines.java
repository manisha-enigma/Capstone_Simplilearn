package pages;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import test_suites.Base;

public class ManageMedicines extends HomePage {

	WebDriver driver;
	
	@FindBy(xpath = "//*[@id='name']")
	WebElement iname;
	@FindBy(xpath = "//*[@id='description']")
	WebElement idescprition;
	@FindBy(xpath = "//*[@id='brand']")
	WebElement ibrand;
	@FindBy(xpath = "//*[@id='unitPrice']")
	WebElement iunitPrice;
	@FindBy(xpath = "//*[@id='quantity']")
	WebElement iquantity;
	@FindBy(xpath = "//*[@id='categoryId']//following::input[5]")
	WebElement Save;
	@FindBy(xpath = "//table[@id='productsTable']/tbody")
	WebElement Tbody;
	@FindBy(xpath = "//*[@class='slider round']")
	WebElement slider;

	public ManageMedicines() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);
	}
	
	public void AddProduct(String name, String brand, String unitprice, String category) throws InterruptedException {
		Thread.sleep(3000);
		iname.sendKeys(name);
		ibrand.sendKeys(brand);
		idescprition.sendKeys("Pain Killer");
		iunitPrice.sendKeys(unitprice);
		iquantity.sendKeys("5");
		WebElement chooseFile = driver.findElement(By.id("file"));
		chooseFile.sendKeys("C:\\Users\\Admin\\Desktop\\Simplilearn Automation\\phase5Capstone\\project\\pp\\medicarecaps-master\\medicarecaps-master\\med.jpg");
		driver.findElement(By.xpath("//*[@id='categoryId']/option[" +category+ "]")).click();
		try {
		Assert.assertTrue(Save.isEnabled());
		log.info("Adding a product validation passed");
		}catch (Exception e) 
		{
			log.error(e);
		}
		Save.click();
		Thread.sleep(1000);
	}

	public void EditQty(String medname, String qty) throws InterruptedException {
		Thread.sleep(3000);
		List<WebElement> row = Tbody.findElements(By.tagName("tr"));
		log.info("Total number of products in the page = " + row.size());
		int ch = 0;
		for(WebElement mlist : row) {
			ch++;
			WebElement lname = driver.findElement(By.xpath("//*[@id='productsTable']/tbody/tr[" +ch+ "]/td[3]"));
			String lsname = lname.getText();
			if(lsname.equals(medname)) {
				WebElement Edit = driver.findElement(By.xpath("//*[@id='productsTable']/tbody/tr[" +ch+ "]/td[8]/a"));
				Edit.click();
			}
		break;
		}
		Thread.sleep(1000);
		iquantity.clear();
		iquantity.sendKeys(qty);
		try {
			Assert.assertTrue(Save.isEnabled());
			log.info("Edit Save button enabled product validation passed");
			}catch (Exception e) 
			{
				log.error(e);
			}
			Save.click();
		Thread.sleep(2000);
	}
	
	public void EditQtyConfirm(String medname) throws Exception {
		Connection con = null;
        con = ConnectionManager.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select quantity from medicare.Product where name=\"Paracetamol\";");
        rs.next();
        int Quantity = rs.getInt(1); 
        rs.close();
		driver.navigate().to("http://localhost:8080/medicare/manage/product");
		Thread.sleep(3000);
		List<WebElement> row = Tbody.findElements(By.tagName("tr"));
		log.info("Total number of products in the page = " + row.size());
		int ch = 0;
		for(WebElement mlist : row) {
			ch++;
			WebElement lname = driver.findElement(By.xpath("//*[@id='productsTable']/tbody/tr[" +ch+ "]/td[3]"));
			String lsname = lname.getText();
			WebElement lsqty = driver.findElement(By.xpath("//*[@id='productsTable']/tbody/tr[" +ch+ "]/td[5]"));
			String uqty = lsqty.getText();
			if(lsname.equals(medname)) {
				Assert.assertEquals(uqty, Integer.toString(Quantity));
				log.info("Edited quanity of product validation passed");
			}
		break;
		}
	}
	public void ActivateDeActivate (String medname) throws InterruptedException{
		slider.click();
		Thread.sleep(3000);
		driver.switchTo().activeElement();
		Thread.sleep(3000);
		
	    String Msg1 = driver.findElement(By.xpath("//*[@class='bootbox-body']")).getText();
	    System.out.println( Msg1 );
	 
	    driver.switchTo().activeElement().findElement(By.xpath("//*[@data-bb-handler='confirm']")).click();
	   
	    Thread.sleep(5000);
	    String Msg2 = driver.findElement(By.xpath("//*[@class='modal-content']")).getText();
	    System.out.println(Msg2);
	    Thread.sleep(3000);
	    driver.switchTo().activeElement().findElement(By.xpath("//*[@data-bb-handler='ok']")).click();
	    Thread.sleep(5000);
	    String Msg3 = driver.findElement(By.xpath("//*[@class='modal-content']")).getText();
	    System.out.println(Msg3);
	    Thread.sleep(3000);

}
}


