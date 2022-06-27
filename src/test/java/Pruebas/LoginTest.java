package Pruebas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import Paginas.SaucedemoPage;

public class LoginTest {

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
}
