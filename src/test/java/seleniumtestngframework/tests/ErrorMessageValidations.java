package seleniumtestngframework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumtestngframework.TestComponents.BaseTest;

public class ErrorMessageValidations extends BaseTest {
	@Test
	public void validateLoginErrorMessage(){
		loginPage.loginApplication("anshika@gmail.com", "Iamking@000111");
		String errorMessageText = loginPage.getErrorMessage();
		Assert.assertEquals(errorMessageText, "Incorrect email or password.");
	}
}
