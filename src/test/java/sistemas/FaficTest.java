package sistemas;

import static java.lang.Thread.sleep;

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
    webDriver.manage().window().maximize();
    webDriver.get("https://fescfafic.edu.br/");
    WebElement facebookPageButton = webDriver.findElement(By.xpath("/html/body/div[1]/div/div/section[10]/div/div/div/div/div/div[3]/div/div/span[1]/a"));
    facebookPageButton.click();
    Assertions.assertEquals("https://www.facebook.com/CatolicaPB/", webDriver.getCurrentUrl());
    webDriver.close();
  }

  @Test
  public void openInstagramPage(){
    WebDriver webDriver = new ChromeDriver();
    webDriver.get("https://fescfafic.edu.br/");
    WebElement facebookPageButton = webDriver.findElement(By.className("fa-instagram"));
    facebookPageButton.click();
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
  public void tooltipTest() throws InterruptedException {
    WebDriver webDriver = new ChromeDriver();
    webDriver.manage().window().maximize();
    webDriver.get("https://www.globo.com/");
    Actions actions = new Actions(webDriver);

    WebElement ge = webDriver.findElement(By.xpath("//*[@id=\"header-section\"]/div/div[4]/div[2]/a[4]"));
    actions.moveToElement(ge).build().perform();

    Assertions.assertEquals("esporte", ge.getAttribute("title"));
    webDriver.close();

  }

}
