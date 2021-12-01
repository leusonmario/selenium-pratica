import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AulaSistemaTest {

  @Test
  public void redirecionamentoPaginaTest(){
    WebDriver webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.get("https://fescfafic.edu.br/");
    WebElement botaoPaginaPrincipal = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/section[1]/div/div/div/div/div/div/div/div/a/span/span"));
    botaoPaginaPrincipal.click();
    Assertions.assertEquals("https://fescfafic.edu.br/principal/", webDriver.getCurrentUrl());
    webDriver.close();
  }

  @Test
  public void buscaFormularioTest(){
    WebDriver webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    Actions actions = new Actions(webDriver);
    webDriver.get("https://www.globo.com/");
    WebElement buscaSection = webDriver.findElement(By.id("header-search-section"));
    actions.moveToElement(buscaSection).click().perform();
    Assertions.assertTrue(buscaSection.isEnabled());
    WebElement busca = webDriver.findElement(By.xpath("//*[@id=\"header-search-input\"]"));
    busca.sendKeys("fantastico");
    busca.submit();
    Assertions.assertTrue(webDriver.getCurrentUrl().contains("fantastico"));
    webDriver.close();
  }

}
