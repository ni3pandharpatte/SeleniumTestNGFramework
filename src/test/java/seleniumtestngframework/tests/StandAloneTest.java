package seleniumtestngframework.tests;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumtestngframework.TestComponents.BaseTest;
import seleniumtestngframeworkdesign.pageobjects.LoginPage;
import seleniumtestngframeworkdesign.pageobjects.ProductCatalog;

public class StandAloneTest extends BaseTest {

	@Test
	public void validateCheckBoxCount() throws IOException {
		// LoginPage loginPage = lauchApplication();  
		// above object creation method lauchApplication() defined as @BeforeMethod
		// So It will be executed before every test method
		// We can directly use the loginPage object here because loginPage object is defined in the extended BaseTest class
		
		System.out.println("Login Page: " + loginPage.getPageTitleText());
		
		// Product Page
		ProductCatalog productCatalog = loginPage.loginApplication("anshika@gmail.com", "Iamking@000");
		System.out.println("Product Page: " + productCatalog.getPageTitleText());
		int checkBoxCount = productCatalog.getCheckBoxListCount();
		Assert.assertEquals(checkBoxCount, 23);
		// closeDriver();
		// above object creation method closeDriver() defined as @AfterMethod
		// So It will be executed before every test method
	}

}
