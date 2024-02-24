package navigationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods.WrapClass;

public class LoginPage {
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//WebElements LoginPage
	@FindBy(id = "user-name")
	private WebElement userNameTxt;
	@FindBy(id = "password")
	private WebElement passwordTxt;
	@FindBy(name = "login-button")
	private WebElement btnLogin;
	@FindBy(xpath = "//*[@data-test = 'error']")
	private WebElement lockError;
	
	//Methods LoginPage
	public void login(String user, String pwd) {
		WrapClass.sendKeys(userNameTxt, user);
		WrapClass.sendKeys(passwordTxt, pwd);
		WrapClass.click(btnLogin);
	
	}
	
	public boolean validateLockError () {
		boolean errorDisplayed = WrapClass.getText(lockError).contains("Sorry, this user has been locked out");
		return errorDisplayed;
	}

}
