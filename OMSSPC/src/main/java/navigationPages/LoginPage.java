package navigationPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonMethods.WrapClass;

public class LoginPage{
	
	public LoginPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//WebElements LoginPage
	@FindBy(className = "username-field") 
	private WebElement userNameTxt;
	@FindBy(className = "submit-button") 
	private WebElement submitBtn;
	@FindBy(className = "password-field") 
	private WebElement passwordTxt;
	@FindBy(className = "submit-button") 
	private WebElement submit1Btn;
	
	//Methods LoginPage
	public void login(String user, String pwd) {
		
		WrapClass.click(submitBtn);
		WrapClass.sendKeys(userNameTxt, user);
		WrapClass.click(submitBtn);
		WrapClass.sendKeys(passwordTxt, pwd);
		WrapClass.click(submit1Btn);
	}
}
