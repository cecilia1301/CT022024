package commonMethods;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;

public class WrapClass {

	public static void click(WebElement webUI) {
		webUI.click();

	}

	public static void sendKeys(WebElement webUI, String textToSend) {
		webUI.sendKeys(textToSend);
	}

	public static String getText(WebElement webUI) {
		return webUI.getText();
	}

	public static boolean veridyElementDisplayed(WebElement webUI) {
		return webUI.isDisplayed();
	}

	public static void takeScreenshot(WebDriver webdriver, String testCaseName) {
		// Toman el screenshot de la pagina sin formato
		File scrFile = ((TakesScreenshot) webdriver).getScreenshotAs(OutputType.FILE);

		// Establecer ruta donde se guarda el screenshot
		String screenshotPath = "./test-output/ExecutionResults";

		try {
			FileHandler.createDir(new File(screenshotPath)); // creamos el folder usando la ruta especificada de la
																// variable "screenshotPath"
			FileHandler.copy(scrFile, new File(screenshotPath + File.separatorChar + testCaseName + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String getJsonValue(String jsonFile, String jsonKey) {
		//JsonData
		try {
			InputStream inputStream = new FileInputStream(GlobalVariables.EXT_DATA +jsonFile + ".json"); //Usamos la ruta donde obtenemos el archivo Json
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));
			
			//Leer los datos
			String jsonValue = jsonObject.getJSONObject(jsonFile).getString(jsonKey);
			return jsonValue;
		
			
		} catch (FileNotFoundException e) {
			//TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		}

	public static String getCellData(String excelName, int row, int column) {
		// Leer archivo Excel
		FileInputStream fis;
		try {
			fis = new FileInputStream(GlobalVariables.EXT_DATA + excelName + ".xlsx");
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);
			Row rowobj = sheet.getRow(row);
			Cell cell = rowobj.getCell(column);
			String value = cell.getStringCellValue();
			return value;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	
	}
}
