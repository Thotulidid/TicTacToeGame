package is.ru.tictactoe;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;
//import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TicTacToeWebTest {
	private WebDriver driver;
	private String baseUrl;
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    driver = new FirefoxDriver();
	    baseUrl = "http://localhost:4567/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

  @Test
  public void testDraw() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Reset game")).click();
    driver.findElement(By.id("0")).click();
    driver.findElement(By.id("4")).click();
    driver.findElement(By.id("3")).click();
    driver.findElement(By.id("6")).click();
    driver.findElement(By.id("7")).click();
    driver.findElement(By.id("8")).click();
    driver.findElement(By.id("5")).click();
    driver.findElement(By.id("1")).click();
    driver.findElement(By.id("2")).click();
    assertEquals("The game finished in a draw.", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("X", driver.findElement(By.id("0")).getText());
    assertEquals("O", driver.findElement(By.id("4")).getText());
    assertEquals("X", driver.findElement(By.id("3")).getText());
    assertEquals("O", driver.findElement(By.id("6")).getText());
    assertEquals("X", driver.findElement(By.id("7")).getText());
    assertEquals("O", driver.findElement(By.id("8")).getText());
    assertEquals("X", driver.findElement(By.id("5")).getText());
    assertEquals("O", driver.findElement(By.id("1")).getText());
    assertEquals("X", driver.findElement(By.id("2")).getText());
  }
  
  @Test
  public void testWinnerX() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Reset game")).click();
    driver.findElement(By.id("4")).click();
    driver.findElement(By.id("5")).click();
    driver.findElement(By.id("2")).click();
    driver.findElement(By.id("6")).click();
    driver.findElement(By.id("0")).click();
    driver.findElement(By.id("1")).click();
    driver.findElement(By.id("8")).click();
    assertEquals("The winner is:X", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("X", driver.findElement(By.id("0")).getText());
    assertEquals("X", driver.findElement(By.id("4")).getText());
    assertEquals("X", driver.findElement(By.id("8")).getText());
  }
  
    @Test
  public void testXSTurn() throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.linkText("Reset game")).click();
    driver.findElement(By.id("0")).click();
    driver.findElement(By.id("4")).click();
    driver.findElement(By.id("1")).click();
    driver.findElement(By.id("5")).click();
    driver.findElement(By.id("3")).click();
    driver.findElement(By.id("7")).click();
    driver.findElement(By.id("6")).click();
    driver.findElement(By.linkText("Reset game")).click();
    assertEquals("X's turn to move!", driver.findElement(By.cssSelector("h1")).getText());
  }
  
  
  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
