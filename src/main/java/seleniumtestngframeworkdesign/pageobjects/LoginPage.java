package seleniumtestngframeworkdesign.pageobjects;
import seleniumtestngframeworkdesign.abstractcomponents.AbstractComponent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends AbstractComponent {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
//		PageFactory.initElements(driver, this);
	}

	By userEmail = By.id("userEmail");
	By userPassword = By.id("userPassword");
	By loginButton = By.id("login");
	By errorMessage = By.className("toast-message");

	// Login page

//	@FindBy(id="userEmail")
//	WebElement userEmail;
//	@FindBy(id="userPassword")
//	WebElement userPassword;
//	@FindBy(id="login")
//	WebElement loginButton;
//	@FindBy(css="[class*='flyInOut']")toast-container

	public ProductCatalog loginApplication(String userName, String password) {
		driver.findElement(userEmail).sendKeys(userName);
		driver.findElement(userPassword).sendKeys(password);
		driver.findElement(loginButton).click();
		
		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;
	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}

	public String getErrorMessage() {
		WebElement errorMessageElement = driver.findElement(errorMessage);
		waitForWebElementToAppear(errorMessageElement, 5);
		return errorMessageElement.getText();
	}
}
