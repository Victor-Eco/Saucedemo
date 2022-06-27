package Pruebas;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import Paginas.ProductosPage;
import Paginas.SaucedemoPage;


public class SelectionObjectTest {

	String url = "https://www.saucedemo.com/";
	String driverPath = "..\\ProyectoSaucedemo\\Drivers\\chromedriver.exe";
	WebDriver driver;
	
	@BeforeSuite
	 public void abrirPagina() {
		
		System.setProperty("webdriver.chrome.exe", driverPath);
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	@Test
	public void Login() {
		
		SaucedemoPage inicio = new SaucedemoPage(driver); 
		inicio.escribirUsuario("standard_user");
		inicio.escribirPassword("secret_sauce");
		inicio.hacerclickLogin();
		
	}
	
	@Test
	public void SelectionObject() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-test.allthethings()-t-shirt-(red)")));
		
		ProductosPage inicio = new ProductosPage(driver); 
		inicio.ElegirProducto();
		
		
	}
}
