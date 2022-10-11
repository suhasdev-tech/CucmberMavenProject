package stepdefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.nopCom.pageObject.AdminPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.nopCom.pageObject.AddCustomerPage;

public class StepDefination extends Base {

	@Given("User lauch chrome browser")
	public void user_lauch_chrome_browser() throws Exception {
	   System.setProperty("webdriver.chrome.driver","E:\\Chrome_105\\chromedriver_win32\\chromedriver.exe");
	   driver=new ChromeDriver();
	   Thread.sleep(2000);
	   ad=new AdminPage(driver);
	}

	@When("User open url {string}")
	public void user_open_url(String Url) throws Exception {
	    driver.get(Url);
	    driver.manage().window().maximize();
	    Thread.sleep(2000);
	}

	@When("User enter email as {string} and password as {string}")
	public void user_enter_email_as_and_password_as(String email, String password) throws Exception {
	   ad.setUserName(email);
	   ad.setPassword(password);
	    Thread.sleep(2000);

	}

	@When("User click on Login button")
	public void user_click_on_login_button() throws Exception {
	   ad.clickLogin();
	    Thread.sleep(2000);

	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title) throws Exception {
	    Assert.assertEquals(title, driver.getTitle());
	    Thread.sleep(2000);

	}

	@Then("close browser.")
	public void close_browser() throws Exception {
	   driver.close();
	   Thread.sleep(3000);
	}
	
	//add new customer
	
	//add new customer
		@Then("User can view Dashboard")
		public void user_can_view_dashboard() {
		 addCust=new AddCustomerPage(driver);
		 Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
		}

		@When("Click on customers menu")
		public void click_on_customers_menu() throws Exception {
		Thread.sleep(2000);
			addCust.clickOnCustomesMenu();
		}

		@When("Click on customers menu item")
		public void click_on_customers_menu_item() throws Exception {
			Thread.sleep(2000);

			addCust.clickOnCustomesMenuItem();
		}

		@When("Click on add new button")
		public void click_on_add_new_button() throws Exception {
		 addCust.clickOnAddNew();
			Thread.sleep(2000);

		}

		@Then("User can view add new customer page")
		public void user_can_view_add_new_customer_page() throws Exception {
			Thread.sleep(2000);

			Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
		}

		
		
		@When("User enter customer info as {string} and {string} and {string} and {string} and {string} and {string} and {string}")
		public void user_enter_customer_info_as_and_and_and_and_and_and(String newEmail, String NewPassword, String firstName, String lastName, String gender, String cName, String admContent) throws Exception {
			addCust.SetEmail(newEmail);
			addCust.SetPassword(NewPassword);
			addCust.SetFirstName(firstName);
			addCust.SetLastName(lastName);
			addCust.SetGender(gender);
			addCust.SetCompanyName(cName);
			addCust.SetAdminContent(admContent);
			Thread.sleep(3000);
		}

		@When("click on save button")
		public void click_on_save_button() {
		
			addCust.clickOnSave();
		}

		@Then("user can view confirmation msg {string}")
		public void user_can_view_confirmation_msg(String string) throws Exception {
		  Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully."));
			Thread.sleep(2000);

		}
}
