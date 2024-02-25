package seleniumtestngframeworkdesign.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {

	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementToAppear(By byElementLocator, int waitInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitInSeconds));
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElementLocator));
	}

	public void waitForWebElementToAppear(WebElement webElementLocator, int waitInSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitInSeconds));
		wait.until(ExpectedConditions.visibilityOf(webElementLocator));
	}

	public void waitImplicitly(int waitInSeconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(waitInSeconds));
	}

	public String getPageTitleText() {
		return driver.getTitle();
	}
}
