package prueba;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class pruebaTest {
  @Test
  public void f() {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://www.google.com");
  }
}
