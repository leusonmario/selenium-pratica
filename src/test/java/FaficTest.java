import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FaficTest {

  @Test
  public void openFacebookPage(){
    WebDriver webDriver = new ChromeDriver();
    webDriver.get("https://fescfafic.edu.br/");
    WebElement facebookPageButton = webDriver.findElement(By.cssSelector("body > div.elementor.elementor-7318 > div > div > section.elementor-section.elementor-top-section.elementor-element.elementor-element-56443a69.elementor-section-boxed.elementor-section-height-default.elementor-section-height-default > div > div > div > div > div > div.elementor-element.elementor-element-35f1c4d5.elementor-shape-rounded.elementor-grid-0.e-grid-align-center.elementor-widget.elementor-widget-social-icons > div > div > div:nth-child(1) > a > i"));
    facebookPageButton.click();
    Assertions.assertEquals("https://www.facebook.com/FaculdadeFAFIC/", webDriver.getCurrentUrl());
    webDriver.close();
  }

  @Test
  public void openInstagramPage(){
    WebDriver webDriver = new ChromeDriver();
    webDriver.get("https://fescfafic.edu.br/");
    WebElement facebookPageButton = webDriver.findElement(By.className("fa-instagram"));
    facebookPageButton.click();
    Assertions.assertEquals("https://www.instagram.com/faculdadefafic/?hl=pt-br", webDriver.getCurrentUrl());
    webDriver.close();
  }

  @Test
  public void searchTest(){
    WebDriver webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.get("https://www.globo.com/");
    Actions actions = new Actions(webDriver);

    WebElement search = webDriver.findElement(By.xpath("//*[@id=\"header-search-input\"]"));
    actions.moveToElement(search).click().perform();
    search.sendKeys("fantastico");
    search.submit();
    Assertions.assertEquals("https://www.globo.com/busca/?q=fantastico", webDriver.getCurrentUrl());

    WebElement busca = webDriver.findElement(By.xpath("//*[@id=\"q\"]"));
    Assertions.assertEquals("fantastico", busca.getAttribute("value"));
    webDriver.close();

  }

  @Test
  public void tooltipTest(){
    WebDriver webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.get("https://www.globo.com/");
    Actions actions = new Actions(webDriver);

    WebElement ge = webDriver.findElement(By.xpath("//*[@id=\"header-section\"]/div/div[4]/div[2]/a[4]"));
    actions.moveToElement(ge).perform();
    Assertions.assertEquals("esporte", ge.getAttribute("title"));

    webDriver.close();

  }

}
