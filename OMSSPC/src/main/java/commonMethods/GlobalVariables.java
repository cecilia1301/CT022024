package commonMethods;

import org.openqa.selenium.WebDriver;

import setupDriver.SetupDriver;

public class GlobalVariables {
	
	public static final String HOME_PAGE = "https://msdnign:8043/data/perspective/client/OMSweb";
	public static final String USER = "ceciliarazo";
	public static final String PASSWORD = "crh140221#";
	public static final WebDriver driver = SetupDriver.setupDriver();
}
