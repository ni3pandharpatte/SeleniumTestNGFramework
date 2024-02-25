package seleniumtestngframework.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import seleniumtestngframeworkdesign.abstractcomponents.AbstractComponent;
import seleniumtestngframeworkdesign.pageobjects.LoginPage;

public class BaseTest {
	WebDriver driver;
	public LoginPage loginPage;
	
	public WebDriver initializeDriver() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\seleniumtestngframework\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = System.getProperty("browser")!= null ? System.getProperty("browser"): prop.getProperty("browser");
		
		
		System.out.println(System.getProperty("user.dir"));
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		
		AbstractComponent abc = new AbstractComponent(driver);
		abc.waitImplicitly(10);
		driver.manage().window().maximize();
		
		return driver;
	}
	
	@BeforeMethod
	public void lauchApplication() throws IOException {
		driver = initializeDriver();
		loginPage = new LoginPage(driver);
		loginPage.goTo();
	}
	
	@AfterMethod
	public void closeDriver() {
		driver.quit();
	}

}
