package testCases;

import java.time.Duration;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import commonMethods.GlobalVariables;
import navigationPages.LoginPage;
import navigationPages.StationSetupPage;

public class TC01_StationSetup {
	
	// PageObjects
	LoginPage loginPage = new LoginPage(GlobalVariables.driver);
	StationSetupPage stationSetupPage = new StationSetupPage(GlobalVariables.driver);
	
	//Metodo para hacer login y abrir la ventana de product sets
	public void login() throws InterruptedException {
		GlobalVariables.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		loginPage.login(GlobalVariables.USER, GlobalVariables.PASSWORD);
		stationSetupPage.openStationSetup();
	}

	@BeforeTest
	public void startWebDriver() {
		GlobalVariables.driver.get(GlobalVariables.HOME_PAGE);
		GlobalVariables.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}	
	
  @Test
  public void TC01() throws InterruptedException {
	  login();
	  String station = "giovannytest1"; //giovannytest
	  if (stationSetupPage.verifyExistStation(station)) {
		  stationSetupPage.searchRowTable(station);
		  stationSetupPage.openAddEditStationSetupPopup("btn_edit_stationSetup");
		  stationSetupPage.addStationPopup(station);
		  stationSetupPage.addLinesinStation("IQMS-011");
		  
		  stationSetupPage.submitPopupTree();
		  stationSetupPage.selectCheckActiveStation();  
		  
	  } else {
		  stationSetupPage.openAddEditStationSetupPopup("btn_add_stationSetup");  
		  stationSetupPage.addStationPopup(station);
		  stationSetupPage.addLinesinStation("RS");
		  stationSetupPage.addLinesinStation("IQMS-012");
		  
		  stationSetupPage.submitPopupTree();
	  }
	  stationSetupPage.submitAddEditStationPopup();
	  
	  }

}

