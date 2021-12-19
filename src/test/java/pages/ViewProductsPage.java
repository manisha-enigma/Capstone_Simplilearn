package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import test_suites.Base;

public class ViewProductsPage extends HomePage {

	WebDriver driver;
	@FindBy(tagName = "title")
	private WebElement homeTitle;
	@FindBy(xpath = "//*[@class='breadcrumb']/li[2]")
	WebElement AllProducts;
	@FindBy(xpath = "//table[@id='productListTable']/tbody")
	WebElement Tbody;
	@FindBy(xpath = "//*[@class='form-control input-sm']")
	WebElement dropdown;
	@FindBy(xpath = "//*[@type='search']")
	WebElement search;

	public ViewProductsPage() {
		driver = Base.driver;
		// Web element Initializing
		PageFactory.initElements(driver, this);
	}

	public void isViewAllProductPage() throws InterruptedException {
		ViewProducts.click();
		Thread.sleep(3000);
		try {
		Assert.assertEquals("Categories", Categories.getText());
		log.info("View Product Page validation Passed");
		
		}catch(Exception e) {
			log.error(e);
		}
	}

	public void isAntipyretics() throws InterruptedException {
		// ViewProducts.click();
		Thread.sleep(3000);
		Antipyretics.click();
		Thread.sleep(3000);
		try {
		Assert.assertEquals("Antipyretics", CurrentSelection.getText());
		log.info("Antipyretics validation Passed");
		}catch(Exception e) {
			log.error(e);
		}
	}

	public void isAnalgesics() throws InterruptedException {
		// ViewProducts.click();
		Thread.sleep(3000);
		Analgesics.click();
		Thread.sleep(3000);
		try {
		Assert.assertEquals("Analgesics", CurrentSelection.getText());
		log.info("Analgesics validation Passed");
		}catch(Exception e) {
			log.error(e);
		}
	}

	public void isAntibiotics() throws InterruptedException {
		// ViewProducts.click();
		Thread.sleep(3000);
		Antibiotics.click();
		Thread.sleep(3000);
		try {
		Assert.assertEquals("Antibiotics", CurrentSelection.getText());
		log.info("Antibiotics Page validation Passed");
		}catch(Exception e) {
			log.error(e);
		}
	}
	
	
	public void ProductList() throws InterruptedException {
		ViewProducts.click();
		Thread.sleep(3000);
		List<WebElement> row = Tbody.findElements(By.tagName("tr"));
		log.info("Total number of products in the page = " + row.size());
		int ch = 0;
		log.info("Products listed in the current page are : ");
		for(WebElement mlist : row) {
			ch++;
			log.info(driver.findElement(By.xpath("//*[@id='productListTable']/tbody/tr["+ch+"]/td[2]")).getText());
		}
		try {
		Assert.assertEquals("All Products", AllProducts.getText());
		log.info("All Products list page validation Passed");
		}catch(Exception e) {
			log.error(e);
		}
		}
	// Get the title of Products Page
		public String getProductsPageTitle() {
			return driver.getTitle();
		

}
		public void ShowEntriesDropDown() throws InterruptedException {	
		 Select dropdown1 = new Select(dropdown);
		 dropdown1.selectByVisibleText("3 Records");
		 Thread.sleep(1000);
		 log.info("3 Records entry is selected from dropdown and displayed 3 records.");
		 dropdown1.selectByVisibleText("5 Records");
		 Thread.sleep(2000);
		 log.info("5 Records entry is selected from dropdown and displayed max 5 records.");
		 dropdown1.selectByVisibleText("10 Records");
		 Thread.sleep(1000);
		 log.info("10 Records entry is selected from dropdown and displayed max 10 records.");
		 dropdown1.selectByVisibleText("ALL");
		 Thread.sleep(1000);
		 log.info("ALL entry is selected from dropdown and displayed all available records.");
		}
		
		public void searchBox() throws InterruptedException {
			search.sendKeys("Paracetamol");
			Thread.sleep(2000);
			search.clear();
			search.sendKeys("Combiflame");
			Thread.sleep(2000);
			search.clear();
			log.info("User is able to search medicine by entering medicine name in search textbox.");
		}
}
