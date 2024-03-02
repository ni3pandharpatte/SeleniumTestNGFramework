package seleniumtestngframeworkdesign.abstractcomponents;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;

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

	public String getBaseImagesDir() {
		return System.getProperty("user.dir") + "\\src\\main\\java\\data\\baseImages\\";
	}

	public String getResourceImagesDir() {
		return System.getProperty("user.dir") + "\\src\\test\\java\\seleniumtestngframework\\resources\\";
	}

	public boolean compareImages(String expectedImageName, WebElement elementToCapture) throws IOException {
		String expectedImagePath = getBaseImagesDir() + expectedImageName + ".png";

		BufferedImage expectedImage = ImageIO.read(new File(expectedImagePath));

		AShot ashot = new AShot();
		Screenshot screenshot = ashot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,
				elementToCapture);
		BufferedImage actualImage = screenshot.getImage();

		ImageDiffer imageDiffer = new ImageDiffer();
		ImageDiff diff = imageDiffer.makeDiff(expectedImage, actualImage);
		if (diff.hasDiff()) {
			return false;
		} else {
			return true;
		}
	}

	public void captureImage(WebElement elementToCapture, String imageName) throws IOException {
		String imagePath = getBaseImagesDir() + imageName + ".png";
		AShot ashot = new AShot();
		// To solve this error: org.openqa.selenium.JavascriptException: JavaScript
		// error: $ is not defined
		// user-> coordsProvider
		// Screenshot productImageScreenshot = ashot.takeScreenshot(driver,
		// imageElement);
		Screenshot productImageScreenshot = ashot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,
				elementToCapture);
		boolean isImageCreated = ImageIO.write(productImageScreenshot.getImage(), "png", new File(imagePath));

		if (isImageCreated) {
			System.out.println("image is captured and stored at: " + imagePath);
		} else {
			System.out.println("Failed to create image: " + imageName + ".png");
		}
	}
}
