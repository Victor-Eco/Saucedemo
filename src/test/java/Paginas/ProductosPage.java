package Paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductosPage {
//Elementos
	@FindBy(id="add-to-cart-test.allthethings()-t-shirt-(red)")
	WebElement Producto1;
		
//Constructor
  public ProductosPage(WebDriver driver) {	
	  PageFactory.initElements(driver, this);
	  
  }
  
//Acciones sobre el elemento  
  public void ElegirProducto() {
	  Producto1.click();
}
  
  } 