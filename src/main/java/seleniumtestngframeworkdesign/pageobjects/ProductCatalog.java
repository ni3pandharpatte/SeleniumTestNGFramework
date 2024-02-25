package seleniumtestngframeworkdesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import seleniumtestngframeworkdesign.abstractcomponents.AbstractComponent;

public class ProductCatalog extends AbstractComponent {
	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	By productsBy = By.cssSelector(".mb-3");

	@FindBy(xpath = "//input[@type='checkbox']//following::label")
	List<WebElement> checkBoxList;
	
	//Find the number of checkBox
	public int getCheckBoxListCount() {
		waitForElementToAppear(productsBy, 5);
		return checkBoxList.size(); 
	}

}
