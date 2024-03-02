package seleniumtestngframework.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import seleniumtestngframework.TestComponents.BaseTest;

public class LoginTests extends BaseTest {
	@Test
	public void captureLoginButtonImage() throws IOException {
		loginPage.captureLoginButtonImage();
	}
	
	@Test
	public void validateLoginButtonStyleUsingImage() throws IOException {
		loginPage.validateLoginButtonImage();
	}
}
