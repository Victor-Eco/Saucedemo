package edit.Tarea5;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.BeforeSuite;

import Utilities.CapturaEvidencia;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

    public class Asignacion5 {

	String url = "https://www.saucedemo.com";
	String driverPath = "..\\Tarea5\\Drivers\\chromedriver.exe";
	WebDriver driver;
	File pantalla;
	String dirEvidencias = "..\\Tarea5\\Evidencias\\";
	String nombreDocumento = "Evidencias-SauceDemo.docx";
	
   @BeforeSuite 
    public void abrirPagina() { //setUp
	   
	   System.setProperty("webdriver.chrome.driver", driverPath);
	   driver = new ChromeDriver();
	   driver.get(url);
	   driver.manage().window().maximize();   
	   driver.manage().deleteAllCookies();
    }
    @Test(description="Cp Iniciar Sesion", priority=1)
    public void iniciarSesion() throws IOException, InvalidFormatException, InterruptedException {
    withTimeout(50, TimeUnit.SECONDS);
	}
    
    public void withTimeout(int i, TimeUnit seconds) throws IOException, InvalidFormatException, InterruptedException { 
	    
	   driver.findElement(By.name("user-name")).sendKeys("standard_user");
	   
	   driver.findElement(By.id("password")).sendKeys("secret_sauce");
	   CapturaEvidencia.escribirTituloEnDocumento(dirEvidencias + nombreDocumento, "Reservar Producto en Saucedemo", 20);
	   CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "Captura(1).JPG", dirEvidencias + nombreDocumento, "Paso 1 - Pagina principal Logueo de Usuario", 14);
	   
	   driver.findElement(By.xpath("//input[@id='login-button']")).click();
	   
   }
   @Test(description="Cp ReservarProducto", priority=2) 
     public void reservarProducto() throws IOException, InvalidFormatException, InterruptedException {
	   
	    driver.findElement(By.xpath("//*[@id=\"add-to-cart-sauce-labs-backpack\"]")).click();
        
	    driver.findElement(By.cssSelector("#shopping_cart_container")).click();
	    CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "Captura(2).JPG", dirEvidencias + nombreDocumento, "Paso 2 - Verificar producto seleccionado", 14);
	    
 	    driver.findElement(By.id("checkout")).click();	    
		
 	    driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys("victor");
		
 	    driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys("alvarez");
		
 	    driver.findElement(By.id("postal-code")).sendKeys("1636");
	    CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "Captura(3).JPG", dirEvidencias + nombreDocumento, "Paso 3 - Completar formulario", 14);
 	    
 	    
		driver.findElement(By.cssSelector("#continue")).click();
		CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "Captura(4).JPG", dirEvidencias + nombreDocumento, "Paso 4 - Finalizar Reserva", 14);	
		

 	    driver.findElement(By.id("finish")).click();
	    CapturaEvidencia.capturarPantallaEnDocumento(driver, dirEvidencias + "Captura(5).JPG", dirEvidencias + nombreDocumento, "Paso 5 - Reserva finalizada", 14);
 	    
 	    
		String urlEsperada = "https://www.saucedemo.com/checkout-complete.html";
		String urlActual = driver.getCurrentUrl();
		
		AssertJUnit.assertEquals(urlEsperada, urlActual);
		
	}
	@Test(description="Cp Cerrar navegador", priority=3)
     public void cerrarNavegador() {
	 driver.close();	

	}
}
    


   
