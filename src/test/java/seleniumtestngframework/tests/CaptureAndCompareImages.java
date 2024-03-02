package seleniumtestngframework.tests;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import seleniumtestngframework.TestComponents.BaseTest;
import java.io.File;
import java.io.IOException;

public class CaptureAndCompareImages {

	@Test
	public void captureImage() throws IOException, InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		WebElement imageElement = driver.findElement(By.cssSelector("[alt='Google']"));
		String imagePath = System.getProperty("user.dir") + "\\src\\main\\java\\data\\baseImages\\productImage.png";
		AShot ashot = new AShot();
//		To solve this error: org.openqa.selenium.JavascriptException: javascript error: $ is not defined
//		user-> coordsProvider
//		Screenshot  productImageScreenshot = ashot.takeScreenshot(driver, imageElement);
		Screenshot productImageScreenshot = ashot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,
				imageElement);
		ImageIO.write(productImageScreenshot.getImage(), "png", new File(imagePath));

		File file = new File(imagePath);
		if (file.exists()) {
			System.out.println("File exists");
		} else {
			System.out.println("File does not exists");
		}
		driver.quit();
	}

	@Test
	public void compareImages() throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");

		String imagePath = System.getProperty("user.dir") + "\\src\\main\\java\\data\\baseImages\\productImage.png";
		BufferedImage expectedImage = ImageIO.read(new File(imagePath));

		WebElement imageElement = driver.findElement(By.cssSelector("[alt='Google']"));
		AShot ashot = new AShot();
		Screenshot productImageScreenshot = ashot.coordsProvider(new WebDriverCoordsProvider()).takeScreenshot(driver,
				imageElement);
		BufferedImage actualImage = productImageScreenshot.getImage();

		ImageDiffer imageDiffer = new ImageDiffer();
		ImageDiff diff = imageDiffer.makeDiff(expectedImage, actualImage);
		if (diff.hasDiff()) {
			System.out.println("Images are not same");
		} else {
			System.out.println("Images are same");
		}
		driver.quit();
	}
}
