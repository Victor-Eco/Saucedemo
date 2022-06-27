package edit.Tarea5;

import org.testng.annotations.Test;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import Utilities.DatosExcel;


public class Asignacion7 {
	
	String url = "https://www.saucedemo.com/";
	 String driverPath = "..\\ProyectoSaucedemo\\Drivers\\chromedriver.exe";
	 WebDriver driver;

	 
	@BeforeSuite
	public void AbrirPagina() {
		   
	 System.setProperty("webdriver.chrome.driver", driverPath);
	 driver= new ChromeDriver();
	 driver.get(url);
	 driver.manage().window().maximize();
	 driver.manage().deleteAllCookies();
	 
	}
	 
	 @Test(dataProvider="Datos Loguin excel") 
	 public void Loguin (String user, String password, String nombre, String apellido, String codigopostal)  {
	 
     driver.findElement(By.xpath("//input[@id='user-name']")).clear();	 
     driver.findElement(By.id("user-name")).sendKeys(user);
     
     driver.findElement(By.name("password")).clear();
     driver.findElement(By.id("password")).sendKeys(password);
     
	 driver.findElement(By.xpath("//input[@id='login-button']")).click();
	 
	 String urlEsperado = "https://www.saucedemo.com/inventory.html";
	 Assert.assertEquals(driver.getCurrentUrl(), urlEsperado); 
	 	 
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	 wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-test.allthethings()-t-shirt-(red)"))); 
	 
	 driver.findElement(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")).click();
	 
	 driver.findElement(By.cssSelector("#shopping_cart_container")).click();
	 
	 driver.findElement(By.id("checkout")).click();	
	 
	 driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(nombre);
		
	 driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(apellido);
		
	 driver.findElement(By.id("postal-code")).sendKeys(codigopostal);
	 
	 driver.findElement(By.cssSelector("#continue")).click();
	 
	 driver.findElement(By.id("finish")).click();
	 
	 driver.findElement(By.cssSelector("#react-burger-menu-btn")).click();
	 
	 WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(5));
	 wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='logout_sidebar_link']")));
	 
	 driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
	 
	 	 
}
	 
	 @AfterSuite
	 
	 public void cerrarNavegador() {
	 
     driver.close();		 
	 }
	 
	 @DataProvider(name="Datos Loguin excel")
	 public Object [][] ObtenerDatosExcel() throws Exception {
	 return DatosExcel.leerExcel("..\\ProyectoSaucedemo\\DatosExcel\\DatosAsignacion7.xlsx", "Hoja1");
	
	}

}