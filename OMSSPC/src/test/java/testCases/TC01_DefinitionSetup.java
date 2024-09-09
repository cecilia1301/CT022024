package testCases;

import org.testng.annotations.Test;

import commonMethods.GlobalVariables;
import commonMethods.WrapClass;
import navigationPages.DefinitionPage;
import navigationPages.LoginPage;
import navigationPages.StationSetupPage;

import java.time.Duration;

import org.testng.annotations.BeforeMethod;

public class TC01_DefinitionSetup {
	
	// PageObjects
		LoginPage loginPage = new LoginPage(GlobalVariables.driver);
		DefinitionPage  definitionSetupPage = new DefinitionPage(GlobalVariables.driver);
		
		//Metodo para hacer login y abrir la ventana de product sets
		public void login() throws InterruptedException {
			GlobalVariables.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			loginPage.login(GlobalVariables.USER, GlobalVariables.PASSWORD);
			definitionSetupPage.openDefinitionSetup();
		}

  @BeforeMethod
  public void startWebDriver() {
		GlobalVariables.driver.get(GlobalVariables.HOME_PAGE);
		GlobalVariables.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    GlobalVariables.driver.manage().window().maximize(); //Resize current window to the set dimension
	       
  }

  @Test
  public void TC01() throws InterruptedException {

		login();
		
		String definitionType = "Molding Inspection";

		definitionSetupPage.openAddEditDefinitionSetupPopup("btn_addDef_definitionSetup");
		
		Thread.sleep(2000);
		String ddlElement = "ddl_defType_definitionSetup";//id ddl
		String ddlValue = definitionType;//value to select
		String ddlFilter = "";//filter
		definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue,ddlFilter);
		
		boolean PSTest = true; // cambiar a TRUE para pruebas de product set
		if (PSTest == false) {
			Thread.sleep(1000);
			ddlElement = "ddl_product_definitionSetup"; // PENDIENTE POR EL TEMA DE LOS DIVS
			ddlValue = "10000200";
			ddlFilter = "100";
			definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue,ddlFilter);
		}else {
			Thread.sleep(1000);			
			ddlElement = "ddl_productSet_defSetup";
			ddlValue = "test-sel-09";
			ddlFilter = "test-sel";
			
			definitionSetupPage.selectProductSetchk();
			Thread.sleep(2000);
			definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue, ddlFilter);
		}	
		switch(definitionType) {
			case "Molding Inspection":
				ddlElement = "ddl_mold_definitionSetup";
				ddlValue = "54";   //Interactuar con esta variable depende la prueba.
				ddlFilter = "";
				definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue, ddlFilter);

				definitionSetupPage.dinamicInputNumericDefinition("txt_numCavities_definitionSetup", "4");
				
				definitionSetupPage.dinamicInputStringDefinition("txt_cavID_definitionSetup", "1,2,3,4");
				break;
			case "Incoming Inspection":
				ddlElement = "ddl_supplierName_definitionSetup";
				ddlValue = "_CeciliaR";   //Interactuar con esta variable depende la prueba.
				ddlFilter = "_Cec";
				definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue, ddlFilter);
				Thread.sleep(1000);
				break;
			case "In Process Inspection":
			case "Finished Goods":
				Thread.sleep(1000);
				definitionSetupPage.dinamicInputNumericDefinition("txt_numSize_definitionSetup","10");
				break;
		}

		
		definitionSetupPage.dinamicInputStringDefinition("txt_description_definitionSetup", "test");
		
		ddlElement = "ddl_frequency_definitionSetup";
		ddlValue = "SU";   //Interactuar con esta variable depende la prueba.
		ddlFilter = "";
		definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue, ddlFilter);
	
		Thread.sleep(1000);
		definitionSetupPage.dinamicInputNumericDefinition("txt_InspecTime_definitionSetup", "20.0000");
		
		ddlElement = "ddl_station_definitionSetup";
		ddlValue = "giovannytest1";   //Interactuar con esta variable depende la prueba.
		ddlFilter = "gio";
		definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue, ddlFilter);
		
		String fileName = "123-2-CDI.OGP";   
		
		definitionSetupPage.openFilePathPopup("btn_addFilePath_defSetup");
		definitionSetupPage.addFilePath(fileName, "OGP");
		
		definitionSetupPage.selectTabIndex("0");
		definitionSetupPage.dinamicInputStringDefinition("txt_instructions_definitionS", "This is a test");
		definitionSetupPage.dinamicInputStringDefinition("txt_nameInstructions_defSetup", "TEST-URL");
		definitionSetupPage.dinamicInputStringDefinition("txt_url_definitionSetup", "https://msdnign:8043/");
		Thread.sleep(1000);
		definitionSetupPage.dinamicClickButton("btn_saveUrl_definitionSetup");//ID del boton
		Thread.sleep(1000);
		definitionSetupPage.dinamicClickButton("btn_saveUrl_definitionSetup");
//		
//		definitionSetupPage.selectTabIndex("2");
//		definitionSetupPage.dinamicClickButton("btn_addCalculation_defSetup");
//		definitionSetupPage.dinamicInputStringDefinition("txt_nameCalculation_defSetup", "Calculation Test 1");
//		definitionSetupPage.dinamicInputStringDefinition("txt_descCalculation_defSetup", "Testing 1 calculation");
//		
//		ddlElement = "ddl_calculationType_defSetup";
//		ddlValue = "Sum";   //Interactuar con esta variable depende la prueba.
//		ddlFilter = "";
//		definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue, ddlFilter);
//		Thread.sleep(2000);
//		
//		//definitionSetupPage.dinamicClickButton("btn_submitAddCalcu_defSetup");
//		
//		
//		definitionSetupPage.selectCheckbox("//*[@id= 'tbl_chCalcu_defAddEdit']//*[@data-row-id='0']//label");
//		Thread.sleep(2000);
//		definitionSetupPage.selectCheckbox("//*[@id= 'tbl_chCalcu_defAddEdit']//*[@data-row-id='0']//label");
//		Thread.sleep(2000);
//		definitionSetupPage.selectCheckbox("//*[@id= 'tbl_chCalcu_defAddEdit']//*[@data-row-id='1']//label");
//		definitionSetupPage.selectCheckbox("//*[@id= 'tbl_chCalcu_defAddEdit']//*[@data-row-id='1']//label");
//		
//		definitionSetupPage.dinamicClickButton("btn_submitAddCalcu_defSetup");		
//	
		definitionSetupPage.dinamicClickButton("btn_submitDef_definitionSetup");
		definitionSetupPage.submitDefinition();
	}

  @Test
  public void TC02() throws InterruptedException {

		login();
		
		String definitionType = "Molding Inspection";

		definitionSetupPage.openAddEditDefinitionSetupPopup("btn_addDef_definitionSetup");
		
		Thread.sleep(2000);
		String ddlElement = "ddl_defType_definitionSetup";//id ddl
		String ddlValue = definitionType;//value to select
		String ddlFilter = "";//filter
		definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue,ddlFilter);
		
		boolean PSTest = false; // cambiar a TRUE para pruebas de product set
		if (PSTest == false) {
			Thread.sleep(1000);
			ddlElement = "ddl_product_definitionSetup"; // PENDIENTE POR EL TEMA DE LOS DIVS
			ddlValue = "10000200";
			ddlFilter = "100";
			definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue,ddlFilter);
		}else {
			Thread.sleep(1000);			
			ddlElement = "ddl_productSet_defSetup";
			ddlValue = "test-sel-06-1";
			ddlFilter = "test-sel";
			
			definitionSetupPage.selectProductSetchk();
			Thread.sleep(2000);
			definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue, ddlFilter);
		}	
		switch(definitionType) {
			case "Molding Inspection":
				ddlElement = "ddl_mold_definitionSetup";
				ddlValue = "100";   //Interactuar con esta variable depende la prueba.
				ddlFilter = "";
				definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue, ddlFilter);

				definitionSetupPage.dinamicInputNumericDefinition("txt_numCavities_definitionSetup", "4");
				
				definitionSetupPage.dinamicInputStringDefinition("txt_cavID_definitionSetup", "1,2,3,4");
				break;
			case "Incoming Inspection":
				ddlElement = "ddl_supplierName_definitionSetup";
				ddlValue = "_CeciliaR";   //Interactuar con esta variable depende la prueba.
				ddlFilter = "_Cec";
				definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue, ddlFilter);
				Thread.sleep(1000);
				break;
			case "In Process Inspection":
			case "Finished Goods":
				Thread.sleep(1000);
				definitionSetupPage.dinamicInputNumericDefinition("txt_numSize_definitionSetup","10");
				break;
		}

		
		definitionSetupPage.dinamicInputStringDefinition("txt_description_definitionSetup", "test");
		
		ddlElement = "ddl_frequency_definitionSetup";
		ddlValue = "SU";   //Interactuar con esta variable depende la prueba.
		ddlFilter = "";
		definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue, ddlFilter);
	
		Thread.sleep(1000);
		definitionSetupPage.dinamicInputNumericDefinition("txt_InspecTime_definitionSetup", "20.0000");
		
		ddlElement = "ddl_station_definitionSetup";
		ddlValue = "giovannytest1";   //Interactuar con esta variable depende la prueba.
		ddlFilter = "gio";
		definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue, ddlFilter);
		
		String fileName = "123-2-CDI.OGP";   
		
		definitionSetupPage.openFilePathPopup("btn_addFilePath_defSetup");
		definitionSetupPage.addFilePath(fileName, "OGP");
		
		definitionSetupPage.selectTabIndex("0");
		definitionSetupPage.dinamicInputStringDefinition("txt_instructions_definitionS", "This is a test");
		definitionSetupPage.dinamicInputStringDefinition("txt_nameInstructions_defSetup", "TEST-URL");
		definitionSetupPage.dinamicInputStringDefinition("txt_url_definitionSetup", "https://msdnign:8043/");
		Thread.sleep(1000);
		definitionSetupPage.dinamicClickButton("btn_saveUrl_definitionSetup");//ID del boton
		Thread.sleep(1000);
		definitionSetupPage.dinamicClickButton("btn_saveUrl_definitionSetup");
		
		definitionSetupPage.selectTabIndex("2");
		definitionSetupPage.dinamicClickButton("btn_addCalculation_defSetup");
		definitionSetupPage.dinamicInputStringDefinition("txt_nameCalculation_defSetup", "Calculation Test 1");
		definitionSetupPage.dinamicInputStringDefinition("txt_descCalculation_defSetup", "Testing 1 calculation");
		
		ddlElement = "ddl_calculationType_defSetup";
		ddlValue = "Sum";   //Interactuar con esta variable depende la prueba.
		ddlFilter = "";
		definitionSetupPage.dinamicDDLDefinition(ddlElement,ddlValue, ddlFilter);
		Thread.sleep(2000);
		
		//definitionSetupPage.dinamicClickButton("btn_submitAddCalcu_defSetup");
		
		
		definitionSetupPage.selectCheckbox("//*[@id= 'tbl_chCalcu_defAddEdit']//*[@data-row-id='0']//label");
		Thread.sleep(2000);
		definitionSetupPage.selectCheckbox("//*[@id= 'tbl_chCalcu_defAddEdit']//*[@data-row-id='0']//label");
		Thread.sleep(2000);
		definitionSetupPage.selectCheckbox("//*[@id= 'tbl_chCalcu_defAddEdit']//*[@data-row-id='1']//label");
		definitionSetupPage.selectCheckbox("//*[@id= 'tbl_chCalcu_defAddEdit']//*[@data-row-id='1']//label");
		
		definitionSetupPage.dinamicClickButton("btn_submitAddCalcu_defSetup");		
	
	}

  
}
