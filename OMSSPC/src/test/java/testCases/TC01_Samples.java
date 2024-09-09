package testCases;

import org.testng.annotations.Test;

import commonMethods.GlobalVariables;
import navigationPages.DefinitionPage;
import navigationPages.LoginPage;
import navigationPages.SamplesPage;

import java.time.Duration;
import java.util.Random;

import org.testng.annotations.BeforeMethod;

public class TC01_Samples {
	
	// PageObjects
	LoginPage loginPage = new LoginPage(GlobalVariables.driver);
	SamplesPage  samplesPage = new SamplesPage(GlobalVariables.driver);
	
	//Metodo para hacer login y abrir la ventana de product sets
	public void login() throws InterruptedException {
		GlobalVariables.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		loginPage.login(GlobalVariables.USER, GlobalVariables.PASSWORD);
		samplesPage.openSamples();
	}

	  @BeforeMethod
	  public void startWebDriver() {
			GlobalVariables.driver.get(GlobalVariables.HOME_PAGE);
			GlobalVariables.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		    GlobalVariables.driver.manage().window().maximize(); //Resize current window to the set dimension
		       
	  }
	  
	  double GenerateDecimalRandomNumber(double min, double max) {
		  Random ram = new Random();
		  
		  double number = (ram.nextInt((int)((max-min)*10+1))+min*10) / 10.0;
		  return number;
	  }
	  
	  Integer GenerateRandomNumber(int min, int max) {
		  Random ram = new Random();
		  
		  Integer number = ram.ints(min, max).findFirst().getAsInt();
		  return number;
	  }
	  
	 
	  //Primer prueba para creacion de sample
  @Test
  public void TC01() throws InterruptedException {

		login(); 
		
		samplesPage.SetFilterDS("Day");
		samplesPage.searchRowTable("T0710-1 - 55 - SU", "In progress"); //Cambiar nombre de la definicion
		samplesPage.openSampleDataPopup("btn_editS_scheduledSamples");
		
		double min = 1.1;
		double max = 1.9;
		
//		int min = 1;
//		int max = 10;
//		
		//10 inputs
		Integer numberInputs = samplesPage.getTotalInputs();
		
		Integer numberRows = samplesPage.getRowTable();
		
		
		for(Integer i = 0; i < (numberInputs * numberRows); i++) {
			double numRam = GenerateDecimalRandomNumber(min,max);
//			Integer numRam = GenerateRandomNumber(min,max);

		
			samplesPage.dinamicInputStringSample("txt_entryBox_sampleEntry", ""+numRam+"");
			samplesPage.dinamicInputStringSample("txt_charactComments_sampleEntry", "Esto es un comentario de caracteristica");
		}
		samplesPage.saveandClose();
  }
  
  //Segunda prueba para creacion de sample manual
  @Test
  public void TC02() throws InterruptedException {

		login(); 
		
		samplesPage.SetFilterDS("Day");
		samplesPage.searchRowTable("T0710-1 - 55 - SU", "In progress"); //Cambiar nombre de la definicion
		samplesPage.openSampleDataPopup("btn_editS_scheduledSamples");
		
		double min = 1.1;
		double max = 1.9;
		
//		int min = 1;
//		int max = 10;
//		
		//10 inputs
		Integer numberInputs = samplesPage.getTotalInputs();
		
		Integer numberRows = samplesPage.getRowTable();
		
		
		for(Integer i = 0; i < (numberInputs * numberRows); i++) {
			double numRam = GenerateDecimalRandomNumber(min,max);
//			Integer numRam = GenerateRandomNumber(min,max);

		
			samplesPage.dinamicInputStringSample("txt_entryBox_sampleEntry", ""+numRam+"");
			samplesPage.dinamicInputStringSample("txt_charactComments_sampleEntry", "Esto es un comentario de caracteristica");
		}
		samplesPage.saveandClose();
  }
  

  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
//  
//  samplesPage.selectTabIndex("0");
//	definitionSetupPage.dinamicInputStringDefinition("txt_instructions_definitionS", "This is a test");
//	definitionSetupPage.dinamicInputStringDefinition("txt_nameInstructions_defSetup", "TEST-URL");
}
