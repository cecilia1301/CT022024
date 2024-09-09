package testCases;

import org.testng.annotations.Test;
import java.util.Random;

import commonMethods.GlobalVariables;
import navigationPages.CharacteristicPage;
import navigationPages.LoginPage;
import navigationPages.StationSetupPage;

import java.time.Duration;

import org.testng.annotations.BeforeTest;

public class TC01_CharacteristicSetup {
	// PageObjects
	LoginPage loginPage = new LoginPage(GlobalVariables.driver);
	CharacteristicPage characteristicSetupPage = new CharacteristicPage(GlobalVariables.driver);

	// Metodo para hacer login y abrir la ventana de characteristic page
	public void login() throws InterruptedException {
		GlobalVariables.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		loginPage.login(GlobalVariables.USER, GlobalVariables.PASSWORD);
		characteristicSetupPage.openCharacteristicSetup();
	}

	@BeforeTest
	public void startWebDriver() {
		GlobalVariables.driver.get(GlobalVariables.HOME_PAGE);
		GlobalVariables.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void TC01() throws InterruptedException {

		login();
		
		Random ram = new Random();
		
		Integer numRam = ram.nextInt(1000000);
		
		String newCHName = "Dim Test" + numRam;
		
		
		characteristicSetupPage.openAddEditCharacteristicSetupPopup("btn_addCharac_characteristic");
		characteristicSetupPage.addNewCharacteristicName(newCHName, "Test.");
		Thread.sleep(1000);
		characteristicSetupPage.submitCharacteristicName();
		
		Thread.sleep(2000);
		String ddlElement = "ddl_characteristic";//id ddl
		String ddlValue = newCHName;//value to select
		String ddlFilter = "Dim";//filter
		characteristicSetupPage.dinamicDDLCharacteristic(ddlElement,ddlValue,ddlFilter);
		
		boolean PSTest = true; // cambiar a TRUE para pruebas de product set
		if (PSTest == false) {
			Thread.sleep(1000);
			ddlElement = "ddl_product_ch";
			ddlValue = "10000200";
			ddlFilter = "100";
			characteristicSetupPage.dinamicDDLCharacteristic(ddlElement,ddlValue,ddlFilter);
		}else {
			Thread.sleep(1000);			
			ddlElement = "ddl_productSet_ch";
			ddlValue = "test-sel-09";
			ddlFilter = "test-sel";
			
			characteristicSetupPage.selectProductSetchk();
			Thread.sleep(2000);
			characteristicSetupPage.dinamicDDLCharacteristic(ddlElement,ddlValue, ddlFilter);
		}
		
		//data type
		ddlElement = "ddl_dataType_characAddEdit";
		ddlValue = "Variable";   //Interactuar con esta variable depende la prueba.
		ddlFilter = "";
		
		characteristicSetupPage.dinamicDDLCharacteristic(ddlElement, ddlValue, ddlFilter);
		
		Thread.sleep(2000);
		
		//Frequency
		String fqddlElement = "freqType";
		String fqddlValue = "Changeover";   //Interactuar con esta variable depende la prueba.
		String fqddlFilter = "";
		
		characteristicSetupPage.dinamicDDLCharacteristic(fqddlElement, fqddlValue, fqddlFilter);
		
		switch(fqddlValue) {
			case "Time Interval":
				characteristicSetupPage.dinamicInputNumericCharacteristic("txt_intervalHours_characAddEdit", "1");
				break;
			case "AQL":
				fqddlElement = "ddl_aqlLevel_characAddEdit"; 
				fqddlValue = "1.5";  //Interactuar con esta variable depende la prueba.
				fqddlFilter = "1";  //Interactuar con esta variable depende la prueba.(
				characteristicSetupPage.dinamicDDLCharacteristic(fqddlElement, fqddlValue, fqddlFilter);
				break;
			case "Changeover":
				break;
			case "Shift Change":
				break;
		}
		
		if(ddlValue == "Variable") {
			String vlddlElement = "ddl_dataFormat_characAddEdit";
			String vlddlValue = "1 decimal place(s)";   //Interactuar con esta variable depende la prueba.
			String vlddlFilter = "";
			characteristicSetupPage.dinamicDDLCharacteristic(vlddlElement,vlddlValue, vlddlFilter);//ddl_dataFormat_characAddEdit
			characteristicSetupPage.dinamicInputNumericCharacteristic("txt_lsl_characAddEdit", "1");//txt_lsl_characAddEdit
			characteristicSetupPage.dinamicInputNumericCharacteristic("txt_target_characAddEdit", "3");//txt_target_characAddEdit
			characteristicSetupPage.dinamicInputNumericCharacteristic("txt_usl_characAddEdit", "6");//txt_usl_characAddEdit
		}
		
		if(ddlValue != "Attribute (Boolean)") {
			characteristicSetupPage.dinamicInputStringCharacteristic("txt_pickList_characAddEdit", "1;1.5");//txt_pickList_characAddEdit
		}	
		
		characteristicSetupPage.dinamicInputStringCharacteristic("txt_docRevision_characAddEdit", "test");
		
		ddlElement = "ddl_equipmentType_characAddEdit";
		ddlValue = "Air Tester";   //Interactuar con esta variable depende la prueba.
		ddlFilter = "Air";
		characteristicSetupPage.dinamicDDLCharacteristic(ddlElement,ddlValue, ddlFilter);
		
		characteristicSetupPage.dinamicInputStringCharacteristic("txt_equipmentName_characAddEdit", "test");
		characteristicSetupPage.dinamicInputNumericCharacteristic("txt_offsetValue_characAddEdit", "2");
		
		ddlElement = "ddl_destrucTest_characAddEdit";
		ddlValue = "True";   //Interactuar con esta variable depende la prueba.
		ddlFilter = "";
		characteristicSetupPage.dinamicDDLCharacteristic(ddlElement,ddlValue, ddlFilter);
		
		characteristicSetupPage.dinamicInputNumericCharacteristic("txt_grrPercent_characAddEdit", "1");
		characteristicSetupPage.dinamicInputNumericCharacteristic("txt_inspecTime_characAddEdit", "2");
		
		characteristicSetupPage.dinamicInputStringCharacteristic("txt_instruction_characAddEdit", "This is a test");
		
		characteristicSetupPage.submitCharacteristic();
	}
		  
}
