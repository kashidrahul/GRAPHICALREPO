package StepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import io.cucumber.java.en.*;

public class StepDef 
{
	public WebDriver driver;
	public LoginPage loginPg;
	public AddNewCustomerPage addNewCustPg;
	
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() 
	{
	    driver = new ChromeDriver();
	    loginPg = new LoginPage(driver);
	    addNewCustPg = new AddNewCustomerPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) 
	{
	    driver.get(url);
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String password) 
	{
		loginPg.enterEmail(emailAdd);
		loginPg.enterPassword(password);
	}

	@When("Click on Login")
	
	public void click_on_login() 
	{
	    loginPg.clickOnLoginButton();
	}

//////////////////////Login Feature////////////////////////////////////////////////////////
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) 
	{
	    String actualTitle=driver.getTitle();
	    
	    if(actualTitle.equals(expectedTitle))
	    {
	    	Assert.assertTrue(true);//pass
	    }
	    else
	    {
	    	Assert.assertTrue(false);//fail
	    }
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() 
	{
	   loginPg.clickOnLogOutButton(); 
	}

	@Then("close browser")
	public void close_browser() 
	{
		driver.close();
		driver.quit();
	}
	
////////////////////////////////////////////Add New Customer/////////////////////////////////
	
	@Then("User can view Dashboad")
	public void user_can_view_dashboad() 
	{
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Dashboard / nopCommerce administration";
		
		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() 
	{
		addNewCustPg.clickOnCustomersMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() 
	{
		addNewCustPg.clickOnCustomersMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() 
	{
		addNewCustPg.clickOnAddnew();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page()
	{
		String actualTitle = addNewCustPg.getPageTitle();
		String expectedTitle = "Add a new customer / nopCommerce administration";
		
		if(actualTitle.equals(expectedTitle))
		{
			Assert.assertTrue(true);//pass
		}
		else
		{
			Assert.assertTrue(false);//fail
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() 
	{
		addNewCustPg.enterEmail("kashidrahuavp@gmail.com");
		addNewCustPg.enterPassword("Rahul");
		addNewCustPg.enterFirstName("Rahul");
		addNewCustPg.enterLastName("Kashid");
		addNewCustPg.enterGender("Male");
		addNewCustPg.enterDob("11/15/1989");
		addNewCustPg.enterCompanyName("Neosoft");
		addNewCustPg.enterAdminContent("Admin content");
		addNewCustPg.enterManagerOfVendor("Vendor 1");
	}

	@When("click on Save button")
	public void click_on_save_button() 
	{
		addNewCustPg.clickOnSave();
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmationMsg) 
	{
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains(expectedConfirmationMsg))
		{
			Assert.assertTrue(true);//pass
		}
		else
		{
			Assert.assertTrue(false);//fail
		}
	}
}
