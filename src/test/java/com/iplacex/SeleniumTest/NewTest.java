package com.iplacex.SeleniumTest;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	
	@Test
	public void testPageTitle() {
	    WebDriver driver = null;
		// Navega a la página
	    driver.get("http://env-6303523.jelastic.saveincloud.net/ROOT-864/");

	    // Encuentra el cuadro de búsqueda y escribe "pagina principal jelastic"
	    WebElement cuadroBusqueda = driver.findElement(By.name("q"));
	    cuadroBusqueda.sendKeys("pagina inico aplicacion java en hosting jelastic");

	    // Haz clic en el botón de búsqueda
	    cuadroBusqueda.submit();

	    // Espera a que se cargue la página de resultados de búsqueda
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.titleContains("pagina inicio de aplicacion en jelastic - Google Search"));

	    // Verifica que el título de la página sea correcto
	    assertEquals("pagina inicio de aplicacion en jelastic - Google Search", driver.getTitle());
	}

}
