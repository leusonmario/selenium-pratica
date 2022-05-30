package sistemas;

import static java.lang.Thread.sleep;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class AulaSistemaTest {

  @Test
  public void redirecionamentoPaginaTest(){
    //System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_linux64/chromedriver");
    WebDriver webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.get("https://fescfafic.edu.br/");
    WebElement botaoPaginaPrincipal = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/section[1]/div/div/div/div/div/div/div/div/a/span/span"));
    botaoPaginaPrincipal.click();
    Assertions.assertEquals("https://fescfafic.edu.br/principal/", webDriver.getCurrentUrl());
    webDriver.close();
  }

  @Test
  public void redirecionamentoPaginaEmpresa() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver_linux64/chromedriver");
    WebDriver webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.get("https://portal.unicap.br/");
    WebElement botaoPaginaPrincipal = webDriver.findElement(By.xpath("//*[@id=\"layout_com_liferay_site_navigation_menu_web_portlet_SiteNavigationMenuPortlet_INSTANCE_third_navigation_menu_479161\"]"));
    botaoPaginaPrincipal.click();
    sleep(2000);
    Assertions.assertEquals("https://portal.unicap.br/graduacao#presencial/", webDriver.getCurrentUrl());
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
