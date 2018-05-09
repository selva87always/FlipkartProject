package stepDefinition;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class FlipkartAddToCart extends BaseClass{
	
	@Given("^User open Flipart Application in browser$")
	public void user_open_Flipart_Application_in_browser() throws Throwable {
		getDriver();
	    openApplication("https://www.flipkart.com/");
	    Actions action = new Actions(driver);
	    action.sendKeys(Keys.ESCAPE).build().perform();
	}

	@When("^User search the \"([^\"]*)\" and add to the cart$")
	public void user_search_the_and_add_to_the_cart(String item) throws Throwable {
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		driver.findElement(By.name("q")).sendKeys(item);
		
		driver.findElement(By.xpath("//*[@id='container']/div/header/div[1]/div/div/div/div[1]/form/div/div[2]/button/svg")).click();
		
		String parentTab = driver.getWindowHandle();
		
		WebElement link1;
		link1= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='container']/div/div[1]/div/div[2]/div/div[2]/div/div[3]/div[1]/div/div[5]/div/a/div[2]/div[1]/div[1]")));
		link1.click();
		
		Set<String> allTabIds = driver.getWindowHandles();
		for (String currentTab : allTabIds) {
			if(!currentTab.equals(parentTab))
				driver.switchTo().window(currentTab);
		}
			
		driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();
		
		driver.switchTo().window(parentTab);
	}

	@Then("^User verifies whether that item added in cart or not$")
	public void user_verifies_whether_that_item_added_in_cart_or_not() throws Throwable {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[2]/div[1]/div[1]/div[1]/div[1]/a")));
		boolean ItemInCart = element.isDisplayed();
		Assert.assertTrue(ItemInCart);
	}
}
