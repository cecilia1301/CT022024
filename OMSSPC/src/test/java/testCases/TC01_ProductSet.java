package testCases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import commonMethods.GlobalVariables;
import navigationPages.LoginPage;
import navigationPages.ProductSetPage;
import java.time.Duration;

public class TC01_ProductSet {

	// PageObjects
	LoginPage loginPage = new LoginPage(GlobalVariables.driver);
	ProductSetPage productSetPage = new ProductSetPage(GlobalVariables.driver);
	
	//Metodo para hacer login y abrir la ventana de product sets
	public void login() throws InterruptedException {
		GlobalVariables.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		loginPage.login(GlobalVariables.USER, GlobalVariables.PASSWORD);
		productSetPage.openProductSet();
	}

	@BeforeTest
	public void startWebDriver() {
		GlobalVariables.driver.get(GlobalVariables.HOME_PAGE);
		GlobalVariables.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void TC01() throws InterruptedException {

		login(); // mandamos a llamar al metodo login

		if (productSetPage.verifyExistButton()) {
			productSetPage.openAddProductSetPopup("test-sel-01", "test");
			productSetPage.addPartsToProductSet("114500", "114");
		}
		productSetPage.submitProductSet();
	}

	@Test
	public void TC03() throws InterruptedException {

		login(); // mandamos a llamar al metodo login	
		productSetPage.deletePartsfromProductSet("114500");	
	}
	
	@Test
	public void TC04() throws InterruptedException{
		login(); // mandamos a llamar al metodo login
		
		//Mandamos a llamar el metodo deletePS, las veces que sea necesario
		
		String productset_name = "test-sel-09";
		
		boolean exist = productSetPage.verifyExistPS(productset_name);
		
		if (exist == false) {
			productSetPage.deletePartsfromProductSet("114500");
			productSetPage.deletePartsfromProductSet("114700");
			productSetPage.deletePartsfromProductSet("114800");
			productSetPage.deletePartsfromProductSet("399196");
			
			//Abrimos el popup de agregar product set y mandamos como parametros nombre y description
			productSetPage.openAddProductSetPopup(productset_name,"test");
			
			//Agregamos productos al product set
			productSetPage.addPartsToProductSet("114500", "114");
			productSetPage.addPartsToProductSet("114700", "114");
			productSetPage.addPartsToProductSet("114800", "114");
			productSetPage.addPartsToProductSet("399196", "399");
		} else {
			//Editar
			productSetPage.searchRowTable(productset_name);
			productSetPage.openEditProductSetPopup("btn_edit_productSet"); 
			productSetPage.editBasicData("", "testing");
			productSetPage.editBasicData("test-sel-09-1", "");
			productSetPage.editProductSet("399196", "399");
		}
		
		//creamos el productset
		productSetPage.submitProductSet();
		
		productSetPage.deletePartsfromProductSet(productset_name);
		
	}
}
