package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Steps {

    WebDriver driver;

    @Given("Abrir Chrome")
    public void abrir_Chrome() {
        // Inicializa el controlador de Chrome
        System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
        driver = new ChromeDriver();
    }

    @When("Ingresa username {string} y password {string}")
    public void ingresa_Username_y_Password(String username, String password) {
        // Navega a la página de inicio de sesión
        driver.get("http://env-6303523.jelastic.saveincloud.net/ROOT-864/");

        // Ingresa las credenciales
        WebElement usernameField = driver.findElement(By.name("username"));
        WebElement passwordField = driver.findElement(By.name("password"));
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        passwordField.submit();

        // Espera a que se cargue la página de mensaje.jsp
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("mensaje.jsp"));
    }

    @Then("inicia session")
    public void inicia_sesion() {
        // Haz la bienvenida con el nombre, apellido y rut de la persona
        String nombre = "Ivan";
        String apellido = "Bustos";
        String rut = "12.883.762-0";
        WebElement bienvenida = driver.findElement(By.id("bienvenida"));
        bienvenida.sendKeys("Bienvenido, " + nombre + " " + apellido + " (" + rut + ")");
        bienvenida.submit();

        // Espera a que se cargue la página de bienvenida
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.titleContains("Bienvenida"));

        // Verifica que el título de la página sea correcto
        assert driver.getTitle().equals("Bienvenida");
    }

    @Test
    public void testLogin() {
        // Ejecuta los pasos de la prueba
        abrir_Chrome();
        ingresa_Username_y_Password("VAN", "123");
        inicia_sesion();

        // Cierra el navegador
        driver.quit();
    }
}


